package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.UsuarioController;
import model.Usuario;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JPasswordField txtPassword;
	public static JTextField txtEmail;
	public static JButton btnIniciarSesion;
	private UsuarioController controlador;
	public static JPanel mainPanel;


	public MainView() {
		controlador = new UsuarioController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(60, 179, 113));
		contentPane.add(headerPanel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ImageIcon originalIcon = new ImageIcon("sources\\logo.png");
		
		headerPanel.add(lblNewLabel);
		lblNewLabel.setIcon(originalIcon);
		
		
		JLabel lblTitle = new JLabel("iSalud");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		headerPanel.add(lblTitle);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(144, 238, 144));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon("sources\\imgPortada.png"));
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
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 1;
		panel.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblContraseña = new GridBagConstraints();
		gbc_lblContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseña.gridx = 0;
		gbc_lblContraseña.gridy = 4;
		panel.add(lblContraseña, gbc_lblContraseña);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 3;
		gbc_txtPassword.gridy = 4;
		panel.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
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
				CrearCuentas ventanaRegistro = new CrearCuentas(controlador);
				ventanaRegistro.setVisible(true);
			}
		});
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnIniciarSesion, gbc_btnNewButton);
		
		controlador.addListeners();
	}
}