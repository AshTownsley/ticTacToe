package ticTacToe_Townsley;

import java.util.Scanner;

public class TicTacToe {
	private char[][] board;
	private char currentPlayer;
	
	//initialize board
	public TicTacToe() {
		board = new char [3][3];
		currentPlayer = 'X'; //X always starts
		initializeBoard();
	}
	
	//initialize empty spaces
	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	// Display welcome message
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe\n");
	}
	
	//Display current game board
	public void displayGrid() {
		System.out.println("+---+---+---+");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j<3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println("\n+---+---+---+");
		}
	}
	
	//start game loop
	public void startGame() {
		boolean gameOn = true;
		while (gameOn) {
			gameOn = takeTurn();
		}
	}
	
	//Handle players turns
	public boolean takeTurn() {
		Scanner scanner = new Scanner(System.in);
		int row, col;
		
		System.out.println(currentPlayer + "'s turn");
		while (true) {
			System.out.print("Pick a row (1, 2, 3): ");
			row = scanner.nextInt() - 1;
			System.out.print("Pick a column (1, 2, 3): ");
			col = scanner.nextInt() - 1;
			
			if (row >= 0 && row < 3 && col >= 0 && col < 3) {
				if (board[row][col] == ' ') {
					board[row][col] = currentPlayer;
					break;
				} else {
					System.out.println("That space is already taken! Try again.");
				}
			} else {
				System.out.println("Invalid input! Pick a number from 1-3.");
			}
		}
		
		displayGrid();
		
		if (checkForWinner()) {
			System.out.println("Player " + currentPlayer + " wins!");
			return false;
		}
		
		if (isBoardFull()) {
			System.out.println("Its a tie game!");
			return false;
		}
		
		//switch player
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
		return true;		
	}
	
	//check for winner
	private boolean checkForWinner() {
		// check rows and columns
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
				return true; //row win
			if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
				return true; //column win
		}
		
		//check for diagonals
		if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
			return true; //left to right diag win
		if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
			return true; //right to left diag win
		
		return false;
	}
	
	//check for tie game
	private boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
