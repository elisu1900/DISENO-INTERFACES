package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import models.ClientUtil;

import javax.swing.JTable;
import java.awt.FlowLayout;

public class ClientView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblProduct;
	public static DefaultTableModel model;
	private JPanel panelCards;
	private CardLayout cardLayout;
	
	/**
	 * Create the panel.
	 */
	public ClientView() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CLIENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientCreate dialog = new ClientCreate();
			    dialog.setVisible(true);
			}
		});
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientDelete dialog = new ClientDelete();
				dialog.setVisible(getFocusTraversalKeysEnabled());
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnBorrar);
		panel.add(btnCrear);
		
		String[] columnNames = {"Nombre", "Apellido", "email", "edad", "provincia"};
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
	
	public void setCardLayout(JPanel panelCards, CardLayout cardLayout) {
		this.panelCards = panelCards;
		this.cardLayout = cardLayout;
	}
}
