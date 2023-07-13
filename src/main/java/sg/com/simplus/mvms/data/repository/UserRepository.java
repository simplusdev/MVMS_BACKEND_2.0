package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public List<UserEntity> findByIdInt(@Param("idInt") Integer idInt);

    public void deleteByIdInt(@Param("idInt") Integer idInt);
}
