package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "vessel")
public class VesselEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @Column(name = "fleet_id")
    Integer fleetIdInt;

    @Column(name = "name")
    String nameStr;

    @Column(name = "vessel_type")
    String vesselTypeStr;

    @Column(name = "imo_number")
    Integer imoNumberInt;

    @Column(name = "mmsi")
    Integer mmsiInt;

    @Column(name = "mothership_mmsi")
    Integer mothershipMmsiInt;

    @Column(name = "last_port")
    String lastPortStr;

    @Column(name = "last_port_time")
    String lastPortTimeStr;

    @Column(name = "current_port")
    String currentPortStr;

    @Column(name = "destination")
    String destinationStr;

    @Column(name = "length")
    Double lengthDbl;

    @Column(name = "width")
    Double widthDbl;

    @Column(name = "draft")
    Double draftDbl;

    @Column(name = "flag")
    String flagStr;

    @Column(name = "dead_weight")
    Double deadWeightDbl;

    @Column(name = "date_of_build")
    String dateOfBuildStr;

    @Column(name = "timestamp")
    Date timestampDti;

    @Column(name = "project_vessel_type")
    String projectVesselTypeStr;

    @Column(name = "vessel_category_id")
    Integer vesselCategoryIdInt;

    @Column(name = "grosstonnage")
    Double grosstonnageDbl;

    @Column(name = "assigned_route")
    String assignedRouteStr;

    @Column(name = "alert_recipients")
    String alertRecipientsStr;

    @Column(name = "callsign")
    String callsignStr;

    @Column(name = "repeat_indicator")
    Double repeatIndicatorDbl;

    @Column(name = "ais_version")
    Integer aisVersionInt;

    @Column(name = "to_bow")
    Double toBowDbl;

    @Column(name = "to_stern")
    Double toSternDbl;

    @Column(name = "to_port")
    Double toPortDbl;

    @Column(name = "to_starboard")
    Double toStarboardDbl;

    @Column(name = "draught")
    Double draughtDbl;

    @Column(name = "eta")
    String etaStr;

    @Column(name = "dte")
    Integer dteInt;

    @Column(name = "partno")
    Integer partnoInt;

    @Column(name = "vendorid")
    String vendoridStr;

    @Column(name = "model")
    Integer modelInt;

    @Column(name = "serial")
    Integer serialInt;

    @Column(name = "epfd")
    Integer epfdInt;

    @Column(name = "shiptype")
    Integer shiptypeInt;

    @Column(name = "created_by")
    Integer createdByInt;

    @Column(name = "modified_by")
    Integer modifiedByInt;

    @Column(name = "created_date")
    Date createdDateDti;

    @Column(name = "modified_date")
    Date modifiedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Integer getFleetIdInt() {
        return fleetIdInt;
    }

    public void setFleetIdInt(Integer fleetIdInt) {
        this.fleetIdInt = fleetIdInt;
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
