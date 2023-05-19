package sg.com.simplus.mvms.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.com.simplus.mvms.data.entity.SettingConfigurationEntity;

import java.util.List;

@Repository
public interface SettingConfigurationRepository extends JpaRepository<SettingConfigurationEntity, Integer> {

    public List<SettingConfigurationEntity> findByPropertyNameStrContaining(@Param("name") String name);
    public List<SettingConfigurationEntity> findBySettingDataTypeTypeCodeStrContaining(@Param("typeCode") String typeCode);
}
