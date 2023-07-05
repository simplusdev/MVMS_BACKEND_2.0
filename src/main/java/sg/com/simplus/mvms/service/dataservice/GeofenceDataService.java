package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.data.dto.GeofenceAlertTrigger;
import sg.com.simplus.mvms.data.entity.GeofenceEntity;
import sg.com.simplus.mvms.data.repository.GeofenceRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeofenceDataService extends DataServiceEngine<GeofenceEntity,Geofence> {
    @Autowired
    GeofenceRepository geofenceRepository;

    @Autowired
    GeofenceAlertTriggerDataService geofenceAlertTriggerDataService;

    public List<Geofence> findAll(){
         List<Geofence> geofenceList = toDtoList(geofenceRepository.findAll());
         List<GeofenceAlertTrigger> geofenceAlertTriggerList = geofenceAlertTriggerDataService.findAll();
        Map<Integer, List<GeofenceAlertTrigger> > gatMap = new HashMap<>();

        for(GeofenceAlertTrigger geofenceAlertTrigger: geofenceAlertTriggerList){
            List<GeofenceAlertTrigger> gatList = gatMap.get(geofenceAlertTrigger.getGeofence().getIdInt());
            if(gatList==null){
                gatList = new ArrayList<>();
            }
            gatList.add(geofenceAlertTrigger);
            gatMap.put(geofenceAlertTrigger.getGeofence().getIdInt(),gatList);
        }
        for(Geofence geofence: geofenceList){
            geofence.setGeofenceAlertTriggerList(gatMap.get(geofence.getIdInt()));
        }
        return geofenceList;
    }

    public List<Geofence> findByDeletedIntNot(Integer deletedInt){
        return toDtoList(geofenceRepository.findByDeletedIntNot(deletedInt));
    }

    public Geofence findByIdInt(@Param("idInt") Integer idInt){
        List<Geofence> geofenceList = toDtoList(geofenceRepository.findByIdInt(idInt));
        if(geofenceList !=null && geofenceList.size()>0){
            return geofenceList.get(0);
        }
        return  null;
    }

    public Geofence save(Geofence geofence){
        String email  = geofence.getEmailStr();
        System.out.println("GeofenceDataService save geofence email: "+email);
        return  toDto(geofenceRepository.save(toEntity(geofence)) );
    }

    public void deleteByIdInt(Integer idInt){
        geofenceRepository.deleteByIdInt(idInt);
    }

    @Override
    public  void customDto(Object entity, Object dto) {
        Geofence geofence = (Geofence) dto;
        GeofenceEntity geofenceEntity = (GeofenceEntity) entity;
        geofence.setTransparentBln(geofenceEntity.getTransparentInt()==null?false:geofenceEntity.getTransparentInt()==1?true:false);
        geofence.setDeletedBln(geofenceEntity.getDeletedInt()==null?false: geofenceEntity.getDeletedInt()==1?true:false);
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
