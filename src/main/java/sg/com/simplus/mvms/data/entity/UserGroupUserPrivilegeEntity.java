package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "user_group_user_privilege")
public class UserGroupUserPrivilegeEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @Column(name = "user_group_id")
    Integer userGroupIdInt;

    @Column(name = "user_privilege_id")
    Integer userPrivilegeIdInt;

    @Column(name = "created_by")
    Integer createdByInt;

    @Column(name = "created_date")
    Date createdDateDti;

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
