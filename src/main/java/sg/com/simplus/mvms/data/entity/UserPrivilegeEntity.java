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
    private Integer idInt;

    @Column(name = "code")
    private  String codeStr;

    @Column(name = "name")
    private String nameStr;

    @Column(name = "description")
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
