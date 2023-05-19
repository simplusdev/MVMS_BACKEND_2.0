package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.GeofenceEntity;
import sg.com.simplus.mvms.data.repository.GeofenceRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class GeofenceDataService extends DataServiceEngine<GeofenceEntity,Geofence> {
    @Autowired
    GeofenceRepository geofenceRepository;

    public List<Geofence> findAll(){
        return toDtoList(geofenceRepository.findAll());
    }

    public Vessel save(Geofence geofence){
        return  toDto(geofenceRepository.save(toEntity(geofence)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<GeofenceEntity> registerEntityClass() {
        return GeofenceEntity.class;
    }

    @Override
    public Class<Geofence> registerDtoClass() {
        return Geofence.class;
    }
}
