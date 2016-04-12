package model;

public class Order {
	private int OrderID;
	private int ClientID;
	private int ProductID;
	private int Quantity;
	private int TotalPrice;
	
	public Order(){};
	public Order(int id, int client, int product, int quantity, int price) {
		OrderID = id;
		ClientID = client;
		ProductID = product;
		Quantity = quantity;
		TotalPrice = price;
		
		
	}

	public int getId() {
		return OrderID;
	};

	public int getClientID() {
		return ClientID;
	};

	public int getProductID() {
		return ProductID;
	};
	public int getTotal() {
		return TotalPrice;
	};
	public int getQuantity() {
		return Quantity;
	};

	public void setId(int id) {
		this.OrderID = id;
	};

	public void setClientID(int i) {
		this.ClientID = i;
	};

	public void setProductID(int detail) {
		this.ProductID = detail;
	};

	public void setTotal(int detail) {
		this.TotalPrice = detail;
	};
	public void setQuantity(int stock) {
		this.Quantity = stock;
	};
}
