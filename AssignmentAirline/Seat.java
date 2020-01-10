package AssignmentAirline;

/**
 * This class contains information about a seat object. 
 * @author memN0ps.
 *
 */
public class Seat 
{
	private boolean reserved;
	private boolean firstClass;
	private SEATTYPE seatType;
	private SeatPosition position;
	
	/**
	 * Constructs a seat object in a specified position.
	 * @param position, SeatPosition this is the position in the seat map.
	 */
	public Seat(SeatPosition position)
	{
		this.reserved = false;
		this.firstClass = false;
		this.seatType = SEATTYPE.MIDDLE;
		this.position = position;
	}
	
	/**
	 * This is a detailed string representation of a seat object.
	 * @return detailed string representation of a seat object.
	 */
	public String seatDescription()
	{
		String data = "";
		
		if (firstClass)
		{
			data = "First class ";
		}
		else
		{
			data = "Economy class ";
		}
		
		data += seatType+" seat at: "+position;
		
		if (reserved)
		{
			data += " is reserved.";
		}
		else
		{
			data += " is not reserved.";
		}
		
		return data;
	}
	
	/**
	 * sets if a seat is first class or not.
	 * @param firstClass, boolean whether a seat is first class or not.
	 */
	public void setFirstClass(boolean firstClass)
	{	
		this.firstClass = firstClass;
	}
	
	/**
	 * sets the seat type.
	 * @param seatType, SEATTYPE enum the type of seat.
	 */
	public void setSeatType(SEATTYPE seatType)
	{
		this.seatType = seatType;
	}
	
	
	/**
	 * gets the seat postion of the seat.
	 * @return the position of the seat.
	 */
	public SeatPosition getPoistion()
	{
		return position;
	}
	
	/**
	 * checks if the seat is reserved.
	 * @return whether the seat is reserved or not.
	 */
	public boolean isReserved()
	{
		return reserved;
	}
	
	/**
	 * reserves the seat.
	 */
	public void reserve()
	{
		this.reserved = true;
	}
	
	/**
	 * un-reserves the seat.
	 */
	public void unReserve()
	{
		this.reserved = false;
	}
	
	/**
	 * gets the seat type of the seat
	 * @return the seatType,
	 */
	public SEATTYPE getSeatType()
	{
		return seatType;
	}
	
	/**
	 * 
	 * Returns a simple string representation of a seat, as used by the seat map class.
	 * @return a string representing a seat.
	 * 
	 * */
	public String toString()
	{
		String data = "";
		
		if (seatType == SEATTYPE.WINDOW)
		{
			if (firstClass)
			{
				data += 'W';
			}
			else
			{
				data += 'w';
			}
		}
		
		else if (seatType == SEATTYPE.AISLE)
		{
			if (firstClass)
			{
				data += 'A';
			}
			else
			{
				data += 'a';
			}
		}
		
		else if (seatType == SEATTYPE.MIDDLE)
		{
			if (firstClass)
			{
				data += 'M';
			}
			else
			{
				data += 'm';
			}
		}
		
		data += '[';
		
		if (reserved)
		{
			data += 'X';
		}
		else
		{
			data += ' ';
		}
		
		data += ']';
		
		return data;
	}
}
