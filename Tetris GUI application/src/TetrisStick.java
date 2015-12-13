
public class TetrisStick extends TetrisPiece {

	public TetrisStick (){
		super();
		setRotation();
	}
	/**
	 * store rotations
	 */
	public void setRotation(){
					
					//1st stick straight
					pieceMatrix[0][0][0] = true;
					pieceMatrix[0][0][1] = true; 
					pieceMatrix[0][0][2] = true;
					pieceMatrix[0][0][3] = true;
					
					//rotate 90 to the left
					pieceMatrix[1][0][0] = true;
					pieceMatrix[1][1][0] = true;
					pieceMatrix[1][2][0] = true;
					pieceMatrix[1][3][0] = true;
					
					//rotate 180 to the left
					pieceMatrix[2][0][0] = true;
					pieceMatrix[2][0][1] = true; 
					pieceMatrix[2][0][2] = true;
					pieceMatrix[2][0][3] = true;
					
					//rotate 270 to the left
					pieceMatrix[3][0][0] = true;
					pieceMatrix[3][1][0] = true;
					pieceMatrix[3][2][0] = true;
					pieceMatrix[3][3][0] = true;

	}

}
