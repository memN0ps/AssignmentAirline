package AssignmentAirline;

/**
 * This is an abstract class of a SeatMap which contains the seats and orders then in a specific way.
 * @author memN0ps
 *
 */
public abstract class SeatMap 
{
	protected Seat[][] seats;
	protected int rows;
	protected int cols;
	protected int firstClassRows;
	
	
	/**
	 * This is an abstract method to initialize the seat map.
	 */
	public abstract void initialiseSeatMap();
	
	/**
	 * This method gets the seat on the left of the initial seat.
	 * @param seat, Seat object which contains the initial seat.
	 * @return seat to the left of the initial seat or null if it does not exist.
	 */
	public Seat getLeft(Seat seat)
	{
		char col = seat.getPoistion().getCol();
		int row = seat.getPoistion().getRow();
		
		if (col - 'A' == 0)
		{
			return null;
		}
		return getSeat(row, (char)(col - 1));
	}
	
	/**
	 * This method gets the seat on the right of the initial seat.
	 * @param seat, Seat object which contains the initial seat.
	 * @return seat to the right of the initial seat or null if it does not exist.
	 */
	public Seat getRight(Seat seat)
	{
		char col = seat.getPoistion().getCol();
		int row = seat.getPoistion().getRow();
		
		if (col - 'A' == cols - 1)
		{
			return null;
		}
		return getSeat(row, (char)(col + 1));
	}
	
	/**
	 * This method looks for an economy seat that is not reserved and is of type specified.
	 * If the type specified could not be found then it looks again ignoring the type.
	 * @param type, SEATYPE enum contains the type of seat to look for.
	 * @return an unreserved seat of the specified type, or not of the
	 * specified type, or null if there are no seats left in economy.
	 */
	public Seat queryAvailableEconomySeat(SEATTYPE type)
	{
		for (int x = firstClassRows; x < rows; x++)
		{
			for (int y = 0; y < cols; y++)
			{
				if (seats[x][y].getSeatType() == type)
				{
					if (!seats[x][y].isReserved())
					{
						return seats[x][y];
					}
				}
			}
		}
		
		for (int x = firstClassRows; x < rows; x++)
		{
			for (int y = 0; y < cols; y++)
			{
				if (!seats[x][y].isReserved())
				{
					return seats[x][y];
				}
			}
		}
		
		return null;
	}
	
	/**
	 * This method looks for a first class seat that is not reserved and is of type specified.
	 * If the type specified could not be found then it looks again ignoring the type.
	 * @param type, SEATYPE enum contains the type of seat to look for.
	 * @return an unreserved seat of the specified type, or not of the
	 * specified type, or null if there are no seats left in first class.
	 */
	public Seat queryAvailableFirstClassSeat(SEATTYPE type)
	{
		for (int x = 0; x < firstClassRows; x++)
		{
			for (int y = 0; y < cols; y++)
			{
				if (seats[x][y].getSeatType() == type)
				{
					if (!seats[x][y].isReserved())
					{
						return seats[x][y];
					}
				}
			}
		}
		
		for (int x = 0; x < firstClassRows; x++)
		{
			for (int y = 0; y < cols; y++)
			{
				if (!seats[x][y].isReserved())
				{
					return seats[x][y];
				}
			}
		}
		
		return null;
	}
	
	/**
	 * gets the number of rows in a seat map
	 * @return int of rows. 
	 */
	public int getRows()
	{
		return rows;
	}
	
	/**
	 * gets the number of column in a seat map
	 * @return int of cols
	 */
	public int getCols()
	{
		return cols;
	}
	
	/**
	 * gets the seat in that specified row and column for example (3,'B').
	 * @param row, int of the seat.
	 * @param col, char of the seat.
	 * @return a seat that is in the specified row and column.
	 */
	public Seat getSeat(int row, char col)
	{
		return seats[row - 1][col - 'A'];
	}	
	
	/**
	 * 
	 * Returns a string representation of the seating plan, as a grid using the toString methods
	 * for Seat objects
	 * @return a string representing the seating plan
	 * 
	 * */
	public String toString()
	{
		String data = "";
		
		for (int x = 0; x < cols; x++)
		{
			data += "  "+(char)(x + 'A')+"   ";
		}
		
		data += "\n";
		
		for (int x = 0; x < rows; x++)
		{
			if (x + 1 < 10)
			{
				data += " ";
			}
			data += x + 1;
			
			for (int y = 0; y < cols; y++)
			{
				data += " "+seats[x][y].toString()+" ";
			}
			
			data += "\n";
		}	
		
		return data;
	}
}
