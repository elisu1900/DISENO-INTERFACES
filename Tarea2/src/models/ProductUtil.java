package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import views.ClientCreate;
import views.ClientView;
import views.ProductCreate;
import views.ProductDelete;
import views.ProductView;

public class ProductUtil {

	public static ArrayList<Product> listProducts = new ArrayList<>();

	public static void showProducts(java.util.List<Product> listProduct) {
		ProductView.model.setRowCount(0);
		for (Product product : listProduct) {
			Object[] fila = { product.getNombre(), product.getPrecio(), product.isPerecedero() };
			ClientView.model.addRow(fila);
		}
	}

	public static void create() {
		try {
			Boolean perecedero = (String) ClientCreate.cbProvincia.getSelectedItem() == "SI" ? true : false;
			Product nuevo = new Product(ProductCreate.txtNombre.getText(), Double.parseDouble(ProductCreate.txtPrecio.getText()), perecedero);
			listProducts.add(nuevo);
			showProducts(listProducts);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo crear el cliente", "Error al crear",
					JOptionPane.ERROR_MESSAGE);
		}
		

	}

	public static void delete() {
		String nombre = ProductDelete.txtNombre.getText();
		if (listProducts.removeIf(product -> nombre.equals(product.getNombre()))) {
			showProducts(listProducts);

		} else {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el cliente", "Error al borrar",
					JOptionPane.ERROR_MESSAGE);
		}
			
		
	}

}
