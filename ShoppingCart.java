import java.util.Arrays;
import java.util.Comparator;
import java.sql.Timestamp;

/**
 * A class that implements a bag of items using a ResizeableArrayBag ADT.
 * The size of the bag is limited only by the computer's available
 * memory.
 * 
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public class ShoppingCart {
	private String cartID;
	ResizeableArrayBag<Item> cart;
	Timestamp ts = new Timestamp(System.currentTimeMillis());

	/** Creates a ShoppingCart with the specified contents. */
	public ShoppingCart(Item[] contents) {
		// CartID is calculated from timestamp on instantiation.
		// Convert to String to allow concatenation.
		this.cartID = String.valueOf(ts.getTime());
		cart = new ResizeableArrayBag<Item>();
		for (int i=0; i<contents.length; i++) {
			cart.add(contents[i]);
		}
	} // end constructor[]
	
	/**
	 * Gets the cartID (cartID is set as the timestamp when the cart is
	 * initiated and it cannot be changed. 
	 * @return The cartID
	 */
	public String getCartID() {
		return this.cartID;
	} // end getcartID
	
	/**
	 * Removes a specified item from the cart.
	 * @parameter item The item to be removed.
	 * @return Either true if the removal was successful, or False if not. */
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
	 * @param quantity The number of the item to be added.
	 * @return The number of the item added to the cart or 0 if no items 
	 * were added. */
	public int addItem(Item item, int quantity) {
		if (quantity <= 0)
			return 0;
		else {
			for (int i=0; i<quantity; i++) {
				cart.add(item);
			}
		}
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
	 * @return The total number of items in the cart. */
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
		String str = "";
		Item[] counted = sortByName();
		str += String.format(" TABULATED SHOPPING CART CONTENTS\n CartID: %-15s\n\n", getCartID());
		str += String.format(" %-15s %-15s   %5s   %5s%10s\n", "ID", "Name", "Price", "Quant", "Cost");
			
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
				str+=String.format("%-15s %-15s %5d.%02d   %3d %8d.%02d\n", 
						counted[i].getID(), counted[i].getName(), dollarPrice, centsPrice, 
						counted[i].getQuantity(), lineCost/100, lineCost%100);
			}
		}
		str+=String.format("%51s-------\n", " ");
		str+=String.format("%44sTOTAL $%4d.%02d", " ", totalCost/100, totalCost%100);
		return str;
	} // end orderToString
	
	/**
	 * Creates and retrieves the contents of the cart as an array of items.
	 * @return The array of items in the cart.*/
	public Item[] cartToArray() {
		Item [] result = new Item[cart.getCurrentSize()];
		int index = 0;
		while (!isCartEmpty()) {
			result[index] = removeAnyItem();
			index++;
		}
		for (int i=0; i<result.length; i++)
			addItem(result[i], 1);
		return result;
//		return cart.toArray();
	} // end cartToArray
	
	/**
	 * Creates a new array that combines the duplicates and updates the 
	 * quantity fields.
	 * @return The new array. */
	public Item[] sortByName() {
		
		Item[] toBeSorted = cartToArray(); // Copy the bag's array.
		Item[] counted = new Item[toBeSorted.length]; // New empty array to hold duplicates.
		Arrays.sort(toBeSorted, Comparator.comparing(Item::getName)); // Sort on name field.
		int index = 0; // Index position in counted array.
		counted[0] = toBeSorted[0];
		for (int i=0; i<toBeSorted.length-1; i++) {
			if (counted[index].getName().compareTo(toBeSorted[i+1].getName()) == 0) {
				counted[index].setQuantity(counted[index].getQuantity()+toBeSorted[i+1].getQuantity());
			} else {
				index++;
				counted[index] = toBeSorted[i+1];
			}
		}
		return counted;
	} // end sortByName
	
}
