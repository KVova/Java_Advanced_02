package volodymyr;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

	public static User map(ResultSet result) throws SQLException {
		
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		int age = result.getInt("age");
		String address = result.getString("address");
		String email = result.getString("user_email");
		
		return new User(firstName, lastName, age, address, email);
	}
	
}
