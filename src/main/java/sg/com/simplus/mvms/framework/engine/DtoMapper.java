package sg.com.simplus.mvms.framework.engine;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sg.com.simplus.mvms.framework.constant.AuditFields;
import sg.com.simplus.mvms.framework.constant.MapFieldsStrategy;
import sg.com.simplus.mvms.framework.constant.ParentFields;
import sg.com.simplus.mvms.framework.util.DateUtil;
import sg.com.simplus.mvms.framework.util.PropertyUtil;
import sg.com.simplus.mvms.framework.util.StringUtil;

import java.util.*;

public class DtoMapper {

   // private  Map<String,Object> aMap = new HashMap<>();
    private Object oRes;
    private List<String> ignoreList;
    private  List<String> addedList;
    private   Map<String, Object> updateMap;
    private MapFieldsStrategy mapFieldsStrategy;
    private AuditFields auditFields;
    private ParentFields parentFields;

    public DtoMapper(MapBuilderEngine mapBuilder){
          ignoreList = mapBuilder.getIgnoreList();
         addedList = mapBuilder.getAddedList();
        updateMap = mapBuilder.getUpdateMap();
         mapFieldsStrategy = mapBuilder.getMapFieldsStrategy();
         auditFields = mapBuilder.getAuditFields();
         parentFields = mapBuilder.getParentFields();

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Object o = mapBuilder.getObj();

        if(o instanceof List<?>){
            System.out.println("DtoMapperNew o instanceof List " );
            List<Map<String, Object>> newList = new ArrayList<>();
            List<Map<String, Object>> resultList = mapper.convertValue(mapBuilder.getObj(), new TypeReference<List<Map<String, Object>>>() {
            });
            for(Map<String, Object> objectMap: resultList){
                Map<String, Object> newMap = proceedMap(objectMap);
                newList.add(newMap);
            }
            oRes = newList;
        } else {
            System.out.println("DtoMapperNew o instanceof not List " );
            Map<String, Object> result = mapper.convertValue(mapBuilder.getObj(), new TypeReference<Map<String, Object>>() {
            });
            oRes =  proceedMap(result);;
        }

    }

    private Map<String, Object> proceedMap( Map<String, Object> aMap ){
        Map<String, Object> resultTemp = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> resultAddedOnly = new HashMap<>();
        for(String fieldAdded : addedList) {
            if(aMap.containsKey(fieldAdded)){
                resultAddedOnly.put(fieldAdded,aMap.get(fieldAdded));
            }
        }
        if(mapFieldsStrategy==null){
            resultTemp= aMap;
        } else if(mapFieldsStrategy.equals(MapFieldsStrategy.IGNORE_SOME_FIELDS)){
            resultTemp= aMap;
        } else {
            resultTemp = resultAddedOnly;
        }

        System.out.println("ignoreList size: "+ignoreList.size());


        for (String fieldIgnore : ignoreList) {
            resultTemp.remove(fieldIgnore);
            System.out.println("remove field: "+fieldIgnore);
            System.out.println("containsKey field "+fieldIgnore+": "+resultTemp.containsKey(fieldIgnore));
        }



        Set<String> keySet = updateMap.keySet();
        for (String key : keySet) {
            resultTemp.remove(key);
            resultTemp.put(key, updateMap.get(key));
            System.out.println("remove and update field: "+key);
        }

        Set<String> keySetTemp = resultTemp.keySet();
        for (String key : keySetTemp) {
            manageFields(key,result,resultTemp,false);
        }

        return result;
    }

    public void manageFields(String key, Map<String, Object> toMap, Map<String, Object> fromMap, boolean onlyIdAndName){
        Object val = fromMap.get(key);
        System.out.println("val: "+val);
        boolean isExcludeAuditFields = PropertyUtil.isExcludeAuditFields(auditFields,key);
        boolean isParentOnlyIdAndName = PropertyUtil.isParentOnlyIdAndName(parentFields);
        if(!isExcludeAuditFields) {
            boolean isFieldNameDateTime = StringUtil.isFieldNameDateTime(key);
            if (isFieldNameDateTime) {
                String sdate = null;
                if(val!=null) {
                    Date date = new Date((Long) val);
                    sdate = DateUtil.formatDateToYyyMmDdThhMmSs(date);
                }
                System.out.println("put key:" + key + ", sdate: " + sdate);
                if(!onlyIdAndName) {
                    toMap.put(key, sdate);
                }
            } else {
                if(onlyIdAndName){
                    if(key.equals("idInt")||key.equals("nameStr")){
                        toMap.put(key, val);
                    }
                } else {
                    toMap.put(key, val);
                }
            }
        }

        if(val instanceof Map  ) {
            Map<String, Object> result = new HashMap<>();
            Map<String, Object> parentMap =   ( Map<String, Object> )val;
            Set<String> keySetParent = parentMap.keySet();
            for(String keyParent: keySetParent) {
                System.out.println("invoke parent manageFields: "+keyParent);
                manageFields(keyParent, result,parentMap,isParentOnlyIdAndName);
            }
            if(!isExcludeAuditFields) {
                toMap.remove(key);
                toMap.put(key, result);
            }
        }
    }

    public Object getResult() {
        return oRes;
    }


    public static class MapBuilderEngine <T> {

        private T o;

        private List<String> ignoreList = new ArrayList<>();
        private List<String> addedList = new ArrayList<>();
        private  Map<String,Object> updateMap = new HashMap<>();

        private MapFieldsStrategy mapFieldsStrategy;
        private AuditFields auditFields;
        private ParentFields parentFields;

        public  MapBuilderEngine(T o, MapFieldsStrategy mapFieldsStrategy){
            this.o=o;
            this.mapFieldsStrategy=mapFieldsStrategy;
        }

        public  MapBuilderEngine(T o, AuditFields auditFields){
            this.o=o;
            this.auditFields=auditFields;
        }

        public  MapBuilderEngine(T o, ParentFields parentFields){
            this.o=o;
            this.parentFields=parentFields;
        }

        public  MapBuilderEngine(T o, MapFieldsStrategy mapFieldsStrategy, ParentFields parentFields){
            this.o=o;
            this.mapFieldsStrategy=mapFieldsStrategy;
            this.parentFields=parentFields;
        }

        public  MapBuilderEngine(T o, MapFieldsStrategy mapFieldsStrategy, AuditFields auditFields){
            this.o=o;
            this.mapFieldsStrategy=mapFieldsStrategy;
            this.auditFields=auditFields;
        }

        public  MapBuilderEngine(T o, ParentFields parentFields, AuditFields auditFields){
            this.o=o;
            this.parentFields=parentFields;
            this.auditFields=auditFields;
        }

        public  MapBuilderEngine(T o, MapFieldsStrategy mapFieldsStrategy, ParentFields parentFields, AuditFields auditFields){
            this.o=o;
            this.mapFieldsStrategy=mapFieldsStrategy;
            this.parentFields=parentFields;
            this.auditFields=auditFields;
        }

        public MapBuilderEngine(T o ){
            this.o=o;
        }

//        public MapBuilderEngine fromDto(Object dto){
//            this.dto=dto;
//            return this;
//        }
//
//        public MapBuilderEngine fromDtoList(Object dtoList){
//            this.dtoList=dtoList;
//            return  this;
//        }

        public MapBuilderEngine init() {
            return this;
        }

        public MapBuilderEngine ignore(String field) {
            if(mapFieldsStrategy!=null&&mapFieldsStrategy.equals(MapFieldsStrategy.IGNORE_SOME_FIELDS)) {
                this.ignoreList.add(field);
            }
            return this;
        }

        public MapBuilderEngine add(String field) {
            if(mapFieldsStrategy!=null&&mapFieldsStrategy.equals(MapFieldsStrategy.ONLY_CONSTRUCT_SOME_FIELDS)) {
                this.addedList.add(field);
            }
            return this;
        }

        public MapBuilderEngine update(String field, Object val) {
            this.updateMap.put(field,val);
            return this;
        }

        public MapFieldsStrategy getMapFieldsStrategy() {
            return mapFieldsStrategy;
        }

        public AuditFields getAuditFields() {
            return auditFields;
        }

        public ParentFields getParentFields(){
            return parentFields;
        }

        private Object getObj() {
            return o;
        }



        private List<String> getIgnoreList() {
            return ignoreList;
        }
        private List<String> getAddedList() {
            return addedList;
        }

        private Map<String, Object> getUpdateMap() {
            return updateMap;
        }

        public T build(){
            return (T)new DtoMapper(this).getResult();
        }

    }

    public static   Map<String,Object> appendMap(Map<String, Object> aMap,Map<String, Object> appendWithMap){
        Set<String> keySet = appendWithMap.keySet();
        for(String key : keySet){
            aMap.put(key,appendWithMap.get(key));
        }
        return aMap;
    }
}
