package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.data.dto.GeofenceAlertTrigger;
import sg.com.simplus.mvms.service.dataservice.GeofenceAlertTriggerDataService;
import sg.com.simplus.mvms.service.dataservice.GeofenceDataService;
import sg.com.simplus.mvms.service.mapperservice.GeofenceMapper;

import java.util.List;
import java.util.Map;

@Service
public class GeofenceBusinessService {

    @Autowired
    GeofenceDataService geofenceDataService;

    @Autowired
    GeofenceAlertTriggerDataService geofenceAlertTriggerDataService;

    public  List<Map<String,Object>> findAll( ){
        List<Geofence> geofenceList = geofenceDataService.findAll();
        return GeofenceMapper.getListMap(geofenceList);
    }

    public Geofence save(Geofence geofence){
        System.out.println("GeofenceBusinessService save geofence email: "+geofence.getEmailStr());
        List<GeofenceAlertTrigger> geofenceAlertTriggerList = geofence.getGeofenceAlertTriggerList();
        Geofence geofenceSaved =  geofenceDataService.save(geofence);
        geofenceAlertTriggerDataService.deleteByGeofenceIdInt(geofence.getIdInt());
        for(GeofenceAlertTrigger geofenceAlertTrigger: geofenceAlertTriggerList){
            geofenceAlertTrigger.setGeofence(geofenceSaved);
            geofenceAlertTriggerDataService.save(geofenceAlertTrigger);
        }
        return geofenceSaved;
    }

    public Geofence update(Geofence geofence){
        System.out.println("GeofenceBusinessService before update geofence email: "+geofence.getEmailStr());
        Geofence geofenceDb = geofenceDataService.findByIdInt(geofence.getIdInt());
        List<GeofenceAlertTrigger> geofenceAlertTriggerList = geofence.getGeofenceAlertTriggerList();
        for(GeofenceAlertTrigger geofenceAlertTrigger: geofenceAlertTriggerList){
            geofenceAlertTrigger.setGeofence(geofenceDb);
            Integer geofenceAlertTriggerIdInt = geofenceAlertTrigger.getIdInt();
            if(geofenceAlertTriggerIdInt==null){
                GeofenceAlertTrigger geofenceAlertTriggerSaved = geofenceAlertTriggerDataService.update(geofenceAlertTrigger);
                geofenceAlertTriggerSaved.setVesselTypeAisList(geofenceAlertTrigger.getVesselTypeAisList());
                geofenceAlertTriggerSaved.setVesselTypeProjectList(geofenceAlertTrigger.getVesselTypeProjectList());
                geofenceAlertTriggerDataService.saveVesselTypeCriteriaByGeofenceAlertTrigger(geofenceAlertTriggerSaved);
            } else {
                geofenceAlertTriggerDataService.deleteVesselTypeCriteriaByGeofenceAlertTriggerIdInt(geofenceAlertTriggerIdInt);
                GeofenceAlertTrigger geofenceAlertTriggerSaved = geofenceAlertTriggerDataService.update(geofenceAlertTrigger);
                geofenceAlertTriggerSaved.setVesselTypeAisList(geofenceAlertTrigger.getVesselTypeAisList());
                geofenceAlertTriggerSaved.setVesselTypeProjectList(geofenceAlertTrigger.getVesselTypeProjectList());
                geofenceAlertTriggerDataService.saveVesselTypeCriteriaByGeofenceAlertTrigger(geofenceAlertTriggerSaved);
            }

        }
        geofence.setSymbolType(geofenceDb.getSymbolType());
        geofence.setCreatedDateDti(geofenceDb.getCreatedDateDti());
        System.out.println("GeofenceBusinessService after update geofence email: "+geofence.getEmailStr());
        return geofenceDataService.save(geofence);
    }

    public void deleteByIdInt(Integer idInt){
        geofenceDataService.deleteByIdInt(idInt);
    }
}
