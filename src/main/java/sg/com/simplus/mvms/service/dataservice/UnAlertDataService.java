package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UnAlert;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.UnAlertEntity;
import sg.com.simplus.mvms.data.repository.UnAlertRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class UnAlertDataService extends DataServiceEngine<UnAlertEntity,UnAlert> {
    @Autowired
    UnAlertRepository unAlertRepository;

    public List<UnAlert> findAll(){
        return toDtoList(unAlertRepository.findAll());
    }

    public Vessel save(UnAlert unAlert){
        return  toDto(unAlertRepository.save(toEntity(unAlert)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<UnAlertEntity> registerEntityClass() {
        return UnAlertEntity.class;
    }

    @Override
    public Class<UnAlert> registerDtoClass() {
        return UnAlert.class;
    }
}
