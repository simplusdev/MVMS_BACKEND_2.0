package sg.com.simplus.mvms.service.dataservice;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Route;
import sg.com.simplus.mvms.data.dto.Vessel;
import sg.com.simplus.mvms.data.entity.RouteEntity;
import sg.com.simplus.mvms.data.repository.RouteRepository;
import sg.com.simplus.mvms.framework.engine.DataServiceEngine;

import java.util.List;

@Service
public class RouteDataService extends DataServiceEngine<RouteEntity,Route> {
    @Autowired
    RouteRepository routeRepository;

    public List<Route> findAll(){
        return toDtoList(routeRepository.findAll());
    }

    public Vessel save(Route route){
        return  toDto(routeRepository.save(toEntity(route)) );
    }

    @Override
    public  void customDto(Object entity, Object dto) {
    }

    @Override
    public void customEntity(Object dto, Object entity) {
    }

    @Override
    public Class<RouteEntity> registerEntityClass() {
        return RouteEntity.class;
    }

    @Override
    public Class<Route> registerDtoClass() {
        return Route.class;
    }
}
