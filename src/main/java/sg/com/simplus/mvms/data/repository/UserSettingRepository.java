package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.UserSettingEntity;

@Repository
public interface UserSettingRepository extends JpaRepository<UserSettingEntity, Integer> {
    public void deleteByIdInt(@Param("idInt") Integer idInt);
    public void deleteByUserIdInt(@Param("userIdInt") Integer userIdInt);
}
