package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.GeofenceAlertTrigger;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.GeofenceAlertTriggerDataService;
import sg.com.simplus.mvms.service.mapperservice.GeofenceAlertTriggerMapper;

import java.util.List;
import java.util.Map;

@Service
public class GeofenceAlertTriggerBusinessService {

    @Autowired
    GeofenceAlertTriggerDataService geofenceAlertTriggerDataService;

    public  List<Map<String,Object>> findAll(){
        List<GeofenceAlertTrigger> geofenceAlertTriggerList = geofenceAlertTriggerDataService.findAll();
        return GeofenceAlertTriggerMapper.getListMap(geofenceAlertTriggerList);
    }
}
