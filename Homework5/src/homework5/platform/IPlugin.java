package homework5.platform;

import javax.swing.*;

public interface IPlugin {
	Platform p = new Platform();
	public void setPlatform(Platform pl);
	public JPanel show();
	public String getStatus();
	public String getTitle();
}
