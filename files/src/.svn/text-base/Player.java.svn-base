import java.util.Scanner;
/**
 * The Player class is responsible for interacting with the user.
 * @author srollins
 *
 */
public class Player {
	
	private Board board;
	
	/**
	 * The Player constructor takes as input a reference to the board and saves it in a field of player.
	 * @param board
	 */
	public Player(Board board) {
		this.board = board;
	}
	
	/**
	 * Prompts the user for a file name and returns the string entered.
	 * @return
	 */
	public String getFileName() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name of file containing board: ");
		String file = s.next();
		return file;
	}
	
	/**
	 * Prints an appropriate message indicating that the user won.
	 */
	public void winMsg() {
		System.out.println("Congrats! You win!");
	}
	
	/**
	 * Prints an appropriate message indicating that the user lost.
	 */
	public void loseMsg() {
		System.out.println("Sorry...you lose.");		
		
	}

	/**
	 * Prompts the user for a row, column, and value and returns all three in a Choice object.
	 * The method also verifies that each value entered is in the correct range.
	 * @return
	 */
	public Choice getChoice() {
		Choice c = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Time to make a guess!");
		do {
			if(c != null) {
				System.out.println("You cannot change the value in that position!");
				System.out.println("Try again.");
			}
			
			System.out.println("Enter row: ");
			int row = s.nextInt()-1;
			while(row < 0 || row > Board.ROWS-1) {
				System.out.println("Invalid selection.  Enter row (again): ");
				row = s.nextInt()-1;
			}
			System.out.println("Enter column: ");
			int col = s.nextInt()-1;
			while(col < 0 || col > Board.COLS-1) {
				System.out.println("Invalid selection.  Enter column (again): ");
				col = s.nextInt()-1;
			}
			System.out.println("Enter value: ");
			int value = s.nextInt();
			while(value < 1 || value > 9) {
				System.out.println("Invalid selection.  Enter value (again): ");
				value = s.nextInt();
			}
			c = new Choice(row, col, value);
		} while(this.board.isOriginal(c));
		return c;
	}
	
	

}