package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.GeofenceAlertTriggerEntity;

import java.util.List;

@Repository
public interface GeofenceAlertTriggerRepository extends JpaRepository<GeofenceAlertTriggerEntity, Integer> {

    public List<GeofenceAlertTriggerEntity> findByGeofenceIdInt(@Param("geofenceIdInt") Integer geofenceIdInt);

    public void deleteByGeofenceIdInt(@Param("geofenceIdInt") Integer geofenceIdInt);
}
