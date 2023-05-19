package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.SettingConfiguration;
import sg.com.simplus.mvms.data.dto.SettingDataType;
import sg.com.simplus.mvms.framework.util.ConfigUtil;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.SettingConfigurationDataService;

import java.util.List;
import java.util.Map;

@Service
public class SettingConfigurationBusinessService {

    @Autowired
    SettingConfigurationDataService fleetDataService;
    public void findBySettingDataTypeTypeCodeStrContaining(String typeCode, ViewData viewData){
        List<SettingConfiguration> dataList = fleetDataService.findBySettingDataTypeTypeCodeStrContaining(typeCode);
        System.out.println("dataList: "+dataList);
        viewData.setAttributeValue("dataList",dataList);
    }

    public void findMapConfiguration(  ViewData viewData){
        Map<String, Object> configMap = MapConfig.getConfigMap();
        System.out.println("findMapConfiguration configMap.size(): " + configMap.size());
        if(configMap.size()==0) {
            List<SettingConfiguration> dataList = fleetDataService.findByPropertyNameStrContaining("mapconfig.");
            System.out.println("dataList: " + dataList);
            for(SettingConfiguration settingConfiguration: dataList){
                String propertyNameStr = settingConfiguration.getPropertyNameStr();
                String propertyValueStr = settingConfiguration.getPropertyValueStr();
                SettingDataType settingDataType = settingConfiguration.getSettingDataType();
                String typeCode = Constants.TYPE_CODE_TEXT;
                if(settingDataType!=null){
                    typeCode = settingDataType.getTypeCodeStr();
                    System.out.println("SettingDataType typeCode: "+typeCode);
                }
                Object value = ConfigUtil.parseValueByCodeType(propertyValueStr,typeCode);
                System.out.println("SettingConfiguration propertyNameStr: "+propertyNameStr);
                System.out.println("SettingConfiguration value: "+value);
                configMap.put(propertyNameStr,value);
            }
            MapConfig.setConfigMap(configMap);
        } else {
            System.out.println("configMap already populated, skip dataservice ");
        }
        viewData.setAttributeValue("configMap",configMap);
    }
}
