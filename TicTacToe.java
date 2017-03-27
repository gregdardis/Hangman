import java.util.Scanner;

public class TicTacToe {
	Scanner myScanner = new Scanner(System.in);
	String playerLocation;

	char[][] board;

	public TicTacToe() {
		board = new char[3][3];

	}

    public void playTicTacToe() {
        boolean playerXWins = false;
		boolean playerOWins = false;


		initBoard();
		displayBoard2();

		while (true) {

			playerTurn('X');
			displayBoard2();


			if (checkWin('X')) {
				playerXWins = true;
				break;
			}
			if (checkBoardFull()) {
				break;
			}

			playerTurn('O');
			displayBoard2();

			if (checkWin('O')) {
				playerOWins = true;
				break;
			}
			if (checkBoardFull()) {
				break;
			}

		}
		if (playerXWins == true) {
			System.out.println("X's win!");
		}
		else if (playerOWins == true) {
			System.out.println("O's win!");
		}
		else {
			System.out.println("It's a draw");
		}
    }
	public static void main( String[] args ) {
        TicTacToe theGame = new TicTacToe();
		theGame.playTicTacToe();

	}

	public boolean checkWin(char xOrO) {

		for (int i = 0; i < board.length; i++){

			// if a row is filled, they win
			if (board[i][0] == xOrO && board[i][1] == xOrO  && board[i][2] == xOrO) {
				return true;
			}
			// if a column is filled, they win
			if (board[0][i] == xOrO && board[1][i] == xOrO && board[2][i] == xOrO) {
				return true;
			}

		}
		if (board[0][0] == xOrO && board[1][1] == xOrO && board[2][2] == xOrO) {
			return true;
		}
		if (board[2][0] == xOrO && board[1][1] == xOrO && board[0][2] == xOrO) {
			return true;
		}

		return false;
	}

	// CHECKS IF THE BOARD IS FULL
	public boolean checkBoardFull() {
		int boardCounter = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 'X' || board[i][j] == 'O') {
					boardCounter = boardCounter + 1;
				}
			}
		}
		if (boardCounter == 9) {

			return true;
		}
		return false;
	}

	// converts the row, column given into a string array, then an integer array
	public int[] stringToInt() {

		String[] rowAndColumn = playerLocation.split("\\s");
		int[] rowAndColumnIntegers = new int[2];

		for (int i = 0; i < 2; i++) {
			rowAndColumnIntegers[i] = Integer.parseInt(rowAndColumn[i]);
		}
		return rowAndColumnIntegers;
	}

	public void playerTurn(char xOrO) {
		int rowChoice;
		int columnChoice;

		//String playerXLocation;
		int[] theirMove = new int[2];
		System.out.print(xOrO + ", choose your location (row column): ");
		playerLocation = myScanner.nextLine();
		theirMove = stringToInt();

		// now we need to take the integers in this integer array and assign them
		// to the 2D playing field
		rowChoice = theirMove[0];
		columnChoice = theirMove[1];
		if (board[rowChoice - 1][columnChoice - 1] == ' ') {
			board[rowChoice - 1][columnChoice - 1] = xOrO;
		}
		else {
			System.out.println("Sorry, that spot is taken.");
			playerTurn(xOrO);
		}
	}



	public void initBoard() {
		// fills up the board with blanks
		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}

	public void displayBoard2() {

		for ( int r=0; r<3; r++ ) {

			System.out.print("\t"+(r+1)+" ");

			for ( int c=0; c<3; c++ ) {
				if (board[r][c] == ' ') {
					System.out.print( board[r][c] + " " );
				}
				else {
					System.out.print(board[r][c] + " ");
				}

			}

			System.out.println();

		}

		System.out.println("\t  1 2 3 ");
	}
}
