package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.PositionReportLast;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class PositionReportLastMapper {

    public static  Map<String,Object> getMap(PositionReportLast positionReportLast){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<PositionReportLast>(positionReportLast).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<PositionReportLast> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<PositionReportLast>>(list).init().build();
        return  result;
    }

}
