package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import sg.com.simplus.mvms.data.entity.FleetEntity;
import sg.com.simplus.mvms.data.entity.VesselTypeAisEntity;
import sg.com.simplus.mvms.data.entity.VesselTypeProjectEntity;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class GeofenceAlertTrigger {

    private Integer idInt;

    private Geofence geofence;

    private FleetEntity fleet;

    private Integer triggerIndexInt;

    private Double minLengthDbl;

    private Double maxLengthDbl;

    private Double minWidthDbl;

    private Double maxWidthDbl;

    private Double minDraftDbl;

    private Double maxDraftDbl;

    private Double minSpeedDbl;

    private Double maxSpeedDbl;

    private List<VesselTypeAis> vesselTypeAisList;

    private List<VesselTypeProject> vesselTypeProjectList;

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

    public FleetEntity getFleet() {
        return fleet;
    }

    public void setFleet(FleetEntity fleet) {
        this.fleet = fleet;
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

    public Double getMinSpeedDbl() {
        return minSpeedDbl;
    }

    public void setMinSpeedDbl(Double minSpeedDbl) {
        this.minSpeedDbl = minSpeedDbl;
    }

    public Double getMaxSpeedDbl() {
        return maxSpeedDbl;
    }

    public void setMaxSpeedDbl(Double maxSpeedDbl) {
        this.maxSpeedDbl = maxSpeedDbl;
    }

    public List<VesselTypeAis> getVesselTypeAisList() {
        return vesselTypeAisList;
    }

    public void setVesselTypeAisList(List<VesselTypeAis> vesselTypeAisList) {
        this.vesselTypeAisList = vesselTypeAisList;
    }

    public List<VesselTypeProject> getVesselTypeProjectList() {
        return vesselTypeProjectList;
    }

    public void setVesselTypeProjectList(List<VesselTypeProject> vesselTypeProjectList) {
        this.vesselTypeProjectList = vesselTypeProjectList;
    }

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }
}
