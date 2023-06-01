package tek.api.utility;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.github.javafaker.Faker;
import java.text.ParseException;
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
	
	public Date getDateOfBirth() {
		Date date = faker.date().birthday();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(date);
		try {
			return formatter.parse(formattedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Date Parse Exception ");
		}

	}
}

