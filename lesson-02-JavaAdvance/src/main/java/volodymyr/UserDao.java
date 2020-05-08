package volodymyr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(User user) throws SQLException {
		preparedStatemant = connection.prepareStatement(CREATE);
		preparedStatemant.setString(1, user.getFirstName());
		preparedStatemant.setString(2, user.getLastName());
		preparedStatemant.setInt(3, user.getAge());
		preparedStatemant.setString(4, user.getAddress());
		preparedStatemant.setString(5, user.getEmail());
		preparedStatemant.executeUpdate();
	}
	
	public User read(int id) throws SQLException {
		preparedStatemant = connection.prepareStatement(READ_BY_ID);
		preparedStatemant.setInt(1, id);
		ResultSet result = preparedStatemant.executeQuery();
		result.next();
		
		return UserMapper.map(result);
	}
	
	public void update(User user) throws SQLException {
		preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatemant.setString(1, user.getFirstName());
		preparedStatemant.setString(2, user.getLastName());
		preparedStatemant.setInt(3, user.getAge());
		preparedStatemant.setString(4, user.getAddress());
		preparedStatemant.setString(5, user.getEmail());
		preparedStatemant.setInt(6, user.getId());
		preparedStatemant.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		preparedStatemant = connection.prepareStatement(DELETE_BY_ID);
		preparedStatemant.setInt(1, id);
		preparedStatemant.executeUpdate();
	}
	
	public List<User> readAll() throws SQLException{
		List<User> listOfUser = new ArrayList<User>();
		preparedStatemant = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatemant.executeQuery();
		while (result.next()) {
			listOfUser.add(UserMapper.map(result));			
		}
		return listOfUser;
	}
	
	private static String CREATE = "insert into user(first_name, last_name, age, address, user_email) value(?,?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id =?";
	private static String UPDATE_BY_ID = "update user set first_name=?, last_name =?, age =?, address =?, user_email =? where id =?";
	private static String DELETE_BY_ID = "delete from user where id =?";
	private static String READ_ALL = "select * from user";
	
	private Connection connection;
	private PreparedStatement preparedStatemant;
	
}
