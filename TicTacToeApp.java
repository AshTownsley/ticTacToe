package ticTacToe_Townsley;

public class TicTacToeApp {
	public static void main(String[] args) {
		//create instance
		TicTacToe game = new TicTacToe();
		
		//welcome
		game.displayWelcomeMessage();
		
		//empty board
		game.displayGrid();
		
		//start
		game.startGame();
	}
}
