package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.VesselTypeProject;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class VesselTypeProjectMapper {

    public static  Map<String,Object> getMap(VesselTypeProject vesselTypeProject){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<VesselTypeProject>(vesselTypeProject, AuditFields.EXCLUDE).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<VesselTypeProject> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<VesselTypeProject>>(list).init().build();
        return  result;
    }

}
