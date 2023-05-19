package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "setting_data_type")
public class SettingDataTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @Column(name = "type_code")
    private String typeCodeStr;

    @Column(name = "description")
    private String descriptionStr;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public String getTypeCodeStr() {
        return typeCodeStr;
    }

    public void setTypeCodeStr(String typeCodeStr) {
        this.typeCodeStr = typeCodeStr;
    }

    public String getDescriptionStr() {
        return descriptionStr;
    }

    public void setDescriptionStr(String descriptionStr) {
        this.descriptionStr = descriptionStr;
    }

}
