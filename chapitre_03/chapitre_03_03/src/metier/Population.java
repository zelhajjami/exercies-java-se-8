package metier;

import java.util.ArrayList;
import java.util.List;

public class Population {

	private List<Mobile> lesMobiles = new ArrayList<Mobile>();
	
	public Population(int nbMobiles) {
		for( int i=0; i<nbMobiles; i++) {
			Mobile m = new Mobile("mobile "+i);
			// m.nom = "mobile "+i;
			
			lesMobiles.add(m);
		}
	}

	public void deplaceLesMobiles(int i) {
		for(Mobile m : lesMobiles) {
			m.bouge(i);
		}
		
	}
}
