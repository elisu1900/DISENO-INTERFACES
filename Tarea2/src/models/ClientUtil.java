package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import views.ClientView;
import views.ClientDelete;
import views.ClientCreate;


public class ClientUtil {

	public static ArrayList<Client> listClients = new ArrayList<>();

	/**
	 * displays in the table the clients contained in the clients list
	 * @param listClients
	 */
	public static void showClients() {
		ClientView.model.setRowCount(0);
		for (Client client : listClients) {
			Object[] fila = { client.getNombre(), client.getApellidos(), client.getEmail(), client.getEdad(),
					client.getProvincia()};
			ClientView.model.addRow(fila);
		}
	}
	/**
	 * creates a new client using the given parameters
	 */
	public static void create() {
		try {
			Client nuevo = new Client(ClientCreate.txtName.getText(), ClientCreate.txtLastName.getText(),
					ClientCreate.txtEmail.getText(), Integer.parseInt(ClientCreate.txtAge.getText()),
					(String) ClientCreate.cbProvince.getSelectedItem());
			listClients.add(nuevo);
			showClients();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo crear el cliente", "Error al crear",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * deletes a client identified by their email
	 */
	public static void delete() {
		String email = ClientDelete.txtEmailD.getText();

		if (listClients.removeIf(client -> email.equals(client.getEmail()))) {

			showClients();
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente", "Error al eliminar",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
