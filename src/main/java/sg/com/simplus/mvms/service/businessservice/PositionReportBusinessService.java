package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.PositionReportDataService;
import sg.com.simplus.mvms.service.dataservice.VesselDataService;
import sg.com.simplus.mvms.service.mapperservice.PositionReportMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PositionReportBusinessService {

    @Autowired
    PositionReportDataService positionReportDataService;

    @Autowired
    VesselDataService vesselDataService;

    public void findAll(ViewData viewData){
        List<PositionReport> positionReportList = positionReportDataService.findAll();
        viewData.setAttributeValue("positionReportList",positionReportList);
    }

    public List<Map<String,Object>> findByVesselIdIntAndTimestampDtiBetween(Integer vesselIdInt, Date startDateDti, Date endDateDti ){
        return PositionReportMapper.getListMap(positionReportDataService.findByVesselIdIntAndTimestampDtiBetween(vesselIdInt,startDateDti,endDateDti));
    }
}
