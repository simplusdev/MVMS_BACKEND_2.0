package sg.com.simplus.mvms.manager;

import org.springframework.beans.factory.annotation.Autowired;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.repository.VesselRepository;
import sg.com.simplus.mvms.framework.engine.MulticastEngine;
import sg.com.simplus.mvms.service.businessservice.FleetBusinessService;
import sg.com.simplus.mvms.service.businessservice.VesselBusinessService;
import sg.com.simplus.mvms.service.dataservice.FleetDataService;
import sg.com.simplus.mvms.service.mapperservice.VesselMapper;
import sg.com.simplus.mvms.service.multicastservice.MulticastService;

import java.util.Map;

public class VesselManager extends BusinessManager {

	public void executedUserInfo(){
		MulticastService multicastService = MulticastEngine.getMulticastService("ws");
		multicastService.executeGetUserInfo(viewData);
	}

	public Map<String,Object> saveReturnMap(Vessel vessel) {
		Vessel vesselResult = vesselBusinessService.save(vessel);
		Map<String,Object> vesselMap = VesselMapper.getMap(vesselResult);
		return vesselMap;
	}

	public Map<String,Object> updateReturnMap(Vessel vessel) {
		Vessel vesselDb = vesselBusinessService.getById(vessel.getIdInt());
		vesselDb.setNameStr(vessel.getNameStr());
		vesselDb.setMmsiInt(vessel.getMmsiInt());
		vesselDb.setFleet(vessel.getFleet());
		Vessel vesselResult = vesselBusinessService.save(vesselDb);
		Map<String,Object> vesselMap = VesselMapper.getMap(vesselResult);
		return vesselMap;
	}

}
