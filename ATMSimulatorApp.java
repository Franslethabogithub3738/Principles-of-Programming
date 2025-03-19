import java.util.Scanner; //Scanner class is imported from java.util package
import java.text.DecimalFormat; //DecimalFormat class is imported from java.text package

public class ATMSimulatorApp
{//Start class
	public static void main(String[] args)
	{//Start main method
		
		//Declare variables
		Scanner input;
		boolean keepSessionActive = true;
		double rBalance = 5000;
		double rDeposit;
		DecimalFormat formatter;
		int iOption;
		double rAmountWithdraw;
		
		//Instantiate objects
		input = new Scanner(System.in);
		formatter = new DecimalFormat("R####.00");
		
		
		while ( keepSessionActive )
		{//Begin while
	
			//ATM Menu
			System.out.println("\t\nATM SIMULATOR");
			System.out.println("1. Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			
			//input
			System.out.print("Enter option: ");
			iOption = input.nextInt();
			
			switch (iOption)
			{//Begin switch
				
				case 1:
					System.out.println("Balance: "+formatter.format(rBalance));
				break;
				
				case 2:
					System.out.print("Enter the deposit amount: R");
					rDeposit = input.nextDouble();
					System.out.println("Amount deposited successfully: "+formatter.format(rDeposit));
					rBalance += rDeposit;
				break;
				
				case 3:
					System.out.print("Enter amount withdraw: R");
					rAmountWithdraw = input.nextDouble();
					
					if (rAmountWithdraw < rBalance)
					{//Start if-block
						rBalance -= rAmountWithdraw;
						System.out.println("Withdraw successful");
					}//End if-block
					
					else
					{//Begin else-block
						System.out.println("Insufficient Amount");
						continue;
					}//End else-block
				break;
				
				case 4:
					System.out.println("Thank you,byee...");
					keepSessionActive = false;
				break;
				
			}//End switch
			
		}//End while
		
	}//End main method
}//End class