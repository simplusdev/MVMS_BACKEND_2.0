package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.VesselTypeEntity;

import java.util.List;

@Repository
public interface VesselTypeRepository extends JpaRepository<VesselTypeEntity, Integer> {
    public  List<VesselTypeEntity> findByCodeInt(@Param("codeInt") Integer codeInt);
}
