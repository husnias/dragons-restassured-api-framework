package tek.api.sqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class InvalidTokenTest extends APITestConfig{
	@Test
	public void verifyInvalidToken() {
	    // Generate invalid token
	    String invalidToken = getInvalidToken();
	    RequestSpecification request = RestAssured.given();
	    request.queryParam("token", invalidToken);
	    request.queryParam("username", "supervisor");

	    Response response = request.when().get(EndPoints.TOKEN_VERIFY.getValue());
	    Assert.assertEquals(response.getStatusCode(), 400);
	}

	
	}



