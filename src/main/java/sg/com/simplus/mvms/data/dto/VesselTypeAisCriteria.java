package sg.com.simplus.mvms.data.dto;

import java.io.Serializable;


public class VesselTypeAisCriteria implements Serializable {

    private Integer idInt;

    private VesselTypeAis vesselTypeAis;

    private GeofenceAlertTrigger geofenceAlertTrigger;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public VesselTypeAis getVesselTypeAis() {
        return vesselTypeAis;
    }

    public void setVesselTypeAis(VesselTypeAis vesselTypeAis) {
        this.vesselTypeAis = vesselTypeAis;
    }

    public GeofenceAlertTrigger getGeofenceAlertTrigger() {
        return geofenceAlertTrigger;
    }

    public void setGeofenceAlertTrigger(GeofenceAlertTrigger geofenceAlertTrigger) {
        this.geofenceAlertTrigger = geofenceAlertTrigger;
    }
}
