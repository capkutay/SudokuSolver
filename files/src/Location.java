
public class Location {
	
	private int row;
	private int col;
	
	/**
	 * The Location constructor takes as input the row and column where the user wants to place his/her choice and the value of the choice for that square.
	 * @param row
	 * @param col
	 */
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Returns row.
	 * @return
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Sets the value for row.
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}
	/**
	 * Returns column.
	 * @return
	 */
	public int getCol() {
		return col;
	}
	/**
	 * Sets the value for column.
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}



}
