package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "geofence")
public class GeofenceEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @Column(name = "name")
    private String nameStr;

    @Column(name = "description")
    private String descriptionStr;

    @Column(name = "coordinates")
    private String coordinatesStr;

    @Column(name = "transparent")
    private Integer transparentInt;

    @Column(name = "type")
    private String typeStr;

    @Column(name = "longitude")
    private Double longitudeDbl;

    @Column(name = "latitude")
    private Double latitudeDbl;

    @Column(name = "radius")
    private Double radiusDbl;

    @Column(name = "color")
    private String colorStr;

    @Column(name = "deleted")
    private Integer deletedInt;

    @Column(name = "created_date")
    private Date createdDateDti;

    @Column(name = "deleted_date")
    private Date deletedDateDti;

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

    public String getCoordinatesStr() {
        return coordinatesStr;
    }

    public void setCoordinatesStr(String coordinatesStr) {
        this.coordinatesStr = coordinatesStr;
    }

    public Integer getTransparentInt() {
        return transparentInt;
    }

    public void setTransparentInt(Integer transparentInt) {
        this.transparentInt = transparentInt;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
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

    public Double getRadiusDbl() {
        return radiusDbl;
    }

    public void setRadiusDbl(Double radiusDbl) {
        this.radiusDbl = radiusDbl;
    }

    public String getColorStr() {
        return colorStr;
    }

    public void setColorStr(String colorStr) {
        this.colorStr = colorStr;
    }

    public Integer getDeletedInt() {
        return deletedInt;
    }

    public void setDeletedInt(Integer deletedInt) {
        this.deletedInt = deletedInt;
    }

    public Date getCreatedDateDti() {
        return createdDateDti;
    }

    public void setCreatedDateDti(Date createdDateDti) {
        this.createdDateDti = createdDateDti;
    }

    public Date getDeletedDateDti() {
        return deletedDateDti;
    }

    public void setDeletedDateDti(Date deletedDateDti) {
        this.deletedDateDti = deletedDateDti;
    }
}
