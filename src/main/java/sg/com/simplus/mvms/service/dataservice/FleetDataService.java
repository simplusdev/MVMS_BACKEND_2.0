package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Fleet;
import sg.com.simplus.mvms.data.entity.FleetEntity;
import sg.com.simplus.mvms.data.repository.FleetRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class FleetDataService extends DataServiceEngine<FleetEntity,Fleet> {
    @Autowired
    FleetRepository fleetRepository;

    public List<Fleet> findAll(){
        return toDtoList(fleetRepository.findAll());
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
