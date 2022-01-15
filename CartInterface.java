/**
 * An interface that describes the operation of a shopping cart that uses
 * a bag ADT as the basis for its data structure.
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public interface CartInterface<T> {
	
	/**
	 * Removes a specified item from the cart.
	 * @parameter item The item to be removed.
	 * @return Either the removed item if removal was successful, 
	 * or Null if not. */
	public T removeSpecificItem(T item);
	
	/**
	 * Determines whether the cart is empty.
	 * @return True if the cart is empty, or False if not. */
	public boolean isCartEmpty();
	
	/**
	 * Adds the specified item to the cart.
	 * @param item The item to be added.
	 * @return True */
	public boolean addItem(T item);
	
	/**
	 * Removes a random item from the cart.
	 * @return Either the item removed if removal was possible, or Null
	 * if not. */
	public T removeAnyItem();
	
	/**
	 * Removes all items from the cart.
	 * @return Either True if removal was successful, or False if not. */
	public boolean removeAllItems();
	
	/**
	 * Determines if at least one of the specified item is contained in the
	 * cart.
	 * @param item The item to be detected.
	 * @return Either True if at least one of the item is present in the bag,
	 * or False if not. */
	public boolean containsItem(T item);
	
	/**
	 * Determines the number of the specified items in the cart. 
	 * @param item The item to be counted.
	 * @return The number of the specified item in the cart. */
	public int numberOfSpecificItem(T item);
	
	/**
	 * Determines the total number of items in the cart, including duplicates.
	 * @return The number of items in the cart. */
	public int getCartSize();
	
	/**
	 * Creates a tabulated string to show the current contents of the cart 
	 * with each item on a separate line and a column for each of the item's 
	 * properties. The last line to show the total cost of all items in the 
	 * cart. 
	 * @return The tabulated string. */
	public String orderToString();
	
	/**
	 * Creates and retrieves the contents of the cart as an array of items.
	 * @return The array of items in the cart.
	 */
	public T [] cartToArray();
	
	/**
	 * Gets the total cost of all items in the cart.
	 * @return The total cost (multiplied by 100 and expressed as an integer).
	 */
	public int getTotalCost();
	
}


