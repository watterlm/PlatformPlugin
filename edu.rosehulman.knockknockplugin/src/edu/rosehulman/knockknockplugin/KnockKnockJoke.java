package edu.rosehulman.knockknockplugin;

public class KnockKnockJoke {
	private String line1 = "Knock Knock";
	private String response1 = "Who's there?";
	private String line2;
	private String response2;
	private String line3;
	
	private int currentLine = 0;
	
	public KnockKnockJoke(String line2, String line3){
		this.line2 = line2;
		this.response2 = line2 + " who?";
		this.line3 = line3;
	}
	
	public String getLine(){
		switch(currentLine){
			case 0:
				currentLine ++;
				return this.line1;
			case 1:
				currentLine ++;
				return this.response1;
			case 2:
				currentLine ++;
				return this.line2;
			case 3:
				currentLine ++;
				return this.response2;
			case 4:
				currentLine = 0;
				return this.line3;
			default:
				return "";
		}
	}
	
	
}
