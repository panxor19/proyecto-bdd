package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HelloWorldSteps {

    private String helloWorld;

    @Given("I have a hello world feature")
    public void i_have_a_hello_world_feature() {
        helloWorld = "Hello World";
    }

    @When("I run the feature")
    public void i_run_the_feature() {
        System.out.println(helloWorld);
    }

    @Then("I should see {string}")
    public void i_should_see(String string) {
        assert(helloWorld.equals(string));
    }
}
