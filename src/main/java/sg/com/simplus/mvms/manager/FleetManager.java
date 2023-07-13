package sg.com.simplus.mvms.manager;

 

import sg.com.simplus.mvms.data.dto.Fleet;
import sg.com.simplus.mvms.service.mapperservice.FleetMapper;

import java.util.Map;

public class FleetManager extends BusinessManager {

    public Map<String,Object> saveReturnMap(Fleet fleet) {
        Fleet fleetResult = fleetBusinessService.save(fleet);
        Map<String,Object> fleetMap = FleetMapper.getMap(fleetResult);
        return fleetMap;
    }

    public Map<String,Object> updateReturnMap(Fleet fleet) {
        Fleet fleetResult = fleetBusinessService.update(fleet);
        Map<String,Object> fleetMap = FleetMapper.getMap(fleetResult);
        return fleetMap;
    }
}
