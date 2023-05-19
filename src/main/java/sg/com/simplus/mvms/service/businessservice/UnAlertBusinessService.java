package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UnAlert;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.UnAlertDataService;
import sg.com.simplus.mvms.service.mapperservice.UnAlertMapper;

import java.util.List;
import java.util.Map;

@Service
public class UnAlertBusinessService {

    @Autowired
    UnAlertDataService unAlertDataService;

    public  List<Map<String,Object>> findAll(ViewData viewData){
        List<UnAlert> unAlertList = unAlertDataService.findAll();
        return UnAlertMapper.getListMap(unAlertList);
    }
}
