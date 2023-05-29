package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.BuoyEntity;

@Repository
public interface BuoyRepository extends JpaRepository<BuoyEntity, Integer> {
    public void deleteByIdInt(@Param("idInt") Integer idInt);
}
