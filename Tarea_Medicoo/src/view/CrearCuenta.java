package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCuenta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre_crear;
	private JTextField txtApellidos_crear;
	private JTextField txtEmail_crear;
	private JTextField txtPasswd_crear;
	private JTextField txtConfirmpasswd_crear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCuenta dialog = new CrearCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCuenta() {
		
		setBounds(100, 100, 475, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(20, 20, 0, 20));
		contentPanel.setBackground(new Color(0,120,70));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240, 230, 140));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridheight = 3;
			gbc_panel.gridwidth = 7;
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblNombre_crear = new JLabel("Nombre\r\n");
				lblNombre_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNombre_crear = new GridBagConstraints();
				gbc_lblNombre_crear.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre_crear.gridx = 2;
				gbc_lblNombre_crear.gridy = 1;
				panel.add(lblNombre_crear, gbc_lblNombre_crear);
			}
			{
				txtNombre_crear = new JTextField();
				txtNombre_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_txtNombre_crear = new GridBagConstraints();
				gbc_txtNombre_crear.gridwidth = 2;
				gbc_txtNombre_crear.insets = new Insets(0, 0, 5, 0);
				gbc_txtNombre_crear.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre_crear.gridx = 4;
				gbc_txtNombre_crear.gridy = 1;
				panel.add(txtNombre_crear, gbc_txtNombre_crear);
				txtNombre_crear.setColumns(10);
			}
			{
				JLabel lblApellido_crear = new JLabel("Apellidos\r\n");
				lblApellido_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_lblApellido_crear = new GridBagConstraints();
				gbc_lblApellido_crear.insets = new Insets(0, 0, 5, 5);
				gbc_lblApellido_crear.gridx = 2;
				gbc_lblApellido_crear.gridy = 4;
				panel.add(lblApellido_crear, gbc_lblApellido_crear);
			}
			{
				txtApellidos_crear = new JTextField();
				txtApellidos_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtApellidos_crear.setColumns(10);
				GridBagConstraints gbc_txtApellidos_crear = new GridBagConstraints();
				gbc_txtApellidos_crear.gridwidth = 2;
				gbc_txtApellidos_crear.insets = new Insets(0, 0, 5, 0);
				gbc_txtApellidos_crear.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtApellidos_crear.gridx = 4;
				gbc_txtApellidos_crear.gridy = 4;
				panel.add(txtApellidos_crear, gbc_txtApellidos_crear);
			}
			{
				JLabel lblEmail_crear = new JLabel("Email\r\n");
				lblEmail_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_lblEmail_crear = new GridBagConstraints();
				gbc_lblEmail_crear.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail_crear.gridx = 2;
				gbc_lblEmail_crear.gridy = 7;
				panel.add(lblEmail_crear, gbc_lblEmail_crear);
			}
			{
				txtEmail_crear = new JTextField();
				txtEmail_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtEmail_crear.setColumns(10);
				GridBagConstraints gbc_txtEmail_crear = new GridBagConstraints();
				gbc_txtEmail_crear.gridwidth = 2;
				gbc_txtEmail_crear.insets = new Insets(0, 0, 5, 0);
				gbc_txtEmail_crear.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtEmail_crear.gridx = 4;
				gbc_txtEmail_crear.gridy = 7;
				panel.add(txtEmail_crear, gbc_txtEmail_crear);
			}
			{
				JLabel lblContraseña_crear = new JLabel("Contraseña\r\n\t");
				lblContraseña_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_lblContraseña_crear = new GridBagConstraints();
				gbc_lblContraseña_crear.insets = new Insets(0, 0, 5, 5);
				gbc_lblContraseña_crear.gridx = 2;
				gbc_lblContraseña_crear.gridy = 10;
				panel.add(lblContraseña_crear, gbc_lblContraseña_crear);
			}
			{
				txtPasswd_crear = new JTextField();
				txtPasswd_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtPasswd_crear.setColumns(10);
				GridBagConstraints gbc_txtPasswd_crear = new GridBagConstraints();
				gbc_txtPasswd_crear.gridwidth = 2;
				gbc_txtPasswd_crear.insets = new Insets(0, 0, 5, 0);
				gbc_txtPasswd_crear.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPasswd_crear.gridx = 4;
				gbc_txtPasswd_crear.gridy = 10;
				panel.add(txtPasswd_crear, gbc_txtPasswd_crear);
			}
			{
				JLabel lblComfirmContraseña_crear = new JLabel("Confirmar Contraseña\r\n");
				lblComfirmContraseña_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				GridBagConstraints gbc_lblComfirmContraseña_crear = new GridBagConstraints();
				gbc_lblComfirmContraseña_crear.insets = new Insets(0, 0, 0, 5);
				gbc_lblComfirmContraseña_crear.gridwidth = 2;
				gbc_lblComfirmContraseña_crear.gridx = 1;
				gbc_lblComfirmContraseña_crear.gridy = 13;
				panel.add(lblComfirmContraseña_crear, gbc_lblComfirmContraseña_crear);
			}
			{
				txtConfirmpasswd_crear = new JTextField();
				txtConfirmpasswd_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtConfirmpasswd_crear.setColumns(10);
				GridBagConstraints gbc_txtConfirmpasswd_crear = new GridBagConstraints();
				gbc_txtConfirmpasswd_crear.gridwidth = 2;
				gbc_txtConfirmpasswd_crear.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtConfirmpasswd_crear.gridx = 4;
				gbc_txtConfirmpasswd_crear.gridy = 13;
				panel.add(txtConfirmpasswd_crear, gbc_txtConfirmpasswd_crear);
			}
		}
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setBackground(new Color(0,120,70));

			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
