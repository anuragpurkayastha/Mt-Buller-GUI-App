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

public class MtBullerResortGUI extends JFrame implements ActionListener{

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
    JTextArea displayCustomersPanel;
    JPanel customerBtnPanel;

    //-- Buttons
    JButton displayCustomersBtn;
    JButton addCustomerBtn;
    JButton clearBtnCustomer;

    //-- Input labels and fields
    JLabel custNameLbl;
    JTextField custNameField;
    JLabel skiLevelLbl;
    JTextField skiLevelField;

    /*
     *  Declare components for Travel Packages Tab - TODO
     */
    
    //-- Panels
    JPanel travelPackageTab;
    
    /*  CONSTRUCTOR     */
    public MtBullerResortGUI(){
       
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
        accommDisplayArea = new JTextArea(50,50); // (rows,columns)
        accommDisplayPanel.add(accommDisplayArea);
        accommodationTab.add(accommDisplayPanel,BorderLayout.CENTER);
        
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

        // Add tabs to the window
        tabs.add("Accommodation", accommodationTab);
        tabs.add("Customers", customerTab);
        tabs.add("Travel Packages", travelPackageTab);

        add(tabs, BorderLayout.CENTER);
    }// End constructor

    public void actionPerformed(ActionEvent e){
    /*  Action performed method */
        System.out.println("Button clicked!");
    }
    
    /*          MAIN            */
    public static void main(String[] args){
        MtBullerResortGUI app = new MtBullerResortGUI();
        app.setSize(600,500);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }// End main

}// End class
