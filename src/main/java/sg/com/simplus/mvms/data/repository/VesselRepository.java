package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.VesselEntity;

import java.util.List;

@Repository
public interface VesselRepository extends JpaRepository<VesselEntity, Integer> {
    public  List<VesselEntity> findByMmsiInt(@Param("mmsiInt") Integer mmsiInt);

    public  List<VesselEntity> findByFleetIdInt(@Param("fleetIdInt") Integer fleetIdInt);

}
