package tek.api.sqa.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.sqa.base.APITestConfig;
import tek.api.utility.EndPoints;

public class SecurityTest extends APITestConfig {

	@Test
    public void testGenerateToken() {
		// First step to set Base URL done BeforeMethod Annotation
		//2) Prepare Request
		//Option 1 ) Creating a Map
		// Option 2) Creating an encapsulated Object.
		//Option 3) Start as Jason Object.class (not Recommended)
		
        Map<String, String> tokenRequestBody = new HashMap<>();
        tokenRequestBody.put("username", "supervisor");
        tokenRequestBody.put("password", "tek_supervisor");
        //Given Perpare Request
      RequestSpecification request = RestAssured.given().body(tokenRequestBody );
      request.contentType(ContentType.JSON);
        // when sending request to end-point        
        Response response = request.when().post(EndPoints.TOKEN_GENERATION.getValue());
        //Optional to print response in console
        response.prettyPrint();       
        Assert.assertEquals(response.getStatusCode(), 200);
        //Assert token is not null.
        String generatedToken = response.jsonPath().get("token");
        Assert.assertNotNull(generatedToken);
    }
    @Test(dataProvider = "invalidTokenData")   
    public void tokenWithInvalidDataTest(String username, 
    		String password, String expectedErrorMessage ) {
    	
    	Map<String, String> requestBody = new HashMap<>();
    	
    	requestBody.put("username", username);
    	requestBody.put("password", password);
    	RequestSpecification request = RestAssured.given().body(requestBody);
    	 request.contentType(ContentType.JSON);
    	 Response response = request.when().post(EndPoints.TOKEN_GENERATION.getValue());    	 
         response.prettyPrint();
         Assert.assertEquals(response.getStatusCode(), 400);        
         String errorMessage = response.jsonPath().get("errorMessage");
         Assert.assertEquals(errorMessage,expectedErrorMessage);
            	
    }
    @DataProvider(name = "invalidTokenData")
    private Object [][]invalidTokenData(){
    	Object[][] data = {
    			{"WrongUser", "tek_supervisor","User not found"},
    			{"supervisor","WrongPassword", "Password Not Matched"}
    	};
    	return data;
    }
}