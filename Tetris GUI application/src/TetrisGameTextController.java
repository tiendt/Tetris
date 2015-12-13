
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Creates and controls the game and view of its components
 * @author dao23t
 *
 */
public class TetrisGameTextController {

	//model
	private TetrisGame game;
	//view
	private TetrisBoardTextView view;
	
	public TetrisGameTextController(){
		
		game = new TetrisGame();
		view= new TetrisBoardTextView(game.getTetrisBoard());
		
		refreshDisplay();

		readInput();
		
	}
	/**r: right l: left d: down z: cw x: ccw**/
	private void moveEntered(java.lang.String move){
		

		if (move.equals("r")){
			System.out.println ("move right");
			game.attemptMove(1);
		}
		else if (move.equals("l")){

			System.out.println ("move left");
			game.attemptMove(0);

		}
		else if (move.equals("d")){
			System.out.println ("move down");
			game.attemptMove(2);
		}
		else if (move.equals("z")){
			System.out.println ("CW");
			game.attemptMove(4);
		}
		else if (move.equals("x")){
			System.out.println ("CCW");
			game.attemptMove(3);
		}
		System.out.println ("refreshed after move entered");
		refreshDisplay();
	}
	
	/**
	 * Get input from the user, looping until the user types "Quit"
	 * or gives an incorrect value.
	 **/
	public void readInput()
	{
		// wrap input stream read input from user

		BufferedReader in = 
		new BufferedReader( new InputStreamReader( System.in ) );
 
		// prompt the user for input
		System.out.println( "Please enter a move (r,l,d,x,z) or type Quit to end." ); 
 
		// I/O almost always requires a try/catch
		// block as exceptions may be thrown 
		try 
		{
			String line;
			
			// loop until the user types "Quit"
			do {
 
				// try to read a line
				// this function potentially throws an IOException
				line = in.readLine(); 
 
				// attempt to parse the string entered by the user
				try 
				{
					moveEntered(line);
					

				}
				// catch parsing error, thrown when user did not enter
				// an integer
				catch ( NumberFormatException nfe )
				{
					// inform user of error
					System.out.println( "Error: input must be a move (r, l, d, x, z)." );
 
					// exit the program
					System.exit( 0 );
				}
			} while ( (!line.equals( "Quit" ) ) );
		}
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}
		
	}
	
	
	/**Print text view of the game. First, print the number of tetrises cleared. 
	   Second, print the number of lines cleared. Then, print the tetris board. **/
	private void refreshDisplay(){
		System.out.println("Number of lines cleared: " + game.getNumLines());
		System.out.println("Number of Tetrises cleared: " + game.getNumTetrises());
		System.out.println(view.getBoardView());
		System.out.println ("refreshed");
		
	}

}
