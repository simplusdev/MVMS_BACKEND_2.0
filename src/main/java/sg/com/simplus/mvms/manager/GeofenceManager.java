package sg.com.simplus.mvms.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.service.mapperservice.GeofenceMapper;

import java.util.Map;

public class GeofenceManager extends BusinessManager {

    public Map<String,Object> saveReturnMap(Geofence geofence) {
        Geofence geofenceResult = geofenceBusinessService.save(geofence);
        try {
            geofence.setIdInt(geofenceResult.getIdInt());
            producerService.sendToGeofenceTopic(geofence);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Map<String,Object> geofenceMap = GeofenceMapper.getMap(geofenceResult);
        return geofenceMap;
    }

    public Map<String,Object> updateReturnMap(Geofence geofence) {
        Geofence geofenceResult = geofenceBusinessService.update(geofence);
        try {
            geofence.setIdInt(geofenceResult.getIdInt());
            producerService.sendToGeofenceTopic(geofence);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Map<String,Object> geofenceMap = GeofenceMapper.getMap(geofenceResult);
        return geofenceMap;
    }
}
