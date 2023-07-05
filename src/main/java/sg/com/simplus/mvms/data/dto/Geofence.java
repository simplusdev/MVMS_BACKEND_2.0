package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class Geofence {

    private Integer idInt;


    private List<GeofenceAlertTrigger> geofenceAlertTriggerList;

    private String nameStr;

    private String descriptionStr;

    private String coordinatesStr;

    private Boolean transparentBln;

    private SymbolType symbolType;

    private Double longitudeDbl;

    private Double latitudeDbl;

    private Double radiusDbl;

    private String colorStr;

    private String emailStr;

    private Boolean deletedBln;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdDateDti;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date deletedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public List<GeofenceAlertTrigger> getGeofenceAlertTriggerList() {
        return geofenceAlertTriggerList;
    }

    public void setGeofenceAlertTriggerList(List<GeofenceAlertTrigger> geofenceAlertTriggerList) {
        this.geofenceAlertTriggerList = geofenceAlertTriggerList;
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

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(SymbolType symbolType) {
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

    public String getEmailStr() {
        return emailStr;
    }

    public void setEmailStr(String emailStr) {
        this.emailStr = emailStr;
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
