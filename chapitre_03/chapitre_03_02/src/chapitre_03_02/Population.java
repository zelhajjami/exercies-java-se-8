package chapitre_03_02;

import java.util.ArrayList;
import java.util.List;

public class Population {

	List<Mobile> lesMobiles = new ArrayList<Mobile>();
	
	Population(int nbMobiles) {
		for( int i=0; i<nbMobiles; i++) {
			Mobile m = new Mobile();
			m.nom = "mobile "+i;
			lesMobiles.add(m);
		}
	}

	void deplaceLesMobiles(int i) {
		for(Mobile m : lesMobiles) {
			m.bouge(i);
		}
		
	}
}
