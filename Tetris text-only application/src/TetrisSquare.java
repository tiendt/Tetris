
public class TetrisSquare extends TetrisPiece {


	public TetrisSquare (){
		super();
		setRotation();
	}
	/**
	 * store rotations
	 */
	public void setRotation(){

					pieceMatrix[0][0][0] = true;
					pieceMatrix[0][1][0] = true;
					pieceMatrix[0][0][1] = true;
					pieceMatrix[0][1][1] = true;
					
					pieceMatrix[1][0][0] = true;
					pieceMatrix[1][1][0] = true;
					pieceMatrix[1][0][1] = true;
					pieceMatrix[1][1][1] = true;
					
					pieceMatrix[2][0][0] = true;
					pieceMatrix[2][1][0] = true;
					pieceMatrix[2][0][1] = true;
					pieceMatrix[2][1][1] = true;
					
					pieceMatrix[3][0][0] = true;
					pieceMatrix[3][1][0] = true;
					pieceMatrix[3][0][1] = true;
					pieceMatrix[3][1][1] = true;
	}
}
