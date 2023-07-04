package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.VesselTypeProjectCriteria;
import sg.com.simplus.mvms.data.entity.VesselTypeProjectCriteriaEntity;
import sg.com.simplus.mvms.data.repository.VesselTypeProjectCriteriaRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class VesselTypeProjectCriteriaDataService extends DataServiceEngine<VesselTypeProjectCriteriaEntity,VesselTypeProjectCriteria> {
    @Autowired
    VesselTypeProjectCriteriaRepository vesselTypeProjectCriteriaRepository;

    public List<VesselTypeProjectCriteria> findAll(){
        return toDtoList(vesselTypeProjectCriteriaRepository.findAll());
    }

    public List<VesselTypeProjectCriteriaEntity> findByGeofenceAlertTriggerEntityIdInt(@Param("geofenceAlertTriggerId") Integer geofenceAlertTriggerId){
        return toDtoList(vesselTypeProjectCriteriaRepository.findByGeofenceAlertTriggerIdInt(geofenceAlertTriggerId));
    }

    public void deleteByGeofenceAlertTriggerIdInt(@Param("geofenceAlertTriggerId") Integer geofenceAlertTriggerId){
        vesselTypeProjectCriteriaRepository.deleteByGeofenceAlertTriggerIdInt(geofenceAlertTriggerId);
    }

    public VesselTypeProjectCriteria save(VesselTypeProjectCriteria vesselTypeProjectCriteria){
        return  toDto(vesselTypeProjectCriteriaRepository.save(toEntity(vesselTypeProjectCriteria)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<VesselTypeProjectCriteriaEntity> registerEntityClass() {
        return VesselTypeProjectCriteriaEntity.class;
    }

    @Override
    public Class<VesselTypeProjectCriteria> registerDtoClass() {
        return VesselTypeProjectCriteria.class;
    }
}
