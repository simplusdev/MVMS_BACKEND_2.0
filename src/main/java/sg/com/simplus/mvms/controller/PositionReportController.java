package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.framework.util.DateUtil;
import sg.com.simplus.mvms.manager.PositionReportManager;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class PositionReportController extends PositionReportManager {

    @PostMapping(Constants.ENDPOINT_URI_POSITION_REPORT_GET_BY_DATE)
    public ResponseEntity<Object> getPositionReportByDate(@RequestBody Map<String,Object> param) {
        Integer vesselIdInt = (Integer)param.get("vesselIdInt");
        Date startDateDti = DateUtil.parseDateFromYyyyMmDdTHhMmSs(((String) param.get("startDateDti")));
        Date endDateDti = DateUtil.parseDateFromYyyyMmDdTHhMmSs(((String) param.get("endDateDti")));
        List<Map<String,Object>> positionReportList = positionReportBusinessService.findByVesselIdIntAndTimestampDtiBetween(vesselIdInt,startDateDti,endDateDti);
        return ResponseMvms.buildResponse(positionReportList, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }
}
