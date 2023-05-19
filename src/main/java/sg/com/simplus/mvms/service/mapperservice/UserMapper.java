package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.User;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class UserMapper {

    public static  Map<String,Object> getMap(User user){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<User>(user).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<User> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<User>>(list).init().build();
        return  result;
    }

}