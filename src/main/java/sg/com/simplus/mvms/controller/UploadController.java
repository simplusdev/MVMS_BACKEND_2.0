package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.UploadManager;

import javax.transaction.Transactional;
import java.io.File;


@RestController
public class UploadController extends UploadManager  {


    @PostMapping(value = Constants.ENDPOINT_URI_UPLOAD_DXF,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadDxf(@RequestPart MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo( new File("C:\\SIMPLUS\\file\\upload\\dxf\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseMvms.buildResponse(true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }


    @PostMapping(value = Constants.ENDPOINT_URI_UPLOAD_ENC,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadEnc(@RequestPart MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo( new File("C:\\SIMPLUS\\file\\upload\\enc\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseMvms.buildResponse(true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }
}
