import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/*
 * Display the board
 */
public class TetrisBoardGUIView extends JComponent{
	
	private TetrisBoard board;
	//private boolean[][] painted ;

	public TetrisBoardGUIView (TetrisBoard b){
		board = b;
	}
	
	/*
	 * Paint the game
	 */
	public void paint (Graphics g) {
		paintBoardOutline(g, computeBlockSize());
		for (int i = 0; i < board.rows; i++){			
			for (int j =0; j < board.cols; j ++){
				
				if (board.hasBlock(i, j)) {
				
						System.out.println("has block at " + i + ", " + j);
					
							paintBlock(g, i, j, computeBlockSize());
				}
				
//				else{
//					paintBackground(g, i, j, computeBlockSize());
//				}
			}
		}

	}
	private void paintBoardOutline(Graphics g, int blockSize){
		g.drawRect (0, 0, blockSize*board.cols, blockSize*board.rows);
	}
	
	/*
	 * Paint the block at grid row, grid col
	 */
	private void paintBlock(Graphics g,int row,int col,int blockSize){
		Color color[] = new Color[] {
				new Color(0, 153, 153), new Color(71, 163, 71), new Color(51, 153, 255), new Color(109, 19, 123), 
				new Color(255, 191, 255), new Color (204,153, 255), new Color(255, 143, 69)
		};

					g.setColor(color[board.random]);
					g.fillRect(col*blockSize, row*blockSize,blockSize, blockSize);
					g.setColor(Color.black);
					g.drawRect(col*blockSize, row*blockSize, blockSize, blockSize);
	
			
	}
//	private void paintBackground(Graphics g,int row,int col,int blockSize){
//		g.setColor(Color.black);
//		g.fillRect(col*blockSize, row*blockSize,blockSize, blockSize);
//		g.setColor(Color.white);
//		g.drawRect(col*blockSize, row*blockSize, blockSize, blockSize);
//	}
	
	
	/*
	 * Compute the best block size for the current width and height.
	 * @return size (for a square block) in pixels
	 */
	private int computeBlockSize(){
		 int boardWidth = getWidth();
		 	return (boardWidth/board.cols);
	}
	
}
