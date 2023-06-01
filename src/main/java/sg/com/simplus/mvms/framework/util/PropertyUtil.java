package sg.com.simplus.mvms.framework.util;

import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.constant.ParentFields;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropertyUtil {
    private static List<String> auditFieldList = new ArrayList<>();

    static {
        auditFieldList.add(Constants.AUDIT_FIELD_CREATED_BY);
        auditFieldList.add(Constants.AUDIT_FIELD_MODIFIED_BY);
        auditFieldList.add(Constants.AUDIT_FIELD_CREATED_DATE);
        auditFieldList.add(Constants.AUDIT_FIELD_MODIFIED_DATE);
    }

    public static boolean isAuditField(String s){
        return auditFieldList.contains(s);
    }

    public static boolean isExcludeAuditFields(AuditFields auditFields, String key){
        return auditFields != null && auditFields.equals(AuditFields.EXCLUDE) && isAuditField(key);
    }

    public static boolean isParentOnlyIdAndName(ParentFields parentFields){
        return parentFields != null && parentFields.equals(ParentFields.ONLY_CONTAINED_ID_AND_NAME);
    }

    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (K key: map.keySet())
        {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
