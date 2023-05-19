package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.LabelPropertyEntity;

import java.util.List;

@Repository
public interface LabelPropertyRepository extends JpaRepository<LabelPropertyEntity, Integer> {

}
