
/**
 * The class Choice contains all of the data relevant to a single choice or guess given by the user.
 * @author srollins
 *
 */
public class Choice extends Location{


	private int value;
	
	/**
	 * The Choice constructor takes as input the row and column where the user wants to place his/her choice and the value of the choice for that square.
	 * @param row
	 * @param col
	 * @param value
	 */
	public Choice(int row, int col, int value) {
		super(row, col);
		this.value = value;
	}

	/**
	 * Returns value.
	 * @return
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Sets the value of value.
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

}