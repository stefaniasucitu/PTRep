package model;

public class Client {
	private int ClientID;
	private String FirstName;
	private String LastName;
	private String Address;
	private String Phone;
	private String Email;

	public Client(int id, String first, String last, String adr, String phone, String email) {
		ClientID = id;
		FirstName = first;
		LastName = last;
		Address = adr;
		Phone = phone;
		Email = email;
	}

	public Client() {
	}

	public int getId() {
		return ClientID;
	};

	public String getFirst() {
		return FirstName;
	};

	public String getLast() {
		return LastName;
	};

	public String getAddr() {
		return Address;
	};

	public String getPhone() {
		return Phone;
	};

	public String getEmail() {
		return Email;
	};

	public void setId(int id) {
		this.ClientID = id;
	};

	public void setFirst(String detail) {
		this.FirstName = detail;
	};

	public void setLast(String detail) {
		this.LastName = detail;
	};

	public void setAddr(String detail) {
		this.Address = detail;
	};

	public void setPhone(String detail) {
		this.Phone = detail;
	};

	public void setEmail(String detail) {
		this.Email = detail;
	};
}
