import java.util.Scanner;
public class InventoryProject {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		Arrays are reference types, unlike primitive types. 
		Inventory[] inventoryArray = new Inventory[4];
		
		
		for (int i = 0; i < 4; i++) {
			System.out.println("Please provide an item: ");
			String userItem = String.valueOf(scanner.nextLine());
			System.out.println("Please provide that item's quantity: ");
			int userQty = Integer.valueOf(scanner.nextLine());
			System.out.println("Please provide the price of the item: ");
			double userPrice = Double.valueOf(scanner.nextLine());
			
//			This populates the inventory array with the items specified within "Inventory's" parenthesis.
			
			inventoryArray[i] = new Inventory(userItem, userQty, userPrice);
			
		}
		double sum = 0;
		System.out.printf("%-20s%-20s%-20s%-20s%n","Item Name","Qty", "Price", "Value");
		System.out.println("===================================================================");
		for (Inventory inv : inventoryArray) {
			System.out.println(inv);
			sum += inv.inventoryCalc();
		}
		System.out.println("===================================================================");
		System.out.printf("%-60s%.02f","Total", sum);
		scanner.close();
	}

}

class Inventory {
	
	String itemName;
	int qty = 0;
	double price = 0;
	
	public Inventory(String itemName, int qty, double price) {
//		this."variables" refer to class variables
//		if it doesn't have "this." it refers to function variables
		this.itemName = itemName;
		this.qty = qty;
		this.price = price;
	}
	
//	the @override is telling java that we mean to overwrite the original meaning of a function
	@Override
//	 the toString is overwriting the print function for all class
	public String toString() {
//		 means tab (like tab over)
		return String.format("%-20s%-20d%-20.02f%-20.02f", this.itemName, this.qty, this.price, inventoryCalc());
//		toStrings
	}
	
	public double inventoryCalc() {
//		putting double in the parenthesis is called casing. It makes that variable behave as that
//		data type for just that instance.
		return (double)this.qty * this.price;
	}
	
}