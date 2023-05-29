package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserGroupUserPrivilege {

    private Integer idInt;

    private Integer userGroupIdInt;

    private Integer userPrivilegeIdInt;

    private Integer createdByInt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdDateDti;

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

    public Integer getUserPrivilegeIdInt() {
        return userPrivilegeIdInt;
    }

    public void setUserPrivilegeIdInt(Integer userPrivilegeIdInt) {
        this.userPrivilegeIdInt = userPrivilegeIdInt;
    }

    public Integer getCreatedByInt() {
        return createdByInt;
    }

    public void setCreatedByInt(Integer createdByInt) {
        this.createdByInt = createdByInt;
    }

    public Date getCreatedDateDti() {
        return createdDateDti;
    }

    public void setCreatedDateDti(Date createdDateDti) {
        this.createdDateDti = createdDateDti;
    }
}
