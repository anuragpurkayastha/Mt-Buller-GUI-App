/**
    Mt Buller GUI Application

    Name:       Anurag Purkayastha
    Student ID: s3805894

    MtBullerResortGUI.java
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class MtBullerResortGUI extends JFrame implements ActionListener{

    /*-------------- GLOBAL VARIABLES -----------------------------------------------*/
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Accommodation> accommodations = new ArrayList<Accommodation>();
    private ArrayList<TravelPackage> packages = new ArrayList<TravelPackage>();
    /*-------------------------------------------------------------------------------*/

    /*==========        GUI CONFIG      ============================================*/
    /*  Tabs    */
    JTabbedPane tabs;

    /*
     *  Declare components for Accommodations tab
     */

    //-- Panels
    JPanel accommodationTab;
    JTextArea accommDisplayArea;
    JPanel accommDisplayPanel;
    JPanel accommBtnPanel;
    JScrollPane scrollAccomm;

    //-- Buttons
    JButton displayAllAccommBtn;
    JButton displayAvailableAccommBtn;
    JButton clearBtnAccomm;

    /*
     *  Declare components for Customers Tab
     */

    //-- Panels
    JPanel customerTab;
    JPanel addCustomerPanel;
    JPanel addCustomerBtnPanel;
    JPanel customerInputPanel;
    JPanel skiLevelSelectPanel;
    JPanel displayCustomersPanel;
    JPanel customerBtnPanel;

    //-- Buttons
    JButton displayCustomersBtn;
    JButton addCustomerBtn;
    JButton clearBtnCustomer;

    //-- Input labels and fields
    JTextArea custDisplayArea;  // Display area
    JLabel custNameLbl;         // Customer name label
    JTextField custNameField;   // Customer name input
    JLabel skiLevelLbl;         // Ski level label

    ButtonGroup skiLevelSelection;      // Ski Level button group
    JRadioButton beginnerRadioBtn;      // Beginner radio button
    JRadioButton intermediateRadioBtn;  // Intermediate radio button
    JRadioButton expertRadioBtn;        // Expert radio button

    /*
     *  Declare components for Travel Packages Tab - TODO
     */
    
    //-- Panels
    JPanel travelPackageTab;
    
    /*  CONSTRUCTOR     */
    public MtBullerResortGUI(){
        
        // Create the frame
        super("Mt Buller Resort");
      
        /*      Populate lists  */
        this.populateLists();

        /*      Create tabs     */
        tabs = new JTabbedPane();
 
        // Initialize the panels for each tab
        accommodationTab = new JPanel();        // Accommodation tab
        accommodationTab.setLayout(new BorderLayout());
        customerTab = new JPanel();     // Customer tab
        customerTab.setLayout(new BorderLayout());
        travelPackageTab = new JPanel();        // Travel Package Tab
        travelPackageTab.setLayout(new BorderLayout());

        /*
         *      BUILD THE PANELS
         */

        /*-- Accommodation     */

        // Display Panel
        accommDisplayPanel = new JPanel();
        accommDisplayArea = new JTextArea(31,50); // (rows,columns)
        accommDisplayArea.setEditable ( false );
        accommDisplayPanel.add(accommDisplayArea);
        accommodationTab.add(accommDisplayPanel,BorderLayout.CENTER);
        scrollAccomm = new JScrollPane(accommDisplayArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        accommDisplayPanel.setBorder(new TitledBorder("List of Accommodations"));
        accommDisplayPanel.add(scrollAccomm);

        // Button Panel
        accommBtnPanel = new JPanel();

        displayAllAccommBtn = new JButton("Display all accommodation"); // Display all accommodations
        displayAllAccommBtn.addActionListener(this);

        clearBtnAccomm = new JButton("Clear Display");  // Clear display
        clearBtnAccomm.addActionListener(this);

        displayAvailableAccommBtn = new JButton("Display available accommodation"); // Display available accommodation
        displayAvailableAccommBtn.addActionListener(this);

        accommBtnPanel.add(displayAllAccommBtn);
        accommBtnPanel.add(displayAvailableAccommBtn);
        accommBtnPanel.add(clearBtnAccomm);

        accommodationTab.add(accommBtnPanel, BorderLayout.SOUTH);

        /*-- Customers          */
        customerTab = new JPanel();
        customerTab.setLayout(new BorderLayout());

        custNameLbl = new JLabel("Name");
        custNameField = new JTextField(20);

        addCustomerBtn = new JButton("Add Customer");
        addCustomerBtn.addActionListener(this);

        // Add customer panel
        addCustomerPanel = new JPanel();
        addCustomerPanel.setLayout(new GridLayout(3,2,10,10));        // (rows, columns)
        skiLevelSelectPanel = new JPanel();

        skiLevelLbl = new JLabel("Ski Level");

        skiLevelSelection = new ButtonGroup();  // Ski Level Selection

        beginnerRadioBtn = new JRadioButton("Beginner");        // Beginner
        beginnerRadioBtn.addActionListener(this);
        intermediateRadioBtn = new JRadioButton("Intermediate");        // Intermediate
        intermediateRadioBtn.addActionListener(this);
        expertRadioBtn = new JRadioButton("Expert");    // Expert
        expertRadioBtn.addActionListener(this);

        skiLevelSelection.add(beginnerRadioBtn);
        skiLevelSelection.add(intermediateRadioBtn);
        skiLevelSelection.add(expertRadioBtn);

        skiLevelSelectPanel.add(beginnerRadioBtn);
        skiLevelSelectPanel.add(intermediateRadioBtn);
        skiLevelSelectPanel.add(expertRadioBtn);

        addCustomerPanel.add(custNameLbl);
        addCustomerPanel.add(custNameField);
        addCustomerPanel.add(skiLevelLbl);
        addCustomerPanel.add(skiLevelSelectPanel);

        addCustomerPanel.add(addCustomerBtn);

        customerTab.add(addCustomerPanel, BorderLayout.NORTH);

        // Display customers panel
        displayCustomersPanel = new JPanel();
        custDisplayArea = new JTextArea(24, 50);        // (rows, columns)
        custDisplayArea.setEditable ( false );
        displayCustomersPanel.setBorder(new TitledBorder("List of Customers"));
        JScrollPane custDisplayScroll = new JScrollPane(custDisplayArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        displayCustomersPanel.add(custDisplayScroll);
//        displayCustomersPanel.add(custDisplayArea);
        
        customerTab.add(displayCustomersPanel, BorderLayout.CENTER);

        // Buttons Panel
        customerBtnPanel = new JPanel();
        customerBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        displayCustomersBtn = new JButton("Display Customers");
        displayCustomersBtn.addActionListener(this);
        clearBtnCustomer = new JButton("Clear Display");
        clearBtnCustomer.addActionListener(this);
        customerBtnPanel.add(displayCustomersBtn);
        customerBtnPanel.add(clearBtnCustomer);

        customerTab.add(customerBtnPanel, BorderLayout.SOUTH);        
        
        // Add tabs to the window
        tabs.add("Accommodation", accommodationTab);
        tabs.add("Customers", customerTab);
        tabs.add("Travel Packages", travelPackageTab);

        add(tabs, BorderLayout.CENTER);
    }// End constructor

    public void actionPerformed(ActionEvent e){
    /*  Action performed method */
        if (e.getSource() == displayAllAccommBtn){
            this.listAccommodations();
        }
        else if (e.getSource() == clearBtnAccomm){
            accommDisplayArea.setText("");
        }
        else if (e.getSource() == displayAvailableAccommBtn){
            this.listAvailableAccommodations();
        }
        else if (e.getSource() == displayCustomersBtn){
            this.listCustomers();
        }
        else if (e.getSource() == clearBtnCustomer){
            custDisplayArea.setText("");
        }
        else if (e.getSource() == addCustomerBtn){
            this.addCustomer();
        }
    }

    public void populateLists(){
    /*  Method to populate the array lists      */

        /*--    CUSTOMERS       --*/
        customers.add(new Customer("Bruce Banner", 1));
        customers.add(new Customer("Peter Parker", 2));
        customers.add(new Customer("Steve Rogers", 3));

        /*--    ACCOMMODATIONS  --*/
        accommodations.add(new Accommodation(50, "hotel"));
        accommodations.add(new Accommodation(45, "lodge"));
        accommodations.add(new Accommodation(30, "apartment"));
        accommodations.add(new Accommodation(60, "hotel"));
        accommodations.add(new Accommodation(70, "apartment"));
        accommodations.add(new Accommodation(80, "hotel"));
        accommodations.add(new Accommodation(35, "lodge"));
        accommodations.add(new Accommodation(55, "hotel"));
        accommodations.add(new Accommodation(60, "apartment"));
        accommodations.add(new Accommodation(95, "lodge"));
    }

    public void listAccommodations(){
    /*  
        List all accommodations in the display area
    */
        accommDisplayArea.setText("");
        
        for(Accommodation a: accommodations){
            accommDisplayArea.append(a.toString() + "\n\n");
        }
    }

    public void listAvailableAccommodations(){
    /*
        List all available accommodations
    */
        accommDisplayArea.setText("");

        for(Accommodation a: accommodations){
            if(a.getIsAvailable()){
                accommDisplayArea.append(a.toString() + "\n");
            }
        }
    }

    public void listCustomers(){
    /*
        List all customers
    */
        custDisplayArea.setText("");

        for(Customer c: customers){
            custDisplayArea.append(c.toString() + "\n\n");
        }
    }

    public void addCustomer(){
    /*  Add customer    */
        
        // Get the customer name
        String customerName = custNameField.getText();
        if (!customerName.equals("")){

            // Get the ski level
            if (beginnerRadioBtn.isSelected()){
                customers.add(new Customer(customerName,1));
            }
            else if (intermediateRadioBtn.isSelected()){
                customers.add(new Customer(customerName, 2));
            }
            else if (expertRadioBtn.isSelected()){
                customers.add(new Customer(customerName, 3));
            }
        }
        custNameField.setText("");
    }
 
    /*          MAIN            */
    public static void main(String[] args){
        MtBullerResortGUI app = new MtBullerResortGUI();
        app.setSize(650,600);// (width,height)
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }// End main

}// End class
