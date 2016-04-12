package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businessLogic.Operations;
import dataLayer.ClientDAO;
import dataLayer.ProductDAO;
import model.Client;
import model.Product;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public GUI() {
		JFrame Window = new JFrame("Chose Option");
		Window.setLayout(new GridLayout(1, 3));
		Window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Window.setSize(500, 100);
		Window.setVisible(true);
		// Client area
		JPanel A1 = new JPanel();
		JPanel A2 = new JPanel();
		JPanel A3 = new JPanel();
		JButton B1 = new JButton("Client");
		A1.add(B1);
		JButton B2 = new JButton("Product");
		A2.add(B2);
		JButton B3 = new JButton("Order");
		A3.add(B3);
		Window.add(A1);
		Window.add(A2);
		Window.add(A3);
		Window.repaint();
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ClientWindow = new JFrame();
				ClientWindow.setLayout(new GridLayout(1, 2));
				ClientWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
				ClientWindow.setSize(700, 400);
				ClientWindow.setVisible(true);
				JPanel C1 = new JPanel();

				final JPanel C2 = new JPanel();

				C1.setLayout(new GridLayout(5, 1));
				JPanel frame1 = new JPanel();
				JPanel frame2 = new JPanel();
				JPanel frame3 = new JPanel();
				JPanel frame4 = new JPanel();
				JLabel messP = new JLabel("           Client Operations:");
				JButton addC = new JButton("Add Client");
				JButton editC = new JButton("Edit Info");
				JButton removeC = new JButton("Remove Client");
				JButton viewC = new JButton("View Clients");
				frame1.add(addC);
				frame2.add(editC);
				frame3.add(removeC);
				frame4.add(viewC);
				C1.add(messP);
				C1.add(frame1);
				C1.add(frame2);
				C1.add(frame3);
				C1.add(frame4);
				C2.setLayout(new GridLayout(7, 1));
				final JTextField idc = new JTextField("ID");
				final JTextField namec = new JTextField("First Name");
				final JTextField lastc = new JTextField("Last Name");
				final JTextField adrc = new JTextField("Address");
				final JTextField phonec = new JTextField("Phone Number");
				final JTextField email = new JTextField("Email");

				C2.add(idc);
				C2.add(namec);
				C2.add(lastc);
				C2.add(adrc);
				C2.add(phonec);
				C2.add(email);

				ClientWindow.add(C1);
				ClientWindow.add(C2);
				// Client AL
				addC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Client current = new Client(Integer.parseInt(idc.getText()), namec.getText(), lastc.getText(),
								adrc.getText(), phonec.getText(), email.getText());
						ClientDAO.addClient(current);
					}
				});
				editC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Client current = new Client(Integer.parseInt(idc.getText()), namec.getText(), lastc.getText(),
								adrc.getText(), phonec.getText(), email.getText());
						ClientDAO.updateClient(current);
					}
				});
				removeC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Client current = new Client(Integer.parseInt(idc.getText()), namec.getText(), lastc.getText(),
								adrc.getText(), phonec.getText(), email.getText());
						ClientDAO.removeClient(current);
					}
				});
				viewC.addActionListener(new ActionListener() {
					int i = 0;

					public void actionPerformed(ActionEvent e) {
						i++;
						ArrayList<Client> current = new ArrayList<Client>();
						current = ClientDAO.FetchInfo();
						Object rowData[][] = new Object[100][100];
						int k = 0;
						for (Client x : current) {
							k++;
							rowData[k - 1][0] = x.getId();
							rowData[k - 1][1] = x.getLast();
							rowData[k - 1][2] = x.getLast();
							rowData[k - 1][3] = x.getAddr();
							rowData[k - 1][4] = x.getPhone();
							rowData[k - 1][5] = x.getEmail();
						}

						Object columnNames[] = { "ID", "First Name", "Last Name", "Address", "Phone", "Email" };
						JTable viewc = new JTable(rowData, columnNames);
						JScrollPane scrollPane = new JScrollPane(viewc);
						if (i == 1)
							C2.add(scrollPane);
						C2.repaint();
					}
				});

			}
		});
		//// PRODUCT AREA
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ProductWindow = new JFrame();
				ProductWindow.setLayout(new GridLayout(1, 2));
				ProductWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
				ProductWindow.setSize(700, 400);
				ProductWindow.setVisible(true);
				JPanel P1 = new JPanel();
				final JPanel P2 = new JPanel();
				P1.setLayout(new GridLayout(5, 1));
				JLabel mess = new JLabel("           Product Operations:");
				JButton addP = new JButton("Add Product");
				JButton editP = new JButton("Edit Info");
				JButton removeP = new JButton("Remove Product");
				JButton viewP = new JButton("View Products");
				JPanel frame5 = new JPanel();
				JPanel frame6 = new JPanel();
				JPanel frame7 = new JPanel();
				JPanel frame8 = new JPanel();

				frame5.add(addP);
				frame6.add(editP);
				frame7.add(removeP);
				frame8.add(viewP);
				P1.add(mess);
				P1.add(frame5);
				P1.add(frame6);
				P1.add(frame7);
				P1.add(frame8);

				P2.setLayout(new GridLayout(5, 1));
				final JTextField idp = new JTextField("ID");
				final JTextField namep = new JTextField("Name");
				final JTextField quanp = new JTextField("Quantity");
				final JTextField pricep = new JTextField("Price");

				P2.add(idp);
				P2.add(namep);
				P2.add(quanp);
				P2.add(pricep);

				// PRODUCT AL
				addP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Product current = new Product(Integer.parseInt(idp.getText()), namep.getText(),
								Integer.parseInt(quanp.getText()), Integer.parseInt(pricep.getText()));
						ProductDAO.addProduct(current);
					}
				});
				editP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Product current = new Product(Integer.parseInt(idp.getText()), namep.getText(),
								Integer.parseInt(quanp.getText()), Integer.parseInt(pricep.getText()));
						ProductDAO.updateProduct(current);
					}
				});
				removeP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Product current = new Product(Integer.parseInt(idp.getText()), namep.getText(),
								Integer.parseInt(quanp.getText()), Integer.parseInt(pricep.getText()));
						ProductDAO.removeClient(current);
					}
				});
				viewP.addActionListener(new ActionListener() {
					int j = 0;

					public void actionPerformed(ActionEvent e) {
						ArrayList<Product> current = new ArrayList<Product>();
						current = ProductDAO.FetchInfo();
						j++;
						Object rowData[][] = new Object[100][100];
						int k = 0;
						for (Product x : current) {
							k++;
							rowData[k - 1][0] = x.getId();
							rowData[k - 1][1] = x.getName();
							rowData[k - 1][2] = x.getQuantity();
							rowData[k - 1][3] = x.getPrice();

						}

						Object columnNames[] = { "ID", "Name", "Quantity", "Price" };
						JTable viewp = new JTable(rowData, columnNames);
						JScrollPane scrollPane = new JScrollPane(viewp);
						if (j == 1)
							P2.add(scrollPane);
						P2.repaint();
					}
				});

				ProductWindow.add(P1);
				ProductWindow.add(P2);
			}
		});

		/////// ORDER AREA//////////////////
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame OrderWindow = new JFrame();
				OrderWindow.setLayout(new GridLayout(1, 2));
				OrderWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
				OrderWindow.setSize(700, 400);
				OrderWindow.setVisible(true);
				JPanel o1 = new JPanel();
				o1.setLayout(new GridLayout(4, 1));
				JLabel selc = new JLabel("Select Client ID:");
				final JTextField selectC = new JTextField();
				JLabel selp = new JLabel("Select Product ID:");
				final JTextField selectP = new JTextField();
				JLabel selq = new JLabel("Select Quantity:");
				final JTextField orderquantity = new JTextField();
				JPanel frame9 = new JPanel();
				frame9.setLayout(new GridLayout(1, 2));
				JPanel frame10 = new JPanel();
				frame10.setLayout(new GridLayout(1, 2));
				JPanel frame11 = new JPanel();
				frame11.setLayout(new GridLayout(1, 2));
				JPanel frame12 = new JPanel();
				JButton order = new JButton("Place Order");
				frame9.add(selc);
				frame9.add(selectC);
				frame10.add(selp);
				frame10.add(selectP);
				frame11.add(selq);
				frame11.add(orderquantity);
				frame12.add(order);
				o1.add(frame9);
				o1.add(frame10);
				o1.add(frame11);
				o1.add(frame12);
				OrderWindow.add(o1);

				order.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						String mes = Operations.PlaceOrder(Integer.parseInt(selectC.getText()),
								Integer.parseInt(selectP.getText()), Integer.parseInt(orderquantity.getText()));
						JFrame message = new JFrame();
						message.setDefaultCloseOperation(EXIT_ON_CLOSE);
						message.setSize(100, 100);
						message.setVisible(true);
						JLabel o = new JLabel(mes);
						message.add(o);
						

					}
				});
			}
		});
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
