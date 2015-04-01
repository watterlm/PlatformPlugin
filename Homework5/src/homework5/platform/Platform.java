package homework5.platform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class Platform {
	private final int maxConsoleLines = 9; 
	private final int maxShowablePlugins = 10;
	
	JFrame window;
	JPanel listPanel;
	JPanel statusPanel;
	JPanel displayPanel;
	JLabel statusLabel;
	JButton resetList;
	JButton runPlugin;
	
	ArrayList<String> statusConsoleHistory;
	ArrayList<String> pluginNames;
	public Platform(){
		loadPluginList();
		
		window = new JFrame();
		window.setTitle("Homework 5 Plugin Project");
		window.setPreferredSize(new Dimension(800, 800));
		window.setResizable(false);
		
		listPanel = new JPanel(new GridLayout(maxShowablePlugins+2,0,10,5));
		listPanel.setBackground(Color.LIGHT_GRAY);
		listPanel.setPreferredSize(new Dimension(150, 700));
		resetList = new JButton("Reload Plugins");
		resetList.setBounds(10,10,100,100);
			
		listPanel.add(resetList);
		//JSeparator line = new JSeparator();
		//listPanel.add(line);
		JPanel empty = new JPanel();
		empty.setVisible(false);
		listPanel.add(empty);
		for(int i = 0; i<pluginNames.size() && i<maxShowablePlugins; i++)
		{
			runPlugin = new JButton(pluginNames.get(i));
			listPanel.add(runPlugin);
		}	
			
			
		statusPanel = new JPanel();
		statusPanel.setBackground(Color.LIGHT_GRAY);
		statusPanel.setPreferredSize(new Dimension(800, 200));
		statusPanel.setBorder(BorderFactory.createTitledBorder("Status Window"));
		statusLabel = new JLabel("");
		statusLabel.setPreferredSize(new Dimension(760, 160));
		statusLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		statusLabel.setBackground(Color.WHITE);
		statusLabel.setOpaque(true);
		statusLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		statusPanel.add(statusLabel,BorderLayout.CENTER);
		
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.GREEN);
		 	
		window.add(statusPanel,BorderLayout.SOUTH);
		window.add(displayPanel,BorderLayout.CENTER);
		window.add(listPanel,BorderLayout.WEST);
		window.pack();
		window.setVisible(true);
		
		statusConsoleHistory = new ArrayList<String>();
		printStatus("Welcome to Plugin Project!");
		if(pluginNames.size()>maxShowablePlugins)
		{
			printStatus("More than " +  maxShowablePlugins + " Plugins Found! Only showing the first " + maxShowablePlugins + ".");
		}
		
		/*
		//testing
		JPanel testPanel = new JPanel();
		testPanel.setBackground(Color.BLUE);
		updateDisplayPanel(testPanel);			
		//
		*/
	}
	
	public void printStatus(String str){
		statusConsoleHistory.add(str);
		int statusSize = statusConsoleHistory.size();
		String text = "<HTML>";
		for (int i = statusSize-maxConsoleLines; i<statusSize; i++)
		{
			if (i<0)
				i = 0;
			text += statusConsoleHistory.get(i) + "<br>";
		}
		for (int i = statusSize; i<maxConsoleLines; i++)
		{
			text += "<br>";
		}
		text += "</HTML>";
		statusLabel.setText(text);
	}
	
	public void loadPluginList(){
		pluginNames = new ArrayList<String>();
		
		//find files and add from getName()
		pluginNames.add("Hello World Plugin");
		pluginNames.add("Plugin 2");
		pluginNames.add("Plugin 3");
		for(int x=4;x<14;x++)
		{
			pluginNames.add("Plugin "+ x);
		}
		
	}
	
	//replaces the current display panel with the new one
	public void updateDisplayPanel(JPanel newPanel){
		window.remove(displayPanel);
		displayPanel = newPanel;
		window.add(displayPanel,BorderLayout.CENTER);
		
	}
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Platform p = new Platform();
			}
		});
	}
}
