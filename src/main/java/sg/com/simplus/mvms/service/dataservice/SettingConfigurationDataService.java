package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.SettingConfiguration;
import sg.com.simplus.mvms.data.entity.SettingConfigurationEntity;
import sg.com.simplus.mvms.data.entity.SettingDataTypeEntity;
import sg.com.simplus.mvms.data.repository.SettingConfigurationRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class SettingConfigurationDataService extends DataServiceEngine<SettingConfigurationEntity,SettingConfiguration> {
    @Autowired
    SettingConfigurationRepository settingConfigurationRepository;

    public List<SettingConfiguration>   findByPropertyNameStrContaining(@Param("name") String name){
        List<SettingConfigurationEntity> list = settingConfigurationRepository.findByPropertyNameStrContaining(name);

        System.out.println("cek findByPropertyNameStrContaining size list: "+list.size());
        for(SettingConfigurationEntity entity : list){
            SettingDataTypeEntity settingDataType =   entity.getSettingDataType();
            System.out.println("cek findByPropertyNameStrContaining x getPropertyNameStr: "+entity.getPropertyNameStr());
            System.out.println("cek findByPropertyNameStrContaining x settingDataType: "+settingDataType);
            System.out.println("cek findByPropertyNameStrContaining x getDescriptionStr: "+settingDataType.getDescriptionStr());
        }
        return toDtoList(settingConfigurationRepository.findByPropertyNameStrContaining(name) );
    }
    public List<SettingConfiguration> findBySettingDataTypeTypeCodeStrContaining(String name){
        return toDtoList(settingConfigurationRepository.findBySettingDataTypeTypeCodeStrContaining(name) );
    }

    @Override
    public Class<SettingConfigurationEntity> registerEntityClass() {
        return SettingConfigurationEntity.class;
    }

    @Override
    public Class<SettingConfiguration> registerDtoClass() {
        return SettingConfiguration.class;
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

}
