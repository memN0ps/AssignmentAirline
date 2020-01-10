package AssignmentAirline;

/**
 * This an abstract class that contains information about an Airline 
 * @author memN0ps
 *
 */
public abstract class Airline 
{
	protected String airlineName;
	protected Flight[] flights;
	
	/**
	 * This abstract method reserves a first class seat according to the policies of the airline.
	 * @param flight, Flight the flight to reserve seats for.
	 * @param seatType, SEATTYPE enum the type of seat to reserve.
	 * @return a reserved seat object or null.
	 */
	public abstract Seat reserveFirstClass(Flight flight, SEATTYPE seatType);
	
	/**
	 * This abstract method reserves an economy seat according to the policies of the airline.
	 * @param flight, Flight the flight to reserve seats for.
	 * @param seatType, SEATTYPE enum the type of seat to reserve.
	 * @return a reserved seat object or null.
	 */
	public abstract Seat reserveEconomy(Flight flight, SEATTYPE seatType);
	
	/**
	 * gets the airline name
	 * @return String, the airline name.
	 */
	public String getAirlineName() 
	{
		return airlineName;
	}

	/**
	 * sets the airline name.
	 * @param airlineName, string the airline name.
	 */
	public void setAirlineName(String airlineName)
	{
		this.airlineName = airlineName;
	}
	
	/**
	 * gets the flights belonging to an airline.
	 * @return Flight[], flights.
	 */
	public Flight[] getFlights()
	{
		return flights;
	}
	
	/**
	 * sets the flight array belonging to the airline.
	 * @param flights, Flight[] all the flights for the airline.
	 */
	public void setFlights(Flight[] flights) 
	{
		this.flights = flights;
	}
	
	/**
	 * return a welcome message for the airline.
	 * @return a string of the welcome message.
	 * 
	 * */
	public String toString()
	{
		return "Welcome to the "+airlineName+" reservation system";
	}
	
}
