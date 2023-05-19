package sg.com.simplus.mvms.service.mapperservice;

import sg.com.simplus.mvms.data.dto.Note;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.constant.MapFieldsStrategy;
import sg.com.simplus.mvms.framework.constant.ParentFields;
import sg.com.simplus.mvms.framework.engine.DtoMapper;

import java.util.List;
import java.util.Map;

public class NoteMapper {

    public static  Map<String,Object> getMap(Note note){
         Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<Note>(note).init().build();
        return  result;
    }

    public static  Map<String,Object> getMapSaveAndUpdate(Note note){
        Map<String,Object> result = (Map<String,Object>) new DtoMapper.MapBuilderEngine<Note>(note, MapFieldsStrategy.ONLY_CONSTRUCT_SOME_FIELDS).init().add("idInt").build();
        return  result;
    }

    public static  List<Map<String,Object>> getListMap(List<Note> list){
        List<Map<String,Object>> result =( List<Map<String,Object>> ) new DtoMapper.MapBuilderEngine<List<Note>>(list, ParentFields.ONLY_CONTAINED_ID_AND_NAME, AuditFields.EXCLUDE).init().build();
        return  result;
    }

}
