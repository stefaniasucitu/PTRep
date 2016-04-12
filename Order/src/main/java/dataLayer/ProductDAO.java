package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	public static ArrayList<Product> FetchInfo() {
		ArrayList<Product> currentProduct = new ArrayList<Product>();
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from Product");
			while (myRs.next()) {
				currentProduct.add(new Product(myRs.getInt("idProduct"), myRs.getString("Name"),
						myRs.getInt("Quantity"), myRs.getInt("Price")));

			}
		} catch (Exception exc) {
			exc.printStackTrace();

		}
		return currentProduct;
	}

	public static void addProduct(Product curr) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate("INSERT INTO Product " + "VALUES (" + curr.getId() + ", '" + curr.getName() + "', "
					+ curr.getQuantity() + ", " + curr.getPrice() + ")");
		} catch (Exception exc) {
			exc.printStackTrace();

		}
	}

	public static void updateProduct(Product curr) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate("UPDATE Product SET Name='" + curr.getName() + "',Quantity=" + curr.getQuantity()
					+ ", Price=" + curr.getPrice() + "  WHERE idProduct=" + curr.getId());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void removeClient(Product curr) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate("DELETE FROM Product WHERE idProduct=" + curr.getId());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
