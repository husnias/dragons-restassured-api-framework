package tek.api.sqa.base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tek.api.utility.EndPoints;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ExtentITestListenerAdapter.class})
public class APITestConfig extends BaseConfig {

    @BeforeMethod
    public void setupApiTest() {
    	//First step setup BaseURL to RestAssured
        System.out.println("Setting up Test");
        RestAssured.baseURI = getBaseUrl();
    }
    public String getValidToken() {
Map<String, String> requestBody = new HashMap<>();
    	
    	requestBody.put("username", "supervisor");
    	requestBody.put("password", "tek_supervisor");
    	RequestSpecification request = RestAssured.given().body(requestBody);
    	 request.contentType(ContentType.JSON);
    	 Response response = request.when().post(EndPoints.TOKEN_GENERATION.getValue());    	 
         response.prettyPrint();
         Assert.assertEquals(response.getStatusCode(), 200);        
         String token = response.jsonPath().get("token");
        return token;
    }
}
