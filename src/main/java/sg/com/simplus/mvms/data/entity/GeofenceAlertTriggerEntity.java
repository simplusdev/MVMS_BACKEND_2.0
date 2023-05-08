package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "geofence_alert_trigger")
public class GeofenceAlertTriggerEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @Column(name = "geofence_id")
    Integer geofenceIdInt;

    @Column(name = "trigger_index")
    Integer triggerIndexInt;

    @Column(name = "min_length")
    Double minLengthDbl;

    @Column(name = "max_length")
    Double maxLengthDbl;

    @Column(name = "min_width")
    Double minWidthDbl;

    @Column(name = "max_width")
    Double maxWidthDbl;

    @Column(name = "min_draft")
    Double minDraftDbl;

    @Column(name = "max_draft")
    Double maxDraftDbl;

    @Column(name = "timestamp")
    Date timestampDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Integer getGeofenceIdInt() {
        return geofenceIdInt;
    }

    public void setGeofenceIdInt(Integer geofenceIdInt) {
        this.geofenceIdInt = geofenceIdInt;
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
