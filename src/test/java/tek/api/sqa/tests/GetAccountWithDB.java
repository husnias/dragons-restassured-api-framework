package tek.api.sqa.tests;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.model.PrimaryAccount;
import tek.api.sqa.base.DatabaseConfig;
import tek.api.utility.EndPoints;
public class GetAccountWithDB extends DatabaseConfig {
	@Test
	public void getAccountTestWithDBQuery() throws SQLException {
		String query = "select id from primary_person order by id desc limit 1";
		ResultSet resultSet = runQuery(query);
		long queryResultId = 0; 
		while(resultSet.next()) {
			queryResultId = resultSet.getLong("id");
		}
		String validToken = getValidToken(); 
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + validToken);
		request.queryParam("primaryPersonId", queryResultId);
		
		Response response = request.when().get(EndPoints.GET_ACCOUNT.getValue());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String secondQuery = "select * from primary_person where id = " + queryResultId;
		ResultSet secondQueryResult = runQuery(secondQuery);
		
		//get response from json path as Object. 
		PrimaryAccount responseBody = response.jsonPath()
				.getObject("primaryPerson", PrimaryAccount.class);
		
		if (secondQueryResult.next()) {
			String expectedEmail = secondQueryResult.getString("email");
			String expectedFirstName = secondQueryResult.getString("first_name");
			Assert.assertEquals(responseBody.getEmail(), expectedEmail);
			Assert.assertEquals(responseBody.getFirstName(), expectedFirstName);
		}else {
			Assert.fail("Test Fail Second query did not return result for id " + queryResultId);
		}
		
		//int actualPrimaryPersonId = response.jsonPath().get("primaryPerson.id");
		//Assert.assertEquals(actualPrimaryPersonId, queryResultId);
	}

	
	}


