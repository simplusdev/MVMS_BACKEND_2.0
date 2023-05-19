package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.SettingConfigurationManager;

import java.util.Map;

@RestController
public class SettingConfigurationController extends SettingConfigurationManager {

    @GetMapping(Constants.ENDPOINT_URI_CONFIG_MAP_GET_ALL)
    public ResponseEntity<Object> getConfigMapAll( ) {
        settingConfigurationBusinessService.findMapConfiguration( viewData);
        Map<String,Object> configMap = (Map<String, Object>) viewData.getAttributeValue("configMap",Object.class);
        return ResponseMvms.buildResponse(configMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }
}
