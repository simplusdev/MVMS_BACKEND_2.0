package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.BuoyDataService;
import sg.com.simplus.mvms.service.mapperservice.BuoyMapper;

import java.util.List;
import java.util.Map;

@Service
public class BuoyBusinessService {

    @Autowired
    BuoyDataService buoyDataService;
    public  List<Map<String,Object>> findAll(){
        List<Buoy> buoyList = buoyDataService.findAll();
        return BuoyMapper.getListMap(buoyList);
    }

    public Buoy save(Buoy buoy){
        return buoyDataService.save(buoy);
    }

    public void deleteByIdInt(Integer idInt){
        buoyDataService.deleteByIdInt(idInt);
    }
}
