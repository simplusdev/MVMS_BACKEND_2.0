package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.UserGroupEntity;

import java.util.List;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Integer> {

    public List<UserGroupEntity> findByIdInt(@Param("idInt") Integer idInt);

    public void deleteByIdInt(@Param("idInt") Integer idInt);
}
