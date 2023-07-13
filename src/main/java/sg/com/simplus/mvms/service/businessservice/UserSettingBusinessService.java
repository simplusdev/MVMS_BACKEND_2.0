package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.data.dto.UserSetting;
import sg.com.simplus.mvms.data.dto.Vessel;
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

    public  List<Map<String,Object>> findAll(){
        List<UserSetting> userSettingList = userSettingDataService.findAll();
        return UserSettingMapper.getListMap(userSettingList);
    }

    public UserSetting save(UserSetting userSetting){
        return   userSettingDataService.save(userSetting);
    }

    public void deleteByIdInt(Integer idInt){
        userSettingDataService.deleteByIdInt(idInt);
    }

    public void deleteByUserIdInt(Integer userIdInt){
        userSettingDataService.deleteByUserIdInt(userIdInt);
    }
}
