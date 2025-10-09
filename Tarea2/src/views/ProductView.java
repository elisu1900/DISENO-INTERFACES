package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import models.ClientUtil;

public class ProductView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblProduct;
	public static DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public ProductView() {

		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("PRODUCTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductCreate dialog = new ProductCreate();
			    dialog.setVisible(true);
			}
		});
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductDelete dialog = new ProductDelete();
				dialog.setVisible(getFocusTraversalKeysEnabled());
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnBorrar);
		panel.add(btnCrear);
		
		String[] columnNames = {"Nombre", "precio", "perecedero"};
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		tblProduct = new JTable(model);
		tblProduct.setRowHeight(25);
		ClientUtil.showClients(ClientUtil.listClients);
		
		JScrollPane scrollPane = new JScrollPane(tblProduct);
		add(scrollPane, BorderLayout.CENTER);
		
	
	}

}
