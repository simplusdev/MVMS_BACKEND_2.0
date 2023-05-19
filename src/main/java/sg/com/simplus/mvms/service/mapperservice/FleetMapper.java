package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.Fleet;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;


import java.util.List;
import java.util.Map;

public class FleetMapper {

    public static  Map<String,Object> getMap(Fleet fleet){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<Fleet>(fleet).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<Fleet> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<Fleet>>(list, AuditFields.EXCLUDE).init().build();
        return  result;
    }

}
