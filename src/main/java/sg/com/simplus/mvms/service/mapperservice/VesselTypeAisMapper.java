package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.VesselTypeAis;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class VesselTypeAisMapper {

    public static  Map<String,Object> getMap(VesselTypeAis vesselTypeAis){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<VesselTypeAis>(vesselTypeAis, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<VesselTypeAis> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<VesselTypeAis>>(list).init().build();
        return  result;
    }

}
