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
		Item item4 = new Item("Tackle Box", 2150, 3);
		Thread.sleep(100);
		Item item5 = new Item("Hiking Boots", 9585, 2);
		Thread.sleep(100);
		Item item6 = new Item("Skis", 25599, 1);
		Item[] contents = {item1, item2, item3, item4, item5, item6, item6, item6};
		
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
				+ "// removeSpecificItem(item5) returns: " + aCart.removeSpecificItem(item5) + "\n"
				+ "// Contents of cart after removing item5 (Hiking Boots)");
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing isCartEmpty method\n"
				+ "// Cart is not empty, isCartEmpty method should return false.");
		String str = "";
		str = aCart.isCartEmpty() ? "INCORRECT" : "CORRECT";
		System.out.println("isCartEmpty returns: " + aCart.isCartEmpty() + ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing addItem method");
		System.out.println("additem(item5) returns: " + aCart.addItem(item5));
		System.out.println("Contents of cart after adding item5 (Hiking Boots) with addItem method:");
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing removeAnyItem method.");
		System.out.println("removeAnyItem() returns: \n" + aCart.removeAnyItem().itemToString() + "\n"
				+ "// Contents of cart after removing a non-specified item with removeAnyItem method:");
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing containsItem method:");
		System.out.println("addItem(item1) returns: " + aCart.addItem(item1));
		str = aCart.containsItem(item1) ? "CORRECT" : "INCORRECT";
		System.out.println("containsItem(item1) returns: " + aCart.containsItem(item1) + " " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing numberOfSpecificItem method\n"
				+ "// Cart currently contains 3 Ski items (item6), numberOfSpecificItem(item6)\n"
				+ "// should return 3.");
		str = aCart.numberOfSpecificItem(item6) == 3 ? "CORRECT" : "INCORRECT";
		System.out.println("numberOfSpecificItem(item6) returns: " + aCart.numberOfSpecificItem(item6) 
			+ ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing getCartSize method\n"
				+ "// By manual count, cart currently contains 8 items.\n"
				+ "// getCartSize should return 8.");
		str = aCart.getCartSize() == 8 ? "CORRECT" : "INCORRECT";
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
		str = aCart.getTotalCost() == 211346 ? "CORRECT" : "INCORRECT";
		System.out.println("getTotalCost returns: " + aCart.getTotalCost() + ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing removeAllItems method and confirming with isCartEmpty method.");
		aCart.removeAllItems();
		str = aCart.isCartEmpty() ? "CORRECT" : "INCORRECT";
		System.out.println("After removeAllItems, isCartEmpty returns: " + aCart.isCartEmpty() + ", " + str + "\n");
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Adding items to the empty cart.\n"
				+ "// Contents after adding five items:\n");
		System.out.println("addItem(new Item(\"heater\", 8099, 1) returns: " + aCart.addItem(new Item("heater", 8099, 1)));
		Thread.sleep(100); // Pause between instantiation of new items to ensure unique ID's
		System.out.println("addItem(new Item(\"toothpaste\", 225, 2) returns: " + aCart.addItem(new Item("toothpaste", 225, 2)));
		Thread.sleep(100); 
		System.out.println("addItem(new Item(\"comb\", 299, 1) returns: " + aCart.addItem(new Item("comb", 299, 1)));
		Thread.sleep(100); 
		System.out.println("addItem(new Item(\"razor\", 1499, 1) returns: " + aCart.addItem(new Item("razor", 1499, 3)));
		Thread.sleep(100); 
		System.out.println("addItem(new Item(\"mouthwash\", 350, 1) returns: " + aCart.addItem(new Item("mouthwash", 350, 1)));
		displayContents(aCart);
		
		System.out.println("//----------------------------------------------------------------------\n"
				+ "// Testing removeItemByName method:");
		System.out.println("removeItemByName(\"heater\") returns: " + aCart.removeItemByName("heater"));
		displayContents(aCart);
		aCart.orderToString();
		
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