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
import java.time.LocalDate;

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
     *  Declare components for Travel Packages Tab
     */

    //-- Panels
    JPanel travelPackageTab;
    JPanel addTravelPackagePanel;
    JPanel displayTravelPackagePanel;
    JPanel travelPackageBtnPanel;

    //-- Buttons
    JButton addTravelPackageBtn;
    JButton addLiftPassBtn;
    JButton addLessonBtn;
    JButton listPackagesBtn;
    JButton savePackagesBtn;
    JButton readPackagesBtn;

    //-- Input Fields
    JLabel customerSelectLabel;
    JComboBox<String>   selectCustomerCombo;
    JLabel accommodationSelectLabel;
    JComboBox<String> selectAccommodationCombo;
    JLabel addLiftPassLabel;
    JTextField addLiftPassField;
    JLabel addLessonLabel;
    JTextField addLessonField;
    JLabel startDateLabel;
    JTextField startDateField;
    JLabel durationLabel;
    JTextField durationField;
    
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

        /*======================================= Accommodation ========================================================*/

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
        /*====================================== END ACCOMMODATION =================================================================*/
        /*=============================================== CUSTOMERS ====================================================================== */
        customerTab = new JPanel();
        customerTab.setLayout(new BorderLayout());

        custNameLbl = new JLabel("Name");
        custNameField = new JTextField(20);

        addCustomerBtn = new JButton("Add Customer");
        addCustomerBtn.addActionListener(this);

        // Add customer panel
        addCustomerPanel = new JPanel();
        addCustomerPanel.setLayout(new GridLayout(3,2,10,10));        // (rows, columns)
        addCustomerPanel.setBorder(new TitledBorder("New Customer"));
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
        /*=============================================== END CUSTOMERS ====================================================================== */

        /*=============================================== TRAVEL PACKAGES ================================================================== */

        travelPackageTab = new JPanel();
        travelPackageTab.setLayout(new BorderLayout());

        // Add Travel Package panel
        addTravelPackagePanel = new JPanel();
        addTravelPackagePanel.setLayout(new GridLayout(5,2,5,2));   // (rows,columns)
        addTravelPackageBtn = new JButton("Add Package");
        addTravelPackageBtn.addActionListener(this);

        // Inputs for customer and accommodation
        customerSelectLabel = new JLabel("Customer ID");
        selectCustomerCombo = new JComboBox<>();
        
        accommodationSelectLabel = new JLabel("Accommodation ID");
        selectAccommodationCombo = new JComboBox<>();

        // Inputs for Start date and duration
        startDateLabel = new JLabel("Start Date (yyyy-mm-dd)");
        startDateField = new JTextField(11);

        durationLabel = new JLabel("Duration (days)");
        durationField = new JTextField(3);

        // Populate customer and accommodation dropdowns
        for (int i = 0; i < customers.size(); i++){
            selectCustomerCombo.addItem(Integer.toString(customers.get(i).getID()));
        }


        for (int i = 0; i < accommodations.size(); i++){
            selectAccommodationCombo.addItem(Integer.toString(accommodations.get(i).getID()));
        }

        addTravelPackagePanel.setBorder(new TitledBorder("New Travel Package"));
        addTravelPackagePanel.add(customerSelectLabel);
        addTravelPackagePanel.add(selectCustomerCombo);
        addTravelPackagePanel.add(accommodationSelectLabel);
        addTravelPackagePanel.add(selectAccommodationCombo);
        addTravelPackagePanel.add(startDateLabel);
        addTravelPackagePanel.add(startDateField);
        addTravelPackagePanel.add(durationLabel);
        addTravelPackagePanel.add(durationField);
        addTravelPackagePanel.add(addTravelPackageBtn);

        travelPackageTab.add(addTravelPackagePanel, BorderLayout.NORTH);
        /*=============================================== END TRAVEL PACKAGES ====================================================================== */
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
        else if (e.getSource() == addTravelPackageBtn){
            if(!durationField.getText().equals("") && !startDateField.getText().equals("")){
                this.createTravelPackage();
            }
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
                accommDisplayArea.append(a.toString() + "\n\n");
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
        
        Customer newCustomer = null;

        // Get the customer name
        String customerName = custNameField.getText();
        if (!customerName.equals("")){

            // Get the ski level
            if (beginnerRadioBtn.isSelected()){
                newCustomer = new Customer(customerName,1);
            }
            else if (intermediateRadioBtn.isSelected()){
                newCustomer = new Customer(customerName, 2);
            }
            else if (expertRadioBtn.isSelected()){
                newCustomer = new Customer(customerName, 3);
            }
        }
        customers.add(newCustomer);
        custNameField.setText("");      // Clear the customer name field

        // Add the customer ID to the customer combobox
        selectCustomerCombo.addItem(Integer.toString(newCustomer.getID()));
    }

    public void createTravelPackage(){
    /*  Creates a travel package        */
        
        // Get the customer ID and then the customer with that ID
        int selectedCustID = Integer.parseInt((String) selectCustomerCombo.getSelectedItem());
        Customer selectedCustomer = this.getCustomerByID(selectedCustID);

        // Get the accommodation ID and then the accommodation with that ID
        int selectedAccommID = Integer.parseInt((String) selectAccommodationCombo.getSelectedItem());
        Accommodation selectedAccomm = this.getAccommodationByID(selectedAccommID);

        // Get the start date
        LocalDate start = LocalDate.parse(startDateField.getText());

        // Get the duration
        int days = Integer.parseInt(durationField.getText());

        // Create a new travel package.
        packages.add(new TravelPackage(selectedCustomer, selectedAccomm, start, days));

        // Clean up
        selectedAccomm.setIsAvailable(false);
        startDateField.setText("");
        durationField.setText("");
        this.listTravelPackages();

        // Remove the selected accommodation from the combo box
        selectAccommodationCombo.removeItemAt(selectAccommodationCombo.getSelectedIndex());
    }

    public Customer getCustomerByID(int id){
    /*  Get a customer by ID    */

        for (Customer c: customers){
            
            if (c.getID() == id){
                return c;
            }
        }
        return null;
    }

    public Accommodation getAccommodationByID(int id){
    /*  Get Accommodation by ID */
        for (Accommodation a: accommodations){
            if (a.getID() == id){
                return a;
            }
        }
        return null;
    }

    public void listTravelPackages(){
    /* List all Travel packages */
        for (TravelPackage p: packages){
            System.out.println(p);
        }
    }
 
    /*          MAIN            */
    public static void main(String[] args){
        MtBullerResortGUI app = new MtBullerResortGUI();
        app.setSize(650,600);// (width,height)
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }// End main

}// End class
