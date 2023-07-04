package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "vessel_type_project_criteria")
public class VesselTypeProjectCriteriaEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @ManyToOne( )
    @JoinColumn(foreignKey = @ForeignKey(name = "vessel_type_project_id"), name = "vessel_type_project_id")
    private VesselTypeProjectEntity vesselTypeProject;

    @ManyToOne( )
    @JoinColumn(foreignKey = @ForeignKey(name = "geofence_alert_trigger_id"), name = "geofence_alert_trigger_id")
    private GeofenceAlertTriggerEntity geofenceAlertTrigger;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public VesselTypeProjectEntity getVesselTypeProject() {
        return vesselTypeProject;
    }

    public void setVesselTypeProject(VesselTypeProjectEntity vesselTypeProject) {
        this.vesselTypeProject = vesselTypeProject;
    }

    public GeofenceAlertTriggerEntity getGeofenceAlertTrigger() {
        return geofenceAlertTrigger;
    }

    public void setGeofenceAlertTrigger(GeofenceAlertTriggerEntity geofenceAlertTrigger) {
        this.geofenceAlertTrigger = geofenceAlertTrigger;
    }
}
