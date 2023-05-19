package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.UserGroup;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.UserGroupDataService;

import java.util.List;

@Service
public class UserGroupBusinessService {

    @Autowired
    UserGroupDataService userGroupDataService;
    public void findAll(ViewData viewData){
        List<UserGroup> userGroupList = userGroupDataService.findAll();
        viewData.setAttributeValue("userGroupList",userGroupList);
    }
}
