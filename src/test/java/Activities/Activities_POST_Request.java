package Activities;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Activities_POST_Request extends Base {

	@BeforeTest
	public void beforeRequest() {
		
		// create base uri
		RestAssured.baseURI= baseURI;
		  
		// create request object
		httpRequest = RestAssured.given();
		
		//create JsonObject
		
		JSONObject requestparam = new JSONObject();
		requestparam.put("id",31);
		requestparam.put("idBook",31);
		requestparam.put("firstName","ABC");
		requestparam.put("lastName","PQR");
		
		httpRequest.header("content-type","application/json; charset=utf-8; v=1.0");
		
		httpRequest.body(requestparam.toJSONString());
		
		//create response object
		response = httpRequest.request(Method.POST,"/api/v1/Authors");
		
		String responseBodyVal = response.body().asString();
		System.out.println(responseBodyVal);
		
	}
	
	@Test
	public void getVerifyStatusCode() {
       int statusCodeVal = response.getStatusCode();
       Assert.assertEquals(statusCodeVal,200);		
	}
	
	@Test
	public void getVerifyResponseBody() {
		
		//validate response body value
		String responseBodyVal = response.jsonPath().get("firstName");
	    Assert.assertEquals(responseBodyVal,"ABC");	
	}
	
	@Test
	public void getVerifyResponseHeader() {
    
		String responseHeaderValue = response.header("content-type");
	    Assert.assertEquals(responseHeaderValue,"application/json; charset=utf-8; v=1.0");			
	}
		
}
