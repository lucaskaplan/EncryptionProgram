import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

public class MainProgramFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JList list;
	JMenuItem saveMenuItem;
	JMenuItem openMenuItem;
	JMenuItem importMenuItem;
	JMenuItem exportMenuItem;
	JPanel cards;
	final static String CAESARCIPHER = "Caesar Cipher";
	final static String ANOTHERCIPHER = "Another Cipher";
	final static String THIRDCIPHER = "Third Cipher";
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	DefaultListModel listModel;
	ArrayList<CustomKey> keys = new ArrayList<CustomKey>();
	ArrayList<String> keyNames = new ArrayList<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainProgramFrame frame = new MainProgramFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainProgramFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		keys.add(new CustomKey("Caesar Cipher", "test", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test1", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test2", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test3", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test4", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test5", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test6", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test7", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test8", "4"));
		keys.add(new CustomKey("Caesar Cipher", "test9", "4"));
		
		//document panel components
		JPanel documentPanel = new JPanel();
		tabbedPane.addTab("Document", null, documentPanel, null);
		documentPanel.setLayout(new BorderLayout(0, 0));
		
	    textArea = new JTextArea();
	    textArea.setLineWrap(true);
		documentPanel.add(textArea, BorderLayout.CENTER);
		
		JPanel documentButtonPanel = new JPanel();
		documentPanel.add(documentButtonPanel, BorderLayout.EAST);
		documentButtonPanel.setLayout(new GridLayout(0, 1));
		
		JButton encryptButton = new JButton("Encrypt");
		encryptButton.addActionListener(new openEncryptFrameListener());
		documentButtonPanel.add(encryptButton);
		
		JButton decryptButton = new JButton("Decrypt");
		decryptButton.addActionListener(new DecryptListener());
		documentButtonPanel.add(decryptButton);
		
		//New Custom Key panel components		
		JPanel newCustomKeyPanel = new JPanel();
		tabbedPane.addTab("New Custom Key", null, newCustomKeyPanel, null);
		newCustomKeyPanel.setLayout(new BorderLayout(0, 0));
		
			//comboBox panel
		JPanel comboBoxPane = new JPanel();
		String[] encyptTypes = {CAESARCIPHER, ANOTHERCIPHER, THIRDCIPHER};
		JComboBox comboBox = new JComboBox(encyptTypes);
		comboBox.setEditable(false);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
		        CardLayout cl = (CardLayout)(cards.getLayout());
		        cl.show(cards, (String)evt.getItem());
		    }
		});
		
		JLabel lblEncryptionKeyType = new JLabel("Encryption Key Type:");
		comboBoxPane.add(lblEncryptionKeyType);
		comboBoxPane.add(comboBox);
		newCustomKeyPanel.add(comboBoxPane, BorderLayout.NORTH);
		
			//cards panel and individual panels	
		JPanel card1 = new JPanel();
			card1.setLayout(null);
			JLabel lblKeyName_2 = new JLabel("Key Name:");
			lblKeyName_2.setBounds(6, 12, 74, 16);
			card1.add(lblKeyName_2);		
			textField = new JTextField();
			textField.setBounds(74, 6, 134, 28);
			card1.add(textField);
			textField.setColumns(10);		
			JLabel lblShiftNumber = new JLabel("Shift Number:");
			lblShiftNumber.setBounds(6, 40, 87, 16);
			card1.add(lblShiftNumber);
			textField_1 = new JTextField();
			textField_1.setBounds(105, 34, 109, 28);
			card1.add(textField_1);
			textField_1.setColumns(10);	
			JButton btnSaveKey = new JButton("Save Key");
			btnSaveKey.setBounds(296, 128, 117, 29);
			card1.add(btnSaveKey);
			btnSaveKey.addActionListener(new SaveCaesarCipherListener());
		JPanel card2 = new JPanel();
			card2.setLayout(null);		
			textField_2 = new JTextField();
			textField_2.setBounds(74, 6, 134, 28);
			card2.add(textField_2);
			textField_2.setColumns(10);		
			JLabel lblKeyName = new JLabel("Key Name:");
			lblKeyName.setBounds(6, 12, 71, 16);
			card2.add(lblKeyName);		
			JButton btnSaveKey_1 = new JButton("Save Key");
			btnSaveKey_1.setBounds(296, 128, 117, 29);
			card2.add(btnSaveKey_1);
		JPanel card3 = new JPanel();
			card3.setLayout(null);		
			JLabel lblKeyNamel = new JLabel("Key Name:");
			lblKeyNamel.setBounds(6, 12, 66, 16);
			card3.add(lblKeyNamel);		
			textField_3 = new JTextField();
			textField_3.setBounds(74, 6, 134, 28);
			card3.add(textField_3);
			textField_3.setColumns(10);		
			JButton btnSaveKey_2 = new JButton("Save Key");
			btnSaveKey_2.setBounds(296, 128, 117, 29);
			card3.add(btnSaveKey_2);
		cards = new JPanel(new CardLayout());
		cards.add(card1, CAESARCIPHER);		
		cards.add(card2, ANOTHERCIPHER);			
		cards.add(card3, THIRDCIPHER);	
		newCustomKeyPanel.add(cards, BorderLayout.CENTER);
		
		//key list panel components
		JPanel keyListPanel = new JPanel();
		tabbedPane.addTab("Key List", null, keyListPanel, null);
		keyListPanel.setLayout(null);		
		listModel = new DefaultListModel();
		addKeyToList();
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setBounds(5, 5, 400, 150);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setBounds(list.getBounds());	
		keyListPanel.add(listScroller);	
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(296, 165, 117, 29);
		keyListPanel.add(btnDelete);
		btnDelete.addActionListener(new DeleteListener());
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(167, 167, 117, 29);
		keyListPanel.add(btnEdit);
			
		//JMenuBar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		saveMenuItem = new JMenuItem("Save");
	    openMenuItem = new JMenuItem("Open");
	    importMenuItem = new JMenuItem("Import");
	    exportMenuItem = new JMenuItem("Export");
		
		//saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(saveMenuItem);
		
		//openMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(openMenuItem);
		
		//importMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(importMenuItem);
				
		//exportMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(exportMenuItem);
		
		menuBar.add(fileMenu);	
		this.setJMenuBar(menuBar);	
	}
	
	public String encryptCeasarCipher(String string, int c) {
		String[] words = string.split(" ");
		String encryptedString = "";
		for (int k = 0; k < words.length; k++) {
			char[] chars = words[k].toCharArray();		
			for (int i = 0; i < chars.length; i++) {	
				char ch = chars[i];
				int start = (int)ch;
				int end = start + c;							
				char newCh = (char)end;
				encryptedString += newCh;	
			}
			encryptedString += " ";
		}
		return encryptedString;
	}
	
	public String decryptCeasarCipher(String string, int c) {
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
		
	
	private class EncryptListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textArea.setText(encryptCeasarCipher(textArea.getText(), 5));
		}
	}
	
	private class DecryptListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textArea.setText(decryptCeasarCipher(textArea.getText(), 5));
		}
	}
	
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
	
	private class SaveCaesarCipherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CustomKey newKey = new CustomKey("Caesar Cipher", textField.getText(), textField_1.getText());
			keys.add(newKey);
			addKeyToList();
			System.out.println(keys);
		}
	}
	
	private class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selectedItem = list.getSelectedIndex();
			String keyName = keyNames.get(selectedItem);
			keyNames.remove(selectedItem);
			updateKeyList();
			
			for (CustomKey c: keys) {
				if (c.getName().equals(keyName)) {
					keys.remove(c);
				}
			}
		}
	}
	
	private class openEncryptFrameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				EncryptFrame encryptFrame = new EncryptFrame(keys);
				encryptFrame.setVisible(true);
			}
		}
	
	public void addKeyToList() {
		listModel.clear();
		keyNames.clear();
		for (CustomKey c: keys) {
			keyNames.add(c.getName());
		}
		for (String s: keyNames) {
			listModel.addElement(s.toString());
		}
	}
	
	public void updateKeyList() {
		listModel.clear();
		for (String s: keyNames) {
			listModel.addElement(s.toString());
		}
	}
}
