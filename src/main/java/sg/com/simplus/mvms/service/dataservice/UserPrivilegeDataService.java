package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserPrivilege;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.UserPrivilegeEntity;
import sg.com.simplus.mvms.data.repository.UserPrivilegeRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class UserPrivilegeDataService extends DataServiceEngine<UserPrivilegeEntity,UserPrivilege> {
    @Autowired
    UserPrivilegeRepository userPrivilegeRepository;

    public List<UserPrivilege> findAll(){
        return toDtoList(userPrivilegeRepository.findAll());
    }

    public Vessel save(UserPrivilege userPrivilege){
        return  toDto(userPrivilegeRepository.save(toEntity(userPrivilege)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<UserPrivilegeEntity> registerEntityClass() {
        return UserPrivilegeEntity.class;
    }

    @Override
    public Class<UserPrivilege> registerDtoClass() {
        return UserPrivilege.class;
    }
}
