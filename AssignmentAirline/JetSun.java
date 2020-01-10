package AssignmentAirline;

/**
 * This class extends airline and contains information about jetsun and its policies.
 * @author memN0ps
 *
 */
public class JetSun extends Airline
{
	/**
	 * This is a default constructor for jetsun.
	 */
	public JetSun()
	{
		airlineName = "JetSun";
	}
	
	/**
	 * This method reserves a first class seat according to the policies of jetsun
	 * @param flight, Flight the flight to reserve seats for.
	 * @param seatType, SEATTYPE enum the type of seat to reserve.
	 * @return a reserved seat object or null.
	 */
	public Seat reserveFirstClass(Flight flight, SEATTYPE seatType)
	{
		int countSavedSeats = 0;
		boolean noNeighbor = false;
		Seat savedSeats[] = new Seat[flight.getSeats().getCols() * flight.getSeats().getRows()];
		Seat seat = flight.reserveFirstClassSeat(seatType);
		
		if (seat == null)
		{
			do
			{
				noNeighbor = false;
				seat = flight.getSeats().queryAvailableEconomySeat(SEATTYPE.AISLE);
				
				if (seat == null)
				{
					return null;
				}
				else if (seat.getSeatType() == SEATTYPE.AISLE)
				{
					seat.reserve();
					Seat leftSeat = flight.getSeats().getLeft(seat);
					
					if (leftSeat.isReserved())
					{
						Seat rightSeat = flight.getSeats().getRight(seat);
						
						if (rightSeat.isReserved())
						{
							savedSeats[countSavedSeats] = seat;
							countSavedSeats++;
							noNeighbor = true;
						}
						else
						{
							rightSeat.reserve();
						}
					}
					else
					{
						leftSeat.reserve();
					}
				}
				else
				{
					return null;
				}
			}
			while (noNeighbor);
			
			for (int x = 0; x < countSavedSeats; x++)
			{
				savedSeats[x].unReserve();
			}
		}
		else
		{
			seat.reserve();
		}
		return seat;
	}
	
	/**
	 * This method reserves an economy seat according to the policies of jetsun.
	 * @param flight, Flight the flight to reserve seats for.
	 * @param seatType, SEATTYPE enum the type of seat to reserve.
	 * @return a reserved seat object or null.
	 */
	public Seat reserveEconomy(Flight flight, SEATTYPE seatType)
	{
		Seat seat = flight.getSeats().queryAvailableEconomySeat(seatType);
	
		if (seat == null || seat.getSeatType() != seatType)
		{
			seat = flight.reserveFirstClassSeat(seatType);
		}
		else
		{
			seat.reserve();
		}
		
		return seat;
	}
}
