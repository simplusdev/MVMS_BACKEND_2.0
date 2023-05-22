package sg.com.simplus.mvms.manager;

import sg.com.simplus.mvms.data.dto.UserSetting;
import sg.com.simplus.mvms.service.mapperservice.UserSettingMapper;

import java.util.Map;

public class UserSettingManager extends BusinessManager {
    public Map<String,Object> saveReturnMap(UserSetting userSetting) {
        UserSetting userSettingResult = userSettingBusinessService.save(userSetting);
        Map<String,Object> userSettingMap = UserSettingMapper.getMap(userSettingResult);
        return userSettingMap;
    }
}
