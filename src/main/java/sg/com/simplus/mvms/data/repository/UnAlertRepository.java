package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.UnAlertEntity;

@Repository
public interface UnAlertRepository extends JpaRepository<UnAlertEntity, Integer> {

    public void deleteByVesselIdInt(@Param("vesselIdInt")Integer vesselIdInt);
}
