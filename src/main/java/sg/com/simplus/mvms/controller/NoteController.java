package sg.com.simplus.mvms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.Note;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.manager.NoteManager;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
public class NoteController extends NoteManager {

    @GetMapping(Constants.ENDPOINT_URI_NOTE_GET_BY_VESSEL_ID)
    public ResponseEntity<Object> getNoteByVesselId(@PathVariable("id") Integer vesselIdInt) {
        // System.out.println("test property value: "+ String.format(StringUtil.getPropertyValue("prop2"),"toto",21));
        List<Map<String,Object>> listMap = noteBusinessService.findByVesselIdInt(vesselIdInt);
        return ResponseMvms.buildResponse(listMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PostMapping(Constants.ENDPOINT_URI_NOTE_CREATE)
    public ResponseEntity<Object> createNote(@RequestBody Note note) {
        Map<String,Object>  savedNote = noteBusinessService.save(note);
        return ResponseMvms.buildResponse(savedNote, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @PostMapping(Constants.ENDPOINT_URI_NOTE_UPDATE)
    public ResponseEntity<Object> updateNote(@RequestBody Note note) {
        Map<String,Object>  savedNote =  noteBusinessService.save(note);
        return ResponseMvms.buildResponse(savedNote, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(Constants.ENDPOINT_URI_NOTE_DELETE_BY_VESSEL_ID)
    public ResponseEntity<Object> deleteByVesselId(@PathVariable("id") Integer vesselIdInt) {
        noteBusinessService.deleteByVesselIdInt(vesselIdInt);
        return ResponseMvms.buildResponse( true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }

    @Transactional
    @DeleteMapping(Constants.ENDPOINT_URI_NOTE_DELETE_BY_ID)
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer idInt) {
        noteBusinessService.deleteByIdInt(idInt);
        return ResponseMvms.buildResponse( true, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
                StatusType.RESULT_SUCCESS.getMessage());
    }
}
