package sg.com.simplus.mvms.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sg.com.simplus.mvms.data.dto.VesselType;
import sg.com.simplus.mvms.service.dataservice.VesselTypeDataService;

import java.util.LinkedHashMap;
import java.util.List;

@Component
public class VesselTypeLookupService {

    @Autowired
    VesselTypeDataService vesselTypeDataService;

    private static LinkedHashMap<Integer, VesselType> vesselTypeByCodeList = new LinkedHashMap<Integer,VesselType>();

    public void fetch(){
        List<VesselType> vtList = vesselTypeDataService.findAll();
        for(VesselType vt : vtList){
            if(vt.getCodeInt()!=null) {
                if (!vesselTypeByCodeList.containsKey(vt.getCodeInt())) {
                    vesselTypeByCodeList.put(vt.getCodeInt(),vt);
                }
            }
        }
    }

    public  VesselType getVesselTypeByCode(Integer codeInt){
        if(codeInt != null){
            return vesselTypeByCodeList.get(codeInt);
        }
        return null;
    }
}
