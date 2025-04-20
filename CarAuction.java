import java.text.DecimalFormat;
import java.util.Scanner;

public class CarAuction{
	
	static DecimalFormat formatter = new DecimalFormat("R######.00");
	
	public static void main(String[] args){
		
		String[] modelNames = {"Corrola","Hilux","Quantum","RAV4","Cruiser","Starlet"};
		double[] originalPrices = {426100.00,550800.00,762500.00,744600.00,1351000.00,313300.00};
		double[] sellingPrices = {326100.00,355080.00,650000.00,69000.00,850000.00,220000.00};
		double[] loss = new double[modelNames.length];
		
		populateLoss(loss, sellingPrices, originalPrices);
		sortVehicles (modelNames, originalPrices, sellingPrices, loss);
		
		double totalLoss = 0.0;
		for(int i = 0; i < loss.length; i++)
			totalLoss += loss[i];
		
		displayVehicles(modelNames, originalPrices, sellingPrices, loss, totalLoss);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter the model name you would like to see the selling price of :");
		String enteredModelName = input.nextLine();
		
		int indexModel = searchVehicle (modelNames,enteredModelName);
		
		if(indexModel != -1)
			System.out.println(modelNames[indexModel]+"  R"+sellingPrices[indexModel]);
		else
			System.out.println("Model name was not found");
		
	}
	
	public static void populateLoss(double loss[], double sellingPrices[], double originalPrices[]){
		
		for(int i = 0; i < loss.length; i++)
			loss[i] = originalPrices[i] - sellingPrices[i];
	}
	
	public static void sortVehicles (String modelNames[], double originalPrices[], double sellingPrices[], double loss[]){
		
		for(int i = 0; i < modelNames.length - 1; i++){
			for(int j = 0; j < modelNames.length - 1; j++){
				
				if(modelNames[j].compareTo(modelNames[j + 1]) > 0){
					
					String tempName = modelNames[j];
					modelNames[j] = modelNames[j + 1];
					modelNames[j + 1] = tempName;
					
					double tempPrice = originalPrices[j];
					originalPrices[j] = originalPrices[j + 1];
					originalPrices[j + 1] = tempPrice;
					
					tempPrice = sellingPrices[j];
					sellingPrices[j] = sellingPrices[j + 1];
					sellingPrices[j + 1] = tempPrice;
					
					tempPrice = loss[j];
					loss[j] = loss[j + 1];
					loss[j + 1] = tempPrice;
				}
			}
			
		}
	}
	
	public static void displayVehicles(String modelNames[], double originalPrices[], double sellingPrices[],double loss[], double totalLoss){
		
		System.out.println("\nVehicle Model\t\t\tOriginal Price\t\t\t\tSelling Price\t\t\tLoss");
		for(int i = 0; i < modelNames.length; i++)
			System.out.println(modelNames[i]+"\t\t\t\t"+formatter.format(originalPrices[i])+"\t\t\t\t"+formatter.format(sellingPrices[i])+"\t\t\t"+formatter.format(loss[i]));
		System.out.println("Total loss "+formatter.format(totalLoss));
	}
	
	public static int searchVehicle (String modelNames[], String enteredModelName){
		
		int index = -1;
		for(int i = 0; i < modelNames.length; i++){
			
			if(modelNames[i].equalsIgnoreCase(enteredModelName))
				index = i;
		}
		return index;
		
	}
}