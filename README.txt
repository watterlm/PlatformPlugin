Homework 5 - Plugin Platform
Logan Hallowell and Lindsey Watterson

Run Platform.java in the Homework5 Eclipse project to execute.
The existing plugins are loaded and displayed in a list. Each plugin has
a button which loads it into the main screen. Both the platform and the
plugins can print to the console at the bottom of the screen. The reload
button refreshes the list of available plugins. The add button allows the 
user to add their own plugin from a jar file, which is then copied into 
the platform's directory.

To add new plugins for this platform, your plugin class must inherit 
IPlugin from the Homework 5 project. Plugins can call the printStatus
after loading the platform to print to the platform's status window. 
Create a jar file of the project. Then,copy it to the plugin folder of 
the Homework5 project or add it using the Add button in the GUI.