package sg.com.simplus.mvms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.framework.constant.StatusType;
import sg.com.simplus.mvms.framework.util.StringUtil;
import sg.com.simplus.mvms.manager.VesselManager;
import sg.com.simplus.mvms.framework.response.ResponseMvms;
import sg.com.simplus.mvms.service.mapperservice.VesselMapper;

import javax.transaction.Transactional;


@RestController
public class VesselController extends VesselManager {

	@GetMapping(Constants.ENDPOINT_URI_VESSEL_GET_ALL)
	public ResponseEntity<Object> getVesselAll( ) {
      // System.out.println("test property value: "+ String.format(StringUtil.getPropertyValue("prop2"),"toto",21));
		System.out.println(StringUtil.getPropertyValue("vessel.mmsi.unique"));

		List<Map<String,Object>> listMap =  vesselBusinessService.findAll();
 		return ResponseMvms.buildResponse(listMap, StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
				StatusType.RESULT_SUCCESS.getMessage());
	}

	@Transactional
	@PostMapping(value = Constants.ENDPOINT_URI_VESSEL_CREATE  )
	public  ResponseEntity<Object> createVessel(
			@RequestBody Vessel vessel) {
		return ResponseMvms.buildResponse(saveReturnMap(vessel), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
				StatusType.RESULT_SUCCESS.getMessage());
	}

	@Transactional
	@PostMapping(value = Constants.ENDPOINT_URI_VESSEL_ADD_TO_FLEET  )
	public  ResponseEntity<Object> addVesselToFleet(
			@RequestBody Vessel vessel) {
		return ResponseMvms.buildResponse(vesselBusinessService.addVesselToFleet(vessel.getIdInt(),vessel.getFleet().getIdInt()), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
				StatusType.RESULT_SUCCESS.getMessage());
	}

	@Transactional
	@PostMapping(value = Constants.ENDPOINT_URI_VESSEL_REMOVE_FROM_FLEET  )
	public  ResponseEntity<Object> removeVesselFromFleet(
			@RequestBody Vessel vessel) {
		return ResponseMvms.buildResponse(vesselBusinessService.removeVesselFromFleet(vessel.getIdInt()), StatusType.RESULT_SUCCESS.getCode(), HttpStatus.OK,
				StatusType.RESULT_SUCCESS.getMessage());
	}

}
