package a9pt2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import a8.Opponent;
import a8.RandomOpponent;

public class PlantPanel extends JPanel implements ActionListener {

	private JRadioButton pirateShip = new JRadioButton("Pirate Ship");
    private JRadioButton blackShip = new JRadioButton("Black Ship");
    private PlantType plantType = PlantType.PIRATESHIP;
    
    
    public PlantPanel () {
    	
    	// Add this as a listener, so it can receive events
        // when either button is clicked.
        pirateShip.addActionListener(this);
        blackShip.addActionListener(this);
        add(pirateShip);
        add(blackShip);
        setLayout(new GridLayout(2, 1));
        
        
        ButtonGroup group = new ButtonGroup();
        pirateShip.setSelected(true);
        group.add(pirateShip);
        group.add(blackShip);
    }
    
   public PlantType getPlantType() {
	   return plantType;
   }
    
 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pirateShip) {
            plantType = PlantType.PIRATESHIP;
	}	
		if(e.getSource() == blackShip) {
			plantType = PlantType.BLACKSHIP;
		}
	}

}
