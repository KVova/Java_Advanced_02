package volodymyr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {
	
	public MagazineDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Magazine magazine) throws SQLException {
		preparedStatemant = connection.prepareStatement(CREATE);
		preparedStatemant.setString(1, magazine.getMagazineName());
		preparedStatemant.setInt(2, magazine.getMagazinePrice());
		preparedStatemant.setInt(3, magazine.getQuantity());
		preparedStatemant.executeUpdate();
	}
	
	public Magazine read(int id) throws SQLException {
		preparedStatemant = connection.prepareStatement(READ_BY_ID);
		preparedStatemant.setInt(1, id);
		ResultSet result = preparedStatemant.executeQuery();
		result.next();
		
		return MagazineMapper.map(result);
	}
	
	public void update(Magazine magazine) throws SQLException {
		preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatemant.setString(1, magazine.getMagazineName());
		preparedStatemant.setInt(2, magazine.getMagazinePrice());
		preparedStatemant.setInt(3, magazine.getQuantity());
		preparedStatemant.setInt(4, magazine.getId());
		preparedStatemant.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		preparedStatemant = connection.prepareStatement(DELETE_BY_ID);
		preparedStatemant.setInt(1, id);
		preparedStatemant.executeUpdate();
	}
	
	public List<Magazine> readAll() throws SQLException{
		List<Magazine> listOfUser = new ArrayList<>();
		preparedStatemant = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatemant.executeQuery();
		while (result.next()) {
			listOfUser.add(MagazineMapper.map(result));			
		}
		return listOfUser;
	}
	
	private static String CREATE = "insert into magazine(magazine_name, magazine_price, quantity) value(?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id =?";
	private static String UPDATE_BY_ID = "update magazine set magazine_name=?, magazine_price =?, quantity =? where id =?";
	private static String DELETE_BY_ID = "delete from magazine where id =?";
	private static String READ_ALL = "select * from magazine";
	
	private Connection connection;
	private PreparedStatement preparedStatemant;
	
}