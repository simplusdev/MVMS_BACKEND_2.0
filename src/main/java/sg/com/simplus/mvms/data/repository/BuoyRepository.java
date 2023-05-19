package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.BuoyEntity;

@Repository
public interface BuoyRepository extends JpaRepository<BuoyEntity, Integer> {
    
}
