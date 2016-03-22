package student.polynom.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import student.polynoms.Operation;
import student.polynoms.entities.CoeffDegree;
import student.polynoms.entities.Polynom;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JTextField p1 = new JTextField();
	JTextField p2 = new JTextField();
	JTextField res = new JTextField();
	String pol1;
	String pol2;

	public Window() {
		JFrame Window = new JFrame();
		Window.setLayout(new GridLayout(4, 1));
		Window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Window.setSize(300, 500);
		Window.setVisible(true);

		JPanel Polyn1 = new JPanel();
		JPanel Polyn2 = new JPanel();
		JPanel Oper = new JPanel();
		JPanel Result = new JPanel();

		// Polyn1 area
		JButton t1 = new JButton("P1:");
		p1.setPreferredSize(new Dimension(150, 40));
		Polyn1.add(t1);
		Polyn1.add(p1);

		// Polyn2 area
		JButton t2 = new JButton("P2:");
		p2.setPreferredSize(new Dimension(150, 40));
		Polyn2.add(t2);
		Polyn2.add(p2);

		// Operations area
		JButton sum = new JButton("+");
		JButton sub = new JButton("-");
		JButton mul = new JButton("*");
		JButton div = new JButton("/");
		JButton der = new JButton("diff");
		JButton integ = new JButton("intgr");

		sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pol1 = p1.getText();
				pol2 = p2.getText();
				Polynom Pol1 = new Polynom(pol1);
				Polynom Pol2 = new Polynom(pol2);
				Polynom result = Operation.addPolynoms(Pol1, Pol2);
				DisplayResult(result);
			}
		});
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pol1 = p1.getText();
				pol2 = p2.getText();
				Polynom Pol1 = new Polynom(pol1);
				Polynom Pol2 = new Polynom(pol2);
				Polynom result = Operation.substractPolynoms(Pol1, Pol2);
				DisplayResult(result);
			}
		});
		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pol1 = p1.getText();
				pol2 = p2.getText();
				Polynom Pol1 = new Polynom(pol1);
				Polynom Pol2 = new Polynom(pol2);
				Polynom result = Operation.multiplyPolynoms(Pol1, Pol2);
				DisplayResult(result);
			}
		});
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pol1 = p1.getText();
				pol2 = p2.getText();
				Polynom Pol1 = new Polynom(pol1);
				Polynom Pol2 = new Polynom(pol2);
				Polynom result = Operation.dividePolynoms(Pol1, Pol2);
				DisplayResult(result);
			}
		});
		der.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pol1 = p1.getText();
				Polynom Pol1 = new Polynom(pol1);
				Polynom result = Operation.differentiatePolynoms(Pol1);
				DisplayResult(result);
			}
		});
		integ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pol1 = p1.getText();
				Polynom Pol1 = new Polynom(pol1);
				Polynom result = Operation.integratePolynoms(Pol1);
				DisplayResult(result);
			}
		});

		Oper.add(sum);
		Oper.add(sub);
		Oper.add(mul);
		Oper.add(div);
		Oper.add(der);
		Oper.add(integ);

		// Result area
		JButton r = new JButton("Result:");
		res.setPreferredSize(new Dimension(270, 40));
		res.setEditable(false);
		Result.add(r);
		Result.add(res);

		Window.add(Polyn1);
		Window.add(Polyn2);
		Window.add(Oper);
		Window.add(Result);
	}

	private void DisplayResult(Polynom polynom) {
		String output = "";
		for (CoeffDegree x : polynom.p1) {
			if (x.getCoeff()==0)
				output+="";
			else {
			if (x.getCoeff()<0)
				output+=+x.getCoeff() + "x^" + x.getDegree();
			else
			output += "+" + x.getCoeff() + "x^" + x.getDegree();
		}}
		res.setText(output);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
