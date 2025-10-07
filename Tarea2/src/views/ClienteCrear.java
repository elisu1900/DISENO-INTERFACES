package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ClienteCrear extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ClienteCrear() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(68, 38, 90, 23);
		add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("APELLIDOS:\r\n");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellidos.setBounds(68, 87, 90, 23);
		add(lblApellidos);
		
		JLabel lblNewLabel_1_1 = new JLabel("EDAD:\r\n\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(68, 145, 90, 23);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("EMAIL:\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(68, 195, 90, 23);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("PROVINCIA:\r\n\r\n");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(68, 242, 90, 23);
		add(lblNewLabel_1_1_1_1);

	}
}
