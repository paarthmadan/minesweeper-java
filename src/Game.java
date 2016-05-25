import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Game implements ActionListener{
	
	
	final String TITLE = "Minesweeper";
	
	
	
	JFrame frame = new JFrame(TITLE);
	
	Container tileGrid = new Container();
	
	JButton[][] tiles;
	
	char [][] boardVals;
	
	public Game(int width, int height, int gridSize, int numberOfMines){
		
		
		GameLogic gl = new GameLogic(gridSize, numberOfMines);
		
		String gridVals = gl.finalString;
		
		boardVals = new char[gridSize][gridSize];
		
		int iterator = 0;
		
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				boardVals[i][j] = gridVals.charAt(iterator);
				iterator++;
			}
		}
		
		
		frame.setSize(width, height);
		
		//centers GUI
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tiles = new JButton[gridSize][gridSize];
	
		
		tileGrid.setLayout(new GridLayout(gridSize, gridSize));
		
		
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				tiles[i][j] = new JButton();
				
				tiles[i][j].addActionListener(this);
				tiles[i][j].setActionCommand(i + " " + j);
				
				tileGrid.add(tiles[i][j]);
			}
		}

		frame.setLayout(new BorderLayout());
		frame.add(tileGrid, BorderLayout.CENTER);
		
		
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){

		String numbers = event.getActionCommand();
		
		int x = Integer.parseInt( numbers.substring( 0, numbers.indexOf(" ") ) );
		int y = Integer.parseInt( numbers.substring( numbers.indexOf(" ") + 1 ) );
		
		tiles[x][y].setText(String.valueOf(boardVals[x][y]));
		
	
	}
	

	
	
	public static void main(String [] args){
		new Game(300, 300, 10, 10);
	}
}

