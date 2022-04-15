package application;

import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;

public class Principale {

	@FXML
	TextArea ta_affichage;
	
	public void demarrer() {
		Alert al = new Alert(AlertType.INFORMATION);
		al.setHeaderText("Ca va prendre du temps!");
		al.setTitle("Lancement du traitement");
		al.setContentText("On démarre....");
		al.showAndWait();
		
		try {
			String texte = ihm.Principale.traitement();
			ta_affichage.setText(texte);
			
		} catch (Exception e) {
			
			al = new Alert(AlertType.ERROR);
			al.setHeaderText("Au traitement ...");
			al.setTitle("Erreur");
			al.setContentText(e.toString());
			al.showAndWait();
		}
		
	}
}
