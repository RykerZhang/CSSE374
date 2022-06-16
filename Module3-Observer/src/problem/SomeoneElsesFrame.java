package problem;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class SomeoneElsesFrame extends JFrame {
	// I REALLY don't want to know about MyFrame!
	public SomeoneElsesFrame(int nPanels) {
		super();
		this.setLayout(new FlowLayout());

		for (int i = 0; i < nPanels; i++) {
			CountingPanel panel = new CountingPanel();
			this.add(panel);
		}
		this.setTitle("Someone else's frame");
		
		this.pack();
	}
}
