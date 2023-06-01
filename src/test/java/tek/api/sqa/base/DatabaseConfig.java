package tek.api.sqa.base;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DatabaseConfig extends APITestConfig {
	
	private Connection getConnected() {
		HashMap<String, String> dbProp = getDatabaseProperties(); 
		String url = dbProp.get("db_url");
		String username = dbProp.get("username");
		String password = dbProp.get("password");
		
		try {
			return DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			throw new RuntimeException("Failing the test due database connectivity " + e.getMessage());
		}
	}
	
	private Statement getStatement() {
		Connection connection = getConnected();
		try {
		return connection.createStatement();
		}catch (SQLException e) {
			throw new RuntimeException("Failing the test due creating statement " + e.getMessage());
		}
	}
	
	public ResultSet runQuery(String query) {
		try {
			Statement statement = getStatement();
			return statement.executeQuery(query);
		}catch (SQLException e) {
			throw new RuntimeException("Failing the test due executing query " + e.getMessage());
		}
	}
}


