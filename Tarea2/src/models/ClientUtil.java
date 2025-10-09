package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import views.ClientView;
import views.ClientDelete;
import views.ClientCreate;

public class ClientUtil {

	public static ArrayList<Client> listClients = new ArrayList<>();


	public static void showClients(java.util.List<Client> listClients) {
		ClientView.model.setRowCount(0);
		for (Client client : listClients) {
			Object[] fila = { client.getNombre(), client.getApellidos(), client.getEmail(), client.getEdad(),
					client.getProvincia() };
			ClientView.model.addRow(fila);
		}
	}

	public static void create() {
		try {
			Client nuevo = new Client(ClientCreate.txtNombre.getText(), ClientCreate.txtApellido.getText(),
					ClientCreate.txtEmail.getText(), Integer.parseInt(ClientCreate.txtEdad.getText()),
					(String) ClientCreate.cbProvincia.getSelectedItem());
			listClients.add(nuevo);
			showClients(listClients);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo crear el cliente", "Error al crear",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void delete() {
		String email = ClientDelete.txtEmailD.getText();

		if (listClients.removeIf(client -> email.equals(client.getEmail()))) {

			showClients(listClients);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente", "Error al eliminar",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
