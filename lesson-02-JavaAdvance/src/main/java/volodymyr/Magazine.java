package volodymyr;

public class Magazine {

	public Magazine(int id, String magazineName, int magazinePrice, int quantity) {
		super();
		this.id = id;
		this.magazineName = magazineName;
		this.magazinePrice = magazinePrice;
		this.quantity = quantity;
	}
	
	public Magazine(String magazineName, int magazinePrice, int quantity) {
		super();
		this.magazineName = magazineName;
		this.magazinePrice = magazinePrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}

	public int getMagazinePrice() {
		return magazinePrice;
	}

	public void setMagazinePrice(int magazinePrice) {
		this.magazinePrice = magazinePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Magazine [id " + id + ", Magazine Name - " + magazineName + ", Price = " + magazinePrice
				+ ", quantity = " + quantity + "]";
	}

	private int id;
	private String magazineName;
	private int magazinePrice;
	private int quantity;
	
}