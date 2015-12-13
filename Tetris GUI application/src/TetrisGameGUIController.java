import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Creates and controls the game and GUI view of its components
 * @author dao23t
 *
 */
public class TetrisGameGUIController extends JPanel implements KeyListener {
	public static final int DEFAULT_DROP_RATE = 1000;
	//model
	private TetrisGame game;
	//view
	private TetrisBoardGUIView view;

	private ActionListener actionListener;
	
	private JLabel linesLabel ;
	
	private JLabel tetrisesLabel;
	
	private Timer gameTimer;
	
	private int dropRate ;
		
	public TetrisGameGUIController(){
			super(new BorderLayout());
			
			game = new TetrisGame();
			view = new TetrisBoardGUIView(game.getTetrisBoard());
			
			linesLabel = new JLabel();
			tetrisesLabel = new JLabel();
			
			add(createView(), BorderLayout.CENTER);
     		add(createScore(), BorderLayout.NORTH);

     		
			refreshDisplay();
			setupTimer();
			
			addKeyListener(this);
			this.setFocusable(true);

	}
		
	/*
	* create a timer to advance time
	 */
	public void setupTimer()
	{
		actionListener =  new ActionListener(){
			public void actionPerformed(ActionEvent e){
				game.attemptMove(2);
				refreshDisplay();
			}
		}; 
		dropRate = DEFAULT_DROP_RATE;
		gameTimer = new Timer(dropRate, actionListener); 
		
		gameTimer.start();
			
	}
	
	private JComponent createView(){
		
		return view;
	}
	
	private JPanel createScore(){
		
		JPanel gameScore = new JPanel(new BorderLayout());
		
		gameScore.add(linesLabel, BorderLayout.NORTH);
		gameScore.add(tetrisesLabel, BorderLayout.SOUTH);
		
		return gameScore;		
	}
	
	public void refreshDisplay(){ 
		linesLabel.setText("Lines cleared: " + game.getNumLines());
		tetrisesLabel.setText("Tetrises cleared: " + game.getNumTetrises());
		
		repaint();
		
	}	
	/**
	 * Listening for key strokes
	 */
	/**Handle the key typed event */
	
	public void keyTyped(KeyEvent e){
		
	}
	
	/**Handle the key-pressed event */
	public void keyPressed (KeyEvent e){
		
	}
	
	/**Handle the key-released event */
	public void keyReleased (KeyEvent e){
	/**r: right l: left d: down z: cw x: ccw**/
	switch(e.getKeyCode()){
	
			case KeyEvent.VK_LEFT:
				game.attemptMove(0);
				break;
			
			case KeyEvent.VK_RIGHT:
				game.attemptMove(1);
				break;
			
			case KeyEvent.VK_DOWN:
				game.attemptMove(2);
				break;
			
			case KeyEvent.VK_X:
				game.attemptMove(3);
				break;
				
			case KeyEvent.VK_Z:
				game.attemptMove(4);
				break;
				
			default:
			System.out.println("KEY" + e.getKeyCode()) ;
	}
	refreshDisplay();
	}
}
