package sg.com.simplus.mvms.data.dto;

import java.io.Serializable;
import java.util.Date;

public class Alert implements Serializable {

    private Integer idInt;

    private String geofenceNameStr;

    private String alertStr;

    private Vessel vessel;

    private Date timestampDti;

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

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }
}
