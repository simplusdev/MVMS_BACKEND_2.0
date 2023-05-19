package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserGroupUserPrivilege;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.UserGroupUserPrivilegeEntity;
import sg.com.simplus.mvms.data.repository.UserGroupUserPrivilegeRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class UserGroupUserPrivilegeDataService extends DataServiceEngine<UserGroupUserPrivilegeEntity,UserGroupUserPrivilege> {
    @Autowired
    UserGroupUserPrivilegeRepository userGroupUserPrivilegeRepository;

    public List<UserGroupUserPrivilege> findAll(){
        return toDtoList(userGroupUserPrivilegeRepository.findAll());
    }

    public Vessel save(UserGroupUserPrivilege userGroupUserPrivilege){
        return  toDto(userGroupUserPrivilegeRepository.save(toEntity(userGroupUserPrivilege)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<UserGroupUserPrivilegeEntity> registerEntityClass() {
        return UserGroupUserPrivilegeEntity.class;
    }

    @Override
    public Class<UserGroupUserPrivilege> registerDtoClass() {
        return UserGroupUserPrivilege.class;
    }
}
