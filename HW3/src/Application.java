import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Application {

	private JFrame frmSalesList;
	private JTextField txtItem;
	private JTextField txtCost;
	private JTextField txtQuantity;
	private JTextField txtOutputTotal;
	private JTextArea txtOutputList;
	private SalesSlip saleSlip;

	/**
	 * Launch the application.
	 * The Sales App will keep track of all items purchased
	 * as well as the total cost of everything combined.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmSalesList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
		saleSlip = new SalesSlip();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalesList = new JFrame();
		frmSalesList.setTitle("SALES LIST");
		frmSalesList.setBounds(100, 100, 450, 300);
		frmSalesList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSalesList.getContentPane().setLayout(null);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(65, 14, 46, 14);
		frmSalesList.getContentPane().add(lblItem);
		
		JLabel lblCost = new JLabel("Cost: $");
		lblCost.setBounds(65, 45, 46, 14);
		frmSalesList.getContentPane().add(lblCost);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(65, 82, 46, 14);
		frmSalesList.getContentPane().add(lblQuantity);
		
		txtItem = new JTextField();
		txtItem.setBounds(134, 11, 250, 20);
		frmSalesList.getContentPane().add(txtItem);
		txtItem.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setBounds(134, 42, 136, 20);
		frmSalesList.getContentPane().add(txtCost);
		txtCost.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(134, 79, 136, 20);
		frmSalesList.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JButton btnAdd = new JButton("Add Item to the Sales List");
		btnAdd.setBounds(101, 110, 235, 23);
		frmSalesList.getContentPane().add(btnAdd);
		
		txtOutputList = new JTextArea();
		txtOutputList.setBounds(65, 144, 319, 59);
		frmSalesList.getContentPane().add(txtOutputList);
		
		JLabel lblTotalSale = new JLabel("Total Sales: $");
		lblTotalSale.setBounds(65, 218, 71, 14);
		frmSalesList.getContentPane().add(lblTotalSale);
		
		txtOutputTotal = new JTextField();
		txtOutputTotal.setBounds(156, 215, 114, 20);
		frmSalesList.getContentPane().add(txtOutputTotal);
		txtOutputTotal.setColumns(10);
		
		/**
		 * When the button is pressed, the program will begin to run a new Action Event
		 * All of the information for an item will be parsed and gathered.
		 * After a new SalesItem is created, with the information typed in by the user,
		 * it will be added to the Sales Slip, which is the output text area.
		 * Once added, it will be set to text and displayed.
		 * The same will be done for the total cost, but in the OutputTotal text field.
		 * Afterwards the fields will be cleared so the user can add more items.
		 */
		
		btnAdd.addActionListener(new ActionListener() {//when the button is pressed, the program will
            public void actionPerformed(ActionEvent e) {//begin to run accumulitive actions
                String name = txtItem.getText();
                double price = Double.parseDouble(txtCost.getText());
                int quantity = Integer.parseInt(txtQuantity.getText());
                //gathering the name, price, and quantity of an item, before it is added
               

                SalesItem item = new SalesItem(name, price, quantity); //creating a new sales item with the new info
                saleSlip.addItem(item); //adding it to the list

                txtOutputList.setText(saleSlip.toString()); //displaying the item into the text output
                
                txtOutputTotal.setText(String.valueOf(saleSlip.getTotalSales())); // Convert total to string and display
                //displaying the total cost in the OutputTotal Text Field

               
                // Clear fields
                txtItem.setText("");
                txtCost.setText("");
                txtQuantity.setText("");
            }
        });
	}
}
