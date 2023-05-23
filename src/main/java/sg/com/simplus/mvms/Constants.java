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

    //endpoint for vessel
    public static final String ENDPOINT_URI_VESSEL_GET_ALL = "/vessel/get-all";
    public static final String ENDPOINT_URI_VESSEL_CREATE = "/vessel/create";
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
    public static final String ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_DELETE_BY_ID = "/user-display-configuration/delete-by-id";
    public static final String ENDPOINT_URI_USER_DISPLAY_CONFIGURATION_DELETE_BY_USER_ID = "/user-display-configuration/delete-by-user-id";

    //endpoint for user setting
    public static final String ENDPOINT_URI_POSITION_REPORT_GET_BY_DATE = "/position-report/get-by-date";
}
