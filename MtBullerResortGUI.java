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
    JTextArea accommDisplayPanel;
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

    
    /*  CONSTRUCTOR     */
    public MtBullerResortGUI(){
       
        /*      Create tabs     */
        tabs = new JTabbedPane();
 
        // Initialize the panels for each tab
        accommodationTab = new JPanel();
        customerTab = new JPanel();

        /*
         *      BUILD THE TABS
         */

        /*-- Accommodations     */
        
        
        // Add tabs to the window
        tabs.add("Accommodation", accommodationTab);
        tabs.add("Customers", customerTab);

        add(tabs, BorderLayout.CENTER);
    }// End constructor

    public void actionPerformed(ActionEvent e){
    /*  Action performed method */
        System.out.println("Button clicked!");
    }
    
    /*          MAIN            */
    public static void main(String[] args){
        MtBullerResortGUI app = new MtBullerResortGUI();
        app.setSize(500,500);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }// End main
}// End class
