package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.GeofenceAlertTrigger;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class GeofenceAlertTriggerMapper {

    public static  Map<String,Object> getMap(GeofenceAlertTrigger geofenceAlertTrigger){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<GeofenceAlertTrigger>(geofenceAlertTrigger, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<GeofenceAlertTrigger> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<GeofenceAlertTrigger>>(list).init().build();
        return  result;
    }

}
