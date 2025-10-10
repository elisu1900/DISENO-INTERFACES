package views;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.table.TableRowSorter;

import models.ClientUtil;
import models.ProductUtil;

public class ProductView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblProduct;
	public static DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ProductView() {

		setLayout(new BorderLayout(0, 0));

		JLabel lblTitle = new JLabel("PRODUCTO");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblTitle, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton btnCreate = new JButton("CREAR");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProductCreate dialog = new ProductCreate();
				dialog.setVisible(true);
			}
		});

		JButton btnDelete = new JButton("BORRAR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProductDelete dialog = new ProductDelete();
				dialog.setVisible(getFocusTraversalKeysEnabled());
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnDelete);
		panel.add(btnCreate);
		panel.setBackground(Color.decode("#FFE5E5")); // Rosa pastel claro

		String[] columnNames = { "Nombre", "precio", "perecedero" };
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tblProduct = new JTable(model);
		tblProduct.setRowHeight(25);
		tblProduct.getTableHeader().setBackground(Color.decode("#D4B5E8")); 
		tblProduct.getTableHeader().setForeground(Color.WHITE);
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		tblProduct.setRowSorter(sorter);
		
		ProductUtil.showProducts();

		JScrollPane scrollPane = new JScrollPane(tblProduct);
		add(scrollPane, BorderLayout.CENTER);

	}

}
