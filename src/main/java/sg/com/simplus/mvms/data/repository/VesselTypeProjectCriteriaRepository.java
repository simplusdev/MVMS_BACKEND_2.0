package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.VesselTypeProjectCriteriaEntity;

import java.util.List;

@Repository
public interface VesselTypeProjectCriteriaRepository extends JpaRepository<VesselTypeProjectCriteriaEntity, Integer> {
    public List<VesselTypeProjectCriteriaEntity> findByGeofenceAlertTriggerIdInt(@Param("geofenceAlertTriggerId") Integer geofenceAlertTriggerId);

    public void deleteByGeofenceAlertTriggerIdInt(@Param("geofenceAlertTriggerId") Integer geofenceAlertTriggerId);
}
