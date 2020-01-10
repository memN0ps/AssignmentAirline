package AssignmentAirline;

/**
 * This class extends seat map and contains the information about a Boeing aircraft.
 * @author memN0ps
 *
 */
public class BoeingSeatMap extends SeatMap
{

	/**
	 * This is a default constructor specific to the boeing aircraft.
	 */
	public BoeingSeatMap() 
	{
		rows = 10;
		cols = 7;
		firstClassRows  = 4;
		seats = new Seat[rows][cols];
		initialiseSeatMap();
	}
	
	
	/**
	 * This initializes the boeing seat map.
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
				
				if (y == 1 || y == 2 || y == 4 || y == 5)
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
