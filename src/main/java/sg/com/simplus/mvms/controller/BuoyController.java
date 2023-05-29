package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.Buoy;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.framework.util.DateUtil;
import sg.com.simplus.mvms.manager.BuoyManager;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class BuoyController extends BuoyManager {

    @GetMapping(Constants.ENDPOINT_URI_SYMBOL_GET_ALL)
    public ResponseEntity<Object> getBuoyAll( ) {
        List<Map<String,Object>> listMap =  buoyBusinessService.findAll();
        return ResponseMvms.buildResponse(listMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @PostMapping(value = Constants.ENDPOINT_URI_SYMBOL_CREATE )
    public  ResponseEntity<Object> createBuoy(
            @RequestBody Buoy buoy) {

        //Date startDateDti = DateUtil.parseDateFromDdMmYyyyHhMm(buoy.getTimestampDti().getTime());
        return ResponseMvms.buildResponse(saveReturnMap(buoy), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @PostMapping(value = Constants.ENDPOINT_URI_SYMBOL_UPDATE)
    public  ResponseEntity<Object> updateBuoy(
            @RequestBody Buoy buoy) {
        return ResponseMvms.buildResponse(saveReturnMap(buoy), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(value = Constants.ENDPOINT_URI_SYMBOL_DELETE)
    public  ResponseEntity<Object> deleteBuoy(
            @PathVariable("id") Integer idInt) {
        buoyBusinessService.deleteByIdInt(idInt);
        return ResponseMvms.buildResponse(true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

}