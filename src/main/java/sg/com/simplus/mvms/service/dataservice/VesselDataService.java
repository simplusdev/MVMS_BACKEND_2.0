package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.VesselEntity;
import sg.com.simplus.mvms.data.repository.VesselRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class VesselDataService extends DataServiceEngine<VesselEntity,Vessel> {
    @Autowired
    VesselRepository fleetRepository;

    public List<Vessel> findAll(){
        return toDtoList(fleetRepository.findAll() );
    }

    public Vessel save(Vessel vessel){
       return  toDto(fleetRepository.save(toEntity(vessel)) );
    }

    public Vessel getById(Integer id){
        return  toDto(fleetRepository.getById(id) );
    }

    @Override
    public Class registerEntityClass(){
        return VesselEntity.class;
    }

    @Override
    public Class registerDtoClass(){
        return Vessel.class;
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

}
