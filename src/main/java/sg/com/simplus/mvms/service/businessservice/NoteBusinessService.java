package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Note;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.NoteDataService;
import sg.com.simplus.mvms.service.mapperservice.NoteMapper;

import java.util.List;
import java.util.Map;

@Service
public class NoteBusinessService {

    @Autowired
    NoteDataService noteDataService;
    public List<Map<String,Object>> findAll(){
        List<Note> noteList = noteDataService.findAll();
        return NoteMapper.getListMap(noteList);
    }

    public Map<String,Object> save(Note note){
        return NoteMapper.getMapSaveAndUpdate(noteDataService.save(note));
    }

    public void deleteByIdInt(Integer idInt){
        noteDataService.deleteByIdInt(idInt);
    }

    public void deleteByVesselIdInt(Integer vesselIdInt){
        noteDataService.deleteByVesselIdInt(vesselIdInt);
    }

    public List<Map<String,Object>> findByVesselIdInt(@Param("vesselIdInt") Integer vesselIdInt ){
        List<Note> noteList = noteDataService.findByVesselIdInt(vesselIdInt);
        return NoteMapper.getListMap(noteList);
    }
}
