package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.VesselType;
import sg.com.simplus.mvms.data.entity.VesselTypeEntity;
import sg.com.simplus.mvms.data.repository.VesselTypeRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class VesselTypeDataService extends DataServiceEngine<VesselTypeEntity,VesselType> {
    @Autowired
    VesselTypeRepository vesselTypeRepository;

    public List<VesselType> findAll(){
        return toDtoList(vesselTypeRepository.findAll());
    }

    public  VesselType findByCodeInt(Integer codeInt){
        List<VesselType>  vesselTypeList = toDtoList(vesselTypeRepository.findByCodeInt(codeInt));
        if(vesselTypeList!=null && vesselTypeList.size()>0) {
            return vesselTypeList.get(0);
        }
        return null;
    }

    public VesselType save(VesselType vesselType){
        return  toDto(vesselTypeRepository.save(toEntity(vesselType)) );
    }


    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<VesselTypeEntity> registerEntityClass() {
        return VesselTypeEntity.class;
    }

    @Override
    public Class<VesselType> registerDtoClass() {
        return VesselType.class;
    }
}
