package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Population implements Serializable{

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

	public synchronized void deplaceLesMobiles(int i) throws MatriceException {
		for(Mobile m : lesMobiles) {
			m.bouge(i);
			m.calculeScore(100,100);
		}
		
	}

	public Population genere(Critere critere) {
		List<Mobile> nouveaux = new ArrayList<>();
		for (Mobile m : lesMobiles) {
			if (critere.applique(m)) {
				m.resetToOrigin();
				nouveaux.add(m);
			}
		}
		
		//System.out.println("Nombre de mobiles conservés : "+nouveaux.size());
	
		int debut=nouveaux.size();
		for (int i=debut; i<lesMobiles.size(); i++) {
			nouveaux.add(new MobileIntelligent(" mobile "+i));
		}
		
		return new Population(nouveaux);
	}

	public double getScoreMoyen() {
		double retval = 0;
		for (Mobile m : lesMobiles) {
			retval += m.getScore();
		}
		return retval/lesMobiles.size();
	}

	public Mobile getCoordonneesMeilleur() throws Exception {
		double meilleurScore = 0;
		Mobile meilleurMobile = null;
		for (Mobile m : lesMobiles) {
			if(meilleurScore < m.getScore()) {
				meilleurScore = m.getScore();
				meilleurMobile = m;
			}
		}
		
		if(meilleurMobile != null) return meilleurMobile;
		else throw new Exception("Pas de meilleur ??");
	}

	public synchronized List<Mobile> getMobiles() {
		return lesMobiles;
	}
}
