package tek.api.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TestingDatabaseConnection {
	

	public static void main(String[] args) {
			String url = "jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app?useSSL=true&requireSSL=false";
			String port = "3306";
			String databaseName = "tek_insurance_app";
			String username = "tek_student_user";
			String password = "MAY_2022";

			try {
				// Create A connection to DB.
				Connection connection = DriverManager.getConnection(url, username, password);
				// Create Statement using connection
				Statement statement = connection.createStatement();
				// Using statement execute queries. and return ResultSet.
				ResultSet resultSet = statement
						.executeQuery("select * from primary_person order by id desc limit 1;");
				//.executeQuery("select count(id) as count from primary_person;");
				//ResultSet is Iterator. so in order loop through we have to use while loop.
				while(resultSet.next()) {
					//long primaryPersonId = resultSet.getLong("count");
					long primaryPersonId = resultSet.getLong("id");
					String email = resultSet.getString("email");
					String firstName = resultSet.getString("first_name");
					
					System.out.println(primaryPersonId);
					System.out.println(email);
					System.out.println(firstName);
				}
				// the only thing changing is query and result set
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


