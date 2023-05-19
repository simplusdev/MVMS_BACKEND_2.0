package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class BuoyMapper {

    public static  Map<String,Object> getMap(Buoy buoy){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<Buoy>(buoy).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<Buoy> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<Buoy>>(list).init().build();
        return  result;
    }

}
