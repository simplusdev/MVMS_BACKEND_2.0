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
    private Integer idInt;

    @ManyToOne(  )
    @JoinColumn(foreignKey = @ForeignKey(name = "fleet_id"), name = "fleet_id")
    private FleetEntity fleet;

    @ManyToOne(  )
    @JoinColumn(foreignKey = @ForeignKey(name = "vessel_type_ais_id"), name = "vessel_type_ais_id")
    private VesselTypeAisEntity vesselTypeAis;

    @ManyToOne(  )
    @JoinColumn(foreignKey = @ForeignKey(name = "vessel_type_project_id"), name = "vessel_type_project_id")
    private VesselTypeProjectEntity vesselTypeProject;

    @Column(name = "name")
    private String nameStr;

    @Column(name = "vessel_type")
    private String vesselTypeStr;

    @Column(name = "imo_number")
    private Integer imoNumberInt;

    @Column(name = "mmsi")
    private Integer mmsiInt;

    @Column(name = "mothership_mmsi")
    private Integer mothershipMmsiInt;

    @Column(name = "last_port")
    private String lastPortStr;

    @Column(name = "last_port_time")
    private String lastPortTimeStr;

    @Column(name = "current_port")
    private String currentPortStr;

    @Column(name = "destination")
    private String destinationStr;

    @Column(name = "length")
    private Double lengthDbl;

    @Column(name = "width")
    private Double widthDbl;

    @Column(name = "draft")
    private Double draftDbl;

    @Column(name = "dwt")
    private Double dwtDbl;

    @Column(name = "gt")
    private Double gtDbl;

    @Column(name = "flag")
    private String flagStr;

    @Column(name = "dead_weight")
    private Double deadWeightDbl;

    @Column(name = "date_of_build")
    private String dateOfBuildStr;

    @Column(name = "timestamp")
    private Date timestampDti;

    @Column(name = "project_vessel_type")
    private String projectVesselTypeStr;

    @Column(name = "vessel_category_id")
    private Integer vesselCategoryIdInt;

    @Column(name = "grosstonnage")
    private Double grosstonnageDbl;

    @Column(name = "assigned_route")
    private String assignedRouteStr;

    @Column(name = "email")
    private String emailStr;

    @Column(name = "callsign")
    private String callsignStr;

    @Column(name = "repeat_indicator")
    private Double repeatIndicatorDbl;

    @Column(name = "ais_version")
    private Integer aisVersionInt;

    @Column(name = "to_bow")
    private Double toBowDbl;

    @Column(name = "to_stern")
    private Double toSternDbl;

    @Column(name = "to_port")
    private Double toPortDbl;

    @Column(name = "to_starboard")
    private Double toStarboardDbl;

    @Column(name = "eta")
    private String etaStr;

    @Column(name = "dte")
    private Integer dteInt;

    @Column(name = "partno")
    private Integer partnoInt;

    @Column(name = "vendorid")
    private String vendoridStr;

    @Column(name = "model")
    private Integer modelInt;

    @Column(name = "serial")
    private Integer serialInt;

    @Column(name = "epfd")
    private Integer epfdInt;

    @Column(name = "shiptype")
    private Integer shiptypeInt;

    @Column(name = "created_by")
    private Integer createdByInt;

    @Column(name = "modified_by")
    private Integer modifiedByInt;

    @Column(name = "created_date")
    private Date createdDateDti;

    @Column(name = "modified_date")
    private Date modifiedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public FleetEntity getFleet() {
        return fleet;
    }

    public void setFleet(FleetEntity fleet) {
        this.fleet = fleet;
    }

    public VesselTypeAisEntity getVesselTypeAis() {
        return vesselTypeAis;
    }

    public void setVesselTypeAis(VesselTypeAisEntity vesselTypeAis) {
        this.vesselTypeAis = vesselTypeAis;
    }

    public VesselTypeProjectEntity getVesselTypeProject() {
        return vesselTypeProject;
    }

    public void setVesselTypeProject(VesselTypeProjectEntity vesselTypeProject) {
        this.vesselTypeProject = vesselTypeProject;
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

    public Double getDwtDbl() {
        return dwtDbl;
    }

    public void setDwtDbl(Double dwtDbl) {
        this.dwtDbl = dwtDbl;
    }

    public Double getGtDbl() {
        return gtDbl;
    }

    public void setGtDbl(Double gtDbl) {
        this.gtDbl = gtDbl;
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

    public String getEmailStr() {
        return emailStr;
    }

    public void setEmailStr(String emailStr) {
        this.emailStr = emailStr;
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
