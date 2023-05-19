package sg.com.simplus.mvms.service.multicastservice;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import sg.com.simplus.mvms.framework.util.ViewData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class MockService extends MulticastService {

    @Override
    public void registerMulticast() {
        registerMulticast("mock",new MockService());
    }

    public  void testHello(){
        System.out.println("Hello from MockService!");
    }

    public void executeGetUserInfo(ViewData viewData) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Void> requestEntity =null;

        URL urlUser = null;
        try {
            urlUser = new URL("http://18.140.32.61:81/getUserByCompany");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        List<Map<String, Object>> userRes = null;
        userRes = restTemplate.exchange(urlUser.toString(),
                HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Map<String, Object>>>() {
                }).getBody();

        viewData.setAttributeValue("userInfo", userRes);
    }
}
