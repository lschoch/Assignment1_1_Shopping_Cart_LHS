/**
 * A class that creates items to be presented for purchase in an 
 * online shopping enterprise. 
 * 
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public class Item implements ItemInterface {
	private String ID;
	private String name;
	private int price;
	private int quantity;
	private int intID = 1;
	
	/** Creates a blank item with calculated ID. */
	public Item() {
		// ID's are assigned as consecutive integers starting with 1.
		// Convert to String to allow concatenation.
		this.ID = String.valueOf(intID);
		intID++;
		this.name = " ";
		this.quantity = 0;
	} // end default constructor
	
	/** Creates an item with a calculated ID and the specified paramenters. */
	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	} // end constructor
	
	/**
	 * Gets the String ID of the item.
	 * @return The item's ID. */
	public String getID() {
		return ID;
	} // end getID
	
	/**
	 * Gets the name of the item.
	 * @return The name of the item. */
	public String getName() {
		return name;
	} // end getName
	
	/**
	 * Gets the price of the item multiplied by 100, expressed as an integer.
	 * @return The item's price multiplied by 100. */
	public int getPrice() {
		return price;
	} // end getPrice
	
	/**
	 * Gets the quantity which is either the number of items in stock, for 
	 * inventory items or the number in a particular cart for a shopping cart
	 * item.
	 * @return The quantity. */
	public int getQuantity() {
		return quantity;
	} // end getQuantity
	
	/**
	 * Sets the String ID of the item.
	 * @param id The String ID to be set. */
	public void setID(String id) {
		this.ID = id;
	} // end setID  
	
	/**
	 * Set the name of the item.
	 * @param name The name to be set. */
	public void setName(String name) {
		this.name = name;
	} // end setName;
	
	/** 
	 * Sets the price of the item multiplied by 100, expressed as an integer.
	 * @param id The price of the item to be set. */
	public void setPrice(int price) {
		this.price = price;
	} // end setPrice
	
	/**
	 * Sets the quantity of the item, either the quantity in stock, for 
	 * an inventory item or the quantity contained in a particular cart
	 * for a shopping cart item.
	 * @param quantity The quantity to be set */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} // end setQuantity
	
	/**
	 * Creates a string that shows all properties of the item.
	 * @return The created string. */
	@Override
	public String itemToString() {
		return "Item [ID=" + ID + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
