import java.util.ArrayList;

public class SalesSlip {
	private ArrayList<SalesItem> items;
	//array list that will be displayed in the output text

	public SalesSlip() {
		items = new ArrayList<>();
		//declaring the new array list of items and their characteristics as "items"
		//this is what gets called up in the Application.java
	}

	public void addItem(SalesItem item) {
		items.add(item);
		//adds the item to the list
	}

	public double getTotalSales() {
		double total = 0; //total price starts at 0 when list is empty
		for (SalesItem item : items) { //for each of the items
			total += item.getTotalPrice(); //the total gets increased by the total price of each item
			//getTotalPrice() is called up to gather the total for that item and add it
		}
		return total; //return the total price
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (SalesItem item : items) { //for each of the items
			sb.append(item.toString()).append("\n"); //create a line with item information
		}
		sb.append("Total Sales: $").append(getTotalSales());
		return sb.toString(); 
	}
}
