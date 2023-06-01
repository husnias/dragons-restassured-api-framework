package tek.api.sqa.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;
public class GetAllAcountTest extends APITestConfig {

	@Test
	public void getAllAccountTest() {
		// Prepare the request.
		String token = getValidToken();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		Response response = request.when().get(EndPoints.GET_ALL_ACCOUNTS.getValue());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
