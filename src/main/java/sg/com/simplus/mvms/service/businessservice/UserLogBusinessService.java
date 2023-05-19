package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserLog;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.UserLogDataService;
import sg.com.simplus.mvms.service.mapperservice.UserLogMapper;

import java.util.List;
import java.util.Map;

@Service
public class UserLogBusinessService {

    @Autowired
    UserLogDataService userLogDataService;

    public  List<Map<String,Object>> findAll(ViewData viewData){
        List<UserLog> userLogList = userLogDataService.findAll();
        return UserLogMapper.getListMap(userLogList);
    }
}
