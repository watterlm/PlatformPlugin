package homework5.platform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import javax.swing.*;

public class Platform{
	private final int maxConsoleLines = 9; 
	private final int maxShowablePlugins = 10;
	private static String pluginFolderPath;
	
	// array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "jar"
    };
    // filter to identify images based on their extensions
    final FilenameFilter JAR_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
	
	JFrame window;
	JPanel listPanel;
	JPanel statusPanel;
	JPanel displayPanel;
	JLabel statusLabel;
	JButton resetList;
	JButton runPlugin;
	
	ArrayList<String> statusConsoleHistory;
	ArrayList<IPlugin> plugins;
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
		for(int i = 0; i<plugins.size() && i<maxShowablePlugins; i++)
		{
			runPlugin = new JButton(plugins.get(i).getTitle());
			final IPlugin plugin = plugins.get(i);
			runPlugin.addActionListener(new ActionListener() {
				  @Override
				  public void actionPerformed(ActionEvent ae) {
				    updateDisplayPanel(plugin.show());
				    printStatus(plugin.getStatus());
				  }
				});
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
		if(plugins.size()>maxShowablePlugins)
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
		plugins = new ArrayList<IPlugin>();
		
		//find files and add from getName()
		File dir = new File("pluginFolderPath");
		
		try {
			for (final File f: dir.listFiles(JAR_FILTER)){
				ClassLoader pluginLoader;
		
		        pluginLoader = URLClassLoader.newInstance(new URL[] { f.toURI().toURL() });
		        
		        JarFile jf = new JarFile(f.getName());
		        Manifest manifest = jf.getManifest();
		        Attributes att = manifest.getMainAttributes();
		        String pluginClassName = att.getValue("Plugin-Name");
		        
		        IPlugin plugin;
		        plugin = (IPlugin) pluginLoader.loadClass(
				                pluginClassName).newInstance();
	
		        plugins.add(plugin);
	        }
		} catch(Exception e){
			
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
				try {
					File currentDirectory = new File("");
					String commonPath = currentDirectory.getAbsolutePath();
					commonPath = commonPath.substring(commonPath.lastIndexOf(File.separator) + 1);

					pluginFolderPath = commonPath + "\\plugin";
					File pluginDir = new File(pluginFolderPath);
					if (!pluginDir.exists() || !pluginDir.isDirectory()){
						pluginDir.mkdirs();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				Platform p = new Platform();
			}
		});
	}
}
