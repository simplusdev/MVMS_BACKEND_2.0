package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.UserSetting;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class UserSettingMapper {

    public static  Map<String,Object> getMap(UserSetting userSetting){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<UserSetting>(userSetting, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<UserSetting> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<UserSetting>>(list).init().build();
        return  result;
    }

}
