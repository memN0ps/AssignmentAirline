package AssignmentAirline;

/**
 * This class extends airline and contains information about fastair and its policies.
 * @author memN0ps
 *
 */
public class FastAir extends Airline
{
	/**
	 * This is a default constructor for fastair.
	 */
	public FastAir()
	{
		airlineName = "FastAir";
	}
	
	/**
	 * This method reserves a first class seat according to the policies of fastair
	 * @param flight, Flight the flight to reserve seats for.
	 * @param seatType, SEATTYPE enum the type of seat to reserve.
	 * @return a reserved seat object or null.
	 */
	public Seat reserveFirstClass(Flight flight, SEATTYPE seatType)
	{
		int countSavedSeats = 0;
		boolean noRow = false;
		Seat savedSeats[] = new Seat[flight.getSeats().getCols() * flight.getSeats().getRows()];
		Seat seat = flight.getSeats().queryAvailableFirstClassSeat(seatType);
		Seat tempSeat;
		
		if (seat == null || seat.getSeatType() != seatType)
		{
			do
			{
				noRow = false;
				seat = flight.getSeats().queryAvailableEconomySeat(SEATTYPE.WINDOW);
				
				if (seat != null && seat.getSeatType() == SEATTYPE.WINDOW)
				{
					seat.reserve();
					tempSeat = flight.getSeats().getRight(seat);
					
					for (int z = 0; z < flight.getSeats().getCols() - 1; z++)
					{
						if (tempSeat == null || tempSeat.isReserved())
						{
							savedSeats[countSavedSeats] = seat;
							countSavedSeats++;
							noRow = true;
						}
						else
						{
							tempSeat = flight.getSeats().getRight(tempSeat);
						}
						
						if (noRow)
						{
							break;
						}
					}
				}
				else
				{
					return null;
				}
			}
			while (noRow);
			
			for (int x = 0; x < countSavedSeats; x++)
			{
				savedSeats[x].unReserve();
			}
			
			tempSeat = flight.getSeats().getRight(seat);
			
			for (int z = 0; z < flight.getSeats().getCols() - 1; z++)
			{
				tempSeat.reserve();
				tempSeat = flight.getSeats().getRight(tempSeat);
			}
		}
		else
		{
			seat.reserve();
		}
		
		return seat;
	}
	
	/**
	 * This method reserves an economy seat according to the policies of fastair.
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
