package sg.com.simplus.mvms.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class PositionReportLast extends Position {


    private Integer vesselIdInt;


    public Integer getVesselIdInt() {
        return vesselIdInt;
    }

    public void setVesselIdInt(Integer vesselIdInt) {
        this.vesselIdInt = vesselIdInt;
    }


}
