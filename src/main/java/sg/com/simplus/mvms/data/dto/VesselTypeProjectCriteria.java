package sg.com.simplus.mvms.data.dto;

import java.io.Serializable;


public class VesselTypeProjectCriteria implements Serializable {

    private Integer idInt;

    private VesselTypeProject vesselTypeProject;

    private GeofenceAlertTrigger geofenceAlertTrigger;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public VesselTypeProject getVesselTypeProject() {
        return vesselTypeProject;
    }

    public void setVesselTypeProject(VesselTypeProject vesselTypeProject) {
        this.vesselTypeProject = vesselTypeProject;
    }

    public GeofenceAlertTrigger getGeofenceAlertTrigger() {
        return geofenceAlertTrigger;
    }

    public void setGeofenceAlertTrigger(GeofenceAlertTrigger geofenceAlertTrigger) {
        this.geofenceAlertTrigger = geofenceAlertTrigger;
    }
}
