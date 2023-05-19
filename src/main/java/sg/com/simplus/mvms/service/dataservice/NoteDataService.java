package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Note;
import sg.com.simplus.mvms.data.dto.Note;
import sg.com.simplus.mvms.data.entity.NoteEntity;
import sg.com.simplus.mvms.data.repository.NoteRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class NoteDataService extends DataServiceEngine<NoteEntity,Note> {
    @Autowired
    NoteRepository noteRepository;

    public List<Note> findAll(){
        return toDtoList(noteRepository.findAll());
    }

    public List<Note> findByVesselIdInt(@Param("vesselIdInt") Integer vesselIdInt){
        return toDtoList(noteRepository.findByVesselIdInt(vesselIdInt));
    }

    public Note save(Note note){
        return  toDto(noteRepository.save(toEntity(note)) );
    }

    public void deleteByIdInt(Integer idInt){
        noteRepository.deleteByIdInt(idInt);
    }

    public void deleteByVesselIdInt(Integer vesselIdInt){
        noteRepository.deleteByVesselIdInt(vesselIdInt);
    }
    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<NoteEntity> registerEntityClass() {
        return NoteEntity.class;
    }

    @Override
    public Class<Note> registerDtoClass() {
        return Note.class;
    }
}
