package sg.com.simplus.mvms.data.ref;

import sg.com.simplus.mvms.framework.util.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

public enum AisVersionRef {
    UNDEFINED(0);
    private Integer code;
    private String value;

    private AisVersionRef(Integer code ) {
        this.code=code;
    }

    private static Map map = new HashMap<>();

    static {
        map.put(0, "ITU1371");
        map.put(1, "future editions");
        map.put(2, "future editions");
        map.put(3, "future editions");
    }

    public static String descOf(Integer code){
        if(code!=null) {
            return (String) map.get(code);
        }
        return null;
    }

    public static Integer codeOf(String desc){
        return (Integer) PropertyUtil.getKey(map, desc);
    }

    public Integer getCode() {
        return code;
    }
}

