package metier;

import java.util.ArrayList;
import java.util.List;

public class Population {

	private List<Mobile> lesMobiles = new ArrayList<Mobile>();
	
	private static int numero;
	
	public static int getNumero() {
		return numero;
	}
	
	public Population(int nbMobiles) {
		
		numero++;
		
		for( int i=0; i<nbMobiles; i++) {
			Mobile m = new MobileIntelligent("mobile "+i);
			lesMobiles.add(m);
		}
	}

	public Population(List<Mobile> lesMobiles2) {
		lesMobiles = lesMobiles2;
		numero++;
	}

	public void deplaceLesMobiles(int i) throws MatriceException {
		for(Mobile m : lesMobiles) {
			m.bouge(i);
		}
		
	}

	public Population genere(Critere critere) {
		List<Mobile> nouveaux = new ArrayList<>();
		for (Mobile m : lesMobiles) {
			if (critere.applique(m)) {
				nouveaux.add(m);
			}
		}
		
		int debut=nouveaux.size();
		for (int i=debut; i<lesMobiles.size(); i++) {
			nouveaux.add(new MobileIntelligent(" mobile "+i));
		}
		
		return new Population(nouveaux);
	}
}
