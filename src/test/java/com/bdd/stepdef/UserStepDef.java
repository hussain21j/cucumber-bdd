package com.bdd.stepdef;

import com.bdd.model.Greeting;
import com.bdd.model.User;
import com.bdd.util.RestAPIInvokerUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserStepDef {
    String apiUrl = "http://localhost:8080/api/";
    ObjectMapper mapper = new ObjectMapper();
    RestAPIInvokerUtil apiInvokerUtil = new RestAPIInvokerUtil();
    Greeting greetingResponse;
    ResponseEntity<String> responseEntity;

    @When("^I add user$")
    public void i_add_user(String name, String code) throws Throwable {
        responseEntity = apiInvokerUtil.apiPostUserOperation(apiUrl+"user", new User(name, code));
    }

    @When("^I add user with name \"([^\"]*)\" and code \"([^\"]*)\"$")
    public void i_add_user_with_name_and_code(String name, String code) throws Throwable {
        responseEntity = apiInvokerUtil.apiPostUserOperation(apiUrl+"user", new User(name, code));
        System.out.println("response code: "+responseEntity.getStatusCode());
    }

    @When("^I add user with details  \"([^\"]*)\" and code \"([^\"]*)\"$")
    public void addUsers(String name, String code) throws Throwable {
        responseEntity = apiInvokerUtil.apiPostUserOperation(apiUrl+"user", new User(name, code));
    }

    @Then("^the response code should be successful$")
    public void the_result_should_be_successful() throws Throwable {
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }


    @When("^I add a new user \"([^\"]*)\" and code \"([^\"]*)\"$")
    public void testAdd(String name, String code) throws Throwable {
        responseEntity = apiInvokerUtil.apiPostUserOperation(apiUrl+"user", new User(name, code));
    }

    @Then("^the result should be (-?\\d+)$")
    public void validateResult(int expectedResult) throws Throwable {
        System.out.println("expectedResult :"+expectedResult);
    }
}
