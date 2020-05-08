package volodymyr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		UserDao userDao = new UserDao(ConnectionUtils.openConnection());
		
		userDao.readAll().forEach(System.out::println);;
		System.out.println();
		System.out.println("\n");
		
		List<User> listOfUser = new ArrayList<>();
		listOfUser.add(new User("Ivan", "Pavlov", 30, "Lviv", "pavlovi@gmail.com"));
		listOfUser.add(new User("Vira", "Ivaniv", 25, "Lutsk", "ivanivv@gmail.com"));
		listOfUser.add(new User("Svitlana", "Mayko", 33, "Kuiv", "maykosv@gmail.com"));
		listOfUser.add(new User("Yura", "Gusak", 35, "Sumy", "gusaky@gmail.com"));
		listOfUser.add(new User("Volodymyr", "Knyshuk", 24, "Odessa", "volmart@gmail.com"));

		listOfUser.forEach(user->{
			try {
				userDao.insert(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		userDao.readAll().forEach(System.out::println);;
		System.out.println("************************************************\n");

		//READ-BY-ID
		User userFromDB = userDao.read(3);
		System.out.println(userFromDB);
		
		//UPDATE-BY_ID
		userFromDB.setLastName(userFromDB.getLastName()+"va");
		userDao.update(userFromDB);
		
		userDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");
		
		//DELETE_BY_ID
		userDao.delete(4);
		
		//READ-BY-ID
		userDao.readAll().forEach(System.out::println);;
		System.out.println("************************************************\n");
		
////////////////////////////////////////////////////////////////////////////////////////////
		
		
		MagazineDao magazineDao = new MagazineDao(ConnectionUtils.openConnection());
		
		magazineDao.readAll().forEach(System.out::println);;
		System.out.println();
		System.out.println("\n");
		
		List<Magazine> listOfMagazine = new ArrayList<>();
		listOfMagazine.add(new Magazine("Kvitka", 25, 50));
		listOfMagazine.add(new Magazine("Auto News", 55, 27));
		listOfMagazine.add(new Magazine("Sad and Gorod", 5, 500));
		listOfMagazine.add(new Magazine("News", 7, 100));
		listOfMagazine.add(new Magazine("Gorod", 5, 0));
		listOfMagazine.add(new Magazine("News about the planet", 7, 10));
		
		listOfMagazine.forEach(magazine->{
			try {
				magazineDao.insert(magazine);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		magazineDao.readAll().forEach(System.out::println);;
		System.out.println("************************************************\n");
		
		Magazine magazineFromDB = magazineDao.read(4);
		System.out.println(magazineFromDB);
		
		magazineFromDB.setMagazineName(magazineFromDB.getMagazineName()+ "New");
		magazineDao.update(magazineFromDB);
		System.out.println(magazineFromDB.getMagazineName().toString());
		
		magazineDao.delete(3);
		magazineDao.readAll().forEach(System.out::println);;
		System.out.println("************************************************\n");
		
	}

}
