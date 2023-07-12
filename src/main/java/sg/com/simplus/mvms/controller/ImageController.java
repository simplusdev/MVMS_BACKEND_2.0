package sg.com.simplus.mvms.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.manager.ImageManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


@RestController
public class ImageController extends ImageManager {

    @GetMapping(
            value = Constants.ENDPOINT_URI_GET_IMAGE_TILE,
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public ResponseEntity<byte[]> getImageWithMediaType() throws IOException {
        //example path only for testing
        byte[] bytes =  Files.readAllBytes(new File("C:\\SIMPLUS\\file\\mvms\\dxf_test\\repository\\Simplus\\VTBBMS\\Images\\tiles\\1.0.0\\DXF_temp\\1\\0\\1.png").toPath());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(bytes);
    }
}
