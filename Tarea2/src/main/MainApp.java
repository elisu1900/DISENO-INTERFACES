package main;

import models.Client;
import models.ClientUtil;
import views.MainView;

public class MainApp {

	
	
	//MIRAR POR QUE NO APARECEN LOS BOTONES DE CREAR Y BORRAR Y QUE CUANDO SE LE DE A BORRR QUE TE MANDE A BUSCAR POR EMAI Y QUE AL 
	//DARLE A CREAR QUE SIMPLEMENTE TE LLEVE A UN MENU DE CREAR.
	
	
	
	public static void main(String[] args) {

		Client cliente = new Client("aaa", "eee", "iii", 12, "aaa");
		ClientUtil.listClients.add(cliente);
		Client cliente1 = new Client("aaa", "eee", "iii", 20, "aaa");
		ClientUtil.listClients.add(cliente1);
		Client cliente2 = new Client("aaa", "eee", "iii", 18, "aaa");
		ClientUtil.listClients.add(cliente2);
		Client cliente3 = new Client("aaa", "eee", "iii", 17, "aaa");
		ClientUtil.listClients.add(cliente3);
		Client cliente4 = new Client("aaa", "eee", "iii", 16, "aaa");
		ClientUtil.listClients.add(cliente4);
		Client cliente5 = new Client("aaa", "eee", "iii", 15, "aaa");
		ClientUtil.listClients.add(cliente5);
		Client cliente6 = new Client("aaa", "eee", "iii", 13, "aaa");
		ClientUtil.listClients.add(cliente6);
		
		
		MainView ventana = new MainView();
		ventana.setVisible(true);
	}

}
