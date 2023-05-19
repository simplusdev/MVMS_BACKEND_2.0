package sg.com.simplus.mvms.framework.util;

import sg.com.simplus.mvms.Constants;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtil {
    public static Object parseValueByCodeType(String value, String typeCode){
        if(typeCode.equals(Constants.TYPE_CODE_TEXT)){
            return value;
        }
        if(typeCode.equals(Constants.TYPE_CODE_LONG)){
            return Long.parseLong(value);
        }
        if(typeCode.equals(Constants.TYPE_CODE_DOUBLE)){
            return Double.parseDouble(value);
        }
        if(typeCode.equals(Constants.TYPE_CODE_BOOLEAN)){
            return parseBoolean(value);
        }
        if(typeCode.equals(Constants.TYPE_CODE_ARR_TEXT)){
            return parseToListText(value);
        }
        if(typeCode.equals(Constants.TYPE_CODE_ARR_LONG)){
            return parseToListLong(value);
        }
        if(typeCode.equals(Constants.TYPE_CODE_ARR_DOUBLE)){
            return parseToListDouble(value);
        }
        if(typeCode.equals(Constants.TYPE_CODE_ARR_BOOLEAN)){
            return parseToListBoolean(value);
        }
        return null;
    }



    private static Boolean parseBoolean(String value){
        if(value!= null){
            if(value.equalsIgnoreCase("Y")||value.equalsIgnoreCase("YES")||value.equalsIgnoreCase("TRUE")){
                return true;
            }
        }
        return false;
    }
    private static List<String> parseToListText(String value){
        List<String> list = new ArrayList<>();
        String tokens [] = StringUtil.splitByPipe(value);
        for(int i=0;i< tokens.length; i++){
            list.add(tokens[i]);
        }
        return list;
    }

    private static List<Long> parseToListLong(String value){
        List<Long> list = new ArrayList<>();
        String tokens [] = StringUtil.splitByPipe(value);
        for(int i=0;i< tokens.length; i++){
            Long v = Long.parseLong(tokens[i]);
            list.add(v);
        }
        return list;
    }

    private static List<Double> parseToListDouble(String value){
        List<Double> list = new ArrayList<>();
        String tokens [] = StringUtil.splitByPipe(value);
        for(int i=0;i< tokens.length; i++){
            Double v = Double.parseDouble(tokens[i]);
            list.add(v);
        }
        return list;
    }

    private static List<Boolean> parseToListBoolean(String value){
        List<Boolean> list = new ArrayList<>();
        String tokens [] = StringUtil.splitByPipe(value);
        for(int i=0;i< tokens.length; i++){
            Boolean v = parseBoolean(tokens[i]);
            list.add(v);
        }
        return list;
    }

}
