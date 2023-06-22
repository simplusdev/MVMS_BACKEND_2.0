package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.VesselTypeAis;
import sg.com.simplus.mvms.service.dataservice.VesselTypeAisDataService;
import sg.com.simplus.mvms.service.mapperservice.VesselTypeAisMapper;

import java.util.List;
import java.util.Map;

@Service
public class VesselTypeAisBusinessService {

    @Autowired
    VesselTypeAisDataService vesselTypeAisDataService;
    public  List<Map<String,Object>> findAll(){
        List<VesselTypeAis> vesselTypeAisList = vesselTypeAisDataService.findAll();
        return VesselTypeAisMapper.getListMap(vesselTypeAisList);
    }
}
