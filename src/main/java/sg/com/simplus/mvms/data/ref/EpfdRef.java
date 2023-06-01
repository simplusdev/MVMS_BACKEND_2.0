package sg.com.simplus.mvms.data.ref;

import sg.com.simplus.mvms.framework.util.PropertyUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum EpfdRef {
    UNDEFINED(0),
    GPS(1),
    GLONASS(2),
    COMBINED_GLONASS(3),
    LORAN_C(4),
    CHAYKA(5),
    INTEGRATED_NAVIGATION_SYSTEM(6),
    SURVEYED(7),
    GALILEO(8),
    RESERVED(9),
    INTERNAL_GNSS(12);

    private Integer code;
    private String value;
    private static Map map = new HashMap<>();

    static {
       map.put(0,"Undefined");
       map.put(1,"GPS");
       map.put(2,"GLONASS");
       map.put(3,"Combined GPS/GLONASS");
        map.put(4,"Loran-C");
        map.put(5,"Chayka");
        map.put(6,"Integrated navigation system");
        map.put(7,"Surveyed");
        map.put(8,"Galileo");
        map.put(9,"Reserved");
        map.put(10,"Reserved");
        map.put(11,"Reserved");
        map.put(12,"Reserved");
        map.put(13,"Reserved");
        map.put(14,"Reserved");
        map.put(15,"Internal GNSS");
    }

    private EpfdRef(Integer code ) {
        this.code=code;
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
