package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Fleet;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.FleetDataService;
import sg.com.simplus.mvms.service.dataservice.VesselDataService;
import sg.com.simplus.mvms.service.mapperservice.FleetMapper;
import sg.com.simplus.mvms.service.mapperservice.VesselMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FleetBusinessService {

    @Autowired
    FleetDataService fleetDataService;

    @Autowired
    VesselDataService vesselDataService;

    public  List<Map<String,Object>> findAll(){
        List<Fleet> fleetList = fleetDataService.findAll();
        List<Vessel> vessels = vesselDataService.findAll();
        Map<Integer,List<Map<String,Object>>> mapVesselList = new HashMap<>();
        for(Vessel vessel: vessels){
            Integer fleetId = vessel.getFleet().getIdInt();
            List<Map<String,Object>> vesselList = (List<Map<String,Object>>) mapVesselList.get(fleetId);
            if(vesselList==null){
                vesselList = new ArrayList<>();
            }
            vesselList.add(VesselMapper.getMapWithIdAndNameAndMmsi(vessel));
            mapVesselList.put(fleetId,vesselList);
        }
        List<Map<String,Object>> fleetListMap = FleetMapper.getListMap(fleetList);
        for(Map<String,Object> fleetMap : fleetListMap){
            Integer fleetId = (Integer) fleetMap.get("idInt");
            List<Map<String,Object>> vesselList = mapVesselList.get(fleetId);
            fleetMap.put("vessels",vesselList);
        }
        return fleetListMap;
    }
}
