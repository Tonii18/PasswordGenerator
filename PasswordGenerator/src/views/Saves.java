package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Saves extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton back;

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
	 */
	public Saves() {
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

}
