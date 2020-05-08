package volodymyr;

public class User {

	public User(int id, String firstName, String lastName, int age, String address, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.email = email;
	}
	
	public User(String firstName, String lastName, int age, String address, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id " + id + ", First Name - " + firstName + ", Last Name - " + lastName + ", Age = " + age + ", Address - "
				+ address + ", E-mail: " + email + "]";
	}

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String email;
	
}
