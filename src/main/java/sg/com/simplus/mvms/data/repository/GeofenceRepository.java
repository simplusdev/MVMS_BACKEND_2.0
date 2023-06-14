package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.GeofenceEntity;

import java.util.List;

@Repository
public interface GeofenceRepository extends JpaRepository<GeofenceEntity, Integer> {
    public void deleteByIdInt(@Param("idInt") Integer idInt);

    public List<GeofenceEntity> findByDeletedIntNot(@Param("deletedInt") Integer deletedInt);
}
