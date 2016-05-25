import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game {
	
	JFrame frame = new JFrame("Minesweeper");
	
	Container tileGrid = new Container();
	
	JButton[][] tiles;
	
	public Game(int width, int height, int gridSize){
		
		frame.setSize(width, height);
		
		//centers GUI
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tiles = new JButton[gridSize][gridSize];
		
		tileGrid.setLayout(new GridLayout(gridSize, gridSize));
		
		
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				tiles[i][j] = new JButton();
				tileGrid.add(tiles[i][j]);
			}
		}
		
		
		frame.setLayout(new BorderLayout());
		frame.add(tileGrid, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	

	
	
	public static void main(String [] args){
		new Game(300, 300, 10);
	}
}

