
public class TetrisL2 extends TetrisPiece {	

	public TetrisL2 (){
		super();
		setRotation();
	}
	/**
	 * store rotations
	 */
	public void setRotation(){
					
					//1st J
					pieceMatrix[0][0][0] = true;
					pieceMatrix[0][0][1] = true;
					pieceMatrix[0][0][2] = true;
					pieceMatrix[0][1][2] = true;
					
					//rotate 90 to the left
					pieceMatrix[1][0][0] = true;
					pieceMatrix[1][1][0] = true; 
					pieceMatrix[1][2][0] = true;
					pieceMatrix[1][0][1] = true;

					//rotate 180 to the left
					
					pieceMatrix[2][1][0] = true;
					pieceMatrix[2][1][1] = true;
					pieceMatrix[2][1][2]= true;
					pieceMatrix[2][0][0] = true;
				
					//rotate 270 to the left

					pieceMatrix[3][1][0] = true;
					pieceMatrix[3][1][1] = true;
					pieceMatrix[3][1][2] = true;
					pieceMatrix[3][0][2] = true;
					
			
	}
}
