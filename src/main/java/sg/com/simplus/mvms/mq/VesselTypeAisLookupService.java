package sg.com.simplus.mvms.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sg.com.simplus.mvms.data.dto.VesselTypeAis;
import sg.com.simplus.mvms.service.dataservice.VesselTypeAisDataService;

import java.util.LinkedHashMap;
import java.util.List;

@Component
public class VesselTypeAisLookupService {

    @Autowired
    VesselTypeAisDataService vesselTypeDataService;

    private static LinkedHashMap<Integer, VesselTypeAis> vesselTypeByCodeList = new LinkedHashMap<Integer, VesselTypeAis>();

    public void fetch(){
        List<VesselTypeAis> vtList = vesselTypeDataService.findAll();
        for(VesselTypeAis vt : vtList){
            if(vt.getCodeInt()!=null) {
                if (!vesselTypeByCodeList.containsKey(vt.getCodeInt())) {
                    vesselTypeByCodeList.put(vt.getCodeInt(),vt);
                }
            }
        }
    }

    public VesselTypeAis getVesselTypeByCode(Integer codeInt){
        if(codeInt != null){
            return vesselTypeByCodeList.get(codeInt);
        }
        return null;
    }
}
