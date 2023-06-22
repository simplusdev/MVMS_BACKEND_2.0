package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.VesselTypeProject;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.VesselTypeProjectEntity;
import sg.com.simplus.mvms.data.repository.VesselTypeProjectRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class VesselTypeProjectDataService extends DataServiceEngine<VesselTypeProjectEntity,VesselTypeProject> {
    @Autowired
    VesselTypeProjectRepository vesselTypeProjectRepository;

    public List<VesselTypeProject> findAll(){
        return toDtoList(vesselTypeProjectRepository.findAll());
    }

    public Vessel save(VesselTypeProject vesselTypeProject){
        return  toDto(vesselTypeProjectRepository.save(toEntity(vesselTypeProject)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<VesselTypeProjectEntity> registerEntityClass() {
        return VesselTypeProjectEntity.class;
    }

    @Override
    public Class<VesselTypeProject> registerDtoClass() {
        return VesselTypeProject.class;
    }
}
