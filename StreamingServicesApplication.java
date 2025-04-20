import java.util.Scanner;
import java.util.Random;

public class StreamingServicesApplication{
	public static void main(String[] args){
		
		String[] serviceProviders = {"YouTube","Netflix","DSTV","ShowMax","PrimeTV","SABC+"};
		String[] originCountry = {"United States","United States","South Africa","South Africa","United States","South Africa"};
		int[] subscribers = new int[serviceProviders.length];
		int[] userRatings = new int[serviceProviders.length];
		
		populateSubscribers(subscribers);
		populateRatings(userRatings,serviceProviders);
		int mostWatched = mostWatchedService(subscribers);
		
		System.out.println("\nMost watched service provider : "+serviceProviders[mostWatched]+" "+subscribers[mostWatched]+" subscribers");
		sortServiceProvider(serviceProviders,originCountry,subscribers,userRatings);
		displayStreamingServices(serviceProviders,originCountry,subscribers,userRatings);
	}
	
	public static void populateSubscribers(int subscribers[]){
		
		Random randomizer = new Random();
		
		for(int i = 0; i < subscribers.length; i++){
			subscribers[i] = randomizer.nextInt(500000 - 100000 + 1) + 100000;
		}
	}
	
	public static void populateRatings(int userRatings[], String serviceProviders[]){
		
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < userRatings.length; i++){
			
			System.out.print("Enter user ratings(1 - 5) for "+serviceProviders[i]+": ");
			userRatings[i] = input.nextInt();
		}
	}
	
	public static int mostWatchedService (int subscribers[]){
		
		int mostHighest = 0;
		
		for(int i = 0; i < subscribers.length; i++){
			
			if(subscribers[i] > mostHighest)
				mostHighest = i;
		}
		return mostHighest;
	}
	
	public static void sortServiceProvider (String serviceProviders[], String originCountry[], int subscribers[], int userRatings[]){
		
		for (int i = 0; i < serviceProviders.length - 1; i++){
			for (int j = 0; j < serviceProviders.length - 1; j++){
				
				if(serviceProviders[j].compareTo(serviceProviders[j+1]) > 0){
								
					String tempString = serviceProviders[j];
					serviceProviders[j] = serviceProviders[j+1];
					serviceProviders[j+1] = tempString;
					
					tempString = originCountry[j];
					originCountry[j] = originCountry[j+1];
					originCountry[j+1] = tempString;
					
					int tempInt = subscribers[j];
					subscribers[j] = subscribers[j+1];
					subscribers[j+1] = tempInt;
					
					tempInt = userRatings[j];
					userRatings[j] = userRatings[j+1];
					userRatings[j+1] = tempInt;
				}
			}
		}
	}
	
	public static void displayStreamingServices(String serviceProviders[], String originCountry[], int subscribers[], int userRatings[]){
		
		System.out.println("==========================================================================================");
		System.out.println("Service providers\t\tCountry\t\t\tSubsribers\tUser Ratings");
		for(int i = 0; i < serviceProviders.length;i++)
			System.out.println(serviceProviders[i]+"\t\t\t\t"+originCountry[i]+"\t\t"+subscribers[i]+"\t\t"+userRatings[i]);
	}
}