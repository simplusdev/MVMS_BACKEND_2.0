package sg.com.simplus.mvms.framework.util;

import java.util.HashMap;
import java.util.Map;

public class ViewData {
    private final Map<String, Object> attribute = new HashMap();
    private static ViewData instance;

//    public static ViewData getInstance(){
//        if(instance == null) {
//            instance = new ViewData();
//        }
//        return instance ;
//    }

    public void setAttributeValue(String key, Object value) {
        if (!StringUtil.isNullOrBlank(key)) {
            this.attribute.put(key, value);
        }

    }

    public <S> S getAttributeValue(String key, Class<S> cls) {
        Object value = this.attribute.get(key);
        return value == null ? null : cls.cast(value);
    }
}
