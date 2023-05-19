package sg.com.simplus.mvms.service.businessservice;


import java.util.HashMap;
import java.util.Map;

public class MapConfig {

    private static Map<String, Object> configMap ;

    public static Map<String, Object> getConfigMap(){
        if(configMap == null) {
            configMap = new HashMap<>();
        }
        return configMap ;
    }


    public static void setConfigMap(Map<String, Object> configMap) {
        MapConfig.configMap = configMap;
    }
}
