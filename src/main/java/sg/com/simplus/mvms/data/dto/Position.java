package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Position {

    private Integer idInt;

    private Integer messageTypeInt;

    private Double repeatIndicatorDbl;

    private Integer accuracyInt;

    private Integer reservedInt;

    private Integer regionalInt;

    @JsonIgnore
    private Integer csInt;

    private String csStr;

    @JsonIgnore
    private Integer displayInt;

    private String displayStr;

    @JsonIgnore
    private Integer dscInt;

    private String dscStr;

    @JsonIgnore
    private Integer bandInt;

    private String bandStr;

    @JsonIgnore
    private Integer msg22Int;

    private String msg22Str;

    @JsonIgnore
    private Integer assignedInt;

    private String assignedStr;

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

    public String getCsStr() {
        return csStr;
    }

    public void setCsStr(String csStr) {
        this.csStr = csStr;
    }

    public Integer getDisplayInt() {
        return displayInt;
    }

    public void setDisplayInt(Integer displayInt) {
        this.displayInt = displayInt;
    }

    public String getDisplayStr() {
        return displayStr;
    }

    public void setDisplayStr(String displayStr) {
        this.displayStr = displayStr;
    }

    public Integer getDscInt() {
        return dscInt;
    }

    public void setDscInt(Integer dscInt) {
        this.dscInt = dscInt;
    }

    public String getDscStr() {
        return dscStr;
    }

    public void setDscStr(String dscStr) {
        this.dscStr = dscStr;
    }

    public Integer getBandInt() {
        return bandInt;
    }

    public void setBandInt(Integer bandInt) {
        this.bandInt = bandInt;
    }

    public String getBandStr() {
        return bandStr;
    }

    public void setBandStr(String bandStr) {
        this.bandStr = bandStr;
    }

    public Integer getMsg22Int() {
        return msg22Int;
    }

    public void setMsg22Int(Integer msg22Int) {
        this.msg22Int = msg22Int;
    }

    public String getMsg22Str() {
        return msg22Str;
    }

    public void setMsg22Str(String msg22Str) {
        this.msg22Str = msg22Str;
    }

    public Integer getAssignedInt() {
        return assignedInt;
    }

    public void setAssignedInt(Integer assignedInt) {
        this.assignedInt = assignedInt;
    }

    public String getAssignedStr() {
        return assignedStr;
    }

    public void setAssignedStr(String assignedStr) {
        this.assignedStr = assignedStr;
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
