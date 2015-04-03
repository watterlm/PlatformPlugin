package edu.rosehulman.helloworldplugin;
import homework5.platform.IPlugin;
import homework5.platform.Platform;

import javax.swing.*;


public class HelloWorldPlugin implements IPlugin{
	Platform p;
	JPanel display;
	String title = "Hello World Plugin";
	public HelloWorldPlugin(){
		
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

	@Override
	public void setPlatform(Platform pl) {
		p = pl;
	}

}
