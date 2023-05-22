package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.Route;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class RouteMapper {

    public static  Map<String,Object> getMap(Route route){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<Route>(route, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<Route> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<Route>>(list).init().build();
        return  result;
    }

}
