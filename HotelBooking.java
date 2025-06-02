import java.util.Scanner; //Scanner class is imported from java.util package
import java.text.DecimalFormat; //Decimal class is imported frim java.text package

public class HotelBooking
{//Start class
	public static void main(String[] args)
	{//Start main method
		
		//Instantiate objects
		Scanner input = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("R#,###.00");
		
		//Declare variables
		int NumRooms, Choice, NumNight;
		double AmountPerRoom, AmountDue, TotalAmountMade = 0;
		boolean KeepSessionActive = true;
		
		//Input
		System.out.print("Enter the number of rooms available: ");
		NumRooms = input.nextInt();
		System.out.print("Enter the amount per room: ");
		AmountPerRoom = input.nextDouble();
		
		while(KeepSessionActive)
		{//Begin while-loop
			
			System.out.print("\nHotel Booking System: \n"+
							"1. Book a Room\n"+
							"2. Checkout a Room\n"+
							"3. Check Availability\n"+
							"4. Exit\n"+
							"Enter your choice: ");
			Choice = input.nextInt();
			
			switch (Choice)
			{//Begin switch
				
				case 1:
					System.out.print("How many night would like to book a room for?: ");
					NumNight = input.nextInt();
					AmountDue = NumNight*AmountPerRoom;
					
					//Accumulating the total amount made
					TotalAmountMade += AmountDue;
					
					//Display AmountDue
					System.out.println("Room booked successfully and your total price for "+NumNight+" nights is "+formatter.format(AmountDue));
					NumRooms--;
				continue;
				
				case 2:
					System.out.println("Room successfully checked out!.");
				continue;
				
				case 3:
					System.out.println("Available Rooms: "+NumRooms);
				continue;
				
				case 4:
					System.out.println("Exiting Hotel Booking System");
					KeepSessionActive = false;
				
				default:
					System.out.println("Invalid choice!");
			}//End switch
			
			//Display Business Summary
			System.out.println("Number of available rooms: "+NumRooms);
			System.out.println("Total Amount made: "+formatter.format(TotalAmountMade));
			
		}//End while loop
		
	}//End main method
}//End class