package AssignmentAirline;
import java.util.Scanner;

/**
 * 
 * This class provides a user interface which enables the customer
 * to view an airline reservation seating plan, choose and reserve seats. 
 * The user receives confirmation of the reservation.
 * 
 * @author memN0ps
 * 
 * */
public class AirlineReservationApplication
{
	private static Flight[] jetSunFlights;
	private static Flight[] fastAirFlights;
	
	public static void main(String[] args) 
	{
		createFlights(); //Hardcoded flights
		int airLine;
		Airline fastAir = new FastAir();
		Airline jetSun = new JetSun();
		fastAir.setFlights(fastAirFlights);
		jetSun.setFlights(jetSunFlights);
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Which airline would you like to travel with?");
		System.out.println("1: FastAir Airline");
		System.out.println("2: JetSun Airline");
		airLine = keyboard.nextInt();
		
		if (airLine == 1)
		{
			System.out.println(""+fastAir);
		}
		else if (airLine == 2)
		{
			System.out.println(""+jetSun);
		}
		
		System.out.println("Which flight would you like to reserve a seat on?");
		
		if (airLine == 1)
		{
			for (int x = 0; x < fastAir.getFlights().length; x++)
			{
				System.out.println((x + 1)+": "+fastAir.getFlights()[x]);
			}
		}
		else if (airLine == 2)
		{
			for (int x = 0; x < jetSun.getFlights().length; x++)
			{
				System.out.println((x + 1)+": "+jetSun.getFlights()[x]);
			}
		}
		
		int flightChoice = keyboard.nextInt();
		Flight newFlight = null;
		
		if (airLine == 1)
		{
			newFlight = fastAir.getFlights()[flightChoice - 1];
		}
		else if (airLine == 2)
		{
			newFlight = jetSun.getFlights()[flightChoice - 1];
		}

		System.out.println("Booking seats for "+newFlight);
		//PRINTING OUT THE SEATMAP
		System.out.println(newFlight.getSeats().toString());
		
		//This loop exits upon the users choice and prompts the user for input
		while (true)
		{
			System.out.println("1. Reserve First Class");
			System.out.println("2. Reserve Economy Class");
			System.out.println("3. Show Seating Map");
			System.out.println("4. Quit");
			
			int classChoice = keyboard.nextInt();
			int seatTypeChoice = 0;
			
			if (classChoice == 1 || classChoice == 2)
			{
				System.out.println("Which seat type?");
				System.out.println("1. WINDOW");
				System.out.println("2. AISLE");
				System.out.println("3. MIDDLE");
				
				seatTypeChoice = keyboard.nextInt();
			}
			
			if (classChoice == 1)
			{
				Seat newSeat = null;
				
				if (seatTypeChoice == 1)
				{
					if (airLine == 1)
					{
						newSeat = fastAir.reserveFirstClass(newFlight, SEATTYPE.WINDOW);
					}
					else if (airLine == 2)
					{
						newSeat = jetSun.reserveFirstClass(newFlight, SEATTYPE.WINDOW);
					}
				}
				else if (seatTypeChoice == 2)
				{
					if (airLine == 1)
					{
						newSeat = fastAir.reserveFirstClass(newFlight, SEATTYPE.AISLE);
					}
					else if (airLine == 2)
					{
						newSeat = jetSun.reserveFirstClass(newFlight, SEATTYPE.AISLE);
					}
				}
				else
				{
					if (airLine == 1)
					{
						newSeat = fastAir.reserveFirstClass(newFlight, SEATTYPE.MIDDLE);
					}
					else if (airLine == 2)
					{
						newSeat = jetSun.reserveFirstClass(newFlight, SEATTYPE.MIDDLE);
					}
				}	
				
				System.out.println(newFlight.getSeats().toString());
				
				if (newSeat == null)
				{
					System.out.println("Reservation can not be made.");
				}
				else
				{
					System.out.println("Seat reservation: "+newSeat.seatDescription());
				}
			}
			else if (classChoice == 2)
			{
				Seat newSeat = null;
				
				if (seatTypeChoice == 1)
				{
					if (airLine == 1)
					{
						newSeat = fastAir.reserveEconomy(newFlight, SEATTYPE.WINDOW);
					}
					else if (airLine == 2)
					{
						newSeat = jetSun.reserveEconomy(newFlight, SEATTYPE.WINDOW);
					}
				}
				else if (seatTypeChoice == 2)
				{
					if (airLine == 1)
					{
						newSeat = fastAir.reserveEconomy(newFlight, SEATTYPE.AISLE);
					}
					else if (airLine == 2)
					{
						newSeat = jetSun.reserveEconomy(newFlight, SEATTYPE.AISLE);
					}
				}
				else
				{
					if (airLine == 1)
					{
						newSeat = fastAir.reserveEconomy(newFlight, SEATTYPE.MIDDLE);
					}
					else if (airLine == 2)
					{
						newSeat = jetSun.reserveEconomy(newFlight, SEATTYPE.MIDDLE);
					}
				}	
				
				System.out.println(newFlight.getSeats().toString());
				
				if (newSeat == null)
				{
					System.out.println("Reservation can not be made.");
				}
				else
				{
					System.out.println("Seat reservation: "+newSeat.seatDescription());
				}
			}
			else if (classChoice == 3)
			{
				System.out.println(newFlight.getSeats().toString());
			}
			else if (classChoice == 4)
			{
				System.out.println("Goodbye.");
				break;
			}
		}
	}
	
	/**
	 * 
	 * This method intialises two arrays of flights, hardcoded. 
	 *  
	 * 
	 * */
	public static void createFlights()
	{
		jetSunFlights = new Flight[3];
		fastAirFlights = new Flight[3];
		
		jetSunFlights[0] = new Flight("AKL Auckland International Airport", "MEL Melbourne International Airport", 15, 00, "GF345", new BoeingSeatMap());
		jetSunFlights[1] = new Flight("LAX Los Angeles World Airports", "JFK John F. Kennedy International Airport ", 10, 00, "LA246", new AirBusSeatMap());
		jetSunFlights[2] = new Flight("SYD Sydney Kingsford Smith Airport", "LHR London Heathrow Airport", 16, 20, "AK345", new AirBusSeatMap());
		
		fastAirFlights[0] = new Flight("AKL Auckland International Airport", "LAX Los Angeles World Airports", 18, 45, "LA998", new AirBusSeatMap());
		fastAirFlights[1] = new Flight("SYD Sydney Kingsford Smith Airport", "MEL Melbourne International Airport", 21, 20, "GF249", new BoeingSeatMap());
		fastAirFlights[2] = new Flight("CAN Guangzhou Baiyun International Airport", "DEL Indira Gandhi International Airport", 23, 30, "AK346", new AirBusSeatMap());
	}
}
