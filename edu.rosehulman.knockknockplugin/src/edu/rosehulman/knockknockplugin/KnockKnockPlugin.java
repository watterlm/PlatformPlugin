package edu.rosehulman.knockknockplugin;

import homework5.platform.IPlugin;
import homework5.platform.Platform;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KnockKnockPlugin implements IPlugin{
	Platform p;
	JPanel display;
	String title = "Knock Knock Plugin";
	public KnockKnockPlugin(){
		
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
