package problem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class CountingPanel extends JPanel {
	int count;
	public CountingPanel(){
		super();
		JButton button = new JButton("0");
		button.addActionListener((ActionEvent e) -> {
			count++;
			button.setText(Integer.toString(count));
		});
		this.add(button);
	}
}
