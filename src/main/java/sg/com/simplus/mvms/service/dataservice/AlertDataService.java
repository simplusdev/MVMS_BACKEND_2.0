package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Alert;
import sg.com.simplus.mvms.data.dto.Alert;
import sg.com.simplus.mvms.data.entity.AlertEntity;
import sg.com.simplus.mvms.data.repository.AlertRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class AlertDataService extends DataServiceEngine<AlertEntity,Alert> {
    @Autowired
    AlertRepository alertRepository;

    public List<Alert> findAll(){
        return toDtoList(alertRepository.findAll());
    }

    public void deleteByVesselIdInt( Integer vesselIdInt){
        alertRepository.deleteByVesselIdInt(vesselIdInt);
    }

    public Alert save(Alert alert){
        return  toDto(alertRepository.save(toEntity(alert)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<AlertEntity> registerEntityClass() {
        return AlertEntity.class;
    }

    @Override
    public Class<Alert> registerDtoClass() {
        return Alert.class;
    }
}
