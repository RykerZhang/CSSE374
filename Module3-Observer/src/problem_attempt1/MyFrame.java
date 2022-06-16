package problem_attempt1;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	int[] counts = new int[2];
	JLabel sumLabel = null;

	void updateSumLabel() {
		String sumText = "sum: %d";
		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			sum += counts[i];
		}
		sumLabel.setText(String.format(sumText, sum));
	}

	public MyFrame() {
		super();
		this.setLayout(new FlowLayout());

		sumLabel = new JLabel("sum: 0");

		CountingPanel panel1 = new CountingPanel(this, 0);
		CountingPanel panel2 = new CountingPanel(this, 1);

		this.add(sumLabel);
		this.add(panel1);
		this.add(panel2);
		this.pack();

		// Why don't we call this stuff here?
		// this.setLocationRelativeTo(null);
		// setVisible(true);
	}
}
