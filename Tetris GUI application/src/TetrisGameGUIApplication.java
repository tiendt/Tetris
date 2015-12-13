import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrisGameGUIApplication extends Object{
	

	public static void main (String[] args){

			JFrame tetrisFrame = new JFrame("Tetris");
			tetrisFrame.setSize(350, 700);
			tetrisFrame.add(new TetrisGameGUIController());
			tetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			tetrisFrame.setVisible (true);
	}
}
