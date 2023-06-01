package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.data.dto.PositionReportLast;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.PositionReportEntity;
import sg.com.simplus.mvms.data.entity.PositionReportLastEntity;
import sg.com.simplus.mvms.data.ref.*;
import sg.com.simplus.mvms.data.repository.PositionReportLastRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class PositionReportLastDataService extends DataServiceEngine<PositionReportLastEntity,PositionReportLast> {
    @Autowired
    PositionReportLastRepository positionReportLastRepository;

    public List<PositionReportLast> findAll(){
        return toDtoList(positionReportLastRepository.findAll());
    }

    public Vessel save(PositionReportLast positionReportLast){
        return  toDto(positionReportLastRepository.save(toEntity(positionReportLast)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
        PositionReportLast positionReport = (PositionReportLast) dto;
        PositionReportLastEntity positionReportEntity = (PositionReportLastEntity) entity;
        positionReport.setCsStr(CsUnitRef.descOf(positionReportEntity.getCsInt()));
        positionReport.setDisplayStr(DisplayFlagRef.descOf(positionReportEntity.getDisplayInt()));
        positionReport.setDscStr(DscFlagRef.descOf(positionReportEntity.getDscInt()));
        positionReport.setBandStr(BandFlagRef.descOf(positionReportEntity.getBandInt()));
        positionReport.setMsg22Str(Msg22FlagRef.descOf(positionReportEntity.getMsg22Int()));
        positionReport.setAssignedStr(AssignedRef.descOf(positionReportEntity.getAssignedInt()));
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<PositionReportLastEntity> registerEntityClass() {
        return PositionReportLastEntity.class;
    }

    @Override
    public Class<PositionReportLast> registerDtoClass() {
        return PositionReportLast.class;
    }
}
