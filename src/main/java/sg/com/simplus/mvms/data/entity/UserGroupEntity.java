package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "user_group")
public class UserGroupEntity   implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @Column(name = "name")
    private String nameStr;

    @Column(name = "privileges")
    private String privilegesStr;


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

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getPrivilegesStr() {
        return privilegesStr;
    }

    public void setPrivilegesStr(String privilegesStr) {
        this.privilegesStr = privilegesStr;
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
