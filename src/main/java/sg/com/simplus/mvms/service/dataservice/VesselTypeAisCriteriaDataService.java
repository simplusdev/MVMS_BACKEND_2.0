package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.VesselTypeAisCriteria;
import sg.com.simplus.mvms.data.entity.VesselTypeAisCriteriaEntity;
import sg.com.simplus.mvms.data.repository.VesselTypeAisCriteriaRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class VesselTypeAisCriteriaDataService extends DataServiceEngine<VesselTypeAisCriteriaEntity,VesselTypeAisCriteria> {
    @Autowired
    VesselTypeAisCriteriaRepository vesselTypeAisCriteriaRepository;

    public List<VesselTypeAisCriteria> findAll(){
        return toDtoList(vesselTypeAisCriteriaRepository.findAll());
    }

    public List<VesselTypeAisCriteriaEntity> findByGeofenceAlertTriggerEntityIdInt(@Param("geofenceAlertTriggerId") Integer geofenceAlertTriggerId){
        return toDtoList(vesselTypeAisCriteriaRepository.findByGeofenceAlertTriggerIdInt(geofenceAlertTriggerId));
    }

    public void deleteByGeofenceAlertTriggerIdInt(@Param("geofenceAlertTriggerId") Integer geofenceAlertTriggerId){
        vesselTypeAisCriteriaRepository.deleteByGeofenceAlertTriggerIdInt(geofenceAlertTriggerId);
    }

    public VesselTypeAisCriteria save(VesselTypeAisCriteria vesselTypeAisCriteria){
        return  toDto(vesselTypeAisCriteriaRepository.save(toEntity(vesselTypeAisCriteria)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<VesselTypeAisCriteriaEntity> registerEntityClass() {
        return VesselTypeAisCriteriaEntity.class;
    }

    @Override
    public Class<VesselTypeAisCriteria> registerDtoClass() {
        return VesselTypeAisCriteria.class;
    }
}
