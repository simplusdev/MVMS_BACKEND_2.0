package sg.com.simplus.mvms.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.data.dto.PositionReportLast;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.dto.VesselTypeAis;
import sg.com.simplus.mvms.framework.util.GeofenceUtil;
import sg.com.simplus.mvms.service.businessservice.PositionReportBusinessService;
import sg.com.simplus.mvms.service.businessservice.VesselBusinessService;
import sg.com.simplus.mvms.service.dataservice.PositionReportLastDataService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class ConsumerService {

    @Autowired
    VesselBusinessService vesselBusinessService;

    @Autowired
    PositionReportBusinessService positionReportBusinessService;

    @Autowired
    PositionReportLastDataService positionReportLastDataService;

    @Autowired
    VesselTypeAisLookupService vesselTypeLookupService;

    @Autowired
    GeofenceUtil geofenceUtil;

    @Autowired
    ProducerService producerService;

    ObjectMapper mapper = new ObjectMapper();

    @JmsListener(destination = Constants.JMS_QUEUE_NAME, containerFactory = "queueListenerFactory")
    public void receive(final Message jsonMessage) throws JMSException {


        //System.out.println(new Date()+" Received message ");
        //processReceivedMessage(jsonMessage);
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    processReceivedMessage(jsonMessage);
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void processReceivedMessage(Message jsonMessage)  throws JMSException {
      //  System.out.println(new Date()+" processReceivedMessage message ");
        String messageData = null;
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
            Map<String, Object> map = null;
            try {
                map = mapper.readValue(messageData, Map.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            String type = (String) map.get("type");
            Integer partNoInt = (Integer) map.get("partNoInt");
            Map<String, Object> data = (Map<String, Object>) map.get("data");


            if (type != null && type.equals("StaticVoyageRelatedData")) {
                // System.out.println("StaticVoyageRelatedData data: "+data);
                processVessel("StaticVoyageRelatedData",data);
            }

            if (type != null && type.equals("StaticDataReport")) {
                //System.out.println("StaticDataReport data: "+data);
                processVessel("StaticDataReport",data);

            }
            if (type != null && type.equals("PositionReportClassA")) {
                //System.out.println("PositionReportClassA data: "+data);
                processPositionReport("PositionReportClassA",data);

            }
            if (type != null && type.equals("StandardClassBCSPositionReport")) {
                // System.out.println("StandardClassBCSPositionReport data: "+data);
                processPositionReport("StandardClassBCSPositionReport",data);
            }
            if (type != null && type.equals("ExtendedClassBCSPositionReport")) {
                // System.out.println("ExtendedClassBCSPositionReport data: "+data);
                processPositionReport("ExtendedClassBCSPositionReport",data);
            }
        }
    }

    public void processVessel(String reportType, Map<String, Object> data ){

        Vessel vessel = mapper.convertValue(data, Vessel.class);
        Integer mmsiIntJms = vessel.getMmsiInt();
        System.out.println(new Date()+" receive message from JMS vesselName: "+vessel.getNameStr()+", WidthDbl: "+vessel.getWidthDbl()+", LengthDbl: "+vessel.getLengthDbl()+", shipType: "+vessel.getShiptypeInt());

        Vessel vesselDb = vesselBusinessService.findByMmsiInt(mmsiIntJms);
        if (vesselDb == null) {
            //System.out.println("inserting vessel data: " + data);
            vessel.setCreatedDateDti(new Date());
            vesselDb = vesselBusinessService.save(vessel);
        } else {
            //System.out.println("updating vessel  vesselDb ID: "+vesselDb.getIdInt()+", data: " + data);
            Integer vesselDbId = vesselDb.getIdInt();

            if(reportType.equals("StaticVoyageRelatedData")){
                vesselDb.setMmsiInt(vessel.getMmsiInt());
                vesselDb.setImoNumberInt(vessel.getImoNumberInt());
                vesselDb.setNameStr(vessel.getNameStr());
                vesselDb.setVesselTypeStr(vessel.getVesselTypeStr()); // need to confirm to Ben
                if(vessel.getShiptypeInt()!=null){
                    VesselTypeAis vesselType = vesselTypeLookupService.getVesselTypeByCode(vessel.getShiptypeInt());
                    if(vesselType!=null){
                        vesselDb.setVesselTypeAis(vesselType);
                    }
                }
                vesselDb.setCallsignStr(vessel.getCallsignStr());
                vesselDb.setDestinationStr(vessel.getDestinationStr());
                vesselDb.setLengthDbl(vessel.getLengthDbl());
                vesselDb.setWidthDbl(vessel.getWidthDbl());
                vesselDb.setDraftDbl(vessel.getDraftDbl());
                vesselDb.setRepeatIndicatorDbl(vessel.getRepeatIndicatorDbl());
                vesselDb.setAisVersionInt(vessel.getAisVersionInt());
                vesselDb.setToBowDbl(vessel.getToBowDbl());
                vesselDb.setToSternDbl(vessel.getToSternDbl());
                vesselDb.setToPortDbl(vessel.getToPortDbl());
                vesselDb.setToStarboardDbl(vessel.getToStarboardDbl());
                vesselDb.setEtaStr(vessel.getEtaStr());
                vesselDb.setDteInt(vessel.getDteInt());
                vesselDb.setEpfdInt(vessel.getEpfdInt());
                vesselDb.setModifiedDateDti(new Date());
            }
            if(reportType.equals("StaticDataReport")){

                vesselDb.setMmsiInt(vessel.getMmsiInt());
                vesselDb.setMothershipMmsiInt(vessel.getMothershipMmsiInt());
                vesselDb.setNameStr(vessel.getNameStr());
                vesselDb.setVesselTypeStr(vessel.getVesselTypeStr()); // need to confirm to Ben
                if(vessel.getShiptypeInt()!=null){
                    VesselTypeAis vesselType = vesselTypeLookupService.getVesselTypeByCode(vessel.getShiptypeInt());
                    if(vesselType!=null){
                        vesselDb.setVesselTypeAis(vesselType);
                    }
                }
                vesselDb.setCallsignStr(vessel.getCallsignStr());
                vesselDb.setLengthDbl(vessel.getLengthDbl());
                vesselDb.setWidthDbl(vessel.getWidthDbl());
                vesselDb.setDraftDbl(vessel.getDraftDbl());
                vesselDb.setRepeatIndicatorDbl(vessel.getRepeatIndicatorDbl());
                vesselDb.setToBowDbl(vessel.getToBowDbl());
                vesselDb.setToSternDbl(vessel.getToSternDbl());
                vesselDb.setToPortDbl(vessel.getToPortDbl());
                vesselDb.setToStarboardDbl(vessel.getToStarboardDbl());
                vesselDb.setPartnoInt(vessel.getPartnoInt());
                vesselDb.setVendoridStr(vessel.getVendoridStr());
                vesselDb.setModelInt(vessel.getModelInt());
                vesselDb.setSerialInt(vessel.getSerialInt());
                vesselDb.setModifiedDateDti(new Date());
            }
            //System.out.println("updatedVessel   vesselDb.getIdInt(): "+vesselDb.getIdInt()+", vesselDbId: "+vesselDbId);
            vesselBusinessService.save(vesselDb);
        }

        PositionReportLast positionReportLast = positionReportLastDataService.findOneByVesselIdInt(vesselDb.getIdInt());
        if(positionReportLast!=null){
            //System.out.println("found positionReportLast getVesselIdInt:  "+positionReportLast.getVesselIdInt());
        }
        vesselDb.setPositionReportLast(positionReportLast);
        // test dummy data
//        if(vesselDb.getMmsiInt()==457744000) {
//        vesselDb.setLengthDbl(100.0);
//        vesselDb.setWidthDbl(200.0);
//        vesselDb.setDraftDbl(300.0);
//        positionReportLast = new PositionReportLast();
//        positionReportLast.setLatitudeDbl(32.104447);
//        positionReportLast.setLongitudeDbl(34.865108);
//         //   System.out.println("found vesselDb.getMmsiInt() 563002360 sending email");
//        }
        // test dummy data
        if(positionReportLast!=null)
        geofenceUtil.checkGeofenceInfringement(vesselDb,positionReportLast);
        try {
            producerService.sendToVesselTopic(vesselDb);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public void processPositionReport(String type, Map<String, Object> data ){
        //System.out.println(" data: "+data);
        PositionReport positionReport = mapper.convertValue(data, PositionReport.class);
        //System.out.println(" data type: "+type+": getCsInt: "+positionReport.getCsInt()+", getBandInt: "+positionReport.getBandInt()+", getMsg22Int: "+positionReport.getMsg22Int());
        //System.out.println(" positionReport.getTimestampDti(): "+positionReport.getTimestampDti());
        Vessel vessel = positionReport.getVessel();
        //System.out.println(" vessel: "+vessel);
        Integer mmsiInt = vessel.getMmsiInt();
        //System.out.println(" vessel mmsiInt: "+mmsiInt);
        Vessel vesselDb = vesselBusinessService.findByMmsiInt(mmsiInt);
        //System.out.println(" vesselDb: "+vesselDb);
        // for test, comment insert vessel
        if(vesselDb==null){
            vessel.setCreatedDateDti(new Date());
            vesselDb =  vesselBusinessService.save(vessel);
            //System.out.println(" vesselDb getIdInt after save: "+vesselDb.getIdInt());
        }
        positionReport.setVessel(vesselDb);

        if(vesselDb!=null) {
            positionReportBusinessService.deleteForAisUpdate(mmsiInt, positionReport.getTimestampDti());
            positionReportBusinessService.save(positionReport);
        }
        positionReport.setVessel(null);
        if(vesselDb!=null) {
            vesselDb.setPositionReportLast(positionReport);
        }
        // test dummy data
//        vesselDb.setLengthDbl(100.0);
//        vesselDb.setWidthDbl(200.0);
//        vesselDb.setDraftDbl(300.0);
//        positionReport.setLatitudeDbl(32.104447);
//        positionReport.setLongitudeDbl(34.865108);
        // test dummy data
        if(vesselDb!=null) {
            geofenceUtil.checkGeofenceInfringement(vesselDb, positionReport);
        }
        // Testing dummie data
        //                SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss");
        //                try {
        //                    Date timestampDti =    sdf.parse("11-06-2023 10:10:11");
        //                    positionReportBusinessService.deleteForAisUpdate(111,timestampDti);
        //                } catch (ParseException e) {
        //                    throw new RuntimeException(e);
        //                }

        try {
            if(vesselDb!=null) {
                producerService.sendToVesselTopic(vesselDb);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
