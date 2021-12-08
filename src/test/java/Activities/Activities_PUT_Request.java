package Activities;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Activities_PUT_Request extends Base {

	@BeforeTest
	public void beforeRequest() {
		
		RestAssured.baseURI= baseURI;
		
		httpRequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		requestParam.put("id",4);
		requestParam.put("title","Activity 4"); 
		requestParam.put("dueDate","2021-12-08T19:22:15.6315035+00:00"); 
		requestParam.put("completed",false); 
		
		httpRequest.body(requestParam.toJSONString());
	
		response = httpRequest.request(Method.PUT,"/api/v1/Activities/3");
		
		String responseBodyVal = response.body().asString();
		System.out.println(responseBodyVal);
	}
	
	@Test
	public void getVerifyStatusCode() {
		
		int statusCodeVal  = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
	}
	
	
}
