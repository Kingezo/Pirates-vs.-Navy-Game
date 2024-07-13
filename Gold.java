package a9pt2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Gold {
	
	private int gold;
	
	
	public Gold (){
	
		
		
		
	}
	public int getGold() {
	
		return gold;
	}
	
	public void setGold(int resource) {
		this.gold = resource;
		
	}
	 public void goldIncreaseRate() {
	     gold += 50;
	    		
	    }
	 
	 public String toString() {
		 return "Doubloons: " + gold;
	 }
}

