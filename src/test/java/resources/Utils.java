package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public static ResponseSpecification resp;
	public static Map<String,Object> headerMap;
	
	public RequestSpecification requestSpecification() throws IOException 
	{
		if(req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req =new RequestSpecBuilder().setBaseUri(getGlobalProperties("baseURL")).setRelaxedHTTPSValidation()
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();		
		return req;	 
		}
		return req;	 
	}
	
	public ResponseSpecification responseSpecification() 
	{
			resp =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			return resp;	
	}
	
	public static String getGlobalProperties(String key) throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) 
	{
		String resp = response.asString();
		JsonPath js= new JsonPath(resp);
		return js.get(key).toString();
	}
	
	public void setHeader() 
	{

	}
	
	public static String getRandomNumberString() {
	    // It will generate 3 digit random Number.
	    // from 0 to 999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999);

	    // this will convert any number sequence into 3 character.
	    return String.format("%03d", number);
	}
		
	public Map<String, Object> setheader(String key, String value){
		headerMap = new HashMap<String,Object>();
		headerMap.put(key, value);
		return headerMap;
		}
	
	}


