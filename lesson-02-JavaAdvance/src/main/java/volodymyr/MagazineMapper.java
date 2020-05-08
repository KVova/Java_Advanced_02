package volodymyr;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {

	public static Magazine map(ResultSet result) throws SQLException {
		
		String magazineName = result.getString("magazine_name");
		int magazinePrice = result.getInt("magazine_price");
		int quantity = result.getInt("quantity");
		
		return new Magazine(magazineName, magazinePrice, quantity);
	}
	
}
