package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.ClientUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientCreate extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	String[] provincias = { "Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Barcelona",
			"Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona",
			"Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "La Coruña",
			"La Rioja", "Las Palmas", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense",
			"Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona",
			"Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza", "Ceuta", "Melilla" };
	public static JComboBox cbProvincia;
	public static JTextField txtApellido;
	public static JTextField txtNombre;
	public static JTextField txtEmail;
	public static JTextField txtEdad;
	private ClientView panelPadre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClientCreate dialog = new ClientCreate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClientCreate(ClientView padre) {
		this.panelPadre = padre;
	}
	    
	/**
	 * Create the dialog.
	 */
	public ClientCreate() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setLayout(new GridLayout(5, 2, 10, 10));
		contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// NOMBRE
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblNombre);
		txtNombre = new JTextField();
		contentPanel.add(txtNombre);

		// APELLIDO
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblApellido);
		txtApellido = new JTextField();
		contentPanel.add(txtApellido);

		// EMAIL
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblEmail);
		txtEmail = new JTextField();
		contentPanel.add(txtEmail);
		// EMAIL
		JLabel lblEdad = new JLabel("EDAD:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblEdad);
		txtEdad = new JTextField();
		contentPanel.add(txtEdad);
		// PROVINCIA
		JLabel lblProvincia = new JLabel("PROVINCIA:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblProvincia);
		cbProvincia = new JComboBox<String>(provincias);
		contentPanel.add(cbProvincia);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientUtil.create();
					
					if (panelPadre != null) {
						ClientUtil.showClients(ClientUtil.listClients);
					}
					
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);

		}
	}

}
