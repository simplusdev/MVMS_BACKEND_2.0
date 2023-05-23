package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.PositionReport;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.PositionReportEntity;
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

    public Vessel save(PositionReport positionReport){
        return  toDto(positionReportRepository.save(toEntity(positionReport)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
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
