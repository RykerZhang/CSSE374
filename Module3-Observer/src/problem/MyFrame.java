package problem;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	int lastpanel1count = 0;
	int lastpanel2count = 0;

	public MyFrame() {
		super();
		this.setLayout(new FlowLayout());

		JLabel sum = new JLabel("sum: 0");

		CountingPanel panel1 = new CountingPanel();
		CountingPanel panel2 = new CountingPanel();

		this.add(sum);
		this.add(panel1);
		this.add(panel2);
		this.pack();

		// pull data from panels
		// FIXME: have panels PUSH data to this frame, instead of making this frame PULL data from the implementation details of the panels. 
		Thread watcher = new Thread(() -> {
			while (true) {
				if (panel1.count > lastpanel1count) {
					lastpanel1count = panel1.count;
					sum.setText("sum: "
							+ Integer.toString(lastpanel1count
									+ lastpanel2count));
				} else if (panel2.count > lastpanel2count) {
					lastpanel2count = panel2.count;
					sum.setText("sum: "
							+ Integer.toString(lastpanel1count
									+ lastpanel2count));
				}

				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					break;
				}
			}
		});
		watcher.start();

		// Why don't we call this stuff here?
		// this.setLocationRelativeTo(null);
		// setVisible(true);
	}
}
