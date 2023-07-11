package sg.com.simplus.mvms;

public class Constants {

    //type code use to map config data type
    public static final String TYPE_CODE_TEXT = "TEXT";
    public static final String TYPE_CODE_LONG = "LONG";
    public static final String TYPE_CODE_DOUBLE = "DOUBLE";
    public static final String TYPE_CODE_BOOLEAN = "BOOLEAN";
    public static final String TYPE_CODE_ARR_TEXT = "ARR_TEXT";
    public static final String TYPE_CODE_ARR_LONG = "ARR_LONG";
    public static final String TYPE_CODE_ARR_DOUBLE = "ARR_DOUBLE";
    public static final String TYPE_CODE_ARR_BOOLEAN = "ARR_BOOLEAN";

    //suffix data type
    public static final String SUFFIX_DATA_TYPE_DATETIME = "Dti";

    //audit field names
    public static final String AUDIT_FIELD_CREATED_BY = "createdByInt";
    public static final String AUDIT_FIELD_MODIFIED_BY = "modifiedByInt";
    public static final String AUDIT_FIELD_CREATED_DATE = "createdDateDti";
    public static final String AUDIT_FIELD_MODIFIED_DATE = "modifiedDateDti";

    //root context of all endpoint
    public static final String ROOT_ENDPOINT_CONTEXT = "/api";

    //endpoint for fleet
    public static final String ENDPOINT_URI_FLEET_GET_ALL = "/fleet/get-all";

    public static final String ENDPOINT_URI_FLEET_CREATE = "/fleet/create";

    //endpoint for vessel
    public static final String ENDPOINT_URI_VESSEL_GET_ALL = "/vessel/get-all";
    public static final String ENDPOINT_URI_VESSEL_CREATE = "/vessel/create";
    public static final String ENDPOINT_URI_VESSEL_UPDATE = "/vessel/update";

    public static final String ENDPOINT_URI_VESSEL_UPDATE_EMAIL = "/vessel/update-email";
    public static final String ENDPOINT_URI_VESSEL_ADD_TO_FLEET = "/vessel/add-to-fleet";
    public static final String ENDPOINT_URI_VESSEL_REMOVE_FROM_FLEET = "/vessel/remove-from-fleet";

    //endpoint for mapview configuration
    public static final String ENDPOINT_URI_CONFIG_MAP_GET_ALL = "/config/map/get-all";

    //endpoint for vessel note
    public static final String ENDPOINT_URI_NOTE_GET_BY_VESSEL_ID = "/note/get-by-vessel-id/{id}";
    public static final String ENDPOINT_URI_NOTE_CREATE = "/note/create";
    public static final String ENDPOINT_URI_NOTE_UPDATE = "/note/update";
    public static final String ENDPOINT_URI_NOTE_DELETE_BY_ID = "/note/delete-by-id/{id}";
    public static final String ENDPOINT_URI_NOTE_DELETE_BY_VESSEL_ID = "/note/delete-by-vessel-id/{id}";

    //endpoint for user setting
    public static final String ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_CREATE = "/user-display-configuration/create";
    public static final String ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_UPDATE = "/user-display-configuration/update";
    public static final String ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_DELETE_BY_ID = "/user-display-configuration/delete-by-id/{id}";
    public static final String ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_DELETE_BY_USER_ID = "/user-display-configuration/delete-by-user-id/{id}";

    //endpoint for user setting
    public static final String ENDPOINT_URI_POSITION_REPORT_GET_BY_DATE = "/position-report/get-by-date";

    //endpoint for geofence
    public static final String ENDPOINT_URI_GEOFENCE_GET_ALL = "/geofence/get-all";
    public static final String ENDPOINT_URI_GEOFENCE_CREATE = "/geofence/create";
    public static final String ENDPOINT_URI_GEOFENCE_UPDATE = "/geofence/update";
    public static final String ENDPOINT_URI_GEOFENCE_DELETE = "/geofence/delete/{id}";

    //endpoint for buoy
    public static final String ENDPOINT_URI_SYMBOL_GET_ALL = "/symbol/get-all";
    public static final String ENDPOINT_URI_SYMBOL_CREATE = "/symbol/create";
    public static final String ENDPOINT_URI_SYMBOL_UPDATE = "/symbol/update";
    public static final String ENDPOINT_URI_SYMBOL_DELETE = "/symbol/delete/{id}";

    //endpoint for vessel type ais
    public static final String ENDPOINT_URI_VESSEL_TYPE_AIS_GET_ALL = "/vessel-type-ais/get-all";

    //endpoint for vessel type project
    public static final String ENDPOINT_URI_VESSEL_TYPE_PROJECT_GET_ALL = "/vessel-type-project/get-all";

    //endpoint for upload
    public static final String ENDPOINT_URI_UPLOAD_DXF = "/upload/dxf";
    public static final String ENDPOINT_URI_UPLOAD_ENC = "/upload/enc";

    public static final String JMS_QUEUE_NAME = "AIS_DECODING_SERVICE.QUEUE";

    public static final String JMS_TOPIC_NAME_VESSEL = "BACKEND_VESSEL_POSITION.TOPIC";

    public static final String JMS_TOPIC_NAME_GEOFENCE = "BACKEND_GEOFENCE.TOPIC";

    public static final String JMS_TOPIC_NAME_GEOFENCE_ALERT_TRIGGER = "BACKEND_GEOFENCE_ALERT_TRIGGER.TOPIC";

}
