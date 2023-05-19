package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.ProjectVesselType;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class ProjectVesselTypeMapper {

    public static  Map<String,Object> getMap(ProjectVesselType projectVesselType){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<ProjectVesselType>(projectVesselType).init().build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<ProjectVesselType> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<ProjectVesselType>>(list).init().build();
        return  result;
    }

}
