package ihm;

import metier.Population;

public class Principale {

	public static void main(String[] args) {

		System.out.println("population num?ro " + Population.getNumero());

		Population pop = new Population(50);
		try {
			for (int generation = 0; generation < 10; generation++) {
				System.out.println("population num?ro " + Population.getNumero());

				for (int i = 0; i < 10; i++) {

					pop.deplaceLesMobiles(i);

				}

				pop = pop.genere(new CritereSimple());
			}
		} 
		catch (IllegalArgumentException e) {

			System.out.println("Erreur de param?tre " + e.toString());
		}
		catch(Exception e1) {
			System.out.println("Erreur de matrices : " + e1.getMessage());
			
		}

	}

}
