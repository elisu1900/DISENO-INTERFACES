package models;

import java.util.ArrayList;

public class ClientsUtils {

	public static ArrayList<Client> listClients = new ArrayList<>();
	public static ArrayList<Product> listProducts = new ArrayList<>();
	
	public static void showClients() {
		views.MainView.textArea.setText("nombre \t apellido\t edad\t provincia");

		for (Client client : listClients) {
			

			views.MainView.textArea.setText(client.toString() + "\n");
		}
	}
}

