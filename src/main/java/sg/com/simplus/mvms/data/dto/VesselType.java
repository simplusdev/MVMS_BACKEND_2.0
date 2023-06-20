package sg.com.simplus.mvms.data.dto;

import java.io.Serializable;

public class VesselType implements Serializable {

    private Integer idInt;

    private Integer codeInt;

    private String descriptionStr;

    private String colorStr;

    private String iconStr;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Integer getCodeInt() {
        return codeInt;
    }

    public void setCodeInt(Integer codeInt) {
        this.codeInt = codeInt;
    }

    public String getDescriptionStr() {
        return descriptionStr;
    }

    public void setDescriptionStr(String descriptionStr) {
        this.descriptionStr = descriptionStr;
    }

    public String getColorStr() {
        return colorStr;
    }

    public void setColorStr(String colorStr) {
        this.colorStr = colorStr;
    }

    public String getIconStr() {
        return iconStr;
    }

    public void setIconStr(String iconStr) {
        this.iconStr = iconStr;
    }

 }
