package com.bdd.stepdef;

import com.bdd.FizzBuzz;
import com.bdd.model.Greeting;
import com.bdd.util.RestAPIInvokerUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;

public class GreetingStepDef {
    FizzBuzz fizzBuzz;
    String result;
    String apiUrl = "http://localhost:8080/api/";
    ObjectMapper mapper = new ObjectMapper();
    RestAPIInvokerUtil apiInvokerUtil = new RestAPIInvokerUtil();
    Greeting greetingResponse;

    @Given("^Create a FizzBuzz game play$")
    public void createAFizzBuzzGamePlay() throws Throwable {
        fizzBuzz = new FizzBuzz();
    }

    @When("^I play with number (\\d+)$")
    public void iPlayWithNumber(int number) throws Throwable {
        result = fizzBuzz.play(number);
    }

    @Then("^The result is \"([^\"]*)\"$")
    public void the_result_is(String expectedResult) throws Throwable {
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Given("^api is available$")
    public void apiIsAvailable() {
        String response = apiInvokerUtil.callAPI(apiUrl+"healthcheck");
        Assertions.assertThat(response).isEqualTo("OK");
    }

    @When("^I call greeting endpoint$")
    public void iCallGreetingEndpoint() throws IOException {
        greetingResponse =  mapper.readValue(apiInvokerUtil.callAPI(apiUrl+"greeting"), Greeting.class);
    }

    @Then("^The api result is \"([^\"]*)\"$")
    public void theResultIs(String expectedResult) throws Throwable {
        Assertions.assertThat(greetingResponse.getContent()).isEqualTo(expectedResult);
    }
}
