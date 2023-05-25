package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.data.dto.Geofence;
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

    public Geofence save(Geofence geofence){
        return  toDto(geofenceRepository.save(toEntity(geofence)) );
    }

    public void deleteByIdInt(Integer idInt){
        geofenceRepository.deleteByIdInt(idInt);
    }

    @Override
    public  void customDto(Object entity, Object dto) {
        Geofence geofence = (Geofence) dto;
        GeofenceEntity geofenceEntity = (GeofenceEntity) entity;
        geofence.setTransparentBln(geofenceEntity.getTransparentInt()==1?true:false);
        geofence.setDeletedBln(geofenceEntity.getDeletedInt()==1?true:false);
    }

    @Override
    public void customEntity(Object dto, Object entity) {
        GeofenceEntity geofenceEntity = (GeofenceEntity) entity;
        Geofence geofence = (Geofence) dto;
        geofenceEntity.setTransparentInt(geofence.getTransparentBln()?1:0);
        geofenceEntity.setDeletedInt(geofence.getDeletedBln()?1:0);
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
