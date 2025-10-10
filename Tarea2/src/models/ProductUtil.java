package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import views.ProductCreate;
import views.ProductDelete;
import views.ProductView;

public class ProductUtil {

	public static ArrayList<Product> listProducts = new ArrayList<>();

	/**
	 * loads each product’s data into the table
	 * 
	 * @param listProduct
	 */
	public static void showProducts() {
		ProductView.model.setRowCount(0);
		for (Product product : listProducts) {
			Object[] fila = { product.getNombre(), product.getPrecio(), product.isPerecedero() };
			ProductView.model.addRow(fila);
		}
	}

	/**
	 * creates the new products to be added
	 */
	public static void create() {
		try {
			Boolean perecedero = (String) ProductCreate.cbPerishable.getSelectedItem() == "SI" ? true : false;
			Product nuevo = new Product(ProductCreate.txtName.getText(),
					Double.parseDouble(ProductCreate.txtPrice.getText()), perecedero);
			listProducts.add(nuevo);
			showProducts();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo crear el producto", "Error al crear",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * delete a product identify by name
	 */
	public static void delete() {
		String nombre = ProductDelete.txtName.getText();
		if (listProducts.removeIf(product -> nombre.equals(product.getNombre()))) {
			showProducts();

		} else {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el producto", "Error al borrar",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
