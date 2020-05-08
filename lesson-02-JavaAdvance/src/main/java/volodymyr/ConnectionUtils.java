package volodymyr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	private static String USER_NAME = "admin";
	private static String USER_PASSWORD = "admin";
	private static String URL = "jdbc:mysql://localhost/internet_magazine?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
	
	public static Connection openConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}
	
}
