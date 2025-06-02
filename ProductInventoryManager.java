import java.util.Scanner;
import java.text.DecimalFormat;

//@Author: Lethabo Matsi

public class ProductInventoryManager{
	
	static Scanner input = new Scanner(System.in);
	static DecimalFormat formatter = new DecimalFormat("R####,00");
	
	public static void main(String[] args){
		
		String[] productNames = {"Sugar", "Laptop", "Book", "Dress", "Sphahlo", "Panado"};
		String[] productCategories = {"Food", "Electronics", "Stationery", "Clothing", "Food", "Health"};
		double[] productPrices = new double[productNames.length];
		int[] productQuantities = new int[productNames.length];
		
		System.out.println("\n=== PRODUCT INVENTORY MANAGER ===");
		System.out.println("1. Add product");
		System.out.println("2. View products");
		System.out.println("3. Search product by name");
		System.out.println("4. Sort products by name");
		System.out.println("5. Update stock quantity");
		System.out.println("6. Exit");
		System.out.print("Choose an option: ");
		int userOption = input.nextInt();
		
		while(userOption != 6){
			
			switch(userOption){
				
				case 1:
					addProduct(productNames, productPrices, productQuantities);
				break;
				
				case 2:
					viewProducts(productNames, productCategories, productPrices, productQuantities);
				break;
				
				case 3:
					int index = searchProduct(productNames);
					
					if(index != -1)
						System.out.print(productNames[index]+" found and the price is "+formatter.format(productPrices[index]));
					else
						System.out.print("Product not found");
				break;
				
				case 4:
					sortProducts(productNames, productCategories, productPrices, productQuantities);
				break;
				
				case 5:
					updateStockQuantity(productNames,productQuantities);
				break;
				
				case 6:
				break;
				
				default:
					System.out.print("\nInvalid Option");
			}
			
			System.out.println("\n=== PRODUCT INVENTORY MANAGER ===");
			System.out.println("1. Add product");
			System.out.println("2. View products");
			System.out.println("3. Search product by name");
			System.out.println("4. Sort products by name");
			System.out.println("5. Update stock quatity");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			userOption = input.nextInt();
		}
		System.out.println("Exiting....!");
	}
	
	public static void addProduct(String productNames[], double productPrices[], int productQuantities[]){
		
		System.out.println("\n");
		for (int i = 0; i < productNames.length; i++){
			
			System.out.print("Enter price for "+productNames[i]+": R");
			productPrices[i] = input.nextDouble();
			System.out.print("Enter quantity for "+productNames[i]+": ");
			productQuantities[i] = input.nextInt();
		}
	}
	
	public static void viewProducts(String productNames[], String productCategories[],double productPrices[], int productQuantities[]){
		
		System.out.println("\nNo.\t\tName\t\tCategory\t\tPrice\t\tQuantity");
		
		for(int i = 0; i < productNames.length; i++){
			
			System.out.println(i+1+"\t\t"+productNames[i]+"\t\t"+productCategories[i]+"\t\t"+formatter.format(productPrices[i])+"\t\t"+productQuantities[i]);
		}
	}
	
	public static int searchProduct(String productNames[]){
		
		int productIndexNum = -1;
		System.out.print("\nEnter the name of the product you want to search: ");
		String enteredName = input.next();
		
		for(int i = 0; i < productNames.length; i++){
			
			if(enteredName.equalsIgnoreCase(productNames[i]))
				productIndexNum = i;
		}
		return productIndexNum;
	}
	
	public static void sortProducts(String productNames[], String productCategories[], double productPrices[], int productQuantities[]){
		
		for(int i = 0; i < productNames.length; i++){
			for(int j = 0; j < productNames.length - 1; j++){
				
				if(productNames[j].compareTo(productNames[j + 1]) > 0){
					
					String tempString = productNames[j];
					productNames[j] = productNames[j + 1];
					productNames[j + 1] = tempString;
					
					tempString = productCategories[j];
					productCategories[j] = productCategories[j + 1];
					productCategories[j + 1] = tempString;
					
					double tempValue = productPrices[j];
					productPrices[j] = productPrices[j + 1];
					productPrices[j + 1] = tempValue;
					
					int tempNum = productQuantities[j];
					productQuantities[j] = productQuantities[j + 1];
					productQuantities[j + 1]  = tempNum;
				}
			}
		}
	}
	
	public static void updateStockQuantity(String productNames[] ,int productQuantities[]){
		
		System.out.print("Enter the product name you want to update: ");
		String enteredProduct = input.next();
		
		int indexNumber = -1;
		
		for(int i = 0; i < productNames.length; i++){
			
			if(enteredProduct.equalsIgnoreCase(productNames[i]))
				indexNumber = i;
		}
		
		if(indexNumber != -1){
			
			System.out.print("Enter new quantity: ");
			productQuantities[indexNumber] = input.nextInt();
			System.out.println("Stock updated");
		}
		
		else
			System.out.println(enteredProduct+" is not in stock!!");
	}
}