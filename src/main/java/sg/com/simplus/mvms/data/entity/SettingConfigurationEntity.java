package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "setting_configuration")
public class SettingConfigurationEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(foreignKey = @ForeignKey(name = "setting_data_type_id"), name = "setting_data_type_id")
    private SettingDataTypeEntity settingDataType;

    @Column(name = "property_name")
    private String propertyNameStr;

    @Column(name = "property_value")
    private String propertyValueStr;

    @Column(name = "created_by")
    private Integer createdByInt;

    @Column(name = "modified_by")
    Integer modifiedByInt;

    @Column(name = "created_date")
    Date createdDateDti;

    @Column(name = "modified_date")
    Date modifiedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public SettingDataTypeEntity getSettingDataType() {
        return settingDataType;
    }

    public void setSettingDataType(SettingDataTypeEntity settingDataType) {
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
