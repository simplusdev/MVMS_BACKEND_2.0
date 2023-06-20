package sg.com.simplus.mvms.framework.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class EmailUtil {
    public static void sendEmail(String subject, String to, String message ){
        RestTemplate restTemplate = new RestTemplate();
        URL url = null;

        HttpEntity<String> requestEntity = new HttpEntity<String>(null, null);
        try {
            StringBuffer sbParam = new StringBuffer();
            String encoding = "UTF-8";


            String data = null;

                data = "apikey=" + StringUtil.getPropertyValue("email.api.apiKey");
                data += "&from=" +  StringUtil.getPropertyValue("email.api.from");
                data += "&fromName=" + StringUtil.getPropertyValue("email.api.fromName");;
                data += "&subject=" + subject ;
                data += "&to=" +  to ;
                data += "&bodyText=" + message ;


            System.out.println("email URL: https://api.elasticemail.com/v2/email/send?"+data);


            url = new URL("https://api.elasticemail.com/v2/email/send?"+data);

        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException {} "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ResponseEntity<JsonNode> response = null;
        try {
            response = restTemplate.exchange(url.toString(), HttpMethod.POST, requestEntity, com.fasterxml.jackson.databind.JsonNode.class);
            System.out.println("Email response body: " + response.getBody().toString());
        } catch (Exception ex){
            System.out.println("Email exception message: " +ex.getMessage());
        }
    }
}
