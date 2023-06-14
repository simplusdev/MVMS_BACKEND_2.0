package sg.com.simplus.mvms.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.service.dataservice.GeofenceAlertTriggerDataService;
import sg.com.simplus.mvms.service.dataservice.GeofenceDataService;

import java.util.*;

@Component
public class GeofenceLookupService {

    @Autowired
    GeofenceDataService geofenceDataService;

    @Autowired
    GeofenceAlertTriggerDataService geofenceAlertTriggerDataService;

    private static LinkedHashMap<Integer,Geofence> geofenceList = new LinkedHashMap<Integer,Geofence>();

    public void fetch(){
        List<Geofence>  itemList =  geofenceDataService.findAll();
        System.out.println("GeofenceLookupService fetch itemList size: "+itemList.size());
        for(Geofence geofence: itemList){
            if(!geofenceList.containsKey(geofence.getIdInt())) {
                geofence.setGeofenceAlertTriggerList(geofenceAlertTriggerDataService.findByGeofenceIdInt(geofence.getIdInt()));
                System.out.println("GeofenceLookupService getGeofenceAlertTriggerList size: "+geofence.getGeofenceAlertTriggerList().size());
                geofenceList.put(geofence.getIdInt(), geofence);
            }
        }
    }

    public static List<Geofence> getGeofenceList() {
        return new ArrayList<>(geofenceList.values());
    }
}
