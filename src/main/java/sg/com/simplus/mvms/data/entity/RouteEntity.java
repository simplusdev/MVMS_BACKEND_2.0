package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "route")
public class RouteEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Integer idInt;

    @Column(name = "name")
    String nameStr;

    @Column(name = "coordinates")
    String coordinatesStr;

    @Column(name = "deleted")
    Integer deletedInt;

    @Column(name = "created_by")
    Integer createdByInt;

    @Column(name = "deleted_by")
    Integer deletedByInt;

    @Column(name = "created_date")
    Date createdDateDti;

    @Column(name = "deleted_date")
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
