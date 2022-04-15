package ihm;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import metier.MatriceException;
import metier.Population;

public class Principale {

	public static void main(String[] args) {

		final int nbMobiles = 50;
		
		Population pop = new Population(nbMobiles);
		try {
			for (int generation = 0; generation < 10; generation++) {
				System.out.println("population numéro " + Population.getNumero());

				for (int i = 0; i < nbMobiles; i++) {
					pop.deplaceLesMobiles(i);
				}

				double scoreMoyen = pop.getScoreMoyen();
						
				FileWriter fw = new FileWriter("data.txt");
				
				PrintWriter pw = new PrintWriter(fw);
				
				System.out.println("Score moyen pour la génération "+generation+" : "+scoreMoyen);
				System.out.println("Coordonnées du meilleur mobile " +pop.getCoordonneesMeilleur());
				
				pw.println("Score moyen pour la génération "+generation+" : "+scoreMoyen);
				pw.println("Coordonnées du meilleur mobile " +pop.getCoordonneesMeilleur());
				
				pw.close();
				
				pop = pop.genere(new CritereDistance(scoreMoyen));
			}
		} 
		catch (IllegalArgumentException e) {
			System.out.println("Erreur de paramètre " + e.toString());
		}
		catch(MatriceException e1) {
			System.out.println("Erreur de matrices : " + e1.getMessage());
			
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		finally {
			System.out.println("Toujours exécuté");
		}

	}

}
