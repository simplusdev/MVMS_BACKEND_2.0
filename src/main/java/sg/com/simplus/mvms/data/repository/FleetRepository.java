package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.FleetEntity;

import java.util.List;

@Repository
public interface FleetRepository  extends JpaRepository<FleetEntity, Integer> {
    public List<FleetEntity> findByNameStrContaining(@Param("name") String name);

    public List<FleetEntity> findByIdInt(@Param("idInt") Integer idInt);

    public void deleteByIdInt(@Param("idInt") Integer idInt);
}
