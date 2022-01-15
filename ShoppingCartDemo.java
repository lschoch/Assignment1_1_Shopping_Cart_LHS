import java.util.Arrays;
import java.util.Comparator;

/**
 * A class to test the methods defined in the class ShoppingCart.
 * 
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public class ShoppingCartDemo {
	
	public static void main(String[] args) throws InterruptedException{
		// Item ID is set from timestamp on instantiation.
		Item item1 = new Item("Table", 30000, 1);
		// Pause between instantiation of new items to ensure unique ID's
		Thread.sleep(100); 
		Item item2 = new Item("Chair", 10000, 2);
		Thread.sleep(100);
		Item item3 = new Item("Fishing Reel", 7500, 3);
		Thread.sleep(100);
		Item item4 = new Item("Tackle Box", 2150, 1);
		Thread.sleep(100);
		Item item5 = new Item("Hiking Boots", 9585, 2);
		Thread.sleep(100);
		Item item6 = new Item("Skis", 25599, 3);
		Item[] contents = {item1, item2, item3, item4, item5, item6};
		
		// A cart that is not full
		ShoppingCart aCart = new ShoppingCart (contents);
		
		System.out.println("//----------------------------------------------------------------------");
		System.out.println("// Cart contents are displayed by converting the cart to an array,\n"
			+ "// sorting on name, and printing each item using the item.toString \n"
			+ "// method.\n\n"
			+ "// Contents of cart created with preferred constructor:");
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing removeSpecificItem method.\n"
				+ "// Contents of cart after removing item5 (Hiking Boots) with \n"
				+ "// removeSpecificItem method:");
		aCart.removeSpecificItem(item5);
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing isCartEmpty method\n"
				+ "// Cart is not empty, isCartEmpty method should return false.");
		String str = "";
		str = aCart.isCartEmpty() ? "INCORRECT" : "CORRECT";
		System.out.println("isCartEmpty returns: " + aCart.isCartEmpty() + ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Contents of cart after adding 2 counts of item5 (Hiking Boots)with addItem method:\n");
		aCart.addItem(item5);
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Contents of cart after removing a non-specified item with removeAnyItem method:");
		Item itemRemoved = new Item();
		itemRemoved = aCart.removeAnyItem();
		displayContents(aCart);
		System.out.println("item removed: " + itemRemoved.getName() + ", quantity: " 
				+ itemRemoved.getQuantity() + ".\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing containsItem method\n");
		System.out.println("containsItem(item4) returns: " + aCart.containsItem(item4) + "\n"
				+ "Current cart contents displayed for verification (item4 is \"Tackle Box\"");
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing removeSpecificItem method\n");
		aCart.removeSpecificItem(item6);
		str = aCart.containsItem(item6) ? "INCORRECT" : "CORRECT";
		System.out.println("after removing item6 with removeSpecificItem, containsItem(item6) "
				+ "returns: " + aCart.containsItem(item6) + ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing numberOfSpecificItem method\n"
				+ "// Cart currently contains 2 Tackle Box entries (item4), numberOfSpecificItem(item4)\n"
				+ "// should return 2.");
		str = aCart.numberOfSpecificItem(item4) == 2 ? "CORRECT" : "INCORRECT";
		System.out.println("numberOfSpecificItem(item4) returns: " + aCart.numberOfSpecificItem(item4) 
			+ ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing getCartSize method\n"
				+ "// By manual count, cart currently contains 7 items.\n"
				+ "// getCartSize should return 7.");
		str = aCart.getCartSize() == 7 ? "CORRECT" : "INCORRECT";
		System.out.println("// Current cart contents:");
		displayContents(aCart);
		System.out.println("getCurrentSize returns: " + aCart.getCartSize() 
			+ ", " + str + "\n\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing the orderToString method:\n"
				+ "// The following shows the output of the orderToString method followed\n"
				+ "// by a listing of the cart's items for verification. Listing the cart's\n"
				+ "// contents uses the cartToArray method.\n");
		//System.out.println("\n");
		System.out.println(aCart.orderToString() + "\n");
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing getTotalCost method.\n"
				+ "// See preceding orderToCart output for verification.\n");
		str = aCart.getTotalCost() == 469500 ? "CORRECT" : "INCORRECT";
		System.out.println("getTotalCost returns: " + aCart.getTotalCost() + ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing removeAllItems method and confirming with isCartEmpty method.\n");
		aCart.removeAllItems();
		str = aCart.isCartEmpty() ? "CORRECT" : "INCORRECT";
		System.out.println("After removeAllItems, isCartEmpty returns: " + aCart.isCartEmpty() + ", " + str + "\n");
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Adding and removing items using the appropriate methods.\n"
				+ "// Contents after adding five items:\n");
		aCart.addItem(new Item("Toothpaste", 200, 10));
//		aCart.addItem(item6, 1);
//		aCart.addItem(item1, 5);
//		aCart.addItem(item5, 2);
//		aCart.addItem(item3, 1);
		displayContents(aCart);
		System.out.println(aCart.orderToString());
		
	} // end main
	
	/**
	 * A method to display cart contents by converting cart to array
	 * and printing each item with the item.toString method.	
	 * @param cart The cart to be displayed.
	 */
	private static void displayContents(ShoppingCart cart) {
		Item[] ar = Arrays.copyOf(cart.cartToArray(), cart.cartToArray().length);
		Arrays.sort(ar, Comparator.comparing(Item::getName)); // Sort on name.
		System.out.println("Cart contents:");
		for (int i=0; i<ar.length; i++) 
			System.out.println(ar[i].itemToString());
		System.out.println(" ");
	} // end displayContents
	
} // end class