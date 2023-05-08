package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "user_privilege")
public class UserPrivilegeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @Column(name = "code")
    String codeStr;

    @Column(name = "name")
    String nameStr;

    @Column(name = "description")
    String descriptionStr;

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