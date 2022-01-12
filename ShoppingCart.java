import java.util.*;

/**
 * A class that implements a bag of items using a ResizeableArrayBag ADT.
 * The size of the bag is limited only by the computer's available
 * memory.
 * 
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public class ShoppingCart {
	// private String cartID;
	private ResizeableArrayBag<Item> cart;
	// private int intID = 1;

	/** Creates a bag with the specified contents. */
	public ShoppingCart(Item[] contents) {
		// ID's are assigned as consecutive integers starting with 1.
		// Convert to String to allow concatenation.
		// this.cartID = String.valueOf(intID);
		// intID++;
		cart = new ResizeableArrayBag<Item>();
		for (int i=0; i<contents.length; i++) {
			cart.add(contents[i]);
		}
	} // end constructor[]
	
	/**
	 * Removes a specified item from the cart.
	 * @parameter item The item to be removed.
	 * @return Either true if the removal was successful, or False if not.
	 * or Null if not. */
	public boolean removeSpecificItem(Item item) {
		return cart.remove(item);
	} // end removeSpecificItem
	
	/**
	 * Determines whether the cart is empty.
	 * @return True if the cart is empty, or False if not. */
	public boolean isCartEmpty() {
		return cart.isEmpty();
	} // end isCartEmpty
	
	/**
	 * Adds the specified quantity of a specified item to the cart.
	 * @param item The item to be added.
	 * @param quantity The number of items to be added.
	 * @return The number of items added to the cart or 0 if no items added. */
	public int addItem(Item item, int quantity) {
		if (quantity <= 0)
			return 0;
		else {
			for (int i=0; i<quantity; i++) {
				cart.add(item);
			}
		}
		item.setQuantity(item.getQuantity() + quantity);
		return quantity;
	}// end addItem
	
	/**
	 * Removes a random item from the cart.
	 * @return The item removed if removal was successful, or null if not. */
	public Item removeAnyItem() {
		return cart.remove();
	} // end removeAnyItem
	
	/**
	 * Removes all items from the cart. */
	public void removeAllItems() {
		cart.clear();
	} // end removeAllItems
	
	/**
	 * Determines if at least one of the specified item is contained in the
	 * cart.
	 * @param item The item to be detected.
	 * @return Either True if at least one of the item is present in the bag,
	 * or False if not. */
	public boolean containsItem(Item item) {
		return cart.contains(item);
	} // end containsItem
	
	/**
	 * Determines the number of the specified item in the cart. 
	 * @param item The item to be counted.
	 * @return The number of the specified item in the cart. */
	public int numberOfSpecificItem(Item item) {
		return cart.getFrequencyOf(item);
	} // end numberOfSpecificItem
	
	/**
	 * Determines the total number of items in the cart, including duplicates.
	 * @return The number of items in the cart. */
	public int getCartSize() {
		return cart.getCurrentSize();
	} // end getCartSize
	
	/**
	 * Creates a tabulated string to show the current contents of the cart 
	 * with each item on a separate line and a column for each of the item's 
	 * properties. The last line to show the total cost of all items in the 
	 * cart. 
	 * @return The tabulated string. */
	public String orderToString() {
		String str;
		Item[] counted = new Item[getCartSize()]; // There may be empty elements.
		counted = sortByName();
		str = "ID\tName\t\tPrice\tQuantity\tCost\n";
		int totalCost = 0;
		int dollarPrice = 0;
		int centsPrice = 0;
		int lineCost = 0;
		for (int i=0; i<counted.length; i++) {
			if (counted[i] != null) {
				dollarPrice = counted[i].getPrice()/100;
				centsPrice = counted[i].getPrice()%100;
				lineCost = counted[i].getPrice()*counted[i].getQuantity();
				totalCost+=lineCost;
				str+= counted[i].getID()+"\t"+counted[i].getName()+"\t\t$"
					+dollarPrice+"."+centsPrice+"\t"+counted[i].getQuantity()
					+"\t$"+lineCost/100+"."+lineCost%100+"\n";
			}
		}
		str+= "\t\t\t\ttotal\t$"+totalCost/100+"."+totalCost%100+"\n";
		return str;
	} // end orderToString
	
	/**
	 * Creates and retrieves the contents of the cart as an array of items.
	 * @return The array of items in the cart.*/
	public Item [] cartToArray() {
		return cart.toArray();
	} // end cartToArray
	
	/**
	 * Gets the total cost of all items in the cart multiplied by 100 and
	 * expressed as an integer.
	 * @return The total cost. */
	public int getTotalCost() {
		int total = 0;
		Item[] counted = new Item[getCartSize()]; // There may be empty elements.
		counted = sortByName();
		for (int i=0; i<counted.length; i++) {
			if (counted[i] != null) {
				total+= counted[i].getPrice()*counted[i].getQuantity();
			}
		}
		return total;
	}
	
	/**
	 * Creates a new array then removes duplicates and updates quantity field.
	 * @return The new array. */
	private Item[] sortByName() {
		Item[] sorted = new Item[getCartSize()];
		Item[] counted = new Item[getCartSize()];
		Arrays.sort(sorted, Comparator.comparing(Item::getName));
		int counter = 1; // Count of 1 means no duplicates.
		int index = 0; // Index position in counted array.
		for (int i=0; i<sorted.length-1; i++) {
			if (sorted[i].getName().compareTo(sorted[i+1].getName()) == 0) 
				counter++; // Increment counter for each duplicate.
			else {
				counted[index] = sorted[i];
				counted[index].setQuantity(counter);
				counter = 0;
				index++;
			}
		}
		return counted;
	} // end sortByName
}
