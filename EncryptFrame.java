import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.Rectangle;
import javax.swing.JPasswordField;


public class EncryptFrame extends JFrame {

	private JPanel contentPane;
	ArrayList<String> keyNames = new ArrayList<String>();
	DefaultListModel listModel;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public EncryptFrame(ArrayList<CustomKey> keys) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
					
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setBounds(5, 50, 200, 200);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setBounds(new Rectangle(5, 50, 200, 222));	
		contentPane.add(listScroller);		
		
		
		for (CustomKey c: keys) {
			keyNames.add(c.getName());
		}
		for (String s: keyNames) {
			listModel.addElement(s.toString());
		}
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(250, 35, 68, 16);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(250, 102, 134, 16);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblChooseEncryptionKey = new JLabel("Choose Encryption Key:");
		lblChooseEncryptionKey.setBounds(6, 16, 160, 16);
		contentPane.add(lblChooseEncryptionKey);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBounds(327, 243, 117, 29);
		contentPane.add(btnEncrypt);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 62, 134, 28);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(250, 131, 134, 29);
		contentPane.add(passwordField_1);
	}
}
