package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.User;
import sg.com.simplus.mvms.data.dto.User;
import sg.com.simplus.mvms.data.entity.UserEntity;
import sg.com.simplus.mvms.data.repository.UserRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class UserDataService extends DataServiceEngine<UserEntity,User> {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return toDtoList(userRepository.findAll());
    }

    public User  findByIdInt(Integer idInt){
         List<UserEntity> list = userRepository.findByIdInt(idInt);
        if(list!=null && list.size()>0){
            return toDto(list.get(0));
        }
        return  null;
    }

    public void deleteByIdInt(Integer idInt){
        userRepository.deleteByIdInt(idInt);
    }
    
    public User save(User user){
        return  toDto(userRepository.save(toEntity(user)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<UserEntity> registerEntityClass() {
        return UserEntity.class;
    }

    @Override
    public Class<User> registerDtoClass() {
        return User.class;
    }
}
