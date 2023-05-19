package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.BuoyEntity;
import sg.com.simplus.mvms.data.repository.BuoyRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class BuoyDataService extends DataServiceEngine<BuoyEntity,Buoy> {
    @Autowired
    BuoyRepository buoyRepository;

    public List<Buoy> findAll(){
        return toDtoList(buoyRepository.findAll());
    }

    public Vessel save(Buoy buoy){
        return  toDto(buoyRepository.save(toEntity(buoy)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<BuoyEntity> registerEntityClass() {
        return BuoyEntity.class;
    }

    @Override
    public Class<Buoy> registerDtoClass() {
        return Buoy.class;
    }
}
