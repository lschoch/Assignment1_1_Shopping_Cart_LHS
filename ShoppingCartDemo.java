
/**
 * A class to test the methods defined in the class ShoppingCart.
 * 
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public class ShoppingCartDemo {
	
	public static void main(String[] args) throws InterruptedException{
		// Item ID is calculated from timestamp on instantiation.
		Item item1 = new Item("Table", 30000, 2);
		// Pause between instantiation of new items to ensure unigue ID's
		Thread.sleep(100); 
		Item item2 = new Item("Chair", 10000, 1);
		Thread.sleep(100);
		Item item3 = new Item("Fishing Reel", 7500, 1);
		Thread.sleep(100);
		Item item4 = new Item("Tackle Box", 2150, 2);
		Thread.sleep(100);
		Item item5 = new Item("Hiking Boots", 9585, 20);
		Thread.sleep(100);
		Item item6 = new Item("Skis", 25599, 1);
		Item[] contents = {item1, item2, item2, item5, item4, item4, item6, item3};
		
		// A cart that is not full
		ShoppingCart aCart = new ShoppingCart (contents);
		
		displayContents(aCart);
		Item[] sort = new Item[aCart.getCartSize()];
		sort = aCart.cartToArray(); //sortByName();
		for (int i=0; i<sort.length; i++)
			if (sort[i] !=null)
				System.out.print(sort[i].itemToString() + "\n");
		System.out.println("");
		displayContents(aCart);
		
		
//		System.out.println("//----------------------------------------------------------------------");
//		System.out.println("// Cart contents are printed by converting the cart to an array\n"
//			+ "// and printing each item using the item.toString method.\n\n"
//			+ "// Contents of cart created with preferred constructor:");
//		displayContents(aCart);
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Contents of cart after removing item5 (Hiking Boots) with removeSpecificItem method:");
//		aCart.removeSpecificItem(item5);
//		displayContents(aCart);
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Testing isCartEmpty method\n"
//				+ "// Cart is not empty, isCartEmpty method should return false.");
//		String str = "";
//		str = aCart.isCartEmpty() ? "INCORRECT" : "CORRECT";
//		System.out.println("isCartEmpty returns: " + aCart.isCartEmpty() + ", " + str + "\n");
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Contents of cart after adding 2 counts of item5 (Hiking Boots)with addItem method:\n"
//				+ "// (Recall that item5 is 20 pairs of boots so adding 2 items5's = 40 pairs added.");
//		aCart.addItem(item5, 2);
//		displayContents(aCart);
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Contents of cart after removing a non-specified item with removeAnyItem method:");
//		Item itemRemoved = new Item();
//		itemRemoved = aCart.removeAnyItem();
//		displayContents(aCart);
//		System.out.println("item removed: " + itemRemoved.getName() + ", quantity: " 
//				+ itemRemoved.getQuantity() + ".\n");
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Testing containsItem method\n"
//				+ "// Cart currently contains every item, containsItem method should return true\n"
//				+ "// for any item.");
//		str = aCart.containsItem(item4) ? "CORRECT" : "INCORRECT";
//		System.out.println("containsItem(item4) returns: " + aCart.containsItem(item4) + ", " + str);
//		aCart.removeSpecificItem(item6);
//		str = aCart.containsItem(item6) ? "INCORRECT" : "CORRECT";
//		System.out.println("after removing item6, containsItem(item6) returns: " 
//				+ aCart.containsItem(item6) + ", " + str + "\n");
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Testing numberOfSpecificItem method\n"
//				+ "// Cart currently contains 2 Tackle Box entries (item4), numberOfSpecificItem(item4)\n"
//				+ "// should return 2.");
//		str = aCart.numberOfSpecificItem(item4) == 2 ? "CORRECT" : "INCORRECT";
//		System.out.println("numberOfSpecificItem(item4) returns: " + aCart.numberOfSpecificItem(item4) 
//			+ ", " + str + "\n");
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Testing getCartSize method\n"
//				+ "// By manual count, cart currently contains 7 items.\n"
//				+ "// getCartSize should return 7.");
//		str = aCart.getCartSize() == 7 ? "CORRECT" : "INCORRECT";
//		System.out.println("// Current cart contents:");
//		displayContents(aCart);
//		System.out.println("getCurrentSize returns: " + aCart.getCartSize() 
//			+ ", " + str + "\n");
//		
//		System.out.println("//----------------------------------------------------------------------\n"
//				+ "// Output of orderToString method followed by a listing of the cart's items\n"
//				+ "// for verification. Listing the cart's contents uses the cartToArray method.\n");
//		System.out.println("\n\n");
//		System.out.println(aCart.orderToString() + "\n");
//		displayContents(aCart);
//		displayContents(aCart);
//		
//		aCart.getTotalCost();
//		System.out.println(aCart.getCartSize());
//		
	} // end main
	
	/**
	 * A method to display cart contents by converting cart to array
	 * and printing each item with the item.toString method.	
	 * @param cart The cart to be displayed.
	 */
	private static void displayContents(ShoppingCart cart) {
		Item[] ar = cart.cartToArray();
		for (int i=0; i<ar.length; i++) 
			System.out.println(ar[i].itemToString());
		System.out.println("");
	} // end displayContents
	
} // end class