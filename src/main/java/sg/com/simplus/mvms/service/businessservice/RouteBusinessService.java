package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.simplus.mvms.data.dto.Route;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.service.dataservice.RouteDataService;
import sg.com.simplus.mvms.service.mapperservice.RouteMapper;

import java.util.List;
import java.util.Map;

@Service
public class RouteBusinessService {

    @Autowired
    RouteDataService routeDataService;
    public  List<Map<String,Object>> findAll(){
        List<Route> routeList = routeDataService.findAll();
        return RouteMapper.getListMap(routeList);
    }
}
