package sg.com.simplus.mvms.data.ref;

import sg.com.simplus.mvms.framework.util.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

public enum AssignedRef {
    UNDEFINED(0);
    private Integer code;
    private String value;

    private AssignedRef(Integer code ) {
        this.code=code;
    }

    private static Map map = new HashMap<>();

    static {
        map.put(0, "autonomous mode");
        map.put(1, "assigned mode");
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

