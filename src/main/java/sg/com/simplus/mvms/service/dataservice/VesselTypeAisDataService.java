package sg.com.simplus.mvms.service.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.VesselTypeAis;
import sg.com.simplus.mvms.data.entity.VesselTypeAisEntity;
import sg.com.simplus.mvms.data.repository.VesselTypeAisRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class VesselTypeAisDataService extends DataServiceEngine<VesselTypeAisEntity, VesselTypeAis> {
    @Autowired
    VesselTypeAisRepository vesselTypeRepository;

    public List<VesselTypeAis> findAll(){
        return toDtoList(vesselTypeRepository.findAll());
    }

    public VesselTypeAis findByCodeInt(Integer codeInt){
        List<VesselTypeAis>  vesselTypeList = toDtoList(vesselTypeRepository.findByCodeInt(codeInt));
        if(vesselTypeList!=null && vesselTypeList.size()>0) {
            return vesselTypeList.get(0);
        }
        return null;
    }

    public VesselTypeAis save(VesselTypeAis vesselType){
        return  toDto(vesselTypeRepository.save(toEntity(vesselType)) );
    }


    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<VesselTypeAisEntity> registerEntityClass() {
        return VesselTypeAisEntity.class;
    }

    @Override
    public Class<VesselTypeAis> registerDtoClass() {
        return VesselTypeAis.class;
    }
}
