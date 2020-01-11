package com.bdd.util;

import com.bdd.model.Greeting;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class RestAPIInvokerUtil {
    public String callAPI(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public static void main(String[] args) throws IOException {
        RestAPIInvokerUtil invokerUtil = new RestAPIInvokerUtil();
        String response =  invokerUtil.callAPI("http://localhost:8080/api/greeting");
        System.out.println("response :"+response);
        Greeting greeting = new ObjectMapper().readValue(response, Greeting.class);

        System.out.println(""+greeting.getId());
    }
}
