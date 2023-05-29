package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PositionReportLast {

    private Integer idInt;

    private Integer vesselIdInt;

    private Integer messageTypeInt;

    private Double repeatIndicatorDbl;

    private Integer accuracyInt;

    private Integer reservedInt;

    private Integer regionalInt;

    private Integer csInt;

    private Integer displayInt;

    private Integer dscInt;

    private Integer bandInt;

    private Integer msg22Int;

    private Integer assignedInt;

    private Integer raimInt;

    private Double longitudeDbl;

    private Double latitudeDbl;

    private Double speedDbl;

    private Double courseDbl;

    private String statusStr;

    private Double headingDbl;

    private String callsignStr;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date timestampDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Integer getVesselIdInt() {
        return vesselIdInt;
    }

    public void setVesselIdInt(Integer vesselIdInt) {
        this.vesselIdInt = vesselIdInt;
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
