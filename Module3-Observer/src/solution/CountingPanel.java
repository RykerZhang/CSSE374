package solution;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import solution.observers.Observer;
import solution.observers.Subject;

public class CountingPanel extends JPanel implements Subject {
	private int count;
	ArrayList<Observer> observers;

	public CountingPanel() {
		super();
		observers = new ArrayList<>();
		JButton button = new JButton("0");
		button.addActionListener((ActionEvent e) -> {
			count++;
			button.setText(Integer.toString(count));
			this.notifyObservers();
		});
		this.add(button);
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers){
			o.update(this, count);
		}
	}
}
