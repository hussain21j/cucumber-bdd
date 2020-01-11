package com.bdd.util;

import com.bdd.model.Greeting;
import com.bdd.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.core.SpringVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class RestAPIInvokerUtil {
    public String apiGetOperation(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public ResponseEntity<String> apiPostUserOperation(String url, User user) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, user, String.class);
        return responseEntity;
    }

    @Test
    public void testGet() throws IOException {
        System.out.println("spring version :"+SpringVersion.getVersion());
        RestAPIInvokerUtil invokerUtil = new RestAPIInvokerUtil();
        String response =  invokerUtil.apiGetOperation("http://localhost:8080/api/greeting");
        System.out.println("response :"+response);
        Greeting greeting = new ObjectMapper().readValue(response, Greeting.class);

        System.out.println(""+greeting.getId());
    }

    @Test
    public void testPost() throws IOException {
        RestAPIInvokerUtil invokerUtil = new RestAPIInvokerUtil();

        User user = new User("name", "sfjsdjfjsd");
        ResponseEntity<String> responseEntity = invokerUtil.apiPostUserOperation("http://localhost:8080/api/user", user);
        String body = responseEntity.getBody();
        List<User> users = (List<User>) new ObjectMapper().readValue(body, Object.class);
        System.out.println(users);
    }
}
