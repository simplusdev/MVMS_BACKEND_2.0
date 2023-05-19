package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.PositionReportLast;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.PositionReportLastDataService;

import java.util.List;

@Service
public class PositionReportLastBusinessService {

    @Autowired
    PositionReportLastDataService positionReportLastDataService;
    public void findAll(ViewData viewData){
        List<PositionReportLast> positionReportLastList = positionReportLastDataService.findAll();
        viewData.setAttributeValue("positionReportLastList",positionReportLastList);
    }
}
