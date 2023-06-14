package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.PositionReportLastEntity;

import java.util.List;

@Repository
public interface PositionReportLastRepository extends JpaRepository<PositionReportLastEntity, Integer> {

    public List<PositionReportLastEntity> findByVesselIdInt(@Param("vesselIdInt") Integer vesselIdInt);
}
