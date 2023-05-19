package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.dto.Note;
import sg.com.simplus.mvms.data.entity.NoteEntity;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {
    public List<NoteEntity> findByVesselIdInt(@Param("vesselIdInt") Integer vesselIdInt);

    public void deleteByIdInt(@Param("idInt") Integer idInt);

    public void deleteByVesselIdInt(@Param("vesselIdInt") Integer vesselIdInt);


}
