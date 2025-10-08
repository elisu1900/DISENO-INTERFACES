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

public class Cliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelCards;
	private CardLayout cardLayout;
	private JTable tblCliente;
	public static DefaultTableModel model;

	
	/**
	 * Create the panel.
	 */
	public Cliente() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CLIENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cardLayout != null && panelCards != null) {
					cardLayout.show(panelCards, "clienteCrear");
				}
			}
		});
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cardLayout != null && panelCards != null) {
					cardLayout.show(panelCards, "clienteBorrar");
				}
			}
		});
		btnBorrar.setBounds(281, 211, 115, 43);
		panel.add(btnBorrar);
		btnCrear.setBounds(54, 211, 115, 43);
		panel.add(btnCrear);
		
		String[] columnNames = {"Nombre", "Apellido", "email", "edad", "provincia"};
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		tblCliente = new JTable(model);
		tblCliente.setBounds(54, 41, 342, 0);
		tblCliente.setRowHeight(25);
		panel.add(tblCliente);
		ClientUtil.mostrarclientes(ClientUtil.listClients);
		
		JScrollPane scrollPane = new JScrollPane(tblCliente);
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void setCardLayout(JPanel panelCards, CardLayout cardLayout) {
		this.panelCards = panelCards;
		this.cardLayout = cardLayout;
	}
}
