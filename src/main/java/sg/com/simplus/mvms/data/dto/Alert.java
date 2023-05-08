package sg.com.simplus.mvms.data.dto;

import java.util.Date;

public class Alert {

    Integer idInt;

    String geofenceNameStr;

    String alertStr;

    Integer vesselIdInt;

    Date timestampDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public String getGeofenceNameStr() {
        return geofenceNameStr;
    }

    public void setGeofenceNameStr(String geofenceNameStr) {
        this.geofenceNameStr = geofenceNameStr;
    }

    public String getAlertStr() {
        return alertStr;
    }

    public void setAlertStr(String alertStr) {
        this.alertStr = alertStr;
    }

    public Integer getVesselIdInt() {
        return vesselIdInt;
    }

    public void setVesselIdInt(Integer vesselIdInt) {
        this.vesselIdInt = vesselIdInt;
    }

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }
}
