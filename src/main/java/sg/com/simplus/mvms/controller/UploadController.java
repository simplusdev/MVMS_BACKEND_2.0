package sg.com.simplus.mvms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.DxfParam;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.UploadManager;

import javax.transaction.Transactional;
import java.io.File;


@RestController
public class UploadController extends UploadManager  {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${dxf.converter.repository}")
    String repository;

    @PostMapping(value = Constants.ENDPOINT_URI_UPLOAD_DXF,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadDxf(@RequestParam("param") String jsonParam,  @RequestParam("file") MultipartFile file  ) {
        String fileName = file.getOriginalFilename();
        DxfParam dxfParam = null;
        try {
            dxfParam = objectMapper.readValue(jsonParam, DxfParam.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("uploadDxf fileName: "+fileName);
        System.out.println("uploadDxf getOverlayMinPixelYDbl: "+dxfParam.getOverlayMinPixelYDbl());
        try {
            //file.transferTo( new File("C:\\SIMPLUS\\file\\mvms\\dxf_test\\repository\\Simplus\\VTBBMS\\Images\\Raw\\" + fileName));
            file.transferTo( new File(  repository + "Raw/"  + fileName));
            System.out.println("uploadDxf write file path: "+repository + "Raw/"  + fileName);
            uploadBusinessService.convert(dxfParam,fileName);
        } catch (Exception e) {
            System.out.println("uploadDxf Exception: "+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseMvms.buildResponse(true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }


}
