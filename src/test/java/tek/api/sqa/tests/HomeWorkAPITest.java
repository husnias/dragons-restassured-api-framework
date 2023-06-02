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
import tek.api.sqa.base.DatabaseConfig;

public class HomeWorkAPITest  extends DatabaseConfig {
	// create account API Test
	//validate with data base 
	//Full Assertion all fields
	
	 @Test
	    public void createAccountTestWithDBValidation() throws SQLException {
	        // Step 1: Create a new Primary Person in the database
	        String insertQuery = "INSERT INTO primary_person (email, first_name) VALUES ('test@example.com', 'John')";
	        executeQuery(insertQuery);

	        // Step 2: Retrieve the ID of the newly created Primary Person
	        String query = "SELECT id FROM primary_person ORDER BY id DESC LIMIT 1";
	        ResultSet resultSet = runQuery(query);
	        long queryResultId = 0;
	        while (resultSet.next()) {
	            queryResultId = resultSet.getLong("id");
	        }

	        // Step 3: Send API request to create the account
	        String validToken = getValidToken();
	        RequestSpecification request = RestAssured.given();
	        request.header("Authorization", "Bearer " + validToken);
	        request.queryParam("primaryPersonId", queryResultId);

	        Response response = request.when().get(EndPoints.GET_ACCOUNT.getValue());
	        Assert.assertEquals(response.getStatusCode(), 200);

	        // Step 4: Retrieve the account details from the database
	        String selectQuery = "SELECT * FROM primary_person WHERE id = " + queryResultId;
	        ResultSet accountResult = runQuery(selectQuery);

	        // Step 5: Deserialize the response body into a PrimaryAccount object
	        PrimaryAccount responseBody = response.jsonPath()
	        		.getObject("primaryPerson", PrimaryAccount.class);

	        // Step 6: Perform assertions
	        if (accountResult.next()) {
	            String expectedEmail = accountResult.getString("email");
	            String expectedFirstName = accountResult.getString("first_name");
	            String expectedLastName = accountResult.getString("last_name");
	            // Add more assertions for other fields

	            Assert.assertEquals(responseBody.getEmail(), expectedEmail);
	            Assert.assertEquals(responseBody.getFirstName(), expectedFirstName);
	            Assert.assertEquals(responseBody.getLastName(), expectedLastName);
	            // Add more assertions for other fields
	        } else {
	            Assert.fail("Test failed: Database query did not return result for id " + queryResultId);
	        }
	    }

	private void executeQuery(String insertQuery) {
		
		
	}
}
