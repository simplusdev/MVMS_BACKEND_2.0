package sg.com.simplus.mvms.data.dto;

import sg.com.simplus.mvms.data.entity.FleetEntity;

import java.io.Serializable;
import java.util.Date;

public class Vessel  implements Serializable {

    private Integer idInt;

    //Integer fleetIdInt;
    private Fleet fleet;

    private Boolean active;

    private String nameStr;

    private String vesselTypeStr;

    private Integer imoNumberInt;

    private Integer mmsiInt;

    private Integer mothershipMmsiInt;

    private String lastPortStr;

    private String lastPortTimeStr;

    private String currentPortStr;

    private String destinationStr;

    private Double lengthDbl;

    private Double widthDbl;

    private Double draftDbl;

    private String flagStr;

    private Double deadWeightDbl;

    private String dateOfBuildStr;

    private Date timestampDti;

    private String projectVesselTypeStr;

    private Integer vesselCategoryIdInt;

    private Double grosstonnageDbl;

    private String assignedRouteStr;

    private String alertRecipientsStr;

    private String callsignStr;

    private Double repeatIndicatorDbl;

    private Integer aisVersionInt;

    private Double toBowDbl;

    private Double toSternDbl;

    private Double toPortDbl;

    private Double toStarboardDbl;

    private Double draughtDbl;

    private String etaStr;

    private Integer dteInt;

    private Integer partnoInt;

    private String vendoridStr;

    private Integer modelInt;

    private Integer serialInt;

    private Integer epfdInt;

    private Integer shiptypeInt;

    private Integer createdByInt;

    private Integer modifiedByInt;

    private Date createdDateDti;

    private Date modifiedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getVesselTypeStr() {
        return vesselTypeStr;
    }

    public void setVesselTypeStr(String vesselTypeStr) {
        this.vesselTypeStr = vesselTypeStr;
    }

    public Integer getImoNumberInt() {
        return imoNumberInt;
    }

    public void setImoNumberInt(Integer imoNumberInt) {
        this.imoNumberInt = imoNumberInt;
    }

    public Integer getMmsiInt() {
        return mmsiInt;
    }

    public void setMmsiInt(Integer mmsiInt) {
        this.mmsiInt = mmsiInt;
    }

    public Integer getMothershipMmsiInt() {
        return mothershipMmsiInt;
    }

    public void setMothershipMmsiInt(Integer mothershipMmsiInt) {
        this.mothershipMmsiInt = mothershipMmsiInt;
    }

    public String getLastPortStr() {
        return lastPortStr;
    }

    public void setLastPortStr(String lastPortStr) {
        this.lastPortStr = lastPortStr;
    }

    public String getLastPortTimeStr() {
        return lastPortTimeStr;
    }

    public void setLastPortTimeStr(String lastPortTimeStr) {
        this.lastPortTimeStr = lastPortTimeStr;
    }

    public String getCurrentPortStr() {
        return currentPortStr;
    }

    public void setCurrentPortStr(String currentPortStr) {
        this.currentPortStr = currentPortStr;
    }

    public String getDestinationStr() {
        return destinationStr;
    }

    public void setDestinationStr(String destinationStr) {
        this.destinationStr = destinationStr;
    }

    public Double getLengthDbl() {
        return lengthDbl;
    }

    public void setLengthDbl(Double lengthDbl) {
        this.lengthDbl = lengthDbl;
    }

    public Double getWidthDbl() {
        return widthDbl;
    }

    public void setWidthDbl(Double widthDbl) {
        this.widthDbl = widthDbl;
    }

    public Double getDraftDbl() {
        return draftDbl;
    }

    public void setDraftDbl(Double draftDbl) {
        this.draftDbl = draftDbl;
    }

    public String getFlagStr() {
        return flagStr;
    }

    public void setFlagStr(String flagStr) {
        this.flagStr = flagStr;
    }

    public Double getDeadWeightDbl() {
        return deadWeightDbl;
    }

    public void setDeadWeightDbl(Double deadWeightDbl) {
        this.deadWeightDbl = deadWeightDbl;
    }

    public String getDateOfBuildStr() {
        return dateOfBuildStr;
    }

    public void setDateOfBuildStr(String dateOfBuildStr) {
        this.dateOfBuildStr = dateOfBuildStr;
    }

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }

    public String getProjectVesselTypeStr() {
        return projectVesselTypeStr;
    }

    public void setProjectVesselTypeStr(String projectVesselTypeStr) {
        this.projectVesselTypeStr = projectVesselTypeStr;
    }

    public Integer getVesselCategoryIdInt() {
        return vesselCategoryIdInt;
    }

    public void setVesselCategoryIdInt(Integer vesselCategoryIdInt) {
        this.vesselCategoryIdInt = vesselCategoryIdInt;
    }

    public Double getGrosstonnageDbl() {
        return grosstonnageDbl;
    }

    public void setGrosstonnageDbl(Double grosstonnageDbl) {
        this.grosstonnageDbl = grosstonnageDbl;
    }

    public String getAssignedRouteStr() {
        return assignedRouteStr;
    }

    public void setAssignedRouteStr(String assignedRouteStr) {
        this.assignedRouteStr = assignedRouteStr;
    }

    public String getAlertRecipientsStr() {
        return alertRecipientsStr;
    }

    public void setAlertRecipientsStr(String alertRecipientsStr) {
        this.alertRecipientsStr = alertRecipientsStr;
    }

    public String getCallsignStr() {
        return callsignStr;
    }

    public void setCallsignStr(String callsignStr) {
        this.callsignStr = callsignStr;
    }

    public Double getRepeatIndicatorDbl() {
        return repeatIndicatorDbl;
    }

    public void setRepeatIndicatorDbl(Double repeatIndicatorDbl) {
        this.repeatIndicatorDbl = repeatIndicatorDbl;
    }

    public Integer getAisVersionInt() {
        return aisVersionInt;
    }

    public void setAisVersionInt(Integer aisVersionInt) {
        this.aisVersionInt = aisVersionInt;
    }

    public Double getToBowDbl() {
        return toBowDbl;
    }

    public void setToBowDbl(Double toBowDbl) {
        this.toBowDbl = toBowDbl;
    }

    public Double getToSternDbl() {
        return toSternDbl;
    }

    public void setToSternDbl(Double toSternDbl) {
        this.toSternDbl = toSternDbl;
    }

    public Double getToPortDbl() {
        return toPortDbl;
    }

    public void setToPortDbl(Double toPortDbl) {
        this.toPortDbl = toPortDbl;
    }

    public Double getToStarboardDbl() {
        return toStarboardDbl;
    }

    public void setToStarboardDbl(Double toStarboardDbl) {
        this.toStarboardDbl = toStarboardDbl;
    }

    public Double getDraughtDbl() {
        return draughtDbl;
    }

    public void setDraughtDbl(Double draughtDbl) {
        this.draughtDbl = draughtDbl;
    }

    public String getEtaStr() {
        return etaStr;
    }

    public void setEtaStr(String etaStr) {
        this.etaStr = etaStr;
    }

    public Integer getDteInt() {
        return dteInt;
    }

    public void setDteInt(Integer dteInt) {
        this.dteInt = dteInt;
    }

    public Integer getPartnoInt() {
        return partnoInt;
    }

    public void setPartnoInt(Integer partnoInt) {
        this.partnoInt = partnoInt;
    }

    public String getVendoridStr() {
        return vendoridStr;
    }

    public void setVendoridStr(String vendoridStr) {
        this.vendoridStr = vendoridStr;
    }

    public Integer getModelInt() {
        return modelInt;
    }

    public void setModelInt(Integer modelInt) {
        this.modelInt = modelInt;
    }

    public Integer getSerialInt() {
        return serialInt;
    }

    public void setSerialInt(Integer serialInt) {
        this.serialInt = serialInt;
    }

    public Integer getEpfdInt() {
        return epfdInt;
    }

    public void setEpfdInt(Integer epfdInt) {
        this.epfdInt = epfdInt;
    }

    public Integer getShiptypeInt() {
        return shiptypeInt;
    }

    public void setShiptypeInt(Integer shiptypeInt) {
        this.shiptypeInt = shiptypeInt;
    }

    public Integer getCreatedByInt() {
        return createdByInt;
    }

    public void setCreatedByInt(Integer createdByInt) {
        this.createdByInt = createdByInt;
    }

    public Integer getModifiedByInt() {
        return modifiedByInt;
    }

    public void setModifiedByInt(Integer modifiedByInt) {
        this.modifiedByInt = modifiedByInt;
    }

    public Date getCreatedDateDti() {
        return createdDateDti;
    }

    public void setCreatedDateDti(Date createdDateDti) {
        this.createdDateDti = createdDateDti;
    }

    public Date getModifiedDateDti() {
        return modifiedDateDti;
    }

    public void setModifiedDateDti(Date modifiedDateDti) {
        this.modifiedDateDti = modifiedDateDti;
    }
}
