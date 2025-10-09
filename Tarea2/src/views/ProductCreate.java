package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.ClientUtil;
import models.ProductUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductCreate extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField txtNombre;
	public static JTextField txtPrecio;
	public static JTextField txtPerecedero;
	public static JComboBox cbPerecedero;
	private ProductView panelPadre;

	String[] perecedero = { "NO","SI"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductCreate dialog = new ProductCreate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ProductCreate(ProductView padre) {
		this.panelPadre = padre;
	}
	/**
	 * Create the dialog.
	 */
	public ProductCreate() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setLayout(new GridLayout(3, 2, 10, 10));
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
						ProductUtil.create();
						
						if (panelPadre != null) {
							ProductUtil.showProducts(ProductUtil.listProducts);
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
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblNombre);
		txtNombre = new JTextField();
		contentPanel.add(txtNombre);

		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblApellido);
		txtPrecio = new JTextField();
		contentPanel.add(txtPrecio);

		
		JLabel lblPerecedero = new JLabel("PERECEDERO:");
		lblPerecedero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblPerecedero);
		cbPerecedero = new JComboBox<String>(perecedero);
		contentPanel.add(cbPerecedero);
	}
	
	

}
