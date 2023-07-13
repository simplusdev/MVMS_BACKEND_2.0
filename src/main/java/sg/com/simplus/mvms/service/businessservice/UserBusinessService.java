package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.User;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.UserDataService;
import sg.com.simplus.mvms.service.mapperservice.UserMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserBusinessService {

    @Autowired
    UserDataService userDataService;

    public  List<Map<String,Object>> findAll(ViewData viewData){
        List<User> userList = userDataService.findAll();
        return UserMapper.getListMap(userList);
    }

    public User save(User user){
        user.setCreatedDateDti(new Date());
        return userDataService.save(user);
    }

    public User update(User user){
        User userDb = userDataService.findByIdInt(user.getIdInt());
        user.setCreatedDateDti(userDb.getCreatedDateDti());
        user.setModifiedDateDti(new Date());
        return userDataService.save(user);
    }

    public void deleteByIdInt(Integer idInt){
        userDataService.deleteByIdInt(idInt);
    }
}
