import java.util.Scanner;
public class Board {

	public static final int NUM_ROWS = 3;
	public static final char PLAYER1 = 'X';
	public static final char PLAYER2 = 'O';
	public static final char VOID = '.';
	
	private char[][] board;
	private int turn;
	
	public Board() {
		turn = 1;
		board = new char [NUM_ROWS][NUM_ROWS];
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_ROWS; j++) {
				board[i][j] = VOID;
			}
		}
	}
	
	public void shoot() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter row: ");
		int row = sc.nextInt()-1;
		System.out.print("Enter col: ");
		int col = sc.nextInt()-1;
		if ((row > NUM_ROWS) || col > NUM_ROWS) {
			System.out.println("Incorrect data");
			shoot();
		}
		
		if (board[row][col] != VOID) {
			System.out.println("Enter a not used space");
			return;
		}
		if (turn == 1) {
			board[row][col] = PLAYER1;
			turn = 2;
		} else {
			board[row][col] = PLAYER2;
			turn = 1;
		}
	}
	
	public boolean line(char player) {
		int counter = 0;
		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_ROWS; col++) {
				if (board[row][col] == player) {
				counter++;
				}
			}
			if (counter == NUM_ROWS) {
				return true;
			}
			System.out.println(player + " " + "Counter line " + row + " = "  + counter);

			counter = 0;
		}
		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_ROWS; col++) {
				if (board[row][col] == player) {
				counter++;
				}
			}
			if (counter == NUM_ROWS) {
				return true;
			}
			System.out.println(player + " Counter cols = " + row + " = " + counter);

			counter = 0;
		}
		
		return false;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public char getPlayerSymbol() {
	return (turn == 1) ? PLAYER1 : PLAYER2;
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_ROWS; j++) {
				s += board[i][j] + "";
			}
			s += "\n";
		}
		return s;
	}
}