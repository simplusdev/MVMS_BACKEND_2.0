package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserPrivilege {

    private Integer idInt;

    private String codeStr;

    private String nameStr;

    private String descriptionStr;


    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public String getCodeStr() {
        return codeStr;
    }

    public void setCodeStr(String codeStr) {
        this.codeStr = codeStr;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getDescriptionStr() {
        return descriptionStr;
    }

    public void setDescriptionStr(String descriptionStr) {
        this.descriptionStr = descriptionStr;
    }
 }
