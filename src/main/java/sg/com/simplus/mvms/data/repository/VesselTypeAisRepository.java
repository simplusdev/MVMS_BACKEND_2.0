package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.VesselTypeAisEntity;

import java.util.List;

@Repository
public interface VesselTypeAisRepository extends JpaRepository<VesselTypeAisEntity, Integer> {
    public  List<VesselTypeAisEntity> findByCodeInt(@Param("codeInt") Integer codeInt);
}
