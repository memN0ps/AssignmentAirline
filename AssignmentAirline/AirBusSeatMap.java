package AssignmentAirline;

/**
 * This class extends seat map and contains the information about a airbus aircraft.
 * @author memN0ps
 *
 */
public class AirBusSeatMap extends SeatMap 
{

	/**
	 * This is a default constructor specific to the airbus aircraft.
	 */
	public AirBusSeatMap() 
	{
		rows = 12;
		cols = 9;
		firstClassRows  = 6;
		seats = new Seat[rows][cols];
		initialiseSeatMap();
	}
	
	/**
	 * This initializes the Airbus seat map.
	 * */
	public void initialiseSeatMap()
	{
		for (int x = 0; x < rows; x++)
		{
			for (int y = 0; y < cols; y++)
			{
				seats[x][y] = new Seat(new SeatPosition(x + 1, (char)(y + 'A')));
				
				if (x < firstClassRows)
				{
					seats[x][y].setFirstClass(true);
				}
				
				if (y == 2 || y == 3 || y == 5 || y == 6)
				{
					seats[x][y].setSeatType(SEATTYPE.AISLE);
				}
				else if (y == 0 || y == cols - 1)
				{
					seats[x][y].setSeatType(SEATTYPE.WINDOW);
				}
			}
		}
	}
}
