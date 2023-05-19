package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.ProjectVesselType;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.ProjectVesselTypeDataService;

import java.util.List;

@Service
public class ProjectVesselTypeBusinessService {

    @Autowired
    ProjectVesselTypeDataService projectVesselTypeDataService;
    public void findAll(ViewData viewData){
        List<ProjectVesselType> projectVesselTypeList = projectVesselTypeDataService.findAll();
        viewData.setAttributeValue("projectVesselTypeList",projectVesselTypeList);
    }
}
