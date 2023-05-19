package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Alert;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.AlertDataService;
import sg.com.simplus.mvms.service.mapperservice.AlertMapper;

import java.util.List;
import java.util.Map;

@Service
public class AlertBusinessService {

    @Autowired
    AlertDataService alertDataService;

    public  List<Map<String,Object>> findAll(){
        List<Alert> alertList = alertDataService.findAll();
        return AlertMapper.getListMap(alertList);
    }
}
