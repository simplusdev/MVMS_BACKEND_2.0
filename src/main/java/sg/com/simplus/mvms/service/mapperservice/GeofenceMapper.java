package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class GeofenceMapper {

    public static  Map<String,Object> getMap(Geofence geofence){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<Geofence>(geofence, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<Geofence> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<Geofence>>(list, AuditFields.EXCLUDE).init().build();
        return  result;
    }

}
