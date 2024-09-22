public class SalesItem {
	private String name;
	private double price;
	private int quantity;
	//declare the object characteristics like name, price, and quantity

	public SalesItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		//the public sales item list
	}

	public String getName() {
		return name; //gather the item name
	}
	public void setName(String name) {
		this.name = name; //set the item name
	}
	public double getPrice() {
		return price; //gather the item price
	}
	public void setPrice(double price) {
		this.price = price; //set the item price
	}
	public int getQuantity() {
		return quantity;//get the item quantity
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity; //set the item quantity
	}
	public double getTotalPrice() {
		return price * quantity; //equation to find the total cost of the item
	}
	public String toString() {
		return name + ": $" + price + " x " + quantity + " = $" + getTotalPrice();
		//Displays "ItemName, price, and quantity, and the total combined price
	}
}
