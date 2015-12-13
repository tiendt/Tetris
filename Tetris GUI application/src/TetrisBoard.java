
public class TetrisBoard {
	
	protected boolean[][] boardMatrix;
	protected TetrisPiece currentPiece;

	/**position of current (falling) piece currentPieceGridPosition[0] stores the current row 
	   currentPieceGridPosition[1] stores the current column**/
	private int[] currentPieceGridPosition;
	
	protected final int rows = 18;
	protected final int cols = 10;
	protected int random;
	
	public TetrisBoard(){
	
		initBoard();
		addNewPiece();
	}
	/** Initialize the 2D board array to have all false values **/
	public void initBoard(){
		boardMatrix = new boolean [rows][cols];
		
		for (int i =0; i< rows; i ++){
			for (int j = 0; j <cols; j ++){
				boardMatrix[i][j] = false;
			}
		}
		
	}
	/**Initialize an int array of length two to keep track of the grid position of the current piece (row, col)**/
	private void initCurrentGP(){
		//every piece starts at position (0,3)
		currentPieceGridPosition = new int[2];
		currentPieceGridPosition[0] = 0; //row
		currentPieceGridPosition[1] = 3; //col
	}

	/**Add a new random Tetris piece to the board at grid position (0, 3)**/
	public void addNewPiece(){
		//generate a random number from 0 - 6
		random =  (int)Math.floor(Math.random()*7);
		
		if (random == 0){
			currentPiece = new TetrisSquare();
		}
		else if (random == 1){
			currentPiece = new TetrisStick();
		}
		else if (random== 2){
			currentPiece = new TetrisT();
		}
		else if (random == 3){
			currentPiece = new TetrisL1();
		}
		else if (random == 4){
			currentPiece = new TetrisL2();
		}
		else if (random == 5){
			currentPiece = new TetrisS1();
		}
		else if (random == 6){
			currentPiece = new TetrisS2();
		}
		initCurrentGP();
	}
		
	/**getter for boardMatrix**/
	public boolean[][] getBoardMatrix() {

			return boardMatrix;

	}
	/**getter for current piece**/
	public TetrisPiece getCurrentPiece(){
		return currentPiece;
	}

	/**getter for current piece grid position**/
	public int[] getCurrentPieceGridPosition(){
		return currentPieceGridPosition;
	}

	/**Check if rotating clockwise is valid**/
	public boolean rotateCW(){
		//check piece at rotation 0, 1, 2, 3
		int nextRotation = (currentPiece.rotation-1) < 0 ? 3 : currentPiece.rotation-1;
		if (validMove(currentPiece, nextRotation, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			
			currentPiece.rotation=nextRotation;

			return true;
		}
		return false;
	}

	/**Check if rotating counter- clockwise is valid**/
	public boolean rotateCCW(){
		//check piece at rotation 0, 1, 2, 3
		if (validMove(currentPiece, (currentPiece.rotation +1)%4, currentPieceGridPosition[0], currentPieceGridPosition[1])){
			
			currentPiece.rotation=(currentPiece.rotation+1)%4;

			return true;
		}
		return false;
	}
	

	/*
	 * check if move piece to the left is valid
	 */
	
	public boolean moveLeft(){
		if (validMove(currentPiece, currentPiece.rotation, currentPieceGridPosition[0], currentPieceGridPosition[1]-1)){
			currentPieceGridPosition[1] --;
			return true;
		}
		return false;
	}
	/*
	 * check if move piece to the right is valid
	 */
	
	public boolean moveRight(){
		if (validMove(currentPiece, currentPiece.rotation, currentPieceGridPosition[0], currentPieceGridPosition[1]+1)){
			currentPieceGridPosition[1] ++;

			return true;
		}
		return false;
	}
	/*
	 * check if moving down is valid
	 */
	
	public boolean moveDown(){

		if (validMove(currentPiece, currentPiece.rotation, currentPieceGridPosition[0] +1, currentPieceGridPosition[1])){
			currentPieceGridPosition[0] ++;
			return true;
		}
		;
		return false;
	}
	
	/*
	 * Update the board array to reflect the newly landed piece's filled squares
	 * using the currentGridPosition values and the currentPiece's rotation value
	 */	

	public void landPiece(){
		//run for loop through the piece
		for (int i = 0; i < 4; i ++){
			for (int j = 0; j < 4; j ++){
				//find location of the piece
				if (currentPiece.isFilled(currentPiece.rotation, i, j)){
					
					if (i+ currentPieceGridPosition[0] < rows){	
					//update board at the position where the piece landed
					boardMatrix[currentPieceGridPosition[0] + i][currentPieceGridPosition[1]+j] = true;
						
					}
					
				}
			}
		}
		
	}
	
	/**Check if there is a block in the row and column**/

	public boolean hasBlock(int row, int col){

		if (boardMatrix[row][col] == true){
			return true;
		}
		//see if the piece's current position match the row and column on the board we need to check
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j ++){
				if (currentPiece.isFilled(currentPiece.rotation, i, j)){
					int checkRow = i + currentPieceGridPosition [0];
					int checkCol = j + currentPieceGridPosition[1];
					if (checkRow == row && checkCol == col){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270)
	 * would cause an out of bounds condition (i.e., if there would be a block falling off the board).
	 *
	 */
	public boolean isOOB(TetrisPiece piece, int rot, int gridRow, int gridCol){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				
				if (piece.isFilled(rot, i, j)){
					if ((i + gridRow) < 0 || (i + gridRow) >= rows || (j + gridCol) <0 || (j + gridCol) >= cols) {
						return true;
					}
				}
			}
		}
		return false;	
	}
	
	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) 
	 * would cause a collision (i.e., if there would be a block on an already-filled grid square).
	 */
	private boolean checkCollision(TetrisPiece piece, int rot, int gridRow, int gridCol){
		for (int i = 0; i < 4; i++){
			for (int j =0; j < 4; j++) {
				
				if (piece.isFilled(rot, i, j) && hasBlock(gridRow+i,gridCol+j)) { 
					//if there is a true value at the position where the piece is suppose to move to 
					if (boardMatrix[i +gridRow][j +gridCol ] == true){
						return true;
					}
				}
	
			}
		}
		return false;
	}

	/*Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) 
	 *is a valid move
	 */
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol){
		
		if (!isOOB(piece, rot, gridRow, gridCol) &&!checkCollision(piece, rot, gridRow, gridCol)){
			return true;
		}
		return false;
	}
	/**
	 * check to see if any lines have been filled
	 * and remove them
	 * @return number of line that were cleared
	 */
	public int countCompletedLines(){
		int completedLines =0;
		for (int i =0; i < rows; i ++){
			if (fullLine(i)){
				removeLine(i);
				completedLines ++;
			}	
		}
		return completedLines;
	}
	
	/**check if the line is full**/		
	public boolean fullLine (int line)
	{
			for (int j =0; j < cols; j++){
			
				if (boardMatrix[line][j] == false) {
					return false;
				}
			}
			return true;

	}
	/**after that need to shift every row above it by 1**/

	public void removeLine(int line){
		for (int i = line; i > 0; i--){
			for (int j = 0; j < cols; j++){
				
				boardMatrix[i][j] = boardMatrix[i-1][j];
			}
		}	

		//set 1st row to all false
		for (int j = 0; j < cols; j++){
			boardMatrix[0][j] = false;
		}
	}
			
	
}
