package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserSetting;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.UserSettingEntity;
import sg.com.simplus.mvms.data.repository.UserSettingRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class UserSettingDataService extends DataServiceEngine<UserSettingEntity,UserSetting> {
    @Autowired
    UserSettingRepository userSettingRepository;

    public List<UserSetting> findAll(){
        return toDtoList(userSettingRepository.findAll());
    }

    public Vessel save(UserSetting userSetting){
        return  toDto(userSettingRepository.save(toEntity(userSetting)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<UserSettingEntity> registerEntityClass() {
        return UserSettingEntity.class;
    }

    @Override
    public Class<UserSetting> registerDtoClass() {
        return UserSetting.class;
    }
}
