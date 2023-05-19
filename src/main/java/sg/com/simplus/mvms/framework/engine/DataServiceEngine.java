package sg.com.simplus.mvms.framework.engine;

import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.VesselEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DataServiceEngine<E, D> {

    private ModelMapper modelMapper = new ModelMapper();


    public <T, D> D toDto(T item) {
        Class<E> entityClass = (Class<E>) registerEntityClass();
        Class<D> dtoClass = (Class<D>) registerDtoClass();
//        TypeMap typeMap = modelMapper.getTypeMap(entityClass, dtoClass);
//        if (typeMap == null) { // if not  already added
//            modelMapper.addMappings(addCustomToDtoMap());
//        }
        D d = modelMapper.map(item, dtoClass);
        customDto(item,d);
        return d;
    }

    public <T, E> E toEntity(T item) {
        Class<E> entityClass = (Class<E>) registerEntityClass();
        Class<D> dtoClass = (Class<D>) registerDtoClass();
//        TypeMap typeMap = modelMapper.getTypeMap(dtoClass, entityClass);
//        if (typeMap == null) { // if not  already added
//            modelMapper.addMappings(addCustomToEntityMap());
//        }
        E e =  modelMapper.map(item, entityClass);
        customEntity(item,e);
        return e;
    }



    public abstract Class<E> registerEntityClass();

    public abstract Class<D> registerDtoClass();

    public <T, D> List<D> toDtoList(List<T> list) {
        Class<E> entityClass = (Class<E>) registerEntityClass();
        Class<D> dtoClass = (Class<D>) registerDtoClass();
//        TypeMap typeMap = modelMapper.getTypeMap(entityClass, dtoClass);
//        if (typeMap == null) { // if not  already added
//            modelMapper.addMappings(addCustomToDtoMap());
//
//        }
//
//        List<D>  listRes =  list.stream()
//                .map(item -> modelMapper.map(item, dtoClass))
//                .collect(Collectors.toList());

        List<D> listRes =new ArrayList<>();

        for(T t: list){
          D d = modelMapper.map(t, dtoClass);
          customDto(t,d);
          listRes.add(d);
        }


        return  listRes;
    }

    public abstract void customDto(Object entity, Object dto) ;

    public abstract  void customEntity(Object dto, Object entity) ;
}
