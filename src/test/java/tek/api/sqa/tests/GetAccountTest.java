package tek.api.sqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;


public class GetAccountTest extends APITestConfig {

	@Test
	public void getAccountWithExistingId() {
		String token = getValidToken();
		RequestSpecification request = RestAssured.given();

		request.queryParam("primaryPersonId", 7112);
		request.header("Authorization", "Bearer " + token);
		
		Response response = request.when().get(EndPoints.GET_ACCOUNT.getValue());
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		int primaryPersonId = response.jsonPath().get("primaryPerson.id");
		Assert.assertEquals(primaryPersonId, 7112);
	}

		
		
	}


