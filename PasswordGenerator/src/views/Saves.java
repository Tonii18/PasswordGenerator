package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Password;

public class Saves extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton back;
	private JTable table;
	
	private List<Password> passwords;
	
	private String fichero = "C:\\Users\\ajsan\\git\\PasswordGenerator\\PasswordGenerator\\keys\\passwords.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saves frame = new Saves();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Saves() throws IOException {
		setTitle("Generador de contraseñas");
		ImageIcon image = new ImageIcon(getClass().getResource("/icon.png"));
		setIconImage(image.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 602);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(93, 93, 93));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLbl = new JLabel("CONTRASEÑAS GUARDADAS");
		titleLbl.setForeground(new Color(255, 255, 255));
		titleLbl.setFont(new Font("Inter 28pt Black", Font.PLAIN, 26));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(10, 29, 386, 43);
		contentPane.add(titleLbl);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 255, 117), 4));
		panel.setBackground(new Color(93, 93, 93));
		panel.setBounds(34, 95, 338, 448);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(56, 56, 56));
		panelTable.setBounds(26, 30, 285, 326);
		panel.add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setFont(new Font("Inter 28pt Black", Font.PLAIN, 14));
		scrollPane.setBackground(new Color(56, 56, 56));
		scrollPane.setBorder(new LineBorder(new Color(0, 255, 117), 3, true));
		scrollPane.setBounds(10, 10, 265, 306);
		panelTable.add(scrollPane);
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(56, 56, 56));
		header.setFont(new Font("Inter 28pt Black", Font.PLAIN, 26));
		header.setForeground(Color.WHITE);
		header.setBorder(new LineBorder(new Color(0, 255, 117), 1, true));
		table.setRowSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		table.setRowHeight(50);
		table.setGridColor(new Color(0, 255, 117));
		table.setForeground(new Color(255, 255, 255));
		table.setFont(new Font("Inter 28pt Black", Font.PLAIN, 18));
		table.setBackground(new Color(56, 56, 56));
		table.setBorder(null);
		showPasswords();
		scrollPane.setViewportView(table);
		
		back = new JButton("");
		back.setBackground(new Color(0, 255, 117));
		back.setBorder(null);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow_back.png")));
		back.setBounds(271, 385, 40, 40);
		panel.add(back);
		
		//ACTIONS LISTENERS
		
		back.addActionListener(new buttons());
	}
	
	//CLASE PRIVADA PARA LAS ACCIONES DE LOS BOTONES
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			
			if(button == back) {
				Generator g = new Generator();
				g.setVisible(true);
				dispose();
			}
		}
		
	}
	
	//METODOS EXTERNOS
	
	public void showPasswords() throws IOException {
		passwords = new ArrayList<>();
		
		BufferedReader bf = new BufferedReader(new FileReader(fichero));
		String line = "";
		while(line != null) {
			line = bf.readLine();
			passwords.add(new Password(line));
		}
		
		bf.close();
		
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Contraseñas"}));
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		
		for(int i = 0; i < this.passwords.size(); i++) {
			dtm.addRow(new Object[] {
					passwords.get(i).getKey()
			});
		}
	}
}
