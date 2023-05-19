package sg.com.simplus.mvms.data.dto;

import java.util.Date;

public class UserSetting {

    private Integer idInt;

    private Integer userIdInt;

    private String nameStr;

    private String configStringStr;

    private Integer usedInt;

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

    public Integer getUserIdInt() {
        return userIdInt;
    }

    public void setUserIdInt(Integer userIdInt) {
        this.userIdInt = userIdInt;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getConfigStringStr() {
        return configStringStr;
    }

    public void setConfigStringStr(String configStringStr) {
        this.configStringStr = configStringStr;
    }

    public Integer getUsedInt() {
        return usedInt;
    }

    public void setUsedInt(Integer usedInt) {
        this.usedInt = usedInt;
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
