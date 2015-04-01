import javax.swing.*;


public class HelloWorldPlugin implements IPlugin{

	JPanel display;
	String title = "Hello World Plugin";
	HelloWorldPlugin(){
		
		//set up display
		display = new JPanel();
		JLabel helloWorldLabel = new JLabel("Hello World!");
		display.add(helloWorldLabel);
	}
	
	@Override
	public JPanel show() {
		return display;
	}

	@Override
	public String getStatus() {
		return "HelloWorld";
	}

	@Override
	public String getTitle() {
		return title;
	}

}
