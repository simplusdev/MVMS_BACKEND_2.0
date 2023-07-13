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
    private Integer idInt;

    @ManyToOne(  )
    @JoinColumn(foreignKey = @ForeignKey(name = "user_group_id"), name = "user_group_id")
    private UserGroupEntity userGroup;

    @Column(name = "name")
    private String nameStr;

    @Column(name = "username")
    private String usernameStr;

    @Column(name = "password")
    private String passwordStr;


    @Column(name = "created_by")
    private Integer createdByInt;

    @Column(name = "modified_by")
    private Integer modifiedByInt;

    @Column(name = "created_date")
    private Date createdDateDti;

    @Column(name = "modified_date")
    private Date modifiedDateDti;
    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public UserGroupEntity getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEntity userGroup) {
        this.userGroup = userGroup;
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
