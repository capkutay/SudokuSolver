import java.io.InputStreamReader;
import java.util.Scanner;



/**
 * The Game class contains the main logic of game play.
 * @author srollins
 *
 */
public class Game {
	private Board b;
	private Player p;

	/**
	 * The Game constructor first initializes the Board data member, the Player data member.  It then invokes the getFileName method of Player and passes the result to the fillBoard method of Board.
	 */
	public Game() {
		this.b = new Board();
		this.p = new Player(b);
		boolean success = this.b.fillBoard(this.p.getFileName());
		if(!success) {
			System.exit(1);
		}
	}
	
	/**
	 * The main logic of game play.  
	 * Basic algorithm:
	 * As long as the board is not full (1)	get another choice from the user and (2) set the square.  Once the board is full, check if the user has won and print an appropriate message.
	 * User may choose to give up. If user gives up, the board will be solved automatically. 
	 */
	public void play() {
		while(!b.isFull()) {
			//if board is incorrect, program will exit
			if(b.checkIncorrect()){
				System.out.println("Incorrect Board");
				System.exit(1);
			}
			b.display();
			Choice c = p.getChoice();
			b.setSquare(c);		
			System.out.println("Would you like to give up? (yes/no): ");
			Scanner sc = new Scanner(new InputStreamReader(System.in));
			String quitChoice = sc.next();
			if(quitChoice.equals("yes")){
				System.out.println("Solving board.");
				//reset all non-original squares to 0 
				b.resetBoard();
				//call sudoku solver
				b.sudokuSolve();
				b.display();
				System.exit(1);
			}
		}
		boolean win = b.check();
		if(win) {
			this.p.winMsg();
		} else {
			this.p.loseMsg();
		}
	}
	
	
}