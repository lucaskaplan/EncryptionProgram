
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;


public class DecryptFrame extends JFrame {

	private JPanel contentPane;
	ArrayList<String> keyNames = new ArrayList<String>();
	DefaultListModel listModel;
	private String text;
	private JList list;
	ArrayList<CustomKey> keys;
	MainProgramFrame frame;

	public DecryptFrame(ArrayList<CustomKey> keys, MainProgramFrame frame) {
		this.text = text;
		this.frame = frame;
		this.keys = keys;
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
					
		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setBounds(5, 50, 200, 200);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setBounds(new Rectangle(5, 40, 425, 200));	
		contentPane.add(listScroller);				
		
		for (CustomKey c: keys) {
			keyNames.add(c.getName());
		}
		for (String s: keyNames) {
			listModel.addElement(s.toString());
		}
		
		JLabel lblChooseEncryptionKey = new JLabel("Choose Encryption Key:");
		lblChooseEncryptionKey.setBounds(6, 16, 160, 16);
		contentPane.add(lblChooseEncryptionKey);
		
		JButton btnEncrypt = new JButton("Decrypt");
		btnEncrypt.setBounds(327, 243, 117, 29);
		btnEncrypt.addActionListener(new DecryptListener());
		contentPane.add(btnEncrypt);
	}
	
	public String decryptCaesarCipher(String string, int c) {
		String[] words = string.split(" ");
		String decryptedString = "";
		for (int k = 0; k < words.length; k++) {
			char[] chars = words[k].toCharArray();		
			for (int i = 0; i < chars.length; i++) {
				char ch = chars[i];
				int start = (int)ch;
				int end = start - c;				
				char newCh = (char)end;
				decryptedString += newCh;				
			}
			decryptedString += " ";
		}
		return decryptedString;
	}
	
//	private class EncryptListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			String encryptType = "";
//			int shiftNumber;
//			int selectedItem = list.getSelectedIndex();
//			String keyName = keyNames.get(selectedItem);
//			for (CustomKey c: keys) {
//				if (c.getName().equals(keyName)) {
//					encryptType += c.getType();
//					if (encryptType.equals("Caesar Cipher")) {
//						shiftNumber = c.getExtra();
//						String encryptedString = encryptCaesarCipher(frame.getTextArea(), shiftNumber);
//						System.out.println(encryptedString);
//						frame.setTextArea(encryptedString);
//					}
//				}
//			}			
//		}
//	}
	
	private class DecryptListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}	
	}
		
}