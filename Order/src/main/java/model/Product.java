package model;

public class Product {
	private int ProductID;
	private String Name;
	private int Quantity;
	private int Price;

	public Product() {
	};

	public Product(int id, String name, int quantity, int price) {
		ProductID = id;
		Name = name;
		Quantity = quantity;
		Price = price;

	}

	public int getId() {
		return ProductID;
	};

	public String getName() {
		return Name;
	};

	public int getQuantity() {
		return Quantity;
	};

	public int getPrice() {
		return Price;
	};

	public void setId(int id) {
		this.ProductID = id;
	};

	public void setName(String detail) {
		this.Name = detail;
	};

	public void setQuantity(int quan) {
		this.Quantity = quan;
	};

	public void setPrice(int detail) {
		this.Price = detail;
	};

}
