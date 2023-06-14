package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sg.com.simplus.mvms.data.entity.PositionReportEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface PositionReportRepository extends JpaRepository<PositionReportEntity, Integer> {
    List<PositionReportEntity> findByVesselIdIntAndTimestampDtiBetween(@Param("vesselIdInt")Integer vesselIdInt, @Param("startDateDti") Date startDateDti, @Param("endDateDti") Date endDateDti );

    @Transactional
    void deleteByVesselMmsiIntAndTimestampDtiBetween(@Param("mmsiInt")Integer mmsiInt, @Param("startDateDti") Date startDateDti, @Param("endDateDti") Date endDateDti );

}
