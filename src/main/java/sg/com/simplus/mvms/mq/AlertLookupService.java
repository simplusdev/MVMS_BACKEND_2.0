package sg.com.simplus.mvms.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sg.com.simplus.mvms.data.dto.Alert;
import sg.com.simplus.mvms.service.dataservice.AlertDataService;

import java.util.LinkedHashMap;
import java.util.List;

@Component
public class AlertLookupService {

    @Autowired
    AlertDataService alertDataService;


    private static LinkedHashMap<Integer,Alert> alertList = new LinkedHashMap<Integer,Alert>();

    public void fetch(){
        List<Alert>  itemList =  alertDataService.findAll();
        System.out.println("AlertLookupService fetch itemList size: "+itemList.size());
        for(Alert alert: itemList){
            if(!alertList.containsKey(alert.getIdInt())) {
                    alertList.put(alert.getVessel().getIdInt(), alert);
            }
        }
    }

    public LinkedHashMap<Integer,Alert> getAlertMap() {
        return  alertList;
    }
}
