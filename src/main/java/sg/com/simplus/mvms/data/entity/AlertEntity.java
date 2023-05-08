package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "alert")
public class AlertEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @Column(name = "geofence_name")
    String geofenceNameStr;

    @Column(name = "alert")
    String alertStr;

    @Column(name = "vessel_id")
    Integer vesselIdInt;

    @Column(name = "timestamp")
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
