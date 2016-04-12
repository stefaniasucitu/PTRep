
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SimulatorFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public static int limit; // 20 00
	public static int minProcTime;
	public static int maxProcTime;

	public SimulatorFrame() {

		this.setLayout(new GridLayout(2, 1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setVisible(true);
		panel = new JPanel();
		panel.setSize(200, 200);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 1));
		JPanel a1 = new JPanel();
		JPanel a2 = new JPanel();
		JPanel a3 = new JPanel();
		JPanel a4 = new JPanel();
		JButton b1 = new JButton("limit");
		JButton b2 = new JButton("minimum");
		JButton b3 = new JButton("maximum");
		JButton b4 = new JButton("Start");
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		t1.setPreferredSize(new Dimension(90, 40));
		t2.setPreferredSize(new Dimension(90, 40));
		t3.setPreferredSize(new Dimension(90, 40));
		a1.add(b1);
		a1.add(t1);
		a2.add(b2);
		a2.add(t2);
		a3.add(b3);
		a3.add(t3);
		a4.add(b4);
		panel2.add(a1);
		panel2.add(a2);
		panel2.add(a3);
		panel2.add(a4);
		this.add(panel2);
		this.add(panel);

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limit = Integer.parseInt(t1.getText());
				minProcTime = Integer.parseInt(t2.getText());
				maxProcTime = Integer.parseInt(t3.getText());
				Simulator sim = new Simulator(limit, minProcTime, maxProcTime);
				Thread th = new Thread(sim);
				th.start();
			}
		});
	}

	void displayData1(Task[] tasks) {
		panel.removeAll();
		panel.revalidate();
		JList<Task> jtasks1 = new JList<Task>(tasks);
		JScrollPane scroll1 = new JScrollPane(jtasks1);
		scroll1.setPreferredSize(new Dimension(200, 200));
		panel.add(scroll1);

	}

	void displayData2(Task[] tasks) {
		JList<Task> jtasks1 = new JList<Task>(tasks);
		JScrollPane scroll2 = new JScrollPane(jtasks1);
		scroll2.setPreferredSize(new Dimension(200, 200));
		panel.add(scroll2);

	}

	void displayData3(Task[] tasks) {
		JList<Task> jtasks1 = new JList<Task>(tasks);
		JScrollPane scroll3 = new JScrollPane(jtasks1);
		scroll3.setPreferredSize(new Dimension(200, 200));
		panel.add(scroll3);
	}

	void displayData4(Task[] tasks) {
		JList<Task> jtasks1 = new JList<Task>(tasks);
		JScrollPane scroll4 = new JScrollPane(jtasks1);
		scroll4.setPreferredSize(new Dimension(200, 200));
		panel.add(scroll4);
	}

	void displayData5(Task[] tasks) {
		JList<Task> jtasks1 = new JList<Task>(tasks);
		JScrollPane scroll5 = new JScrollPane(jtasks1);
		scroll5.setPreferredSize(new Dimension(200, 200));
		panel.add(scroll5);
		panel.repaint();
		panel.revalidate();
	}
}
