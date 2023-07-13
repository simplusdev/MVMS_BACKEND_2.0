package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserGroup;
import sg.com.simplus.mvms.data.dto.UserGroup;
import sg.com.simplus.mvms.data.entity.UserGroupEntity;
import sg.com.simplus.mvms.data.repository.UserGroupRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class UserGroupDataService extends DataServiceEngine<UserGroupEntity,UserGroup> {
    @Autowired
    UserGroupRepository userGroupRepository;

    public List<UserGroup> findAll(){
        return toDtoList(userGroupRepository.findAll());
    }

    public UserGroup save(UserGroup userGroup){
        return  toDto(userGroupRepository.save(toEntity(userGroup)) );
    }

    public UserGroup findByIdInt(@Param("idInt") Integer idInt){
        List<UserGroupEntity> list =  userGroupRepository.findByIdInt(idInt);
        if(list != null && list.size()> 0 ){
            return toDto(list.get(0));
        }
        return null;
    }

    public void deleteByIdInt(@Param("idInt") Integer idInt){
        userGroupRepository.deleteByIdInt(idInt);
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<UserGroupEntity> registerEntityClass() {
        return UserGroupEntity.class;
    }

    @Override
    public Class<UserGroup> registerDtoClass() {
        return UserGroup.class;
    }
}
