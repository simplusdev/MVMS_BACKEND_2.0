package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.ProjectVesselType;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.ProjectVesselTypeEntity;
import sg.com.simplus.mvms.data.repository.ProjectVesselTypeRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class ProjectVesselTypeDataService extends DataServiceEngine<ProjectVesselTypeEntity,ProjectVesselType> {
    @Autowired
    ProjectVesselTypeRepository projectVesselTypeRepository;

    public List<ProjectVesselType> findAll(){
        return toDtoList(projectVesselTypeRepository.findAll());
    }

    public Vessel save(ProjectVesselType projectVesselType){
        return  toDto(projectVesselTypeRepository.save(toEntity(projectVesselType)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<ProjectVesselTypeEntity> registerEntityClass() {
        return ProjectVesselTypeEntity.class;
    }

    @Override
    public Class<ProjectVesselType> registerDtoClass() {
        return ProjectVesselType.class;
    }
}
