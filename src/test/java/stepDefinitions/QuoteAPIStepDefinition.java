package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.RequestPayloads;
import resources.Utils;

public class QuoteAPIStepDefinition extends Utils {
	
	//RequestSpecification request;
	RequestPayloads payload = new RequestPayloads();
	public String global_User_Token = "q5HWAfJuc8Axkt6ZTgW1tFrUdcgkam1QhOyMWBXpMT/wkyGvxgooSPXoAzj/CzNN050Vvpbyn4jBIl94J5xQTA==";
	static String quoteID;

	
//	@Given("Create Session payload with {string} and {string}")
//	public void create_Session_payload_with_and(String login, String password) throws IOException {
//	    // Write code here that turns the phrase above into concrete actions
//		request = given().spec(requestSpecification())
//				.header("authorization",getGlobalProperties("authorization"))
//				.body(payload.createSessionPayload(getGlobalProperties("session_login"), getGlobalProperties("session_password")));
//	    
//	}

	@Given("Add Quote Payload with {string} {string}")
	public void add_Quote_Payload_with(String author, String body) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//global_User_Token = getJsonPath(UserAPIStepDefinition.response, "User-Token");
		request = given().spec(requestSpecification())
				.header("authorization", getGlobalProperties("authorization"))
				.header("User-Token", global_User_Token)
				.body(payload.addQuotePayload(author, body));    
	}
	
	@Then("verify {string} in response maps to {string} using {string}")
	public void verify_in_response_maps_to_using(String key, String expectedValue, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		quoteID = getJsonPath(response, "id");
		request = given().spec(requestSpecification()).pathParam("quote_id", quoteID)
				.header("authorization",getGlobalProperties("authorization"))
				.header("User-Token", global_User_Token);
		response = getHTTPMethod(request, resource, "GET");
		String actualValue = getJsonPath(response, key);
		Assert.assertEquals(actualValue, expectedValue);
	   
	}
	
	@Given("quoteID of existing quote")
	public void quoteid_of_existing_quote() throws IOException {
	    // Write code here that turns the phrase above into concrete actions		
		
		quoteID = getJsonPath(response, "id");	 
	}
	

}
