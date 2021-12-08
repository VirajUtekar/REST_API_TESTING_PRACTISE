package Resources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	public RequestSpecification httpRequest;
	public Response response;
	
	protected String baseURI = "https://fakerestapi.azurewebsites.net";
	
}
