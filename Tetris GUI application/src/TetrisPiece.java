
public abstract class TetrisPiece {

	/**3 dimensional array maintaining which squares are filled first dimension is 
	rotation (index 0: 0 degrees, index 1: 90 degrees, index 2: 180 degrees, index 3: 270 degrees) 
	second and third dimensions create 4x4 grid with true values indicating filled squares**/
	protected boolean[][][] pieceMatrix;

	/**Maintains the current rotation. 0: 0 degrees, 1: 90 degrees, 2: 180 degrees, 3: 270 degrees**/
	protected int rotation = 0;
	
	public TetrisPiece() {
		pieceMatrix = new boolean[4][4][4];
		
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				for (int k = 0; k < 4; k ++) {
					pieceMatrix[i][j][k] = false;		
				}
			}
		}
		
	}
	protected abstract void setRotation(); 
	
	/**Rotate the piece clockwise by 90 degrees.**/
	protected void rotateCW() {
		rotation = (rotation-1) %4 ;

	}
	
	/**Rotate the piece counter-clockwise by 90 degrees.**/
	protected void rotateCCW(){
		 rotation = (rotation+1) %4;
	}

	/**Get the rotation of this piece**/
	public boolean[][] getPieceRotation(){
		
		return pieceMatrix[rotation];
		
	}

	/**Checks if there is a TetrisBlock at the (row, col) position for the rotation rot, 
	where rot is 0, 90, 180 or 270 degrees**/
	public boolean isFilled(int rot, int row, int col) {

				if ( pieceMatrix[rot][row][col] == true){
					return true;
				}
			
		return false;
	}
	
	
}