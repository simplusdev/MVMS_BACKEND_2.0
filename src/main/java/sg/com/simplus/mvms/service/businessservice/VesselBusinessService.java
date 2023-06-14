package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Fleet;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.VesselDataService;
import sg.com.simplus.mvms.service.mapperservice.VesselMapper;

import java.util.List;
import java.util.Map;

@Service
public class VesselBusinessService {

    @Autowired
    VesselDataService vesselDataService;

    public List<Map<String,Object>> findAll(){
        List<Vessel> vesselList = vesselDataService.findAll();
        return VesselMapper.getListMap(vesselList);
    }

    public  Vessel findByMmsiInt(Integer mmsiInt) {
        return vesselDataService.findByMmsiInt(mmsiInt);
    }

    public Vessel getById(Integer id){
        return vesselDataService.getById(id);
    }

    public Map<String,Object> addVesselToFleet(Integer vesselId, Integer fleetId){
        Vessel vessel = getById(vesselId);
        Fleet fleet = new Fleet();
        fleet.setIdInt(fleetId);
        vessel.setFleet(fleet);
        Vessel vesselSaved = vesselDataService.save(vessel);
        return VesselMapper.getMap(vesselSaved);
    }

    public Map<String,Object> removeVesselFromFleet(Integer vesselId ){
        Vessel vessel = getById(vesselId);
        vessel.setFleet(null);
        Vessel vesselSaved = vesselDataService.save(vessel);
        return VesselMapper.getMap(vesselSaved);
    }

    public Vessel save(Vessel vessel){
      return   vesselDataService.save(vessel);
    }
}
