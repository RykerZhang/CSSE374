package solution;

public class Main {
	public static void main(String[] args){
		MyFrame myFrame = new MyFrame();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		MyOtherFrame MOF = new MyOtherFrame();
		MOF.setLocation(100,100);
		MOF.setVisible(true);
		
		SomeoneElsesFrame otherFrame = new SomeoneElsesFrame(10);
		otherFrame.setVisible(true);
		
		myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
		//MOF.setDefaultCloseOperation(MOF.EXIT_ON_CLOSE);

	}
}
