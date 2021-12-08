package Activities;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Activities_DELETE_Request extends Base {
	
	@BeforeTest
	public void beforeRequest() {
		
	  RestAssured.baseURI=baseURI;
		
	  httpRequest = RestAssured.given();
	  
	  response = httpRequest.request(Method.DELETE,"/api/v1/Activities/3");
	  
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
		
		String responseBodyVal = response.body().asString();
		Assert.assertEquals(responseBodyVal,"");
	}
	
	@Test
	public void getVerifyResponseHeader() {
        String responseHeaderVal = response.getHeader("content-length");
        Assert.assertEquals(responseHeaderVal,"0");
	}

}
