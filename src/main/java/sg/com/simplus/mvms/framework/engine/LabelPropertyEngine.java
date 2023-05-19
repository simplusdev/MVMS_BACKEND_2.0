package sg.com.simplus.mvms.framework.engine;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.LabelProperty;
import sg.com.simplus.mvms.service.dataservice.LabelPropertyDataService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@Service
public class LabelPropertyEngine {


    @Autowired
    LabelPropertyDataService labelPropertyDataService;

    private static Map<String, String> propertyMap = new HashMap<>();

    public   void init(){
        List<LabelProperty> list = labelPropertyDataService.findAll();
        for(LabelProperty labelProperty: list){
            System.out.println("labelProperty getPropertyNameStr: "+labelProperty.getPropertyNameStr());
            System.out.println("labelProperty getPropertyValueStr: "+labelProperty.getPropertyValueStr());
            propertyMap.put(labelProperty.getPropertyNameStr(),labelProperty.getPropertyValueStr());
        }
    }

    public static String getValue(String name){
        return propertyMap.get(name);
    }
}
