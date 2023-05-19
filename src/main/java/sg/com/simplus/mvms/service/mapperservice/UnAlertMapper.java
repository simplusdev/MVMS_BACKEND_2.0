package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.UnAlert;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class UnAlertMapper {

    public static  Map<String,Object> getMap(UnAlert unAlert){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<UnAlert>(unAlert).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<UnAlert> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<UnAlert>>(list).init().build();
        return  result;
    }

}
