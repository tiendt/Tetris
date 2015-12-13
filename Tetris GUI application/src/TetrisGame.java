
public class TetrisGame {

	private TetrisBoard board;
	
	private int numLines;
	private int numTetrises;
	
	public static int CCW=3;
	public static int CW=4;
	public static int LEFT=0;
	public static int RIGHT=1;
	public static int DOWN=2;
	
	public TetrisGame() {

		board = new TetrisBoard();
	}
	
	public TetrisBoard getTetrisBoard(){
		return board;
	}
	public int getNumLines(){
		return numLines;
	}
	
	public int getNumTetrises(){
		return numTetrises;
	}

	/**Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW**/
	public void attemptMove( int moveType){
		System.out.println(moveType);
		if (moveType == RIGHT){	
			board.moveRight();
			
		}
		else if (moveType == LEFT){
			board.moveLeft();
			
		}
		else if (moveType == DOWN){
			//when move down is invalid, we end the round
			if (!board.moveDown() ){
				endRound();
			}
		}
		else if (moveType == CCW){
			board.rotateCCW();
		}
		else if (moveType == CW){
			board.rotateCW();

		}
		
	}

	/**Performed when a piece cannot move down anymore**/
	private void endRound(){
		board.landPiece();
		
		int lines = board.countCompletedLines();
		
		numLines = numLines + lines;
		if (lines == 4){
			numTetrises ++;
		}
		//after ending round, add a new piece to the board
		board.addNewPiece();
	}

}
