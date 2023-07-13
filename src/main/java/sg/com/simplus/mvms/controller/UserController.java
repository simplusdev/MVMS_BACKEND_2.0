package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.Fleet;
import sg.com.simplus.mvms.data.dto.User;
import sg.com.simplus.mvms.data.dto.UserGroup;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.UserManager;

import javax.transaction.Transactional;

@RestController
public class UserController extends UserManager {

    @PostMapping(Constants.ENDPOINT_URI_USER_CREATE)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return ResponseMvms.buildResponse(saveUserReturnMap(user), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PatchMapping(Constants.ENDPOINT_URI_USER_UPDATE)
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return ResponseMvms.buildResponse(updateUserReturnMap(user), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(Constants.ENDPOINT_URI_USER_DELETE_BY_ID)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Integer idInt) {
        userBusinessService.deleteByIdInt(idInt);
        return ResponseMvms.buildResponse(true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PostMapping(Constants.ENDPOINT_URI_USER_UPDATE)
    public ResponseEntity<Object> updateGroup(@RequestBody User user) {
        return ResponseMvms.buildResponse(updateUserReturnMap(user), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PostMapping(Constants.ENDPOINT_URI_USER_GROUP_CREATE)
    public ResponseEntity<Object> createUserGroup(@RequestBody UserGroup userGroup) {
        return ResponseMvms.buildResponse(saveUserGroupReturnMap(userGroup), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PatchMapping(Constants.ENDPOINT_URI_USER_GROUP_UPDATE)
    public ResponseEntity<Object> updateUserGroup(@RequestBody UserGroup userGroup) {
        return ResponseMvms.buildResponse(updateUserGroupReturnMap(userGroup), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(Constants.ENDPOINT_URI_USER_GROUP_DELETE_BY_ID)
    public ResponseEntity<Object> deleteUserGroup(@PathVariable("id") Integer idInt) {
        userGroupBusinessService.deleteByIdInt(idInt);
        return ResponseMvms.buildResponse(true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }
}
