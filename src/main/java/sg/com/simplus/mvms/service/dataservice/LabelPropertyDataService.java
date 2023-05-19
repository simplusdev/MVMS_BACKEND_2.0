package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.LabelProperty;
import sg.com.simplus.mvms.data.entity.LabelPropertyEntity;
import sg.com.simplus.mvms.data.repository.LabelPropertyRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class LabelPropertyDataService extends DataServiceEngine<LabelPropertyEntity, LabelProperty> {
    @Autowired
    LabelPropertyRepository labelPropertyRepository;

//    public List<LabelProperty> findAll(){
//        return toDto(labelPropertyRepository.findAll(),LabelPropertyEntity.class,LabelProperty.class);
//    }

    public List<LabelProperty> findAll(){
        return toDtoList(labelPropertyRepository.findAll() );
    }

    @Override
    public Class<LabelPropertyEntity> registerEntityClass() {
        return LabelPropertyEntity.class;
    }

    @Override
    public Class<LabelProperty> registerDtoClass() {
        return LabelProperty.class;
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }
}
