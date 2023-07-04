package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.*;
import sg.com.simplus.mvms.data.entity.GeofenceAlertTriggerEntity;
import sg.com.simplus.mvms.data.repository.GeofenceAlertTriggerRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeofenceAlertTriggerDataService extends DataServiceEngine<GeofenceAlertTriggerEntity,GeofenceAlertTrigger> {
    @Autowired
    GeofenceAlertTriggerRepository geofenceAlertTriggerRepository;

    @Autowired
    VesselTypeAisCriteriaDataService vesselTypeAisCriteriaDataService;

    @Autowired
    VesselTypeProjectCriteriaDataService vesselTypeProjectCriteriaDataService;

    @Autowired
    VesselTypeAisDataService vesselTypeAisDataService;

    @Autowired
    VesselTypeProjectDataService vesselTypeProjectDataService;


    public List<GeofenceAlertTrigger> findAll(){
        List<GeofenceAlertTrigger> gatList =  toDtoList(geofenceAlertTriggerRepository.findAll());
        List<VesselTypeAis> vesselTypeAisList = vesselTypeAisDataService.findAll();
        List<VesselTypeProject> vesselTypeProjectList = vesselTypeProjectDataService.findAll();
        List<VesselTypeAisCriteria> vesselTypeAisCriteriaList = vesselTypeAisCriteriaDataService.findAll();
        List<VesselTypeProjectCriteria> vesselTypeProjectCriteriaList = vesselTypeProjectCriteriaDataService.findAll();
        Map<Integer,VesselTypeAis> vtaMap = new HashMap<>();
        Map<Integer,VesselTypeProject> vtpMap = new HashMap<>();
        Map<Integer,List<VesselTypeAis>> vtaListMap = new HashMap<>();
        Map<Integer,List<VesselTypeProject>> vtpListMap = new HashMap<>();
        for(VesselTypeAis vta:vesselTypeAisList){
            vtaMap.put(vta.getIdInt(),vta);
        }
        for(VesselTypeProject vtp: vesselTypeProjectList){
            vtpMap.put(vtp.getIdInt(),vtp);
        }
        for(VesselTypeAisCriteria vtac: vesselTypeAisCriteriaList){
            List<VesselTypeAis> vtaList = vtaListMap.get(vtac.getGeofenceAlertTrigger().getIdInt());
            if(vtaList==null){
                vtaList = new ArrayList<>();
            }
            VesselTypeAis vta = vtaMap.get(vtac.getVesselTypeAis().getIdInt());
            if(vta!=null) {
                vtaList.add(vta);
            }
            vtaListMap.put(vtac.getGeofenceAlertTrigger().getIdInt(),vtaList);
        }

        for(VesselTypeProjectCriteria vtpc: vesselTypeProjectCriteriaList){
            List<VesselTypeProject> vtpList = vtpListMap.get(vtpc.getGeofenceAlertTrigger().getIdInt());
            if(vtpList==null){
                vtpList = new ArrayList<>();
            }
            VesselTypeProject vtp = vtpMap.get(vtpc.getVesselTypeProject().getIdInt());
            if(vtp!=null) {
                vtpList.add(vtp);
            }
            vtpListMap.put(vtpc.getGeofenceAlertTrigger().getIdInt(),vtpList);
        }
        for(GeofenceAlertTrigger geofenceAlertTrigger: gatList){
            geofenceAlertTrigger.setVesselTypeAisList(vtaListMap.get(geofenceAlertTrigger.getIdInt()));
            geofenceAlertTrigger.setVesselTypeProjectList(vtpListMap.get(geofenceAlertTrigger.getIdInt()));
        }
        return gatList;
    }

    public List<GeofenceAlertTrigger> findByGeofenceIdInt(Integer geofenceIdInt) {
        return toDtoList(geofenceAlertTriggerRepository.findByGeofenceIdInt(geofenceIdInt));
    }

    public void deleteByGeofenceIdInt(@Param("geofenceIdInt") Integer geofenceIdInt){
        geofenceAlertTriggerRepository.deleteByGeofenceIdInt(geofenceIdInt);
    }

    public void deleteVesselTypeCriteriaByGeofenceAlertTriggerIdInt(Integer geofenceAlertTriggerIdInt){

        vesselTypeAisCriteriaDataService.deleteByGeofenceAlertTriggerIdInt(geofenceAlertTriggerIdInt);


        vesselTypeProjectCriteriaDataService.deleteByGeofenceAlertTriggerIdInt(geofenceAlertTriggerIdInt);

    }

    public void saveVesselTypeCriteriaByGeofenceAlertTrigger(GeofenceAlertTrigger geofenceAlertTrigger){

        List<VesselTypeAis> vesselTypeAisList = geofenceAlertTrigger.getVesselTypeAisList();
        List<VesselTypeProject> vesselTypeProjectList = geofenceAlertTrigger.getVesselTypeProjectList();

        for(VesselTypeAis vesselTypeAis: vesselTypeAisList){
            VesselTypeAisCriteria vesselTypeAisCriteria= new VesselTypeAisCriteria();
            vesselTypeAisCriteria.setVesselTypeAis(vesselTypeAis);
            vesselTypeAisCriteria.setGeofenceAlertTrigger(geofenceAlertTrigger);
            vesselTypeAisCriteriaDataService.save(vesselTypeAisCriteria);
        }

        for(VesselTypeProject vesselTypeProject: vesselTypeProjectList){
            VesselTypeProjectCriteria vesselTypeProjectCriteria = new VesselTypeProjectCriteria();
            vesselTypeProjectCriteria.setVesselTypeProject(vesselTypeProject);
            vesselTypeProjectCriteria.setGeofenceAlertTrigger(geofenceAlertTrigger);
            vesselTypeProjectCriteriaDataService.save(vesselTypeProjectCriteria);
        }
    }

    public GeofenceAlertTrigger update(GeofenceAlertTrigger geofenceAlertTrigger){
        GeofenceAlertTrigger   geofenceAlertTriggerSaved = toDto(geofenceAlertTriggerRepository.save(toEntity(geofenceAlertTrigger)));
        return geofenceAlertTriggerSaved;
    }

    public GeofenceAlertTrigger save(GeofenceAlertTrigger geofenceAlertTrigger){

        List<VesselTypeAis> vesselTypeAisList = geofenceAlertTrigger.getVesselTypeAisList();
        List<VesselTypeProject> vesselTypeProjectList = geofenceAlertTrigger.getVesselTypeProjectList();
        GeofenceAlertTrigger   geofenceAlertTriggerSaved = toDto(geofenceAlertTriggerRepository.save(toEntity(geofenceAlertTrigger)));
        vesselTypeAisCriteriaDataService.deleteByGeofenceAlertTriggerIdInt(geofenceAlertTrigger.getIdInt());

        for(VesselTypeAis vesselTypeAis: vesselTypeAisList){
            VesselTypeAisCriteria vesselTypeAisCriteria= new VesselTypeAisCriteria();
            vesselTypeAisCriteria.setVesselTypeAis(vesselTypeAis);
            vesselTypeAisCriteria.setGeofenceAlertTrigger(geofenceAlertTriggerSaved);
            vesselTypeAisCriteriaDataService.save(vesselTypeAisCriteria);
        }

        vesselTypeProjectCriteriaDataService.deleteByGeofenceAlertTriggerIdInt(geofenceAlertTrigger.getIdInt());
        for(VesselTypeProject vesselTypeProject: vesselTypeProjectList){
            VesselTypeProjectCriteria vesselTypeProjectCriteria = new VesselTypeProjectCriteria();
            vesselTypeProjectCriteria.setVesselTypeProject(vesselTypeProject);
            vesselTypeProjectCriteria.setGeofenceAlertTrigger(geofenceAlertTriggerSaved);
            vesselTypeProjectCriteriaDataService.save(vesselTypeProjectCriteria);
        }

        return geofenceAlertTriggerSaved;
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<GeofenceAlertTriggerEntity> registerEntityClass() {
        return GeofenceAlertTriggerEntity.class;
    }

    @Override
    public Class<GeofenceAlertTrigger> registerDtoClass() {
        return GeofenceAlertTrigger.class;
    }
}
