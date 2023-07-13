package sg.com.simplus.mvms.manager;

import sg.com.simplus.mvms.data.dto.VesselTypeProject;
import sg.com.simplus.mvms.service.mapperservice.VesselTypeProjectMapper;

import java.util.Map;

public class VesselTypeProjectManager extends BusinessManager {

    public Map<String,Object> saveReturnMap(VesselTypeProject vesselTypeProject){
        VesselTypeProject vesselTypeProjectResult = vesselTypeProjectBusinessService.save(vesselTypeProject);
        Map<String,Object> map = VesselTypeProjectMapper.getMap(vesselTypeProjectResult);
        return map;
    }

}
