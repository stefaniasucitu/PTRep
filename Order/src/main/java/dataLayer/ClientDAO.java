package dataLayer;

import java.sql.*;
import java.util.ArrayList;

import model.Client;

public class ClientDAO {

	public static ArrayList<Client> FetchInfo() {
		ArrayList<Client> currentClient = new ArrayList<Client>();

		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from Client");
			while (myRs.next()) {

				currentClient.add(new Client(myRs.getInt("idClient"), myRs.getString("LastName"),
						myRs.getString("FirstName"), myRs.getString("Address"), myRs.getString("PhoneNumber"),
						myRs.getString("EmailAddress")));

			}
		} catch (Exception exc) {
			exc.printStackTrace();

		}
		return currentClient;
	}

	public static void addClient(Client curr) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate("INSERT INTO Client " + "VALUES (" + curr.getId() + ", '" + curr.getFirst() + "', '"
					+ curr.getLast() + "', '" + curr.getAddr() + "', '" + curr.getPhone() + "', '" + curr.getEmail()
					+ "')");
		} catch (Exception exc) {
			exc.printStackTrace();

		}
	}

	public static void updateClient(Client curr) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();

			myStmt.executeUpdate("UPDATE Client " + "SET FirstName='" + curr.getFirst() + "', LastName='"
					+ curr.getLast() + "', Address='" + curr.getAddr() + "', PhoneNumber='" + curr.getPhone()
					+ "', EmailAddress='" + curr.getEmail() + "' WHERE idClient=" + curr.getId());
		} catch (Exception exc) {
			exc.printStackTrace();

		}
	}

	public static void removeClient(Client curr) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShop", "root", "");
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate("DELETE FROM Client WHERE idClient=" + curr.getId());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
