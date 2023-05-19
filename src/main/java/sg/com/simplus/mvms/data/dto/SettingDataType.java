package sg.com.simplus.mvms.data.dto;

import javax.persistence.Column;
import java.util.Date;

public class SettingDataType {

    private Integer idInt;

    private String typeCodeStr;

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
