package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "vessel_type_ais")
public class VesselTypeAisEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @Column(name = "code")
    private Integer codeInt;

    @Column(name = "description")
    private String descriptionStr;

    @Column(name = "color")
    private String colorStr;

    @Column(name = "icon")
    private String iconStr;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Integer getCodeInt() {
        return codeInt;
    }

    public void setCodeInt(Integer codeInt) {
        this.codeInt = codeInt;
    }

    public String getDescriptionStr() {
        return descriptionStr;
    }

    public void setDescriptionStr(String descriptionStr) {
        this.descriptionStr = descriptionStr;
    }

    public String getColorStr() {
        return colorStr;
    }

    public void setColorStr(String colorStr) {
        this.colorStr = colorStr;
    }

    public String getIconStr() {
        return iconStr;
    }

    public void setIconStr(String iconStr) {
        this.iconStr = iconStr;
    }
}
