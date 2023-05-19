package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.constant.MapFieldsStrategy;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class VesselMapper {
    public static Map<String,Object> getMap(Vessel vessel){
        Map<String,Object> aMap =(Map<String,Object>) new DtoMapper.MapBuilderEngine<Vessel>(vessel, AuditFields.EXCLUDE).init().build();
        return  aMap;
    }

    public static Map<String,Object> getMapWithIdAndNameAndMmsi(Vessel vessel){
        Map<String,Object> aMap =(Map<String,Object>) new DtoMapper.MapBuilderEngine<Vessel>(vessel, MapFieldsStrategy.ONLY_CONSTRUCT_SOME_FIELDS, AuditFields.EXCLUDE).init().add("idInt").add("nameStr").add("mmsiInt").build();
        return  aMap;
    }

    public static List<Map<String,Object>> getListMap(List<Vessel> vessel){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<Vessel>>(vessel, AuditFields.EXCLUDE)
                .init()
                .build();
        return  result;
    }
}
