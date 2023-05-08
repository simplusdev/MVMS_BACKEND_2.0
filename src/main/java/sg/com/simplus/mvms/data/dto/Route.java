package sg.com.simplus.mvms.data.dto;

import java.util.Date;

public class Route {

    Integer idInt;

    String nameStr;

    String coordinatesStr;

    Integer deletedInt;

    Integer createdByInt;

    Integer deletedByInt;

    Date createdDateDti;

    Date deletedDateDti;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getCoordinatesStr() {
        return coordinatesStr;
    }

    public void setCoordinatesStr(String coordinatesStr) {
        this.coordinatesStr = coordinatesStr;
    }

    public Integer getDeletedInt() {
        return deletedInt;
    }

    public void setDeletedInt(Integer deletedInt) {
        this.deletedInt = deletedInt;
    }

    public Integer getCreatedByInt() {
        return createdByInt;
    }

    public void setCreatedByInt(Integer createdByInt) {
        this.createdByInt = createdByInt;
    }

    public Integer getDeletedByInt() {
        return deletedByInt;
    }

    public void setDeletedByInt(Integer deletedByInt) {
        this.deletedByInt = deletedByInt;
    }

    public Date getCreatedDateDti() {
        return createdDateDti;
    }

    public void setCreatedDateDti(Date createdDateDti) {
        this.createdDateDti = createdDateDti;
    }

    public Date getDeletedDateDti() {
        return deletedDateDti;
    }

    public void setDeletedDateDti(Date deletedDateDti) {
        this.deletedDateDti = deletedDateDti;
    }
}
