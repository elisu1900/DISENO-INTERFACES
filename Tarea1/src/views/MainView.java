package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.ClientsUtils;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;

	String[] provincias = {
		    "Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila",
		    "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria",
		    "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Granada",
		    "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares",
		    "Jaén", "La Coruña", "La Rioja", "Las Palmas", "León", "Lérida",
		    "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia",
		    "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", 
		    "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia",
		    "Valladolid", "Vizcaya", "Zamora", "Zaragoza", "Ceuta", "Melilla"
		};
	public static JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
					ClientsUtils.showClients();

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
		setBounds(100, 100, 886, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 852, 463);
		contentPane.add(tabbedPane);
		
		JPanel panelVerClients = new JPanel();
		tabbedPane.addTab("Ver Clientes", null, panelVerClients, null);
		panelVerClients.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(10, 10, 827, 416);
		panelVerClients.add(textArea);
		
		JPanel panelNewClient = new JPanel();
		tabbedPane.addTab("Añadir Clientes", null, panelNewClient, null);
		panelNewClient.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(53, 44, 98, 22);
		panelNewClient.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setBounds(262, 45, 96, 25);
		panelNewClient.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("APELLIDOS:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellido.setBounds(53, 110, 98, 22);
		panelNewClient.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtApellido.setColumns(10);
		txtApellido.setBounds(262, 111, 96, 25);
		panelNewClient.add(txtApellido);
		
		JLabel lblEdad = new JLabel("EDAD:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdad.setBounds(53, 182, 98, 22);
		panelNewClient.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEdad.setColumns(10);
		txtEdad.setBounds(262, 183, 96, 25);
		panelNewClient.add(txtEdad);
		
		JComboBox<String> cbProvincia = new JComboBox<>(provincias);
		cbProvincia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbProvincia.setBounds(262, 242, 96, 21);
		panelNewClient.add(cbProvincia);
		
		JLabel lblProvincia = new JLabel("PROVINCIA:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProvincia.setBounds(53, 246, 98, 22);
		panelNewClient.add(lblProvincia);
		
		JButton btnAddEmployes = new JButton("Crear");
		btnAddEmployes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddEmployes.setBounds(590, 128, 114, 42);
		panelNewClient.add(btnAddEmployes);
		
		JPanel panelDeletecli = new JPanel();
		tabbedPane.addTab("Eliminar Clientes", null, panelDeletecli, null);
		
		JPanel panelSeeProduct = new JPanel();
		tabbedPane.addTab("Ver productos", null, panelSeeProduct, null);
		
		JPanel panelDeleteProduct = new JPanel();
		tabbedPane.addTab("New tab", null, panelDeleteProduct, null);
	}
}
