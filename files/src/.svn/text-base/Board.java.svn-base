

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents the Board.  
 * 
 * @author srollins
 *
 */

public class Board {
	public static final int ROWS = 9;
	public static final int COLS = 9;

	private Square[][] board;


	/**
	 * The Board constructor initializes the board array.
	 */
	public Board() {
		this.board = new Square[ROWS][COLS];
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				this.board[i][j] = new Square();
			}
		}
	}

	/**
	 * Takes as input the filename, opens the file, reads in each line, sets the value for each Square in the array, and returns true if successful and false if not. 
	 * The method may not be successful in the event that the file does not exist or is not formatted correctly.
	 * @param filename
	 * @return
	 */

	public boolean fillBoard(String filename) {	

		Scanner scan = null;
		boolean toreturn = true;
		try {            
			scan = new Scanner(new FileReader(filename));
			int row = 0;

			while (scan.hasNext()) {
				String line = scan.nextLine();
				System.out.println(line);

				String[] nums = line.split("\\|");
				int col = 0;

				for (int i = 1; i < nums.length; i++) {
					if(nums[i].trim().equals("")) {
						board[row][col].setValue(0);	
						col++;
						continue;
					}
					int val = Integer.parseInt(nums[i]);
					if(val >= 1 && val <= ROWS) {
						board[row][col].setValue(val);
						board[row][col].setOriginal(true);
					} else {
						//debug message
						System.out.println("Board.fillBoard::Invalid value in original board.");
						return false;
					}
					col++;
				}

				if(col != COLS) {
					//debug message
					System.out.println("Board.fillBoard::Invalid number of columns in original board.");
					return false;
				}
				row++;	
				System.out.println(scan.hasNext());
			}
			if(row != ROWS) {
				//debug message
				System.out.println("Board.fillBoard::Invalid number of rows in original board.");
				return false;				
			}
		} catch(IOException ioe) {
			//debug message
			System.out.println("Board.fillBoard::Error opening file.");			
			toreturn = false;
		} catch(NumberFormatException nfe) { 
			//debug message
			System.out.println("Board.fillBoard::Non-integer input found.");			
			toreturn = false;
		} finally {
			if(scan != null) {
				scan.close();
			}
		}
		return toreturn;

	}
	/**
	 * Returns true if the row and column specified by Choice c refer to a Square filled in the original board and false otherwise.
	 * @param c
	 * @return
	 */
	public boolean isOriginal(Choice c) {
		return this.board[c.getRow()][c.getCol()].isOriginal();
	}

	/**
	 * Sets the value of the Square specified by the row and column in c.
	 * @param c
	 * @return
	 */
	public boolean setSquare(Choice c) {
		if(this.board[c.getRow()][c.getCol()].isOriginal()) {
			return false;
		}
		this.board[c.getRow()][c.getCol()].setValue(c.getValue());
		return true;
	}

	/**
	 * Returns true if all Squares are set and false otherwise.
	 * Must iterate through every Square and return false if any are not set.
	 * @return
	 */
	public boolean isFull() {
		for(int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(!this.board[i][j].isSet()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns true if the solution is correct and false otherwise.
	 * A solution is correct if rows, columns, and subsquares are all correct.
	 * @return
	 */
	public boolean check() {
		return checkRows() && checkCols() && checkSquares();

	}
	/**
	 * Returns true if every row contains all numbers 1-9.
	 * @return
	 */
	private boolean checkRows() {
		for(int i = 0; i < ROWS; i++) {
			for (int num = 1; num <= ROWS; num++) {
				boolean found = false;
				for (int j = 0; j < COLS; j++) {
					if(this.board[i][j].getValue() == num) {
						found = true;
						break;
					}
				}
				if (!found) {
					return false;
				}
			}
		}
		return true;

	}

	/**
	 * Returns true if every column contains all numbers 1-9.
	 * @return
	 */
	private boolean checkCols() {

		for(int i = 0; i < COLS; i++) {
			for (int num = 1; num <= ROWS; num++) {
				boolean found = false;
				for (int j = 0; j < ROWS; j++) {
					if(this.board[j][i].getValue() == num) {
						found = true;
						break;
					}
				}
				if (!found) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns true if every subsquare contains all numbers 1-9.
	 * @return
	 */
	private boolean checkSquares() {
		for(int i = 0; i < ROWS; i+=3) {
			for(int j = 0; j < COLS; j+=3) {
				for (int num = 1; num <= ROWS; num++) {
					boolean found = false;
					for(int k = i; k < (i+3); k++) {
						for(int l = j; l < (j+3); l++) {
							if(this.board[k][l].getValue() == num) {
								found = true;
								break;
							}
						}						
					}
					if (!found) {
						return false;
					}
				}
			}
		}
		return true;

	}

	/**
	 * Displays the board. 
	 */
	public void display() {
		for(int i = 0; i < ROWS; i++) {

			System.out.print((i+1) + " [ ");
			for(int j = 0; j < COLS; j++) {
				if(j == COLS-1) {
					System.out.print(this.board[i][j] + " ] ");
				} else if((j+1)%3 == 0) {
					System.out.print(this.board[i][j] + " || ");					
				} else {
					System.out.print(this.board[i][j] + " | ");
				}
			}
			System.out.println();
			if((i+1)%3 == 0) {
				System.out.println("   -----------  -----------  -----------");
			}
		}
		System.out.println("  =======================================");
		System.out.println("  | 1 | 2 | 3 || 4 | 5 | 6 || 7 | 8 | 9 |");
	}

	/**
	 * Helper method for testing checkRows method.
	 */
	public void initializeCorrect() {
		//initialize each row with 1-9 (in order)
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				board[i][j].setValue((j+1));
			}
		}

		//randomize numbers
		Random r = new Random();
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				int toswap = r.nextInt(COLS);
				Square tmp = board[i][j];
				board[i][j] = board[i][toswap];
				board[i][toswap] = tmp;
			}
		}

	}

	/**
	 * Helper method for testing checkRows method.
	 */	
	public void initializeIncorrect() {

		//start with a correct board
		initializeCorrect();

		Random r = new Random();
		for(int i = 0; i < ROWS; i++) {
			//choose a random value
			int value = r.nextInt(ROWS);
			//choose two random cells and put the same
			//value in both cells
			int col1 = r.nextInt(COLS);
			int col2 = r.nextInt(COLS);

			board[i][col1].setValue(value);
			board[i][col2].setValue(value);
		}
	}
	/*
	 * Returns all possible solutions of a square. Takes in a row and column as input.
	 * All non-original squares have the value 0 
	 */

	public ArrayList<Integer> possibleSolutions(Location loc){
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		for (int posVal = 1; posVal <= 9; posVal++){
			boolean rowContains = false;
			boolean colContains = false;
			boolean squareContains = false;
			//if a row-cell contains the possible value, set row contains to true
			for(int i = 0; i < COLS; i++){
				if (board[loc.getRow()][i].getValue() == posVal){
					rowContains = true;
				}
			}
			//if column contains value, try next possible value
			if(rowContains){
				continue;
			}
			//if a cell contains the value, set column contains to true
			for(int r = 0; r < ROWS; r++){
				if (board[r][loc.getCol()].getValue() == posVal){
					colContains = true;
				}
			}
			if(colContains){
				continue;
			}
			//if the cell in a subsquare contains the value, set square contains to true
			//solution partially provided by Sami Rollins' checkSquares() method
			int topLeftCol = (loc.getCol()/3) * 3;
			int topLeftRow = (loc.getRow()/3) * 3;
			for(int k = topLeftRow; k < (topLeftRow+3); k++) {
				for(int l = topLeftCol; l < (topLeftCol+3); l++) {
					if(board[k][l].getValue() == posVal) {
						squareContains = true;
					}
				}						
			}	
			if(squareContains){
				continue;
			}

			//finally, if neither the square, rows, or columns contain the possible value
			//add the value to the solutions array list
			solutions.add(posVal);				
		}
		return solutions;
	}

	
	public void resetBoard(){
		//set all non-original squares to 0
		int testRow=0;
		int testCol=0;
		for(testRow = 0; testRow < ROWS; testRow++){
			for(testCol = 0; testCol < COLS; testCol++){
				if (!board[testRow][testCol].isOriginal()){
					board[testRow][testCol].setValue(0);
				}
			}
		}
	}
	/*
	 * Method will return true if the board has duplicate values.
	 */
	public boolean checkIncorrect(){
		//find original squares and test to see if there are duplicate numbers
		int r = 0;
		int c = 0;
		boolean rowContains = false;
		boolean colContains = false;
		boolean squareContains = false;
		for(r = 0; r < ROWS; r++){
			//create new hashset for each row
			HashSet<Integer> rowSet = new HashSet<Integer>(ROWS);
			for(c = 0; c < COLS; c++){
				Integer rowVal = new Integer(board[r][c].getValue());
				if(board[r][c].isOriginal()){
					if(rowSet.contains(rowVal)){
						rowContains = true;
					}
					rowSet.add(rowVal);
				}
			}
		}
		//checks columns for duplicate values, returns true if there is a duplicate
		for(c = 0; c < COLS; c++){
			HashSet<Integer> colSet = new HashSet<Integer>(COLS);
			for(r = 0; r < ROWS; r ++){
				Integer colVal = new Integer(board[r][c].getValue());
				if(board[r][c].isOriginal()){
					if(colSet.contains(colVal)){
						colContains = true;						
					}
					colSet.add(colVal);
				}
			}
		}
		//check squares for duplicates, returns true if there is a duplicate
		for(int i = 0; i < 9; i += 3){
			for(int j = 0; j < 9; j += 3){
				HashSet<Integer> squareSet = new HashSet<Integer>(9);
				for(r = 0; r < 3; r++){			
					for(c = 0; c < 3; c++){
						Integer squareInt = new Integer(board[r + i][c + j].getValue());
						if(board[r+i][c+j].isOriginal()){
							if(squareSet.contains(squareInt))
								squareContains = true;							
						}
						squareSet.add(squareInt);
					}			
				}
			}
		}
		//if either rows, columns, or square contain duplicates, the board is incorrect
		if(rowContains || colContains || squareContains){
			return true;
		}

		return false;
	}
	/*
	 * Method to recursively solve sudoku board. Return false if board cannot be solved. Returns true
	 * and solves the board if there is a solution.
	 */
	public boolean sudokuSolve(){

		boolean solved = check();
		if(solved){
			return true;
		} 
		int testRow=0;
		int testCol=0;
		boolean found = false;
		//find a zero square
		for(testRow = 0; testRow < ROWS; testRow++){
			for(testCol = 0; testCol < COLS; testCol++){
				if(board[testRow][testCol].getValue() == 0){
					found = true;
					break;
				}
			}
			//break out of loop if inner loop sets done to true
			if (found)
				break;
		}
		//calling all possible solutions
		ArrayList<Integer> posValues = possibleSolutions(new Location(testRow, testCol));
		//if possible solutions is empty, board cannot be solved
		if (posValues.isEmpty()){
			return false;			
		}
		//try each value in the list of possible values
		for (Integer i : posValues){
			//set value to that solution
			board[testRow][testCol].setValue(i);
			//if sudokuSolve returns true, return true and exit out of for-each loop
			if (sudokuSolve()){
				return true;
			}
		}
		//if value is incorrect, back track by setting square to 0
		board[testRow][testCol].setValue(0);
		return false;
	}
}
