package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.FleetManager;

import java.util.List;
import java.util.Map;

@RestController
public class FleetController extends FleetManager {

    @GetMapping(Constants.ENDPOINT_URI_FLEET_GET_ALL)
    public ResponseEntity<Object> getFleetAll( ) {
         List<Map<String,Object>> listMap =  fleetBusinessService.findAll();
        return ResponseMvms.buildResponse(listMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

}
