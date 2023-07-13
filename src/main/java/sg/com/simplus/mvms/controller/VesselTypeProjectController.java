package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.VesselTypeProject;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.VesselTypeProjectManager;

import java.util.List;
import java.util.Map;

@RestController
public class VesselTypeProjectController extends VesselTypeProjectManager {

    @GetMapping(Constants.ENDPOINT_URI_VESSEL_TYPE_PROJECT_GET_ALL)
    public ResponseEntity<Object> getVesselTypeProjectAll( ) {
         List<Map<String,Object>> listMap =  vesselTypeProjectBusinessService.findAll();
        return ResponseMvms.buildResponse(listMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PostMapping(Constants.ENDPOINT_URI_VESSEL_TYPE_PROJECT_CREATE)
    public ResponseEntity<Object> createVesselTypeProject(@RequestBody VesselTypeProject vesselTypeProject) {
        return ResponseMvms.buildResponse(saveReturnMap(vesselTypeProject), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PatchMapping(Constants.ENDPOINT_URI_VESSEL_TYPE_PROJECT_UPDATE)
    public ResponseEntity<Object> updateVesselTypeProject(@RequestBody VesselTypeProject vesselTypeProject) {
        return ResponseMvms.buildResponse(saveReturnMap(vesselTypeProject), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }
}
