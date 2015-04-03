package edu.rosehulman.colorplugin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homework5.platform.IPlugin;
import homework5.platform.Platform;

import javax.swing.*;


public class ColorChangerPlugin implements IPlugin{
	Platform p;
	JPanel display;
	String title = "Color Changer Plugin";
	public ColorChangerPlugin(){
		
		//set up display
		display = new JPanel();
		display.setBackground(Color.GRAY);
		final JLabel titleLabel = new JLabel("Color Changer");
		titleLabel.setBackground(Color.LIGHT_GRAY);
		
		JButton redButton = new JButton("RED");
		redButton.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent ae) {
				  display.setBackground(Color.RED);
			  }
			});
		
		JButton blueButton = new JButton("BLUE");
		blueButton.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent ae) {
				  display.setBackground(Color.BLUE);
			  }
			});
		
		JButton greenButton = new JButton("GREEN");
		greenButton.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent ae) {
				  display.setBackground(Color.GREEN);
			  }
			});
		
		
		display.add(titleLabel);
		display.add(redButton, BorderLayout.WEST);
		display.add(blueButton, BorderLayout.CENTER);
		display.add(greenButton, BorderLayout.EAST);
		display.setVisible(true);
	}
	

	@Override
	public JPanel show() {
		return display;
	}

	@Override
	public String getStatus() {
		return "Color Changer";
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