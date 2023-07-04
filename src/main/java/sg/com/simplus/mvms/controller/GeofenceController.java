package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.Geofence;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.GeofenceManager;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
public class GeofenceController extends GeofenceManager {

    @GetMapping(Constants.ENDPOINT_URI_GEOFENCE_GET_ALL)
    public ResponseEntity<Object> getGeofenceAll( ) {
        List<Map<String,Object>> listMap =  geofenceBusinessService.findAll();
        return ResponseMvms.buildResponse(listMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @PostMapping(value = Constants.ENDPOINT_URI_GEOFENCE_CREATE )
    public  ResponseEntity<Object> createGeofence(
            @RequestBody Geofence geofence) {
        return ResponseMvms.buildResponse(saveReturnMap(geofence), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @PostMapping(value = Constants.ENDPOINT_URI_GEOFENCE_UPDATE )
    public  ResponseEntity<Object> updateGeofence(
            @RequestBody Geofence geofence) {
        return ResponseMvms.buildResponse(updateReturnMap(geofence), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(value = Constants.ENDPOINT_URI_GEOFENCE_DELETE)
    public  ResponseEntity<Object> deleteGeofence(
            @PathVariable("id") Integer idInt) {
        geofenceBusinessService.deleteByIdInt(idInt);
        return ResponseMvms.buildResponse(true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

}