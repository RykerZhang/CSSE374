package solution;

import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;

import solution.observers.Observer;
import solution.observers.Subject;

public class MyOtherFrame extends JFrame{
	HashMap<Subject, Integer> counts = new HashMap<>();
	int sum;
	JLabel sumLabel;

	private void updateSumLabel() {
		String sumText = "sum: %d";
		sumLabel.setText(String.format(sumText, sum));
	}

	public MyOtherFrame() {
		super();
		int nPanels = 2;
		this.setLayout(new FlowLayout());

		sumLabel = new JLabel();
		updateSumLabel();

		this.add(sumLabel);

		Observer countObserver = (Observer) (Subject subject, int newValue) -> {
			int oldValue = counts.getOrDefault(subject, 0);
			counts.put(subject, newValue);
			sum = sum - oldValue + newValue;
		
			updateSumLabel();
			this.pack();
		};
		
		for (int i = 0; i < nPanels; i++) {
			CountingPanel panel = new CountingPanel();
			
			panel.registerObserver(countObserver);
			
			this.add(panel);
		}

		this.pack();

	}
}
