package sg.com.simplus.mvms.data.dto;

import java.util.Date;

public class User {

    Integer idInt;

    Integer userGroupIdInt;

    String nameStr;

    String usernameStr;

    String passwordStr;

    Boolean activeBln;

    Integer createdByInt;

    Integer modifiedByInt;

    Date createdDateDti;

    Date modifiedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Integer getUserGroupIdInt() {
        return userGroupIdInt;
    }

    public void setUserGroupIdInt(Integer userGroupIdInt) {
        this.userGroupIdInt = userGroupIdInt;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getUsernameStr() {
        return usernameStr;
    }

    public void setUsernameStr(String usernameStr) {
        this.usernameStr = usernameStr;
    }

    public String getPasswordStr() {
        return passwordStr;
    }

    public void setPasswordStr(String passwordStr) {
        this.passwordStr = passwordStr;
    }

    public Boolean getActiveBln() {
        return activeBln;
    }

    public void setActiveBln(Boolean activeBln) {
        this.activeBln = activeBln;
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
