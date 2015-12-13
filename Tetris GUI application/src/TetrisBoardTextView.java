
public class TetrisBoardTextView {

	private TetrisBoard board;
	
	public TetrisBoardTextView(TetrisBoard b) {
		board = b;
	}

	/**
	 * check state of board
	 * x for filled, nothing for empty
	 * @return a string that shows the state of the board
	 */
	public String getBoardView() {
		String boardText = "";
		//int test ;
		for (int i = 0; i < board.rows; i++){
			//test = i;
			String line = "";
			
			for (int j =0; j < board.cols; j ++){
		
				if (board.hasBlock(i, j)) {

					line += "x ";
				}
				else
				{ 
					line+= "- ";
				}		
			}
			
			boardText += line +"\n";	
		}
		return boardText;
		
	}
	
}

