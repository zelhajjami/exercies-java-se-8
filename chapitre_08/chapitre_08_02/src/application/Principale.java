package application;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Supplier;

import ihm.CritereDistance;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import metier.Mobile;
import metier.Population;

public class Principale {

	@FXML
	TextArea ta_affichage;

	@FXML
	BorderPane canvas;

	@FXML
	public void initialize() {
		canvas.getStyleClass().add("borderpane");
	}

	final int nbMobiles = 50;
	Population pop = new Population(nbMobiles);

	public void demarrer() {
		Alert al = new Alert(AlertType.INFORMATION);
		al.setHeaderText("Ca va prendre du temps!");
		al.setTitle("Lancement du traitement");
		al.setContentText("On d?marre....");
		al.showAndWait();

		try {
			final int nbMobiles = 50;

			int processeurs = Runtime.getRuntime().availableProcessors();
			System.out.println("processeurs dispo : " + processeurs);

			ExecutorService services = Executors.newFixedThreadPool(processeurs);
			Future<Mobile> resultat = services.submit(() -> traitement());
			services.shutdown();

			System.out.println("Fin du main");
		

		} catch (Exception e) {

			al = new Alert(AlertType.ERROR);
			al.setHeaderText("Au traitement ...");
			al.setTitle("Erreur");
			al.setContentText(e.toString());
			al.showAndWait();
		}

	}

	private Mobile traitement() throws Exception {

		for (int generation = 0; generation < 100; generation++) {

			for (int i = 0; i < nbMobiles; i++) {
				pop.deplaceLesMobiles(i);
			}

			Thread.sleep(80);
			
			traceMobiles(pop.getMobiles());
	
			Function<Mobile,Boolean> leScore = m -> m.getScore() > pop.getScoreMoyen();
						
			if (generation != 99) {
				pop = pop.genereParFonction(leScore);
			}
		}

		return pop.getCoordonneesMeilleur();
	}

	private void traceMobiles(List<Mobile> mobiles) {

		Platform.runLater(() -> {
			String texte;
			try {
				texte = pop.getCoordonneesMeilleur().toString();
				ta_affichage.setText(texte);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			double tx = canvas.getWidth() / 100;
			double ty = canvas.getHeight() / 100;
			canvas.getChildren().clear();

			for (Mobile m : mobiles) {
				if (m.getX() > 0 && m.getY() > 0)
					canvas.getChildren().add(new Circle(tx * m.getX(), ty * m.getY(), 5));
			}
		});
	}
}
