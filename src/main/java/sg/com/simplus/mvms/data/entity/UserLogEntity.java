package sg.com.simplus.mvms.data.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "user_log")
public class UserLogEntity  implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer idInt;

    @Column(name = "user_id")
    private Integer userIdInt;

    @Column(name = "log")
    private String logStr;

    @Column(name = "name")
    private Date timestamp;

    public Integer getIdInt() {
        return idInt;
    }

    public void setIdInt(Integer idInt) {
        this.idInt = idInt;
    }

    public Integer getUserIdInt() {
        return userIdInt;
    }

    public void setUserIdInt(Integer userIdInt) {
        this.userIdInt = userIdInt;
    }

    public String getLogStr() {
        return logStr;
    }

    public void setLogStr(String logStr) {
        this.logStr = logStr;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
