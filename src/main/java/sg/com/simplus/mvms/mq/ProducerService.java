package sg.com.simplus.mvms.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import sg.com.simplus.mvms.Constants;

@Component
public class ProducerService {




    @Autowired
    JmsTemplate jmsTemplate;

    public void sendToVesselTopic( Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String sObj = "";
        try {
            sObj = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        StringBuffer sbJson = new StringBuffer();
//        sbJson.append("{");
//        sbJson.append("\"type\":\""+objectType+"\",");
//        sbJson.append("\"data\":"+sObj+"");
//        sbJson.append("}");
        //System.out.println(" sbJson : "+sbJson.toString());

        jmsTemplate.convertAndSend(Constants.JMS_TOPIC_NAME_VESSEL, sObj);
    }

    public void sendToGeofenceAlertTriggerTopic( String message) throws JsonProcessingException {


        jmsTemplate.convertAndSend(Constants.JMS_TOPIC_NAME_GEOFENCE_ALERT_TRIGGER,message);
    }

    public void sendToGeofenceTopic( Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String sObj = "";
        try {
            sObj = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        jmsTemplate.convertAndSend(Constants.JMS_TOPIC_NAME_GEOFENCE, sObj);
    }

}
