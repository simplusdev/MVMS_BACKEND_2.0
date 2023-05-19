package sg.com.simplus.mvms.data.dto;

import java.util.Date;

public class SettingConfiguration {

    private Integer idInt;

    private SettingDataType settingDataType;

    private String propertyNameStr;

    private String propertyValueStr;

    private Integer createdByInt;

    private Integer modifiedByInt;

    private Date createdDateDti;

    private Date modifiedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public SettingDataType getSettingDataType() {
        return settingDataType;
    }

    public void setSettingDataType(SettingDataType settingDataType) {
        this.settingDataType = settingDataType;
    }

    public String getPropertyNameStr() {
        return propertyNameStr;
    }

    public void setPropertyNameStr(String propertyNameStr) {
        this.propertyNameStr = propertyNameStr;
    }

    public String getPropertyValueStr() {
        return propertyValueStr;
    }

    public void setPropertyValueStr(String propertyValueStr) {
        this.propertyValueStr = propertyValueStr;
    }

    public Integer getCreatedByInt() {
        return createdByInt;
    }

    public void setCreatedByInt(Integer createdByInt) {
        this.createdByInt = createdByInt;
    }

    public Integer getModifiedByInt() {
        return modifiedByInt;
    }

    public void setModifiedByInt(Integer modifiedByInt) {
        this.modifiedByInt = modifiedByInt;
    }

    public Date getCreatedDateDti() {
        return createdDateDti;
    }

    public void setCreatedDateDti(Date createdDateDti) {
        this.createdDateDti = createdDateDti;
    }

    public Date getModifiedDateDti() {
        return modifiedDateDti;
    }

    public void setModifiedDateDti(Date modifiedDateDti) {
        this.modifiedDateDti = modifiedDateDti;
    }
}
