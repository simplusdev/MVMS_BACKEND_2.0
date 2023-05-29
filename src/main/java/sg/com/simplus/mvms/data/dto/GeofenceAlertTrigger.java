package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GeofenceAlertTrigger {

    private Integer idInt;

    private Geofence geofence;

    private Integer triggerIndexInt;

    private Double minLengthDbl;

    private Double maxLengthDbl;

    private Double minWidthDbl;

    private Double maxWidthDbl;

    private Double minDraftDbl;

    private Double maxDraftDbl;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date timestampDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Geofence getGeofence() {
        return geofence;
    }

    public void setGeofence(Geofence geofence) {
        this.geofence = geofence;
    }

    public Integer getTriggerIndexInt() {
        return triggerIndexInt;
    }

    public void setTriggerIndexInt(Integer triggerIndexInt) {
        this.triggerIndexInt = triggerIndexInt;
    }

    public Double getMinLengthDbl() {
        return minLengthDbl;
    }

    public void setMinLengthDbl(Double minLengthDbl) {
        this.minLengthDbl = minLengthDbl;
    }

    public Double getMaxLengthDbl() {
        return maxLengthDbl;
    }

    public void setMaxLengthDbl(Double maxLengthDbl) {
        this.maxLengthDbl = maxLengthDbl;
    }

    public Double getMinWidthDbl() {
        return minWidthDbl;
    }

    public void setMinWidthDbl(Double minWidthDbl) {
        this.minWidthDbl = minWidthDbl;
    }

    public Double getMaxWidthDbl() {
        return maxWidthDbl;
    }

    public void setMaxWidthDbl(Double maxWidthDbl) {
        this.maxWidthDbl = maxWidthDbl;
    }

    public Double getMinDraftDbl() {
        return minDraftDbl;
    }

    public void setMinDraftDbl(Double minDraftDbl) {
        this.minDraftDbl = minDraftDbl;
    }

    public Double getMaxDraftDbl() {
        return maxDraftDbl;
    }

    public void setMaxDraftDbl(Double maxDraftDbl) {
        this.maxDraftDbl = maxDraftDbl;
    }

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }
}
