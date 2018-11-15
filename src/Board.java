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
		int row = sc.nextInt();
		int col = sc.nextInt();
		if (board[row][col] != VOID) {
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
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_ROWS; j++) {
				if (board[i][j] == player) {
				counter++;
				}
			}
			if (counter == NUM_ROWS) {
				return true;
			}
			counter = 0;
		}
		
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_ROWS; j++) {
				if (board[j][i] == player) {
				counter++;
				}
			}
			if (counter == NUM_ROWS) {
				return true;
			}
			counter = 0;
		}
		
		return false;
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