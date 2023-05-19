package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.GeofenceAlertTriggerEntity;

@Repository
public interface GeofenceAlertTriggerRepository extends JpaRepository<GeofenceAlertTriggerEntity, Integer> {
    
}
