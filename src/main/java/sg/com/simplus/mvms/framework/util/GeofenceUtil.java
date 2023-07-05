package sg.com.simplus.mvms.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sg.com.simplus.mvms.data.dto.*;
import sg.com.simplus.mvms.mq.AlertLookupService;
import sg.com.simplus.mvms.mq.GeofenceLookupService;
import sg.com.simplus.mvms.mq.ProducerService;
import sg.com.simplus.mvms.service.dataservice.AlertDataService;
import sg.com.simplus.mvms.service.dataservice.UnAlertDataService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class GeofenceUtil {

    @Autowired
    ProducerService producerService;

    @Autowired
    AlertDataService alertDataService;

    @Autowired
    UnAlertDataService unAlertDataService;

    @Autowired
    AlertLookupService alertLookupService;

    public  void checkGeofenceInfringement(Vessel vessel, PositionReport positionReport){
        Double double_longitude = positionReport.getLongitudeDbl() != null ? positionReport.getLongitudeDbl() : 0;
        Double double_latitude = positionReport.getLatitudeDbl() != null ?  positionReport.getLatitudeDbl() : 0;
        Date timestampDti = positionReport.getTimestampDti();
        checkGeofenceInfringement(vessel,double_longitude,double_latitude,timestampDti);
    }

    public  void checkGeofenceInfringement(Vessel vessel, PositionReportLast positionReport){

        Double double_longitude = positionReport.getLongitudeDbl() != null ? positionReport.getLongitudeDbl() : 0;
        Double double_latitude = positionReport.getLatitudeDbl() != null ?  positionReport.getLatitudeDbl() : 0;
        Date timestampDti = positionReport.getTimestampDti();
        checkGeofenceInfringement(vessel,double_longitude,double_latitude,timestampDti);
    }

    public  void checkGeofenceInfringement(Vessel vessel, Double _double_longitude,  Double _double_latitude , Date timestampDti){
        String vesselName =  vessel.getNameStr();
        Double double_longitude = _double_longitude != null ? _double_longitude : 0;
        Double double_latitude = _double_latitude != null ?  _double_latitude : 0;
        Double double_length = vessel.getLengthDbl() != null ? vessel.getLengthDbl() : 0;
        Double double_width = vessel.getWidthDbl() !=null ? vessel.getWidthDbl()  : 0;
        Double double_draft = vessel.getDraftDbl() != null ? vessel.getDraftDbl() : 0;
        List<Geofence> geofenceList = GeofenceLookupService.getGeofenceList();
        //System.out.println("checkGeofenceInfringement double_longitude: "+double_longitude+", geofenceList size: "+geofenceList.size());
        for(Geofence geofence: geofenceList){
            GenericPair<Boolean, ArrayList<Integer>>  resInfrigement =  checkGeofenceInfringement(geofence, double_longitude,double_latitude,double_length,double_width,double_draft);
            boolean boolean_infringement = resInfrigement.getFirstObject();
            ArrayList<Integer> arrayList_triggerIndex = resInfrigement.getSecondObject();
            if(boolean_infringement){
                //push alert
                String string_alertTriggers = "";
                for (Integer integer_triggerIndex : arrayList_triggerIndex) {
                    string_alertTriggers += String.valueOf(integer_triggerIndex);
                    string_alertTriggers += ",";
                }

                string_alertTriggers = string_alertTriggers.substring(0, string_alertTriggers.length() - 1);

                String propertyValueStr = StringUtil.getPropertyValue("geofence.alert.trigger.message");

                String string_message = String.format(propertyValueStr,vesselName,geofence.getNameStr(),string_alertTriggers);

                try {
                    producerService.sendToGeofenceAlertTriggerTopic( string_message);
                    Alert alert = new Alert();
                    alert.setAlertStr(string_message);
                    alert.setGeofenceNameStr(geofence.getNameStr());
                    alert.setVessel(vessel);
                    alert.setTimestampDti(timestampDti);
                    alertDataService.deleteByVesselIdInt(vessel.getIdInt());
                    alertDataService.save(alert);
                    Map<Integer,Alert> alertMap = alertLookupService.getAlertMap();
                    alertMap.remove(vessel.getIdInt());
                    alertMap.put(vessel.getIdInt(),alert);
                    String emails = vessel.getEmailStr();
                    if(emails!=null) {
                        String emailArr[] = emails.split(";");
                        for(int i=0;i<emailArr.length;i++) {
                            EmailUtil.sendEmail(StringUtil.getPropertyValue("email.subject.geofence.alert"), emailArr[i], string_message);
                        }
                    }
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

            } else {
                // checking that vessel should be unalert or not
                Map<Integer,Alert> alertMap = alertLookupService.getAlertMap();
                if(alertMap.containsKey(vessel.getIdInt())){
                    UnAlert unAlert = new UnAlert();
                    unAlert.setVessel(vessel);
                    unAlert.setTimestampDti(timestampDti);
                    unAlertDataService.deleteByVesselIdInt(vessel.getIdInt());
                    unAlertDataService.save(unAlert);
                    alertMap.remove(vessel.getIdInt());
                }

            }
        }
    }


    private GenericPair<Boolean, ArrayList<Integer>> checkGeofenceInfringement(Geofence geofence,  Double double_longitude, Double double_latitude,  Double double_length, Double double_width, Double double_draft) {
       // boolean boolean_isVesselProjectVessel = string_vesselCategory.equalsIgnoreCase("project");
        //System.out.println("double_latitude: "+double_latitude);
        //System.out.println("double_longitude: "+double_longitude);
        ArrayList<GenericPair<Double, Double>> arrayList_coordinate = getArrayCoordinates(geofence.getCoordinatesStr());
        List<GeofenceAlertTrigger> arrayList_geofenceAlertTrigger = geofence.getGeofenceAlertTriggerList();
        boolean boolean_isInsideGeofence = false;
        SymbolType symbolType = geofence.getSymbolType();
        //System.out.println(" symbolType.getNameStr(): "+ symbolType.getNameStr());
        // <editor-fold desc="Checking if the vessel is within the geofence boundary" defaultstate="collapsed">
        if (symbolType!= null && symbolType.getNameStr().equals("polygon")) {
            ArrayList<Double> arrayList_longitude = new ArrayList<Double>();
            ArrayList<Double> arrayList_latitude = new ArrayList<Double>();

            for (GenericPair<Double, Double> genericPair_coordinate : arrayList_coordinate) {
                arrayList_longitude.add(genericPair_coordinate.getFirstObject());
                arrayList_latitude.add(genericPair_coordinate.getSecondObject());
            }
            //System.out.println("arrayList_latitude: "+arrayList_latitude);
            //System.out.println("arrayList_longitude: "+arrayList_longitude);
            boolean_isInsideGeofence = GeoMetrics.isInsidePolygon(double_latitude, double_longitude, arrayList_latitude, arrayList_longitude);
        } else {
            boolean_isInsideGeofence = GeoMetrics.isInsideCircle(double_latitude, double_longitude, geofence.getLatitudeDbl(), geofence.getLongitudeDbl(), geofence.getRadiusDbl());
        }
        // </editor-fold>
        ArrayList<Integer> arrayList_triggerIndex = new ArrayList<Integer>();
        boolean boolean_triggerAlert = false;
        //System.out.println("boolean_isInsideGeofence: "+boolean_isInsideGeofence);
        if (boolean_isInsideGeofence) {
           // System.out.println("boolean_isInsideGeofence true");
            for (GeofenceAlertTrigger geofenceAlertTrigger : arrayList_geofenceAlertTrigger) {
                Integer integer_index = geofenceAlertTrigger.getTriggerIndexInt();

                double double_minLength = geofenceAlertTrigger.getMinLengthDbl();
                double double_maxLength = geofenceAlertTrigger.getMaxLengthDbl();
                double double_minWidth = geofenceAlertTrigger.getMinWidthDbl();
                double double_maxWidth = geofenceAlertTrigger.getMaxWidthDbl();
                double double_minDraft = geofenceAlertTrigger.getMinDraftDbl();
                double double_maxDraft = geofenceAlertTrigger.getMaxDraftDbl();

                // <editor-fold desc="For project vessels" defaultstate="collapsed">
//                if (boolean_isVesselProjectVessel) {
//                    if (boolean_disallowProjectVessels) {
                        if ((double_length >= double_minLength && double_length <= double_maxLength)
                                && (double_width >= double_minWidth && double_width <= double_maxWidth)
                                && (double_draft >= double_minDraft && double_draft <= double_maxDraft)) {
                            arrayList_triggerIndex.add(integer_index);
                            boolean_triggerAlert = true;
                        }
//                    }
//                }
                // </editor-fold>

                // <editor-fold desc="For nonproject vessels" defaultstate="collapsed">
//                if (!boolean_isVesselProjectVessel) {
//                    if (boolean_disallowNonProjectVessels) {
//                        if ((double_length >= double_minLength && double_length <= double_maxLength)
//                                && (double_width >= double_minWidth && double_width <= double_maxWidth)
//                                && (double_draft >= double_minDraft && double_draft <= double_maxDraft)) {
//                            arrayList_triggerIndex.add(integer_index);
//                            boolean_triggerAlert = true;
//                        }
//                    }
//                }
                // </editor-fold>
            }
        }

        return new GenericPair<Boolean, ArrayList<Integer>>(boolean_triggerAlert, arrayList_triggerIndex);
    }

    private     ArrayList<GenericPair<Double, Double>> getArrayCoordinates(String string_coordinates){

        ArrayList<GenericPair<Double, Double>> arrayList_coordinate = new ArrayList<GenericPair<Double, Double>>();

        String[] tokens_coordinates = string_coordinates.split(";");
        for (String string_token : tokens_coordinates) {
            String[] token_latLong = string_token.split(",");

            Double double_longitude = Double.valueOf(token_latLong[0]);
            Double double_latitude = Double.valueOf(token_latLong[1]);

            GenericPair<Double, Double> genericPair_coordinate = new GenericPair<Double, Double>(double_longitude, double_latitude);
            arrayList_coordinate.add(genericPair_coordinate);
        }
        return  arrayList_coordinate;
    }
}
