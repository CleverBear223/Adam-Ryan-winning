import static java.lang.System.out;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class CandyControl {

	private JFrame frmSweetoryInven;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CandyControl window = new CandyControl();
					window.frmSweetoryInven.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CandyControl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSweetoryInven = new JFrame();
		frmSweetoryInven.setTitle("Sweet Inventory");
		frmSweetoryInven.setBounds(100, 100, 450, 300);
		frmSweetoryInven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSweetoryInven.getContentPane().setLayout(null);
		
		JLabel lblAddsubInventory = new JLabel("Add/Sub Inventory");
		lblAddsubInventory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddsubInventory.setBounds(145, 53, 150, 34);
		frmSweetoryInven.getContentPane().add(lblAddsubInventory);
		
		JButton btnNewButton = new JButton("Add/Sub Inv.");
		btnNewButton.setBounds(0, 0, 89, 23);
		frmSweetoryInven.getContentPane().add(btnNewButton);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setBounds(94, 0, 89, 23);
		frmSweetoryInven.getContentPane().add(btnAbout);
		
		textField = new JTextField();
		textField.setBounds(27, 188, 86, 20);
		frmSweetoryInven.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lollipops", "Milky Way Bars", "Snickers Bars", "Butterfingers"}));
		comboBox.setBounds(27, 114, 91, 23);
		frmSweetoryInven.getContentPane().add(comboBox);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setBounds(43, 97, 46, 14);
		frmSweetoryInven.getContentPane().add(lblItemId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(43, 174, 46, 14);
		frmSweetoryInven.getContentPane().add(lblQuantity);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File log = new File("log.txt");
				String s1=textField.getText();
				   int a=Integer.parseInt(s1);
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(log, true));
					
					pw.print(a); pw.print(",");   pw.println(comboBox.getSelectedItem())   ;
					
					pw.close();
				}catch(IOException e) {
					out.println("error");
			}
			}});
		btnAdd.setBounds(170, 114, 89, 23);
		frmSweetoryInven.getContentPane().add(btnAdd);
		
		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File log = new File("log.txt");
				String s1=textField.getText();
				   int b=Integer.parseInt(s1);
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(log, true));
					
					pw.print(-b); pw.print(",");   pw.println(comboBox.getSelectedItem())   ;
					
					pw.close();
				}catch(IOException z) {
					out.println("error");
			}
		}});
		btnSubtract.setBounds(170, 187, 89, 23);
		frmSweetoryInven.getContentPane().add(btnSubtract);
		
		JTextPane textPane = new JTextPane();
		textPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				static void filereader(Scanner log);     
				{         
				    int i = 0;         
				    int sum = 0;          
				    while(i <= 19)         
				    {       
				        int nextInt = log.nextInt();          

				        System.out.println(nextInt);             
				        sum = sum + nextInt;
				        i++;         
				    }     
				}
			}
		});
		textPane.setEditable(false);
		textPane.setBounds(309, 97, 103, 139);
		frmSweetoryInven.getContentPane().add(textPane);
	}

}
