package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "user")
public class UserEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @Column(name = "user_group_id")
    Integer userGroupIdInt;

    @Column(name = "name")
    String nameStr;

    @Column(name = "username")
    String usernameStr;

    @Column(name = "password")
    String passwordStr;

    @Column(name = "active")
    Integer activeInt;

    @Column(name = "created_by")
    Integer createdByInt;

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

    public Integer getActiveInt() {
        return activeInt;
    }

    public void setActiveInt(Integer activeInt) {
        this.activeInt = activeInt;
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