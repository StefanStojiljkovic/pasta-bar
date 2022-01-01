package ProjekatPastaBar;

import java.util.Scanner;

public class NarucivanjePaste {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);


		String[] ingridients = { "Makarone", "Spagete", "Bolognese", "Curetina", "Govedja prsuta", "Slanina",
				"Piletina", "4 sira", "Dimljeni sir", "Parmezan", "Pavlaka", "Pesto sos", "Napolitana", "Povrce mix",
				"Pecurke", "Kutija" };
		
		int[] prices = { 50, 60, 120, 120, 140, 100, 100, 100, 80, 50, 80, 80, 80, 50, 50, 20 };
		
		String[] phoneNumbers = { "063111111", "063222222", "063333333", "064444444", "065555555", "066666666" };
		

		boolean stopOrder = false;
		int orderPrice = 0;

		System.out.println("Dobrodosli, izvolite");

		while (stopOrder == false) {

			while (stopOrder == false) {

				System.out.print("Odaberite sastojak: ");
				String ingridient = s.next();

				if (!ingridient.equals("poruci") && findIngredient(ingridients, ingridient) != 0) {

					orderPrice = orderPrice + prices[findIngredient(ingridients, ingridient)];

					System.out.println("Uzeli ste " + ingridient + " ukupno " + orderPrice + "rsd");

				} else if (ingridient.equals("poruci")) {

					System.out.print("Unesite Vas broj telefona: ");
					String phone = s.next();
					System.out.println();

					if (isRegularCustomer(phoneNumbers, phone) == true) {

						orderPrice = orderPrice - (orderPrice * 10 / 100);

						System.out.println("Redovne musterije imaju popust od 10 %");

					}

					stopOrder = true;
					System.out.println("Cena paste je: " + orderPrice + "rsd");
					System.out.println("Prijatno!");
				
				} else {
					System.out.println();
					System.out.println("Trenutno nemamo taj sastojak.");
					System.out.println("Odaberite drugi sastojak.");

					for (int i = 0; i < ingridients.length; i++) {
						System.out.print(ingridients[i] + ", ");
					}
					System.out.println();
					System.out.println();
				}
			}
			
		}
	}
}