package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import resources.Utils;

public class ActivityAPIStepDefinition extends Utils {
	
	public String global_User_Token = "q5HWAfJuc8Axkt6ZTgW1tFrUdcgkam1QhOyMWBXpMT/wkyGvxgooSPXoAzj/CzNN050Vvpbyn4jBIl94J5xQTA==";
	
	@Given("the {string} and {string} for request")
	public void the_and_for_request(String type, String filter) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification())
				.header("authorization", getGlobalProperties("authorization"))
				.header("User-Token", global_User_Token)
				.queryParam("type", type).queryParam("filter", filter);
	}

	@Then("verify {string} in response maps to {string}")
	public void verify_in_response_maps_to(String key, String expected) {
	    // Write code here that turns the phrase above into concrete actions
		String actual = getJsonPath(response, key);	
		Assert.assertEquals(actual, expected);

	}


}
