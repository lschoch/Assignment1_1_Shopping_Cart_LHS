/**
 * An interface to manage items to be presented for purchase in an 
 * online shopping enterprise.
 *  
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public interface ItemInterface {
	
	/**
	 * Gets the String ID of the item.
	 * @return The item's ID. */
	public String getID();
	
	/**
	 * Gets the name of the item.
	 * @return The name of the item. */
	public String getName();
	
	/**
	 * Gets the price of the item multiplied by 100, expressed as an integer.
	 * @return The item's price multiplied by 100. */
	public int getPrice();
	
	/**
	 * Gets the quantity which is either the number of items in stock, for 
	 * inventory items or the number in a particular cart for a shopping cart
	 * item.
	 * @return The quantity. */
	public int getQuantity();
	
	/**
	 * Sets the String ID of the item.
	 * @param id The String ID to be set. */
	public void setID(String id);
	
	/**
	 * Set the name of the item.
	 * @param name The name to be set. */
	public void setName(String name);
	
	/** 
	 * Sets the price of the item multiplied by 100, expressed as an integer.
	 * @param id The price of the item to be set. */
	public void setPrice(int price);
	
	/**
	 * Sets the quantity of the item, either the quantity in stock, for 
	 * an inventory item or the quantity contained in a particular cart
	 * for a shopping cart item.
	 * @param quantity The quantity to be set */
	public void setQuantity(int quantity);
	
	/**
	 * Creates a string that shows all properties of the item.
	 * @return The created string. */
	public String itemToString();

}
