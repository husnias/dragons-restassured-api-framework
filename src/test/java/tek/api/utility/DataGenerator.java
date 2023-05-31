package tek.api.utility;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class DataGenerator {
	
	private Faker faker; 

	public DataGenerator() {
		this.faker = new Faker();
	}
	
	public String getFirstName() {
		return faker.name().firstName(); 
	}
	
	public String getLastName() {
		return faker.name().lastName(); 
	}
	
	public String getEmail() {
		String firstName = getFirstName(); 
		String lastName = getLastName(); 
		return firstName + "_" + lastName + "@gmail.com";
	}
	
	public String getEmail(String firstName, String lastName, String provider) {
		return firstName + "_" + lastName + "@" + provider; 
	}
	
	public String getJobTitle() {
		return faker.job().position(); 
	}
	
	public String getDateOfBirth() {
		Date date = faker.date().birthday();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
}

