package stepDefinitions;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.RequestPayloads;
import resources.Utils;

public class UserAPIStepDefinition extends Utils {

	RequestPayloads payload = new RequestPayloads();
	static String login;
	static String User_Token = "";

	@Given("Create User Payload with {string} {string} {string}")
	public void create_User_Payload_with(String login, String email, String password) throws IOException {
		// To provide the payload in body

		request = given().spec(requestSpecification())
				.header("authorization",getGlobalProperties("authorization"))
				.body(payload.createUserPayload(login, email, password));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		// To call the respective API 
		response = getHTTPMethod(request, resource, method);
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer code) {
		// To validate the status code 
		Assert.assertEquals(response.getStatusCode(), code.intValue());
	}

	@Then("verify login generated maps to {string} using {string}")
	public void verify_login_generated_maps_to_using(String expectedLogin, String resource) throws IOException {
		// To validate that login generated is same as provided using the get API

		login = getJsonPath(response, "login");
		User_Token = getJsonPath(response, "User-Token");
		request = given().spec(requestSpecification()).pathParam("login", login)
				.header("authorization",getGlobalProperties("authorization"))
				.header("User-Token", User_Token);
		user_calls_with_http_request(resource, "GET");
		String actualLogin = getJsonPath(response, "login");
		Assert.assertEquals(actualLogin, expectedLogin);

	}

	@Given("Update User Payload with {string} {string} {string} {string}")
	public void update_User_Payload_with(String loginID, String email, String password, String facebook_username)
			throws IOException {
		// To pass the update user payload
String randomNumber = getRandomNumberString();
		request = given().spec(requestSpecification()).pathParam("login", login)
				.header("authorization",getGlobalProperties("authorization"))
				.header("User-Token", User_Token)
				.body(payload.updateUserPayload(loginID+randomNumber, randomNumber+email, password, facebook_username));

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		// To validate that login value is updated with the provided value
		Assert.assertEquals(getJsonPath(response, keyValue), expectedValue);
	}
	
	@Given("Forgot Password Payload with  {string}")
	public void forgot_Password_Payload_with(String email) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification())
				.header("authorization",getGlobalProperties("authorization"))
				.body(payload.forgotPasswordPayload( email));	    
	}

	@Given("Reset Password Payload with  {string} {string}")
	public void reset_Password_Payload_with(String email, String reset_password_token) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification())
				.header("authorization",getGlobalProperties("authorization"))
				.body(payload.resetPasswordPayload( email,reset_password_token));	    
	}

}
