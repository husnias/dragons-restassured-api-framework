package tek.api.sqa.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.model.PrimaryAccount;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.DataGenerator;
import tek.api.utility.EndPoints;

public class CreateAccountTest extends APITestConfig {


	private DataGenerator data = new DataGenerator(); 
	@Test
	public void createAccountValidTest() {
				

		String validToken = getValidToken(); 

		RequestSpecification request = RestAssured.given(); 
		request.contentType(ContentType.JSON);
		request.header("Authorization" , "Bearer " + validToken);
		//Create Request Body and Then Add to request. 
		PrimaryAccount requestBody = new PrimaryAccount();
		String firstName = data.getFirstName();
		String lastName = data.getLastName();
		requestBody.setEmail(data.getEmail(firstName, lastName, "company.com"));
		requestBody.setFirstName(firstName);
		requestBody.setLastName(lastName);
		requestBody.setTitle("Mr.");
		requestBody.setGender("MALE");
		requestBody.setMaritalStatus("SINGLE");
		requestBody.setEmploymentStatus(data.getJobTitle());
		requestBody.setDateOfBirth(data.getDateOfBirth());
		
		request.body(requestBody);
		
		Response response = request.when()
				.post(EndPoints.ADD_PRIMARY_ACCOUNT.getValue());
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 201);

		PrimaryAccount responseBody = response.as(PrimaryAccount.class);
		//String actualEmail = response.jsonPath().getString("email");
		Assert.assertEquals(responseBody.getEmail(), requestBody.getEmail());
	}



		
		//String actualEmail = response.jsonPath().getString("email");
		//Assert.assertEquals(actualEmail, requestBody.getEmail());
	}

	

