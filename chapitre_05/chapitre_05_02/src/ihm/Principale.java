package ihm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import metier.MatriceException;
import metier.Population;

public class Principale {

	public static void main(String[] args) {

		final int nbMobiles = 50;
		
		Population pop = new Population(nbMobiles);
		try {
			for (int generation = 0; generation < 10; generation++) {
				System.out.println("population num?ro " + Population.getNumero());

				for (int i = 0; i < nbMobiles; i++) {
					pop.deplaceLesMobiles(i);
				}

				double scoreMoyen = pop.getScoreMoyen();
						
				FileWriter fw = new FileWriter("data.txt");
				
				PrintWriter pw = new PrintWriter(fw);
				
				System.out.println("Score moyen pour la g?n?ration "+generation+" : "+scoreMoyen);
				System.out.println("Coordonn?es du meilleur mobile " +pop.getCoordonneesMeilleur());
				
				pw.println("Score moyen pour la g?n?ration "+generation+" : "+scoreMoyen);
				pw.println("Coordonn?es du meilleur mobile " +pop.getCoordonneesMeilleur());
				
				pw.close();
				
				pop = pop.genere(new CritereDistance(scoreMoyen));
			}
		} 
		catch (IllegalArgumentException e) {
			System.out.println("Erreur de param?tre " + e.toString());
		}
		catch(MatriceException e1) {
			System.out.println("Erreur de matrices : " + e1.getMessage());
			
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		finally {
			System.out.println("Toujours ex?cut?");
		}
		
		try(FileOutputStream fis = new FileOutputStream("data.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fis);) {
		
			oos.writeObject(pop);
		
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}

	}

}
