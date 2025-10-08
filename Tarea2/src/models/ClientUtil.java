package models;

import java.util.ArrayList;

import views.Cliente;

public class ClientUtil {

	public static ArrayList<Client> listClients = new ArrayList<>();

	public static ArrayList<Product> listProducts = new ArrayList<>();
	
	public static void mostrarclientes(java.util.List<Client> listClients){
		Cliente.model.setRowCount(0);
		for (Client client : listClients) {
			Object[] fila = {
					client.getNombre(),
					client.getApellidos(),
					client.getEmail(),
					client.getEdad(),
					client.getProvincia()
			};
			Cliente.model.addRow(fila);
		}
	}
}
