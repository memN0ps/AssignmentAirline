package AssignmentAirline;

/**
 * This class contains the position of a seat.
 * @author memN0ps
 *
 */
public class SeatPosition 
{
	private int row;
	private char col;
	
	/**
	 * This constructs a seat position object with specified row and column.
	 * @param row, int number of the row
	 * @param col, char letter of the column.
	 */
	public SeatPosition(int row, char col)
	{
		this.row = row;
		this.col = col;
	}

	/**
	 * gets the row number.
	 * @return row, int
	 */
	public int getRow() 
	{
		return row;
	}

	/**
	 * sets the row number.
	 * @param row, int the row number
	 */
	public void setRow(int row) 
	{
		this.row = row;
	}

	/**
	 * gets the column letter.
	 * @return col, char
	 */
	public char getCol() 
	{
		return col;
	}

	/**
	 * sets the column letter.
	 * @param col, char the column letter.
	 */
	public void setCol(char col) 
	{
		this.col = col;
	}

	/**
	 * 
	 * Returns a string representation of the seat position for example "3B".
	 * @return a string representing the seat position.
	 * 
	 * */
	public String toString() 
	{
		return ""+row+col;
	}
}
