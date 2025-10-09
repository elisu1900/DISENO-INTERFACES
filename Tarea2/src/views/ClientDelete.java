package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.ClientUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientDelete extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ClientView panelPadre;

	public static JTextField txtEmailD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClientDelete dialog = new ClientDelete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClientDelete(ClientView padre) {
		this.panelPadre = padre;
	}

	/**
	 * Create the dialog.
	 */
	public ClientDelete() {
		setBounds(100, 100, 450, 300);
		contentPanel.setLayout(new GridLayout(5, 2, 10, 10));
		contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ClientUtil.delete();

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
		JLabel lblNombre = new JLabel("EMAIL:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblNombre);
		txtEmailD = new JTextField();
		contentPanel.add(txtEmailD);

	}

}
