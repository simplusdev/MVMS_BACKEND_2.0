package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.UserLog;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class UserLogMapper {

    public static  Map<String,Object> getMap(UserLog userLog){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<UserLog>(userLog).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<UserLog> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<UserLog>>(list).init().build();
        return  result;
    }

}
