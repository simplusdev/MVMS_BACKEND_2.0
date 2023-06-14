package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.PositionReportEntity;
import sg.com.simplus.mvms.data.ref.*;
import sg.com.simplus.mvms.data.repository.PositionReportRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.Date;
import java.util.List;

@Service
public class PositionReportDataService extends DataServiceEngine<PositionReportEntity,PositionReport> {
    @Autowired
    PositionReportRepository positionReportRepository;

    public List<PositionReport> findAll(){
        return toDtoList(positionReportRepository.findAll());
    }

    public List<PositionReport> findByVesselIdIntAndTimestampDtiBetween(Integer vesselIdInt,Date startDateDti,Date endDateDti ){
        return toDtoList(positionReportRepository.findByVesselIdIntAndTimestampDtiBetween(vesselIdInt,startDateDti,endDateDti));
    }

    public void deleteByVesselMmsiIntAndTimestampDtiBetween(Integer mmsiInt,Date startDateDti,Date endDateDti ){
        positionReportRepository.deleteByVesselMmsiIntAndTimestampDtiBetween(mmsiInt,startDateDti,endDateDti);
    }

    public PositionReport save(PositionReport positionReport){
        return  toDto(positionReportRepository.save(toEntity(positionReport)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
        PositionReport positionReport = (PositionReport) dto;
        PositionReportEntity positionReportEntity = (PositionReportEntity) entity;
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
    public Class<PositionReportEntity> registerEntityClass() {
        return PositionReportEntity.class;
    }

    @Override
    public Class<PositionReport> registerDtoClass() {
        return PositionReport.class;
    }
}
