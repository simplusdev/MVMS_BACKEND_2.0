package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.VesselTypeAis;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.VesselTypeAisManager;

import java.util.List;
import java.util.Map;

@RestController
public class VesselTypeAisController extends VesselTypeAisManager {

    @GetMapping(Constants.ENDPOINT_URI_VESSEL_TYPE_AIS_GET_ALL)
    public ResponseEntity<Object> getVesselTypeAisAll( ) {
         List<Map<String,Object>> listMap =  vesselTypeAisBusinessService.findAll();
        return ResponseMvms.buildResponse(listMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

 
}
