package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "buoy")
public class BuoyEntity   implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @Column(name = "name")
    private String nameStr;

    @Column(name = "description")
    private String descriptionStr;

    @ManyToOne(  )
    @JoinColumn(foreignKey = @ForeignKey(name = "symbol_type_id"), name = "symbol_type_id")
    private SymbolTypeEntity symbolType;

    @Column(name = "longitude")
    private Double longitudeDbl;

    @Column(name = "latitude")
    private Double latitudeDbl;

    @Column(name = "timestamp")
    private Date timestampDti;

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

    public String getDescriptionStr() {
        return descriptionStr;
    }

    public void setDescriptionStr(String descriptionStr) {
        this.descriptionStr = descriptionStr;
    }

    public SymbolTypeEntity getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(SymbolTypeEntity symbolType) {
        this.symbolType = symbolType;
    }

    public Double getLongitudeDbl() {
        return longitudeDbl;
    }

    public void setLongitudeDbl(Double longitudeDbl) {
        this.longitudeDbl = longitudeDbl;
    }

    public Double getLatitudeDbl() {
        return latitudeDbl;
    }

    public void setLatitudeDbl(Double latitudeDbl) {
        this.latitudeDbl = latitudeDbl;
    }

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }
}
