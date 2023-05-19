package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.data.dto.UserSetting;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.BuoyDataService;
import sg.com.simplus.mvms.service.dataservice.UserSettingDataService;
import sg.com.simplus.mvms.service.mapperservice.UserSettingMapper;

import java.util.List;
import java.util.Map;

@Service
public class UserSettingBusinessService {

    @Autowired
    UserSettingDataService userSettingDataService;

    public  List<Map<String,Object>> findAll(ViewData viewData){
        List<UserSetting> userSettingList = userSettingDataService.findAll();
        return UserSettingMapper.getListMap(userSettingList);
    }
}
