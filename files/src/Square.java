/**
 * The Square class represents a single square in the puzzle board.
 */
public class Square {

	private int value;
	private boolean original;
	private boolean set;
	
	/**
	 * Default constructor.  Sets value, original, and set to appropriate initial values.
	 */
	public Square() {
		this.value = 0;
		this.original = false;
		this.set = false;
	}

	/**
	 * Returns value stored in the square.
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets value stored in the square.
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
		if(value != 0)
			this.set = true;
		else
			this.set = false;	}

	/**
	 * Returns true if this square was set in the original puzzle, false if not.
	 * @return
	 */
	public boolean isOriginal() {
		return original;
	}

	/**
	 * Returns true if the value in this square has been set, false if not.
	 * @return
	 */
	public boolean isSet() {
		return set;
	}

	/**
	 * Sets the value of original. 
	 * @param original
	 */
	public void setOriginal(boolean original) {
		this.original = original;
	}
	
	/**
	 * Returns a String representation of this square.
	 */
	public String toString() {
		if(this.value > 0 && this.value <= Board.ROWS) {
			return Integer.toString(this.value);
		}
		return " ";
	}
	
	
}