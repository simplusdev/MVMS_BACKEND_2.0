package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.GeofenceAlertTrigger;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.GeofenceAlertTriggerEntity;
import sg.com.simplus.mvms.data.repository.GeofenceAlertTriggerRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class GeofenceAlertTriggerDataService extends DataServiceEngine<GeofenceAlertTriggerEntity,GeofenceAlertTrigger> {
    @Autowired
    GeofenceAlertTriggerRepository geofenceAlertTriggerRepository;

    public List<GeofenceAlertTrigger> findAll(){
        return toDtoList(geofenceAlertTriggerRepository.findAll());
    }

    public Vessel save(GeofenceAlertTrigger geofenceAlertTrigger){
        return  toDto(geofenceAlertTriggerRepository.save(toEntity(geofenceAlertTrigger)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<GeofenceAlertTriggerEntity> registerEntityClass() {
        return GeofenceAlertTriggerEntity.class;
    }

    @Override
    public Class<GeofenceAlertTrigger> registerDtoClass() {
        return GeofenceAlertTrigger.class;
    }
}
