package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.UserGroup;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class UserGroupMapper {

    public static  Map<String,Object> getMap(UserGroup userGroup){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<UserGroup>(userGroup, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<UserGroup> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<UserGroup>>(list, AuditFields.EXCLUDE).init().build();
        return  result;
    }

}
