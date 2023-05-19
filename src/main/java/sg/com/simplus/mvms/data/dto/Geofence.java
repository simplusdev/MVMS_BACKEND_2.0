package sg.com.simplus.mvms.data.dto;

import java.util.Date;

public class Geofence {

    private Integer idInt;

    private String nameStr;

    private String descriptionStr;

    private String coordinatesStr;

    private Boolean transparentBln;

    private String typeStr;

    private Double longitudeDbl;

    private Double latitudeDbl;

    private Double radiusDbl;

    private String colorStr;

    private Boolean deletedBln;

    private Date createdDateDti;

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

    public Boolean getTransparentBln() {
        return transparentBln;
    }

    public void setTransparentBln(Boolean transparentBln) {
        this.transparentBln = transparentBln;
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

    public Boolean getDeletedBln() {
        return deletedBln;
    }

    public void setDeletedBln(Boolean deletedBln) {
        this.deletedBln = deletedBln;
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
