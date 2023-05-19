package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.PositionReportLastEntity;

@Repository
public interface PositionReportLastRepository extends JpaRepository<PositionReportLastEntity, Integer> {

}
