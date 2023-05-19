package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.VesselEntity;

import java.util.List;

@Repository
public interface VesselRepository extends JpaRepository<VesselEntity, Integer> {

}