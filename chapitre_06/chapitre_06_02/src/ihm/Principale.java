package ihm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import metier.MatriceException;
import metier.Population;
import metier.Mobile;

public class Principale {

	static File leFichier = new File("data.txt"); 
		
	static double scoreMoyen;
	static Mobile leMeilleur;
	
	public static void main(String[] args) {

		final int nbMobiles = 50;
		
		Thread t1 = new Thread( () -> traitement(nbMobiles));
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Fin du main");
		System.out.println("Le meilleur est "+leMeilleur);
	}

	private static void traitement(final int nbMobiles) {
		Population pop = new Population(nbMobiles);
		try {
			for (int generation = 0; generation < 100; generation++) {
				System.out.println("population num?ro " + Population.getNumero());

				for (int i = 0; i < nbMobiles; i++) {
					pop.deplaceLesMobiles(i);
				}

				scoreMoyen = pop.getScoreMoyen();
						
				leMeilleur = pop.getCoordonneesMeilleur();
				
				if(leFichier.exists()) {
					leFichier = new File("data"+generation+".txt");
				}
				
				FileWriter fw = new FileWriter(leFichier);
				
				PrintWriter pw = new PrintWriter(fw);
				
				System.out.println("Score moyen pour la g?n?ration "+generation+" : "+scoreMoyen);
				System.out.println("Coordonn?es du meilleur mobile " + leMeilleur);
				
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
