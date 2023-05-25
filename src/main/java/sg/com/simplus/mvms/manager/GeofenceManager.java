package sg.com.simplus.mvms.manager;

import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.service.mapperservice.GeofenceMapper;

import java.util.Map;

public class GeofenceManager extends BusinessManager {

    public Map<String,Object> saveReturnMap(Geofence geofence) {
        Geofence geofenceResult = geofenceBusinessService.save(geofence);
        Map<String,Object> geofenceMap = GeofenceMapper.getMap(geofenceResult);
        return geofenceMap;
    }
}
