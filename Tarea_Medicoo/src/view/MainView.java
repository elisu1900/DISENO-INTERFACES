package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel panelCards;
	private CardLayout cardLayout;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(60, 179, 113));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		cardLayout = new CardLayout();
		panelCards = new JPanel(cardLayout);
		contentPane.add(panelCards, BorderLayout.CENTER);

		

		JLabel lblNewLabel = new JLabel("iSalud\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Elias\\workspace1\\Tarea_Medicoo\\sources\\logo.png"));
		headerPanel.add(lblNewLabel);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(144, 238, 144));
		
		panelCards.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon("C:\\Users\\Elias\\workspace1\\Tarea_Medicoo\\sources\\imgPortada.png"));
		mainPanel.add(lblImg, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		mainPanel.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 1;
		panel.add(lblEmail, gbc_lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña\r\n");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblContraseña = new GridBagConstraints();
		gbc_lblContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseña.gridx = 0;
		gbc_lblContraseña.gridy = 4;
		panel.add(lblContraseña, gbc_lblContraseña);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 4;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblCreacionCuenta = new JLabel("¿no tienes cuenta?");
		lblCreacionCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCreacionCuenta = new GridBagConstraints();
		gbc_lblCreacionCuenta.gridwidth = 2;
		gbc_lblCreacionCuenta.insets = new Insets(0, 0, 0, 5);
		gbc_lblCreacionCuenta.gridx = 0;
		gbc_lblCreacionCuenta.gridy = 6;
		panel.add(lblCreacionCuenta, gbc_lblCreacionCuenta);
		lblCreacionCuenta.setForeground(Color.BLUE);
		lblCreacionCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblCreacionCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JPanel welcomePanel = new JPanel();
		panelCards.add(welcomePanel, "name_182186007900");
	}
}
