package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "unalert")
public class UnAlertEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @ManyToOne( )
    @JoinColumn(foreignKey = @ForeignKey(name = "vessel_id"), name = "vessel_id")
    private VesselEntity vessel;

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

    public Date getTimestampDti() {
        return timestampDti;
    }

    public void setTimestampDti(Date timestampDti) {
        this.timestampDti = timestampDti;
    }
}
