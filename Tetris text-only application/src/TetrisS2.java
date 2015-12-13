
public class TetrisS2 extends TetrisPiece{


	public TetrisS2 (){
		super();
		setRotation();
	}
	/**
	 * store rotations
	 */
	public void setRotation(){

					
					//1st Z
					pieceMatrix[0][0][1] = true;
					pieceMatrix[0][1][0] = true; 
					pieceMatrix[0][1][1] = true;
					pieceMatrix[0][2][0] = true;
					
					//rotate 90 to left
					pieceMatrix[1][0][0] = true;
					pieceMatrix[1][0][1] = true;
					pieceMatrix[1][1][1] = true;
					pieceMatrix[1][1][2] = true;
					
					//rotate 180 to left
					pieceMatrix[2][0][1] = true;
					pieceMatrix[2][1][0] = true; 
					pieceMatrix[2][1][1] = true;
					pieceMatrix[2][2][0] = true;
					
					//rotate 270 to left
					pieceMatrix[3][0][0] = true;
					pieceMatrix[3][0][1] = true;
					pieceMatrix[3][1][1] = true;
					pieceMatrix[3][1][2] = true;


	}
}
