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
    private Integer idInt;

    @ManyToOne( )
    @JoinColumn(foreignKey = @ForeignKey(name = "geofence_id"), name = "geofence_id")
    private GeofenceEntity geofence;

    @Column(name = "trigger_index")
    private Integer triggerIndexInt;

    @Column(name = "min_length")
    private Double minLengthDbl;

    @Column(name = "max_length")
    private Double maxLengthDbl;

    @Column(name = "min_width")
    private Double minWidthDbl;

    @Column(name = "max_width")
    private Double maxWidthDbl;

    @Column(name = "min_draft")
    private Double minDraftDbl;

    @Column(name = "max_draft")
    private Double maxDraftDbl;

    @Column(name = "timestamp")
    private Date timestampDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public GeofenceEntity getGeofence() {
        return geofence;
    }

    public void setGeofence(GeofenceEntity geofence) {
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
