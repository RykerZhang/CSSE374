package problem_attempt1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class CountingPanel extends JPanel {
	int count;
	// FIXME: should all CountingPanels really need MyFrames, specifically, to be created?
	// 			What does SomeoneElsesFrame think about this?
	public CountingPanel(MyFrame frame, int i){
		super();
		JButton button = new JButton("0");
		button.addActionListener((ActionEvent e) -> {
			count++;
			button.setText(Integer.toString(count));
			frame.counts[i]++;
			frame.updateSumLabel();
		});
		this.add(button);
	}
}
