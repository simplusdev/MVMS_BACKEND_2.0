package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.PositionReportLast;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.VesselEntity;
import sg.com.simplus.mvms.data.ref.AisVersionRef;
import sg.com.simplus.mvms.data.ref.DteRef;
import sg.com.simplus.mvms.data.ref.EpfdRef;
import sg.com.simplus.mvms.data.ref.ShipTypeRef;
import sg.com.simplus.mvms.data.repository.VesselRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VesselDataService extends DataServiceEngine<VesselEntity,Vessel> {
    @Autowired
    VesselRepository vesselRepository;

    @Autowired
    PositionReportLastDataService positionReportLastDataService;

    public List<Vessel> findAll(){
        List<Vessel> vesselList =toDtoList(vesselRepository.findAll() );
        List<PositionReportLast>  positionReportLastList =  positionReportLastDataService.findAll();
        Map<Integer,PositionReportLast> prlMap = new HashMap<>();
        for(PositionReportLast prl : positionReportLastList){
            prlMap.put(prl.getVesselIdInt(),prl);
        }
        for(Vessel vessel: vesselList){
            //PositionReportLast positionReportLast = positionReportLastDataService.findOneByVesselIdInt(vessel.getIdInt());
            PositionReportLast positionReportLast = prlMap.get(vessel.getIdInt());
            vessel.setPositionReportLast(positionReportLast);
        }
        return vesselList;
    }

    public  Vessel findByMmsiInt(Integer mmsiInt) {
        List<Vessel> vesselList = toDtoList(vesselRepository.findByMmsiInt(mmsiInt));
        Vessel vessel = null;
        if(vesselList!=null && vesselList.size()>0){
            vessel = vesselList.get(0);
            PositionReportLast positionReportLast = positionReportLastDataService.findOneByVesselIdInt(vessel.getIdInt());
            vessel.setPositionReportLast(positionReportLast);
        }
        return vessel;
    }

    public  List<Vessel> findByFleetIdInt(@Param("fleetIdInt") Integer fleetIdInt){
        List<Vessel> vesselList = toDtoList(vesselRepository.findByFleetIdInt(fleetIdInt));
        return vesselList;
    }

    public Vessel save(Vessel vessel){
       return  toDto(vesselRepository.save(toEntity(vessel)) );
    }

    public Vessel merge(Vessel vessel){
        return  toDto(vesselRepository.save(toEntity(vessel)) );
    }

    public Vessel getById(Integer id){
        return  toDto(vesselRepository.getById(id) );
    }

    @Override
    public Class registerEntityClass(){
        return VesselEntity.class;
    }

    @Override
    public Class registerDtoClass(){
        return Vessel.class;
    }

    @Override
    public  void customDto(Object entity, Object dto) {
        Vessel vessel = (Vessel) dto;
        VesselEntity vesselEntity = (VesselEntity) entity;
        vessel.setEpfdStr(EpfdRef.descOf(vesselEntity.getEpfdInt()));
        vessel.setShiptypeStr(ShipTypeRef.descOf(vesselEntity.getShiptypeInt()));
        vessel.setDteStr(DteRef.descOf(vesselEntity.getDteInt()));
        vessel.setAisVersionStr(AisVersionRef.descOf(vesselEntity.getAisVersionInt()));
    }

    @Override
    public void customEntity(Object dto, Object entity) {
        VesselEntity vesselEntity = (VesselEntity) entity;
        Vessel vessel = (Vessel) dto;
//        vesselEntity.setEpfdInt(vessel.getEpfdInt());
//        vesselEntity.setShiptypeInt(vessel.getShiptypInt());
//        vesselEntity.setDteInt(vessel.getDteInt());
//        vesselEntity.setAisVersionInt(vessel.getAisVersionInt());
    }

}
