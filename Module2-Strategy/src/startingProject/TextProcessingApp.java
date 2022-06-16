package startingProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextProcessingApp {
	public String text;
	public JFrame jFrame;
	
	public JPanel contentPane;
	public JTextArea sourceTextArea;
	public JTextArea resultTextArea;

	public JPanel buttonPanel;
	public JButton findButton;
	public JButton capitalizeButton;

	public TextProcessingApp(String text) {
		this.text = text;
		
		// Setup GUI
		jFrame = new JFrame("Text Processor");
		contentPane = (JPanel)jFrame.getContentPane();
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
		contentPane.add(buttonPanel, BorderLayout.NORTH);

		findButton = new JButton("Find");
		buttonPanel.add(findButton);
		
		capitalizeButton = new JButton("Transform");
		buttonPanel.add(capitalizeButton);
		
		JPanel mainTextPanel = new JPanel();
		mainTextPanel.setLayout(new GridLayout(2,1));
		contentPane.add(mainTextPanel, BorderLayout.CENTER);

		sourceTextArea = new JTextArea(this.text);
		sourceTextArea.setPreferredSize(new Dimension(600, 300));
		JPanel sourcePanel = new JPanel(new BorderLayout());
		sourcePanel.setBorder(BorderFactory.createTitledBorder("Application Input"));
		mainTextPanel.add(sourcePanel);
		
		JScrollPane sourceScrollPane = new JScrollPane(sourceTextArea);
		sourcePanel.add(sourceScrollPane);
		
		JPanel resultPanel = new JPanel(new BorderLayout());
		resultPanel.setBorder(BorderFactory.createTitledBorder("Application Output"));
		mainTextPanel.add(resultPanel);
		
		resultTextArea = new JTextArea();
		resultTextArea.setPreferredSize(new Dimension(600, 300));
		JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
		resultPanel.add(resultScrollPane);
		
		// Setup button actions
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String subText = JOptionPane.showInputDialog(jFrame, 
						"Please enter the search string", 
						"Search String Input", 
						JOptionPane.QUESTION_MESSAGE);
				
				int index = find(subText);
				
				String message = String.format("Sorry! Cannot find the string '%s'!", subText);
				if(index > -1) 
					message = String.format("The first occurance of string was found at index: %d", index);
				resultTextArea.setText(message);
			}
		});
		
		capitalizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = transform();
				resultTextArea.setText(result);
			}
		});
		
		// Show GUI
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	public int find(String subText) {
		return this.text.indexOf(subText);
	}
	
	public String transform() {
		return this.text.toUpperCase();
	}

	
	public static void main(String[] args) {
		TextProcessingApp processor = new TextProcessingApp("This is a sample text. It will be processed by this application.");
	}
}
