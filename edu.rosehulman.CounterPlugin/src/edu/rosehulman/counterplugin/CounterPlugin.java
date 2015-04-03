package edu.rosehulman.counterplugin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homework5.platform.IPlugin;
import homework5.platform.Platform;

import javax.swing.*;


public class CounterPlugin implements IPlugin{
	Platform p;
	JPanel display;
	String title = "Counter Plugin";
	int cnt;
	public CounterPlugin(){
		cnt = 0;
		//set up display
		display = new JPanel(new BorderLayout());
		display.setBackground(Color.GRAY);
		final JLabel titleLabel = new JLabel("Counter Plugin");
		
		JPanel centerPanel = new JPanel();//new BorderLayout());
		centerPanel.setSize(new Dimension(500, 100));
		centerPanel.setBackground(Color.GRAY);
		final JLabel counterLabel = new JLabel(cnt+"");
		counterLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		
		JButton plus = new JButton("+");
		plus.setPreferredSize(new Dimension(75, 75));
		plus.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent ae) {
				  cnt++;
				  counterLabel.setText(cnt+"");
			  }
			});
		JButton minus = new JButton("-");
		minus.setPreferredSize(new Dimension(75, 75));	
		minus.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent ae) {
				  cnt--;
				  counterLabel.setText(cnt+"");
				  p.printStatus("minus");
			  }
			});
		display.add(titleLabel,BorderLayout.NORTH);
		centerPanel.add(plus,BorderLayout.EAST);
		centerPanel.add(counterLabel,BorderLayout.CENTER);
		centerPanel.add(minus,BorderLayout.WEST);
		
		display.add(centerPanel,BorderLayout.CENTER);
		display.setVisible(true);
		

	}
	

	@Override
	public JPanel show() {
		return display;
	}

	@Override
	public String getStatus() {
		return "Counter Plugin";
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