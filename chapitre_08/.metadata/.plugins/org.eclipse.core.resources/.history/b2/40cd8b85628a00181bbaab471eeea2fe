package ihm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import metier.MatriceException;
import metier.Population;
import metier.Mobile;

public class Principale {

	static File leFichier = new File("data.txt"); 
		
	static double scoreMoyen;
	static Mobile leMeilleur;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		traitement();
	}

	public static String traitement() throws InterruptedException, ExecutionException {
		final int nbMobiles = 50;
		
		int processeurs = Runtime.getRuntime().availableProcessors();
		System.out.println("processeurs dispo : "+processeurs);
		
		ExecutorService services = Executors.newFixedThreadPool(processeurs);
		Future<Mobile> resultat = services.submit( () -> traitement(nbMobiles));
		services.shutdown();
	
		System.out.println("Fin du main");
		return resultat.get().toString();
	}

	private static Mobile traitement(final int nbMobiles) {
		Population pop = new Population(nbMobiles);
		try {
			for (int generation = 0; generation < 100; generation++) {
				System.out.println("population numéro " + Population.getNumero());

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
				
				System.out.println("Score moyen pour la génération "+generation+" : "+scoreMoyen);
				System.out.println("Coordonnées du meilleur mobile " + leMeilleur);
				
				pw.println("Score moyen pour la génération "+generation+" : "+scoreMoyen);
				pw.println("Coordonnées du meilleur mobile " +pop.getCoordonneesMeilleur());
				
				pw.close();
				
				if(generation != 99) {
					pop = pop.genere(new CritereDistance(scoreMoyen));
				}
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
			System.out.println("Fin du traitement");
		}
		
		return leMeilleur;
	}

}
