import java.util.Scanner; //Scanner class is imported from java.util package

public class EmailAdrressApp
{//Start class
	public static void main(String[] args)
	{//Start main method
		
		//Instantiation of the Scanner object
		Scanner input = new Scanner(System.in);
		
		//Input
		System.out.print("\nEnter your contact details here :");
		String contactDetails = input.nextLine();
		System.out.print("Enter email address domain here :");
		String emailAddressDomain = input.next();
		
		//Invoking method
		contactDetails = getNumbers(contactDetails);
		String emailAddress = contactDetails+"@"+emailAddressDomain;
		displayEmailAddress(contactDetails, emailAddress);
		
		
	}//End main method
	
	public static String getNumbers(String numbers)
	{//Start getNumbers method
		
		int lastIndexSpace = numbers.lastIndexOf(" ");
		String phoneNumbers = numbers.substring(lastIndexSpace+1);
		return phoneNumbers;
		
	}//End getNumbers method
	
	public static void displayEmailAddress(String phoneNo, String mailAddress)
	{//Begin displayEmailAddress method
		
		System.out.println("Extracted numeric substring: "+phoneNo);
		System.out.println("Email address: "+mailAddress);
		
	}//End displayEmailAddress method
		
}//End class