package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserSetting;
import sg.com.simplus.mvms.data.dto.UserSetting;
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

    public UserSetting save(UserSetting userSetting){
        return  toDto(userSettingRepository.save(toEntity(userSetting)) );
    }

    public void deleteByIdInt(Integer idInt){
        userSettingRepository.deleteByIdInt(idInt);
    }

    public void deleteByUserIdInt(Integer userIdInt){
        userSettingRepository.deleteByUserIdInt(userIdInt);
    }

    @Override
    public  void customDto(Object entity, Object dto) {
        UserSettingEntity userSettingEntity = (UserSettingEntity) entity;
        UserSetting userSetting = (UserSetting) dto;
        userSetting.setUsedBln(userSettingEntity.getUsedInt()==1?true:false);
    }

    @Override
    public void customEntity(Object dto, Object entity) {
        UserSetting userSetting = (UserSetting) dto;
        UserSettingEntity userSettingEntity = (UserSettingEntity) entity;
        userSettingEntity.setUsedInt(userSetting.getUsedBln()?1:0);
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
