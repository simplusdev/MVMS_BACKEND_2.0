package sg.com.simplus.mvms.framework.util;

import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.framework.engine.LabelPropertyEngine;

public class StringUtil {
    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String getPropertyValue(String propertyName){
        return LabelPropertyEngine.getValue(propertyName);
    }

    public static String [] splitByComma(String s){
        return s.split(",");
    }

    public static String [] splitByPipe(String s){
        return s.split("\\|");
    }

    public static boolean isFieldNameDateTime(String fieldName){
        if(!isNullOrBlank(fieldName)){
            if(fieldName.length()>2){
                String suffix = fieldName.substring(fieldName.length()-3,fieldName.length());
                //System.out.println("suffix: "+suffix);
                if(suffix.equals(Constants.SUFFIX_DATA_TYPE_DATETIME)){
                    return true;
                }
            }
        }
        return false;
    }
}
