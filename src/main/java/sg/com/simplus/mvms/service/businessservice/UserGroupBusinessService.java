package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserGroup;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.UserGroupDataService;

import java.util.Date;
import java.util.List;

@Service
public class UserGroupBusinessService {

    @Autowired
    UserGroupDataService userGroupDataService;
    public void findAll(ViewData viewData){
        List<UserGroup> userGroupList = userGroupDataService.findAll();
        viewData.setAttributeValue("userGroupList",userGroupList);
    }

    public UserGroup save(UserGroup userGroup) {
        userGroup.setCreatedDateDti(new Date());
        return userGroupDataService.save(userGroup);
    }

    public UserGroup update(UserGroup userGroup) {
        UserGroup userGroupDb = userGroupDataService.findByIdInt(userGroup.getIdInt());
        userGroup.setCreatedDateDti(userGroupDb.getCreatedDateDti());
        userGroup.setModifiedDateDti(new Date());
        return userGroupDataService.save(userGroup);
    }

    public void deleteByIdInt(@Param("idInt") Integer idInt){
        userGroupDataService.deleteByIdInt(idInt);
    }

}
