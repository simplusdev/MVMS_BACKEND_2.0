package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.UserSetting;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.GeofenceManager;
import sg.com.simplus.mvms.manager.UserSettingManager;
import sg.com.simplus.mvms.service.mapperservice.UserSettingMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
public class UserSettingController extends UserSettingManager {

    @GetMapping(value = Constants.ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_GET_ALL )
    public ResponseEntity<Object> getAllUserSetting() {
        List<Map<String,Object>> list =  userSettingBusinessService.findAll();
        return ResponseMvms.buildResponse(list, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @PostMapping(value = Constants.ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_CREATE )
    public ResponseEntity<Object> createUserSetting(
            @RequestBody UserSetting userSetting) {
        return ResponseMvms.buildResponse(saveReturnMap(userSetting), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @PatchMapping(value = Constants.ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_UPDATE)
    public ResponseEntity<Object> updateUserSetting(
            @RequestBody UserSetting userSetting) {
        UserSetting userSettingSaved = userSettingBusinessService.save(userSetting);
        return ResponseMvms.buildResponse(saveReturnMap(userSetting), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(value = Constants.ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_DELETE_BY_ID)
    public ResponseEntity<Object> deleteUserSettingById(
            @PathVariable("id") Integer idInt) {
         userSettingBusinessService.deleteByIdInt(idInt);
        return ResponseMvms.buildResponse( true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(value = Constants.ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_DELETE_BY_USER_ID )
    public ResponseEntity<Object> deleteUserSettingByUserId(
            @PathVariable("id") Integer userIdInt) {
        userSettingBusinessService.deleteByUserIdInt(userIdInt);
        return ResponseMvms.buildResponse( true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

}
