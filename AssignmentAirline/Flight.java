package AssignmentAirline;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class stores data about a flight, and it stores
 * data about the start city, end city, departure time, flight number and seats.
 *
 * @author memN0ps
 * 
 * */
public class Flight 
{
	private String startCity;
	private String endCity;
	private Date departureTime;
	private String flightNumber;
	private SeatMap seats;
	private SimpleDateFormat dateFormat; //Using this for formating the date
	
	/**
	 * Constructs the flight object
	 * @param startCity string which contains the starting city of a flight.
	 * @param endCity, string which contains the destination city of a flight.
	 * @param hours, int which contains the departing hour of a flight in 24 hours format.
	 * @param mins, int which contains the departing minute of a flight in 24 hours format.
	 * @param flightNumber, String which shows the flight number of a flight.
	 * @param seats, SeatMap object, which contains all of the seats of a flight.
	 * */
	public Flight(String startCity, String endCity, int hours, int mins, String flightNumber, SeatMap seats)
	{
		this.startCity = startCity;
		this.endCity = endCity;
		departureTime = new Date();
		setDepartureTime(hours, mins);
		dateFormat = new SimpleDateFormat("HH:mm'h'");
		this.flightNumber = flightNumber;
		this.seats = seats;
	}
	
	/**
	 * This method reserves a first class seat if the seat is not reserved
	 * otherwise if it reserved it returns null.
	 * @param type, SEATTYPE Enum contains the type of seat
	 * @return a reserved seat or null
	 */
	public Seat reserveFirstClassSeat(SEATTYPE type)
	{
		Seat seat = seats.queryAvailableFirstClassSeat(type);
		
		if (seat == null)
		{
			return null;
		}
		
		seat.reserve();
		return seat;
	}
	
	/**
	 * This method reserves a economy seat if the seat is not reserved
	 * otherwise if it reserved it returns null.
	 * @param type, SEATTYPE Enum contains the type of seat
	 * @return a reserved seat or null
	 */
	public Seat reserveEconomySeat(SEATTYPE type)
	{
		Seat seat = seats.queryAvailableEconomySeat(type);
		
		if (seat == null)
		{
			return null;
		}
		
		seat.reserve();
		return seat;
	}
	
	/**
	 * gets the start city of a flight.
	 * @return startCity string.
	 */
	public String getStartCity()
	{
		return startCity;
	}

	/**
	 * sets the start city of a flight.
	 * 
	 * @param startCity string which contains the start city of a flight.
	 */
	public void setStartCity(String startCity)
	{
		this.startCity = startCity;
	}

	/**
	 * gets the destination of a flight.
	 * @return endCity string.
	 */
	public String getEndCity()
	{
		return endCity;
	}

	/**
	 * sets the destination city of a flight.
	 * @param endCity string which contains the destination city of a flight
	 */
	public void setEndCity(String endCity)
	{
		this.endCity = endCity;
	}

	/**
	 * gets the departure time of a flight.
	 * @return departureTime Date object, what time a flight is leaving.
	 */
	public Date getDepartureTime() 
	{
		return departureTime;
	}

	/**
	 * sets the departure time of a flight in 24 hour format.
	 * @param hours, int which contains the hour of when a flight leaves in 24 hour format.
	 * @param mins, int which contains the minutes of when a flight leaves in 24 hours format.
	 */
	public void setDepartureTime(int hours, int mins)
	{
		departureTime.setHours(hours);
		departureTime.setMinutes(mins);
		//I know these methods are depreciated but I'm making use of them for this assignment.
	}

	/**
	 * gets the flight number of a flight.
	 * @return flightNumber, string.
	 */
	public String getFlightNumber() 
	{
		return flightNumber;
	}

	/**
	 * sets the flight number of a flight.
	 * @param flightNumber, String which contains the flight number.
	 */
	public void setFlightNumber(String flightNumber)
	{
		this.flightNumber = flightNumber;
	}

	/**
	 * gets the seats of a flight.
	 * @return seats, SeatMap object.
	 */
	public SeatMap getSeats()
	{
		return seats;
	}

	/**
	 * sets the seats of a flight
	 * @param seats, SeatMap object which contains all the seats of a flight.
	 */
	public void setSeats(SeatMap seats)
	{
		this.seats = seats;
	}
	
	/**
	 * 
	 * Returns a string representation of a flight with departure time in 24 hour format.
	 * @return a string representing of a flight.
	 * 
	 * */
	public String toString()
	{
		return "Flight: "+flightNumber+" from: "+startCity+" to: "+endCity+" departing: "+dateFormat.format(departureTime);
	}
}
