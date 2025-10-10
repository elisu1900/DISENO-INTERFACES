package views;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ClientView panelClient = new ClientView();
	ProductView panelProduct = new ProductView();

	private JPanel panelCards;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 528);

		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		cardLayout = new CardLayout();
		panelCards = new JPanel(cardLayout);
		contentPane.add(panelCards, BorderLayout.CENTER);

		// Header
		JPanel panel_header = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel_header.setBackground(Color.decode("#B4A7D6")); // Lavanda pastel
		contentPane.add(panel_header, BorderLayout.NORTH);

		ImageIcon iconHeader = new ImageIcon(getClass().getResource("/images/imgHeader.png"));
		Image imgHeader = iconHeader.getImage();
		Image imgresizedHeader = imgHeader.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconresizedHeader = new ImageIcon(imgresizedHeader);

		JLabel lblImgHeader = new JLabel(iconresizedHeader);
		JLabel header = new JLabel("I.E.S.Pablo Picasso");

		header.setForeground(Color.WHITE);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel_header.add(lblImgHeader);
		panel_header.add(header);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.decode("#FFE5E5")); // Rosa pastel claro

		panelCards.add(panelMain, "main");
		panelCards.add(panelClient, "cliente");
		panelCards.add(panelProduct, "producto");

		panelClient.setCardLayout(panelCards, cardLayout);

		// Menú lateral
		JPanel panelMenu = new JPanel(new GridLayout(4, 1, 10, 10));
		panelMenu.setBackground(Color.decode("#D4B5E8")); // Lila pastel
		panelMenu.setPreferredSize(new Dimension(200, 0));
		contentPane.add(panelMenu, BorderLayout.WEST);

		

		JButton btnClient = new JButton(" 👤 Clientes");
		btnClient.setBackground(new Color(255, 209, 220)); // Rosa chicle pastel
		btnClient.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));

		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "cliente");
			}
		});
		panelMenu.add(btnClient);

		

		JButton btnProducts = new JButton(" 📦 Productos");
		btnProducts.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
		btnProducts.setBackground(new Color(181, 234, 215)); // Menta pastel
		
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelCards, "producto");
			}
		});
		panelMenu.add(btnProducts);

		JButton btnBill = new JButton(" 💰 Facturas");
		btnBill.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));

		btnBill.setBackground(new Color(255, 203, 164)); // Melocotón pastel
		panelMenu.add(btnBill);

		JButton btnUser = new JButton(" 🛠️ Usuarios");
		btnUser.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));

		btnUser.setBackground(new Color(199, 206, 234)); 
		panelMenu.add(btnUser);

		// Footer
		JPanel panelFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelFooter.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelFooter, BorderLayout.SOUTH);

		JLabel footer = new JLabel("Elias Wassit Calzado");
		footer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelFooter.add(footer);

	}
}