package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import sg.com.simplus.mvms.data.entity.VesselEntity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Fleet  implements Serializable {
    private Integer idInt;


    private String nameStr;

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


    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
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
