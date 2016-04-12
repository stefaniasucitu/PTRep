package businessLogic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import dataLayer.OrderDAO;
import model.Client;
import model.Order;
import model.Product;

public class Operations {
	static int idO = 0;

	public static String PlaceOrder(int cid, int pid, int quan) {
		String under = "";
		Client Customer = new Client();
		Product Item = new Product();
		int Stock;
		Order newOrder = new Order();
		Customer = OrderDAO.getClientInfo(cid);
		Item = OrderDAO.getProductInfo(pid);
		Stock = Item.getQuantity();
		System.out.println(Stock);
		if (Stock >= quan) {
			Stock = Stock - quan;
			OrderDAO.updateStock(Item, Stock);
			newOrder.setId(idO++);
			newOrder.setClientID(Customer.getId());
			newOrder.setProductID(Item.getId());
			newOrder.setQuantity(quan);
			newOrder.setTotal(Item.getPrice());
			OrderDAO.add(newOrder);
			under = "IN STOCK";
			
			// GENERATE "FACTURA"
			generate(newOrder,Customer,Item);
		} else
			under = "UNDERSTOCK";
		return under;
	}
	public static void generate(Order o,Client c,Product p){
		String fileName = "out.txt";
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
			outputStream.println("Factura");
			outputStream.println("Order nr"+o.getId());
			outputStream.println("Client Details:");
			outputStream.println("Name:"+c.getFirst()+" "+c.getLast()+" 	Phone:"+c.getPhone());
			outputStream.println("Product Details:");
			outputStream.println("Name:"+p.getName()+"    Price:"+p.getPrice());
			outputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}

