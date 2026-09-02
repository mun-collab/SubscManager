package model;

public class Subscription {
	private int id;
	private String name;
	private int price;
	private String category;
	private int renewalDay;

	// コンストラクタ
	public Subscription(int id, String name, int price, String category, int renewalDay) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.renewalDay = renewalDay;
	}

	// Getter と Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRenewalDay() {
		return renewalDay;
	}

	public void setRenewalDay(int renewalDay) {
		this.renewalDay = renewalDay;
	}
}