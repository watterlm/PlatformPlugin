package edu.rosehulman.pluginplatform;

import java.io.File;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

public class PluginPlatform {

	protected Shell PluginPlatform;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File currentDirectory = new File("");
			String commonPath = currentDirectory.getAbsolutePath();
			commonPath = commonPath.substring(commonPath.lastIndexOf(File.separator) + 1);
			File pluginDir = new File(commonPath + "plugin");
			if (!pluginDir.exists() || !pluginDir.isDirectory()){
				pluginDir.mkdirs();
			}
			
			PluginPlatform window = new PluginPlatform();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		PluginPlatform.open();
		PluginPlatform.layout();
		while (!PluginPlatform.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		PluginPlatform = new Shell();
		PluginPlatform.setSize(450, 380);
		PluginPlatform.setText("SWT Application");
		
		ScrolledComposite listView = new ScrolledComposite(PluginPlatform, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listView.setBounds(10, 38, 85, 294);
		listView.setExpandHorizontal(false);
		listView.setExpandVertical(true);
		
		Composite statusView = new Composite(PluginPlatform, SWT.NONE);
		statusView.setBounds(101, 232, 323, 100);
		
		Composite executionView = new Composite(PluginPlatform, SWT.NONE);
		executionView.setBounds(101, 38, 323, 188);
		
		Button btnAddPlugin = new Button(PluginPlatform, SWT.NONE);
		btnAddPlugin.setBounds(10, 7, 85, 25);
		btnAddPlugin.setText("Add Plugin");

	}
}
