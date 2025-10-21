package main;

import java.awt.EventQueue;

import models.Client;
import models.ClientUtil;
import models.Product;
import models.ProductUtil;
import views.MainView;

public class MainApp {

	public static void main(String[] args) {

		// ==== CLIENTES ====
		ClientUtil.listClients.add(new Client("Ana", "Torres García", "ana.torres@example.com", 28, "Madrid"));
		ClientUtil.listClients.add(new Client("Luis", "Gómez Pérez", "luis.gomez@example.com", 35, "Barcelona"));
		ClientUtil.listClients.add(new Client("María", "López Díaz", "maria.lopez@example.com", 41, "Valencia"));
		ClientUtil.listClients.add(new Client("Carlos", "Ruiz Navarro", "carlos.ruiz@example.com", 22, "Sevilla"));
		ClientUtil.listClients.add(new Client("Laura", "Martín Sánchez", "laura.martin@example.com", 30, "Bilbao"));
		ClientUtil.listClients.add(new Client("Javier", "Castro Romero", "javier.castro@example.com", 45, "Zaragoza"));
		ClientUtil.listClients.add(new Client("Sofía", "Fernández Ortega", "sofia.fernandez@example.com", 27, "Granada"));
		ClientUtil.listClients.add(new Client("Andrés", "Muñoz Herrera", "andres.munoz@example.com", 33, "Málaga"));
		ClientUtil.listClients.add(new Client("Elena", "Prieto Vega", "elena.prieto@example.com", 50, "Alicante"));
		ClientUtil.listClients.add(new Client("Pablo", "Santos Molina", "pablo.santos@example.com", 39, "Valladolid"));

		// ==== PRODUCTOS ====
		ProductUtil.listProducts.add(new Product("Manzanas", 2.99, true));
		ProductUtil.listProducts.add(new Product("Pan", 1.20, true));
		ProductUtil.listProducts.add(new Product("Leche", 1.05, true));
		ProductUtil.listProducts.add(new Product("Arroz", 3.50, false));
		ProductUtil.listProducts.add(new Product("Aceite de oliva", 8.90, false));
		ProductUtil.listProducts.add(new Product("Yogur", 0.95, true));
		ProductUtil.listProducts.add(new Product("Café molido", 6.80, false));
		ProductUtil.listProducts.add(new Product("Queso curado", 12.50, true));
		ProductUtil.listProducts.add(new Product("Harina", 2.10, false));
		ProductUtil.listProducts.add(new Product("Chocolate", 3.75, false));

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
