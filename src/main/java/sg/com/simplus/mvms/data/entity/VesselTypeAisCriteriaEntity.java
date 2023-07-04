package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "vessel_type_ais_criteria")
public class VesselTypeAisCriteriaEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @ManyToOne( )
    @JoinColumn(foreignKey = @ForeignKey(name = "vessel_type_ais_id"), name = "vessel_type_ais_id")
    private VesselTypeAisEntity vesselTypeAis;

    @ManyToOne( )
    @JoinColumn(foreignKey = @ForeignKey(name = "geofence_alert_trigger_id"), name = "geofence_alert_trigger_id")
    private GeofenceAlertTriggerEntity geofenceAlertTrigger;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public VesselTypeAisEntity getVesselTypeAis() {
        return vesselTypeAis;
    }

    public void setVesselTypeAis(VesselTypeAisEntity vesselTypeAis) {
        this.vesselTypeAis = vesselTypeAis;
    }

    public GeofenceAlertTriggerEntity getGeofenceAlertTrigger() {
        return geofenceAlertTrigger;
    }

    public void setGeofenceAlertTrigger(GeofenceAlertTriggerEntity geofenceAlertTrigger) {
        this.geofenceAlertTrigger = geofenceAlertTrigger;
    }
}
