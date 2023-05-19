package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.Alert;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class AlertMapper {

    public static  Map<String,Object> getMap(Alert alert){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<Alert>(alert).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<Alert> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<Alert>>(list).init().build();
        return  result;
    }

}
