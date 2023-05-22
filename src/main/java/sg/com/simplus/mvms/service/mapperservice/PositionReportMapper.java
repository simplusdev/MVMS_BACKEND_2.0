package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class PositionReportMapper {

    public static  Map<String,Object> getMap(PositionReport positionReport){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<PositionReport>(positionReport, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<PositionReport> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<PositionReport>>(list).init().build();
        return  result;
    }

}
