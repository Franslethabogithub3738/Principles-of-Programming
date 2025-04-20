import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ThemeParkManagerApp{
	
	static DecimalFormat formatter = new DecimalFormat("R####.00");
	
	public static void main(String[] args){
		
		String[] rideNames = {"Anaconda","Golden Loop","Water Slide","Log House","Tower Terror"};
		double[] ticketPrices = {50.50,47.00,55.50,42.00,75.99};
		int[] ticketsSold = new int[rideNames.length];
		double[] revenues = new double[rideNames.length];
		
		populateTicketsSold(ticketsSold);
		calculateRevenues(ticketsSold,ticketPrices,revenues);
		sortByTicketPrice(rideNames,ticketsSold,ticketPrices,revenues);
		displayRidesInformation(rideNames,ticketsSold,ticketPrices,revenues);
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter a ride name to search: ");
		String enteredName = input.nextLine();
		
		int indexSercheRide = searchRide(rideNames,enteredName);
		
		if(indexSercheRide != -1)
			System.out.println(rideNames[indexSercheRide]+"\t"+formatter.format(ticketPrices[indexSercheRide]));
		else
			System.out.println("Ride not found");
	}
	
	public static void populateTicketsSold(int ticketsSold[]){
		
		Random randomizer = new Random();
		for (int i = 0; i < ticketsSold.length; i++){
			
			ticketsSold[i] = randomizer.nextInt(150 - 1 + 1) + 1;
		}
	}
	
	public static void sortByTicketPrice (String rideNames[], int ticketsSold[],double ticketPrices[], double revenues[]){
		
		for(int i = 0; i < rideNames.length - 1; i++){
			for(int j = 0; j < rideNames.length - 1; j++){
				
				if(rideNames[j].compareTo(rideNames[j + 1]) > 0){
					
					String tempRideName = rideNames[j];
					rideNames[j] = rideNames[j + 1];
					rideNames[j + 1] = tempRideName;
					
					int tempNum = ticketsSold[j];
					ticketsSold[j] = ticketsSold[j + 1];
					ticketsSold[j + 1] = tempNum;
					
					double tempPrice = ticketPrices[j];
					ticketPrices[j] = ticketPrices[j + 1];
					ticketPrices[j + 1] = tempPrice;
				
					
					double tempRevenue = revenues[j];
					revenues[j] = revenues[j + 1];
					revenues[j + 1] = tempRevenue;
				}
			}
		}
	}
	
	public static void calculateRevenues(int ticketsSold[], double ticketPrices[], double revenues[]){
		
		for(int i = 0; i < revenues.length; i++)
			revenues[i] = ticketsSold[i]*ticketPrices[i];
	}
	
	public static int searchRide(String rideNames[], String enteredName){
		
		int index = -1;
		
		for(int i = 0;i < rideNames.length; i++){
			
			if(rideNames[i].equals(enteredName))
				index = i;
		}
		
		return index;
	}
	
	public static void displayRidesInformation(String rideNames[], int ticketsSold[], double ticketPrices[], double revenues[]){
		
		System.out.println("\nRide name\t\tTicket Sold\t\tTicket Prices\t\tRevenue");
		
		for(int i = 0; i < rideNames.length; i++)
			System.out.println(rideNames[i]+"\t\t"+ticketsSold[i]+"\t\t\t"+formatter.format(ticketPrices[i])+"\t\t\t"+formatter.format(revenues[i]));
	}
}