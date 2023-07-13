package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Fleet;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.FleetEntity;
import sg.com.simplus.mvms.data.repository.FleetRepository;
import sg.com.simplus.mvms.data.repository.VesselRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class FleetDataService extends DataServiceEngine<FleetEntity,Fleet> {
    @Autowired
    FleetRepository fleetRepository;

    @Autowired
    VesselDataService vesselDataService;

    public List<Fleet> findAll(){
        return toDtoList(fleetRepository.findAll());
    }

    public Fleet findByIdInt(@Param("idInt") Integer idInt){
        List<FleetEntity> entityList = fleetRepository.findByIdInt(idInt);
        if(entityList!=null && entityList.size() > 0 ){
            return toDto(entityList.get(0));
        }
        return null;
    }

    public Fleet save(Fleet fleet){
        return  toDto(fleetRepository.save(toEntity(fleet)) );
    }

    public void deleteByIdInt(Integer idInt){
        List<Vessel> vesselList = vesselDataService.findByFleetIdInt(idInt);
        for(Vessel vessel: vesselList){
            vessel.setFleet(null);
            vesselDataService.save(vessel);
        }
        fleetRepository.deleteByIdInt(idInt);
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<FleetEntity> registerEntityClass() {
        return FleetEntity.class;
    }

    @Override
    public Class<Fleet> registerDtoClass() {
        return Fleet.class;
    }
}
