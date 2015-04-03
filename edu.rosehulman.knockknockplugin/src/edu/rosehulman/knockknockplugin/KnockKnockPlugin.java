package edu.rosehulman.knockknockplugin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import homework5.platform.IPlugin;
import homework5.platform.Platform;

public class KnockKnockPlugin implements IPlugin {
	Platform p;
	JPanel display;
	String title = "Knock Knock Plugin";
	JButton line;
	JButton response;
	
	private int jokePart = 1;
	private KnockKnockJoke currentJoke;
	
	private ArrayList<KnockKnockJoke> jokes = new ArrayList<KnockKnockJoke>();
	
	public KnockKnockPlugin(){
		setJokes();
		p.printStatus("Set Jokes. Time for some fun.");
		
		getJoke();
		
		//set up display
		display = new JPanel(new BorderLayout());
		display.setBackground(Color.GRAY);
		final JLabel titleLabel = new JLabel("Counter Plugin");
		
		JPanel centerPanel = new JPanel();//new BorderLayout());
		centerPanel.setSize(new Dimension(500, 100));
		centerPanel.setBackground(Color.GRAY);
		
		line = new JButton(currentJoke.getLine());
		line.setPreferredSize(new Dimension(300, 75));
		line.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent ae) {
				  jokePart++;
				  if (jokePart > 5){
					  jokePart = 1;
					  getJoke();
				  }
				  line.setText(currentJoke.getLine());
				  p.printStatus("Got new line for joke.");
			  }
			});
		display.add(titleLabel,BorderLayout.NORTH);
		centerPanel.add(line,BorderLayout.CENTER);
		
		display.add(centerPanel,BorderLayout.CENTER);
		display.setVisible(true);
		
	}
	@Override
	public void setPlatform(Platform pl) {
		p = pl;

	}

	@Override
	public JPanel show() {
		return display;
	}

	@Override
	public String getStatus() {
		return title;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	private void getJoke(){
		p.printStatus("Getting a random joke.");
		currentJoke = jokes.get(randIndex());
	}

	private int randIndex(){
		Random rand = new Random();
		return rand.nextInt(jokes.size() + 1);
	}
	
	private void setJokes(){
		jokes.add(new KnockKnockJoke("Orange","Orange you going to let me in?"));
		jokes.add(new KnockKnockJoke("Anee","Anee one you like!"));
		jokes.add(new KnockKnockJoke("Dozen","Dozen anybody want to let me in?"));
		jokes.add(new KnockKnockJoke("Needle","Needle little money for the movies."));
		jokes.add(new KnockKnockJoke("Adore","Adore is between us. Open up!"));
		jokes.add(new KnockKnockJoke("Otto","Otto know. I've got amnesia."));
		jokes.add(new KnockKnockJoke("Robin","Robin the piggy bank again."));
	}
}
