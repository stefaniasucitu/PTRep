package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Client;
import model.Order;
import model.Product;

public class OrderDAO {

	public static Client getClientInfo(int IDCL) {
		Client info = new Client();
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from Client WHERE idClient=" + IDCL);
			if (myRs.next()) {
				info.setId(myRs.getInt("idClient"));
				info.setLast(myRs.getString("LastName"));
				info.setFirst(myRs.getString("FirstName"));
				info.setAddr(myRs.getString("Address"));
				info.setPhone(myRs.getString("PhoneNumber"));
				info.setEmail(myRs.getString("EmailAddress"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return info;
	}

	public static Product getProductInfo(int IDPR) {

		Product info = new Product();
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from Product WHERE idProduct=" + IDPR);
			while (myRs.next()) {
				info.setId(myRs.getInt("idProduct"));
				info.setName(myRs.getString("Name"));
				info.setPrice(myRs.getInt("Price"));
				info.setQuantity(myRs.getInt("Quantity"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();

		}
		return info;
	}

	public static void updateStock(Product prod, int Stock) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate("UPDATE Product SET Name='" + prod.getName() + "',Quantity=" + Stock + ", Price="
					+ prod.getPrice() + "  WHERE idProduct=" + prod.getId());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void add(Order order) {

		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			System.out.println("INSERT INTO `order` VALUES (" + order.getId() + "," + order.getClientID() + ","
					+ order.getProductID() + "," + order.getQuantity() + "," + order.getTotal() + ");");
			myStmt.executeUpdate("INSERT INTO `Order` VALUES (" + order.getId() + "," + order.getClientID() + ","
					+ order.getProductID() + "," + order.getQuantity() + "," + order.getTotal() + ");");

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
