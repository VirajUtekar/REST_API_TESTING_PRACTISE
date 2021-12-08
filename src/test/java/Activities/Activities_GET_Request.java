package Activities;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Activities_GET_Request extends Base {

	
    @BeforeTest
	public void beforeRequest() {
	
    	//create base uri
    	RestAssured.baseURI= baseURI;
    	
    	//create request object
    	httpRequest = RestAssured.given();
    	
    	//create response object
    	response = httpRequest.request(Method.GET,"/api/v1/Authors/authors/books/3");
    	
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
    
       Map<String,String> json = response.jsonPath().getMap("[0]");
       String firstNameVal = json.get("firstName");
       Assert.assertEquals(json.get("firstName"),firstNameVal);
    }
    
    @Test
    public void getVerifyResponseHeader() {
      String responseHeaderVal = response.header("content-type");
      Assert.assertEquals(responseHeaderVal,"application/json; charset=utf-8; v=1.0");
    }
	
}
