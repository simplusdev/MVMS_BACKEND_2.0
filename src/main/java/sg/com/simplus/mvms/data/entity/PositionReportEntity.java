package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "position_report")
public class PositionReportEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @ManyToOne( )
    @JoinColumn(foreignKey = @ForeignKey(name = "vessel_id"), name = "vessel_id")
    private VesselEntity vessel;

    @Column(name = "message_type")
    private Integer messageTypeInt;

    @Column(name = "repeat_indicator")
    private Double repeatIndicatorDbl;

    @Column(name = "accuracy")
    private Integer accuracyInt;

    @Column(name = "reserved")
    private Integer reservedInt;

    @Column(name = "regional")
    private Integer regionalInt;

    @Column(name = "cs")
    private Integer csInt;

    @Column(name = "display")
    private Integer displayInt;

    @Column(name = "dsc")
    private Integer dscInt;

    @Column(name = "band")
    private Integer bandInt;

    @Column(name = "msg22")
    private Integer msg22Int;

    @Column(name = "assigned")
    private Integer assignedInt;

    @Column(name = "raim")
    private Integer raimInt;

    @Column(name = "longitude")
    private Double longitudeDbl;

    @Column(name = "latitude")
    private Double latitudeDbl;

    @Column(name = "speed")
    private Double speedDbl;

    @Column(name = "course")
    private Double courseDbl;

    @Column(name = "status")
    private String statusStr;

    @Column(name = "heading")
    private Double headingDbl;

    @Column(name = "callsign")
    private String callsignStr;

    @Column(name = "timestamp")
    private Date timestampDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public VesselEntity getVessel() {
        return vessel;
    }

    public void setVessel(VesselEntity vessel) {
        this.vessel = vessel;
    }

    public Integer getMessageTypeInt() {
        return messageTypeInt;
    }

    public void setMessageTypeInt(Integer messageTypeInt) {
        this.messageTypeInt = messageTypeInt;
    }

    public Double getRepeatIndicatorDbl() {
        return repeatIndicatorDbl;
    }

    public void setRepeatIndicatorDbl(Double repeatIndicatorDbl) {
        this.repeatIndicatorDbl = repeatIndicatorDbl;
    }

    public Integer getAccuracyInt() {
        return accuracyInt;
    }

    public void setAccuracyInt(Integer accuracyInt) {
        this.accuracyInt = accuracyInt;
    }

    public Integer getReservedInt() {
        return reservedInt;
    }

    public void setReservedInt(Integer reservedInt) {
        this.reservedInt = reservedInt;
    }

    public Integer getRegionalInt() {
        return regionalInt;
    }

    public void setRegionalInt(Integer regionalInt) {
        this.regionalInt = regionalInt;
    }

    public Integer getCsInt() {
        return csInt;
    }

    public void setCsInt(Integer csInt) {
        this.csInt = csInt;
    }

    public Integer getDisplayInt() {
        return displayInt;
    }

    public void setDisplayInt(Integer displayInt) {
        this.displayInt = displayInt;
    }

    public Integer getDscInt() {
        return dscInt;
    }

    public void setDscInt(Integer dscInt) {
        this.dscInt = dscInt;
    }

    public Integer getBandInt() {
        return bandInt;
    }

    public void setBandInt(Integer bandInt) {
        this.bandInt = bandInt;
    }

    public Integer getMsg22Int() {
        return msg22Int;
    }

    public void setMsg22Int(Integer msg22Int) {
        this.msg22Int = msg22Int;
    }

    public Integer getAssignedInt() {
        return assignedInt;
    }

    public void setAssignedInt(Integer assignedInt) {
        this.assignedInt = assignedInt;
    }

    public Integer getRaimInt() {
        return raimInt;
    }

    public void setRaimInt(Integer raimInt) {
        this.raimInt = raimInt;
    }

    public Double getLongitudeDbl() {
        return longitudeDbl;
    }

    public void setLongitudeDbl(Double longitudeDbl) {
        this.longitudeDbl = longitudeDbl;
    }

    public Double getLatitudeDbl() {
        return latitudeDbl;
    }

    public void setLatitudeDbl(Double latitudeDbl) {
        this.latitudeDbl = latitudeDbl;
    }

    public Double getSpeedDbl() {
        return speedDbl;
    }

    public void setSpeedDbl(Double speedDbl) {
        this.speedDbl = speedDbl;
    }

    public Double getCourseDbl() {
        return courseDbl;
    }

    public void setCourseDbl(Double courseDbl) {
        this.courseDbl = courseDbl;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Double getHeadingDbl() {
        return headingDbl;
    }

    public void setHeadingDbl(Double headingDbl) {
        this.headingDbl = headingDbl;
    }

    public String getCallsignStr() {
        return callsignStr;
    }

    public void setCallsignStr(String callsignStr) {
        this.callsignStr = callsignStr;
    }

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }
}
