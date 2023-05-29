package sg.com.simplus.mvms.manager;

import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.service.mapperservice.BuoyMapper;

import java.util.Map;

public class BuoyManager extends BusinessManager {

    public Map<String,Object> saveReturnMap(Buoy buoy) {
        Buoy buoyResult = buoyBusinessService.save(buoy);
        Map<String,Object> buoyMap = BuoyMapper.getMap(buoyResult);
        return buoyMap;
    }
    
}
