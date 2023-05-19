package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.PositionReportDataService;

import java.util.List;

@Service
public class PositionReportBusinessService {

    @Autowired
    PositionReportDataService positionReportDataService;

    public void findAll(ViewData viewData){
        List<PositionReport> positionReportList = positionReportDataService.findAll();
        viewData.setAttributeValue("positionReportList",positionReportList);
    }
}
