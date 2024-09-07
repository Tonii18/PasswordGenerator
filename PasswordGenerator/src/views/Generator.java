package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Password;

public class Generator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField size;
	private JButton increase;
	private JButton decrease;
	private JLabel upperLbl;
	private JLabel lowerLbl;
	private JLabel numbersLbl;
	private JLabel symbolLbl;
	private JCheckBox upperBox;
	private JCheckBox lowerBox;
	private JCheckBox numberBox;
	private JCheckBox symbolBox;
	private JButton generate;
	private JPanel showPassword;
	private JTextField textField;
	private JButton copy;
	private JButton saves;
	
	private int count = 1;
	
	private Set<String> passwords = new HashSet<>();
	
	private List<Character> list = new ArrayList<>();
	
	private String fichero = "keys/passwords.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generator frame = new Generator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Generator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 602);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(93, 93, 93));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("GENERE SU CONTRASEÑA");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Inter 28pt Black", Font.PLAIN, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(10, 29, 386, 43);
		contentPane.add(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 93, 93));
		panel.setBorder(new LineBorder(new Color(0, 255, 117), 4, true));
		panel.setBounds(34, 95, 338, 448);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel charNumber = new JLabel("NUMERO DE CARACTERES");
		charNumber.setFont(new Font("Inter 28pt", Font.BOLD, 15));
		charNumber.setForeground(new Color(255, 255, 255));
		charNumber.setHorizontalAlignment(SwingConstants.CENTER);
		charNumber.setBounds(59, 10, 219, 47);
		panel.add(charNumber);
		
		increase = new JButton("+");
		increase.setBackground(new Color(0, 255, 117));
		increase.setBorder(null);
		increase.setForeground(new Color(255, 255, 255));
		increase.setFont(new Font("Inter 28pt Black", Font.PLAIN, 19));
		increase.setBounds(69, 55, 61, 30);
		panel.add(increase);
		
		decrease = new JButton("-");
		decrease.setBackground(new Color(0, 255, 117));
		decrease.setBorder(null);
		decrease.setForeground(new Color(255, 255, 255));
		decrease.setFont(new Font("Inter 28pt Black", Font.PLAIN, 19));
		decrease.setBounds(208, 55, 61, 30);
		panel.add(decrease);
		
		size = new JTextField();
		size.setFont(new Font("Inter 28pt", Font.PLAIN, 16));
		size.setBorder(null);
		size.setHorizontalAlignment(SwingConstants.CENTER);
		size.setBounds(139, 55, 61, 30);
		size.setText(String.valueOf(count));
		panel.add(size);
		size.setColumns(10);
		
		upperLbl = new JLabel("MAYÚSCULAS");
		upperLbl.setForeground(new Color(255, 255, 255));
		upperLbl.setFont(new Font("Inter 28pt", Font.BOLD, 11));
		upperLbl.setHorizontalAlignment(SwingConstants.CENTER);
		upperLbl.setBounds(19, 130, 78, 30);
		panel.add(upperLbl);
		
		lowerLbl = new JLabel("MINÚSCULAS");
		lowerLbl.setForeground(new Color(255, 255, 255));
		lowerLbl.setFont(new Font("Inter 28pt", Font.BOLD, 11));
		lowerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		lowerLbl.setBounds(107, 130, 78, 30);
		panel.add(lowerLbl);
		
		numbersLbl = new JLabel("NÚMEROS");
		numbersLbl.setForeground(new Color(255, 255, 255));
		numbersLbl.setFont(new Font("Inter 28pt", Font.BOLD, 11));
		numbersLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numbersLbl.setBounds(183, 130, 78, 30);
		panel.add(numbersLbl);
		
		symbolLbl = new JLabel("SÍMBOLOS");
		symbolLbl.setForeground(new Color(255, 255, 255));
		symbolLbl.setFont(new Font("Inter 28pt", Font.BOLD, 11));
		symbolLbl.setHorizontalAlignment(SwingConstants.CENTER);
		symbolLbl.setBounds(254, 130, 78, 30);
		panel.add(symbolLbl);
		
		upperBox = new JCheckBox("");
		upperBox.setHorizontalAlignment(SwingConstants.CENTER);
		upperBox.setHorizontalTextPosition(SwingConstants.CENTER);
		upperBox.setOpaque(false);
		upperBox.setBounds(39, 166, 35, 30);
		upperBox.setIcon(new ImageIcon(getClass().getResource("/checkOutline.png")));
		upperBox.setSelectedIcon(new ImageIcon(getClass().getResource("/checkInline.png")));
		panel.add(upperBox);
		
		lowerBox = new JCheckBox("");
		lowerBox.setOpaque(false);
		lowerBox.setHorizontalTextPosition(SwingConstants.CENTER);
		lowerBox.setHorizontalAlignment(SwingConstants.CENTER);
		lowerBox.setBounds(113, 166, 35, 30);
		lowerBox.setIcon(new ImageIcon(getClass().getResource("/checkOutline.png")));
		lowerBox.setSelectedIcon(new ImageIcon(getClass().getResource("/checkInline.png")));
		panel.add(lowerBox);
		
		numberBox = new JCheckBox("");
		numberBox.setOpaque(false);
		numberBox.setHorizontalTextPosition(SwingConstants.CENTER);
		numberBox.setHorizontalAlignment(SwingConstants.CENTER);
		numberBox.setBounds(187, 166, 35, 30);
		numberBox.setIcon(new ImageIcon(getClass().getResource("/checkOutline.png")));
		numberBox.setSelectedIcon(new ImageIcon(getClass().getResource("/checkInline.png")));
		panel.add(numberBox);
		
		symbolBox = new JCheckBox("");
		symbolBox.setOpaque(false);
		symbolBox.setHorizontalTextPosition(SwingConstants.CENTER);
		symbolBox.setHorizontalAlignment(SwingConstants.CENTER);
		symbolBox.setBounds(261, 166, 35, 30);
		symbolBox.setIcon(new ImageIcon(getClass().getResource("/checkOutline.png")));
		symbolBox.setSelectedIcon(new ImageIcon(getClass().getResource("/checkInline.png")));
		panel.add(symbolBox);
		
		generate = new JButton("GENERAR");
		generate.setBackground(new Color(0, 255, 117));
		generate.setBorder(null);
		generate.setForeground(new Color(255, 255, 255));
		generate.setFont(new Font("Inter 28pt Black", Font.PLAIN, 14));
		generate.setBounds(117, 223, 103, 37);
		panel.add(generate);
		
		showPassword = new JPanel();
		showPassword.setBackground(new Color(56, 56, 56));
		showPassword.setBorder(null);
		showPassword.setBounds(37, 291, 264, 130);
		panel.add(showPassword);
		showPassword.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 255, 117));
		separator.setBorder(null);
		separator.setBounds(10, 45, 244, 9);
		showPassword.add(separator);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("Inter 28pt Black", Font.PLAIN, 22));
		textField.setBackground(new Color(56, 56, 56));
		textField.setBorder(null);
		textField.setBounds(10, 15, 244, 28);
		showPassword.add(textField);
		textField.setColumns(10);
		
		copy = new JButton("");
		copy.setBorder(null);
		copy.setBackground(new Color(0, 255, 117));
		copy.setBounds(61, 64, 40, 40);
		copy.setIcon(new ImageIcon(getClass().getResource("/Copy.png")));
		showPassword.add(copy);
		
		saves = new JButton("");
		saves.setBackground(new Color(0, 255, 117));
		saves.setBorder(null);
		saves.setBounds(162, 64, 40, 40);
		saves.setIcon(new ImageIcon(getClass().getResource("/Save.png")));
		showPassword.add(saves);
		
		//ACTIONS LISTENERS
		
		fillList();
		
		increase.addActionListener(new buttons());
		decrease.addActionListener(new buttons());
		generate.addActionListener(new buttons());
		copy.addActionListener(new buttons());
		saves.addActionListener(new buttons());
		
	}
	
	//CLASE PRIVADA CON LAS FUNCIONALIDADES DE LOS BOTONES
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton button = (JButton)e.getSource();
			
			if(button == increase) {
				if(count >= 15) {
					JOptionPane.showMessageDialog(null, "La contraseña debe tener como máximo 15 dígitos");
				}else {
					count++;
					size.setText(String.valueOf(count));
				}
			}else if(button == decrease) {
				if(count <= 1) {
					JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos un dígito");
				}else {
					count--;
					size.setText(String.valueOf(count));
				}
			}else if(button == generate) {
				generatePassword(upperBox, lowerBox, numberBox, symbolBox);
				try {
					escribirFichero();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(button == copy) {
				copyKey(textField.getText());
			}else if(button == saves) {
				Saves s = new Saves();
				s.setVisible(true);
				dispose();
			}
		}
		
	}
	
	//METODOS EXTERNOS
	
	public void escribirFichero() throws IOException {
		String password = textField.getText();
		
		Password p = new Password(password);
		
		FileWriter fw = new FileWriter(fichero, true);
		fw.write(p+"\n");
		fw.close();
	}
	
	public void copyKey(String key) {
		String password = key;
		StringSelection stringSelection = new StringSelection(password);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		JOptionPane.showMessageDialog(null, "Contraseña copiada correctamente");
	}
	
	public void generatePassword(JCheckBox upper, JCheckBox lower, JCheckBox number, JCheckBox symbol) {
		String key = "";
		
		List<Character> avaliablesChar = new ArrayList<>();
		
		if(!upper.isSelected() && !lower.isSelected() && !number.isSelected() && !symbol.isSelected()) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar al menos una opcion");
		}else {
			if(upper.isSelected()) {
				for(Character c: list) {
					if(Character.isLetter(c) && Character.isUpperCase(c)) {
						avaliablesChar.add(c);
					}
				}
			}
			if(lower.isSelected()) {
				for(Character c: list) {
					if(Character.isLetter(c) && Character.isLowerCase(c)) {
						avaliablesChar.add(c);
					}
				}
			}
			if(number.isSelected()) {
				for(Character c: list) {
					if(Character.isDigit(c)) {
						avaliablesChar.add(c);
					}
				}
			}
			if(symbol.isSelected()) {
				for(Character c: list) {
					if(!Character.isLetterOrDigit(c)) {
						avaliablesChar.add(c);
					}
				}
			}
			
			for(int i = 1; i <= Integer.valueOf(size.getText()); i++) {
				int n = new Random().nextInt(avaliablesChar.size());
				key += avaliablesChar.get(n);
			}
			
		}
		passwords.add(key);
		textField.setText(key);
	}
	
	public void fillList() {
		for(int i = 32; i <= 126; i++) {
			list.add((char)i);
		}
	}
		
	
}
