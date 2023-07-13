package sg.com.simplus.mvms.manager;

import sg.com.simplus.mvms.data.dto.User;
import sg.com.simplus.mvms.data.dto.UserGroup;
import sg.com.simplus.mvms.service.mapperservice.UserGroupMapper;
import sg.com.simplus.mvms.service.mapperservice.UserMapper;

import java.util.Map;

public class UserManager extends BusinessManager {

    public Map<String,Object> saveUserReturnMap(User user) {
        User userResult = userBusinessService.save(user);
        Map<String,Object> userMap = UserMapper.getMap(userResult);
        return userMap;
    }

    public Map<String,Object> updateUserReturnMap(User user) {
        User userResult = userBusinessService.update(user);
        Map<String,Object> userMap = UserMapper.getMap(userResult);
        return userMap;
    }
    public Map<String,Object> saveUserGroupReturnMap(UserGroup userGroup) {
        UserGroup userGroupResult = userGroupBusinessService.save(userGroup);
        Map<String,Object> userGroupMap = UserGroupMapper.getMap(userGroupResult);
        return userGroupMap;
    }

    public Map<String,Object> updateUserGroupReturnMap(UserGroup userGroup) {
        UserGroup userGroupResult = userGroupBusinessService.update(userGroup);
        Map<String,Object> userGroupMap = UserGroupMapper.getMap(userGroupResult);
        return userGroupMap;
    }
}
