package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Properties loadPropertiesFile() throws IOException {
		Properties properties = new Properties();
		InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(input);
		input.close();
		return properties;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Properties properties = null;
		
		try {
			properties = loadPropertiesFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		Class.forName(driver);
		
		connection =DriverManager.getConnection(url,username, password);
		if(connection != null) {
			System.out.println("Connection Established");
		}else {
			System.out.println("Not Connected");
		}
		return connection;
	}
}
