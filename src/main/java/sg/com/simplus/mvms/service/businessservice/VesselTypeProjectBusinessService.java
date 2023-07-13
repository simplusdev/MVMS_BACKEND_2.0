package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.dto.VesselTypeProject;
import sg.com.simplus.mvms.service.dataservice.VesselTypeProjectDataService;
import sg.com.simplus.mvms.service.mapperservice.VesselTypeProjectMapper;

import java.util.List;
import java.util.Map;

@Service
public class VesselTypeProjectBusinessService {

    @Autowired
    VesselTypeProjectDataService vesselTypeProjectDataService;
    public  List<Map<String,Object>> findAll(){
        List<VesselTypeProject> vesselTypeProjectList = vesselTypeProjectDataService.findAll();
        return VesselTypeProjectMapper.getListMap(vesselTypeProjectList);
    }

    public VesselTypeProject save(VesselTypeProject vesselTypeProject){
        return vesselTypeProjectDataService.save(vesselTypeProject);
    }
}
