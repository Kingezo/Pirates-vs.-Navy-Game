package a9pt2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * A top-level panel for playing a game similar to Plants Vs Zombies.
 * 
 * This panel is primarily responsible for coordinating the various
 * aspects of the game, including:
 * - Running the game step-by-step using a timer
 * - Creating and displaying other components that make up the game
 * - Creating new plants and/or zombies, when necessary
 * 
 * @author Travis Martin and David Johnson
 */
@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, MouseListener {
	private static final int NUM_ROWS = 5;
	private static final int NUM_COLS = 7;
	private static final int GRID_BUFFER_PIXELS = 20;
	private static final int CELL_SIZE = 75;
	private static final int STEP_TIME= 20;
	private JLabel display;
	private int counter = 0;
	private Gold gold = new Gold();
	private PlantPanel plantPanel;
	
	
	private Random generator = new Random();
	
	
	/**
	 * This panel is responsible for displaying plants
	 * and zombies, and for managing their interactions.
	 */
	private ActorDisplay actorDisplay = new ActorDisplay(
	        NUM_COLS * CELL_SIZE + GRID_BUFFER_PIXELS * 2,
	        NUM_ROWS * CELL_SIZE + GRID_BUFFER_PIXELS * 2);


	/**  This game is called Pirates Vs. Marines.
	 * ARGGGGHHH! The pirates vessels are docked near a shore and the marines are coming to fight off the pirates and commandeer the island.
	 * Defend the pirates base by shooting the cannons and fighting of the other sailors Me Mateys.
	 * 
	 */
	private Game() {
		addMouseListener(this);
	    add(actorDisplay);
	    plantPanel = new PlantPanel();
	    add(plantPanel);
	    
	    // This layout causes all elements to be stacked vertically
	    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    
		// The timer calls the actionPerformed method every STEP_TIME milliseconds
		Timer timer = new Timer(STEP_TIME, this);
		timer.start();
		display = new JLabel();
		this.add(display);
	
		
		// This adds a plant to every row
//		for (int i = 0; i < NUM_ROWS; i++) {
//		    addPlant(0, i);
//		}
		
//		addZombie(7, 3);
	}

	/**
	 * Executes game logic every time the timer ticks.
	 */
    @Override
    public void actionPerformed(ActionEvent e) {
        actorDisplay.step();
        
       
        // Use AND (&&) statement here to add if resource is enough, mouseClickedStatus
//        if (gold.getGold() >= 100 && mouseClickState) {
//        	addPlant(pixelToGrid(actorDisplay.getX()), pixelToGrid(actorDisplay.getY()));

//        	
//        }
        if (generator.nextInt(100) > 98) {
        	addZombie(NUM_COLS, generator.nextInt(NUM_ROWS));
        }
        counter += 1;
        // I think Tanner negated this
//      if (counter == 250) {
//        gold.goldIncreaseRate();
//       
//      }
        gold.setGold(counter);
        display.setText(gold.toString());  //our call to the gold resource
       
    }
	
    /**
     * Adds a plant to the official game grid & display panel.
     */
	private void addPlant(int col, int row) {
	    // The magic numbers below define various hardcoded plant properties
        actorDisplay.addActor(new Plant(
                gridToPixel(col), gridToPixel(row), CELL_SIZE * 4 / 5, 
                "src/a9pt2/Pirate Ship.png", 150, 5, 1));
	}
	
    /**
     * Adds a zombie to the official game grid & display panel.
     */
	private void addZombie(int col, int row) {
	    // The magic numbers below define various hardcoded zombie properties
        actorDisplay.addActor(new Zombie(
                gridToPixel(col), gridToPixel(row), CELL_SIZE * 4 / 5, 
				"src/a9pt2/clippership.png",
				100, 50, -2, 10));
	}
	
	/**
	 * Converts a row or column to its exact pixel location in the grid.
	 */
	private int gridToPixel(int rowOrCol) {
	    return rowOrCol * CELL_SIZE + GRID_BUFFER_PIXELS;
	}
	
	/**
	 * The inverse of gridToPixel
	 */
	private int pixelToGrid(int xOrY) {
	    return (xOrY - GRID_BUFFER_PIXELS) / CELL_SIZE;
	}
	
	/**
	 * Create, start, and run the game.
	 */
	public static void main(String[] args) {
		
        JFrame app = new JFrame("Plant and Zombie Test");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(new Game());
        app.pack();
        app.setVisible(true);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse click");
		
		int x = e.getX();
		int y = e.getY();
		System.out.println("x is " + x);
		System.out.println("y is " + y);
		if (gold.getGold() > 50) {
			addPlant(pixelToGrid(x), pixelToGrid(y));
			counter -= 50;
		} else {
			System.out.println("not enough gold!");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}