package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserLog;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.UserLogEntity;
import sg.com.simplus.mvms.data.repository.UserLogRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class UserLogDataService extends DataServiceEngine<UserLogEntity,UserLog> {
    @Autowired
    UserLogRepository userLogRepository;

    public List<UserLog> findAll(){
        return toDtoList(userLogRepository.findAll());
    }

    public Vessel save(UserLog userLog){
        return  toDto(userLogRepository.save(toEntity(userLog)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<UserLogEntity> registerEntityClass() {
        return UserLogEntity.class;
    }

    @Override
    public Class<UserLog> registerDtoClass() {
        return UserLog.class;
    }
}
