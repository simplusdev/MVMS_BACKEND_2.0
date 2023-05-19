package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.GeofenceDataService;
import sg.com.simplus.mvms.service.mapperservice.GeofenceMapper;

import java.util.List;
import java.util.Map;

@Service
public class GeofenceBusinessService {

    @Autowired
    GeofenceDataService geofenceDataService;

    public  List<Map<String,Object>> findAll( ){
        List<Geofence> geofenceList = geofenceDataService.findAll();
        return GeofenceMapper.getListMap(geofenceList);
    }
}
