package Activities;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Activities_List_GET_Request extends Base {

	Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void beforeRequest() {
		
		// create base uri
		RestAssured.baseURI= baseURI;
		log.info("base uri is been created");
		
		//create request object
		httpRequest = RestAssured.given();
		log.info("request object is been created");
		
		//create response object
		response = httpRequest.request(Method.GET,"/api/v1/Activities");
		log.info("response object is been created");
		String responseBodyVal = response.body().asString();
		System.out.println(responseBodyVal);
	}
	
	
	@Test
	public void getActivityListStatusCodeVerify() {
		//validate status code
		int statusCodeValue = response.getStatusCode();
		Assert.assertEquals(statusCodeValue, 200);
	    log.info("status code is 200");	
	}
	
	@Test
	public void getActivityListResponseBodyVerify() {
        //validate response body value
		Map<String,String> json = response.jsonPath().getMap("[0]");
		Assert.assertEquals(json.get("title"),"Activity 1");
	}
	
	@Test
	public void getActivityListResponseHeaderVerify() {
       //validate response header
		String responseHeaderVal = response.header("content-type");
		Assert.assertEquals(responseHeaderVal,"application/json; charset=utf-8; v=1.0");
		
	}
}
