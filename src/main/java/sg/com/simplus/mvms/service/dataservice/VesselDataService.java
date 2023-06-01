package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.VesselEntity;
import sg.com.simplus.mvms.data.ref.AisVersionRef;
import sg.com.simplus.mvms.data.ref.DteRef;
import sg.com.simplus.mvms.data.ref.EpfdRef;
import sg.com.simplus.mvms.data.ref.ShipTypeRef;
import sg.com.simplus.mvms.data.repository.VesselRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class VesselDataService extends DataServiceEngine<VesselEntity,Vessel> {
    @Autowired
    VesselRepository vesselRepository;

    public List<Vessel> findAll(){
        return toDtoList(vesselRepository.findAll() );
    }

    public Vessel save(Vessel vessel){
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
