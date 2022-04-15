package ihm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import metier.MatriceException;
import metier.Population;

public class Principale {

	static File leFichier = new File("data.txt"); 
			
	public static void main(String[] args) {

		final int nbMobiles = 50;
		
		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				
				Population pop = new Population(nbMobiles);
				try {
					for (int generation = 0; generation < 100; generation++) {
						System.out.println("population numéro " + Population.getNumero());

						for (int i = 0; i < nbMobiles; i++) {
							pop.deplaceLesMobiles(i);
						}

						double scoreMoyen = pop.getScoreMoyen();
								
						if(leFichier.exists()) {
							leFichier = new File("data"+generation+".txt");
						}
						
						FileWriter fw = new FileWriter(leFichier);
						
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
				
				try(FileOutputStream fis = new FileOutputStream("data.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fis);) {
				
					oos.writeObject(pop);
				
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		
		

		System.out.println("Fin du main");
	}

}
