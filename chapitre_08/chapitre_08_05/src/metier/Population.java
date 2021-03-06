package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public void deplaceLesMobiles(int i) throws MatriceException {
		for(Mobile m : lesMobiles) {
			m.bouge(i);
			m.calculeScore(Critere.getLargeurMax(),Critere.getHauteurMax());
		}
		
	}

	public Population genere(Critere critere) {
		List<Mobile> nouveaux ;/*= new ArrayList<>();
		for (Mobile m : lesMobiles) {
			if (critere.applique(m)) {
				m.resetToOrigin();
				nouveaux.add(m);
			}
		}
		*/
		nouveaux = lesMobiles.stream()
				.filter( m -> critere.applique(m))
				.map( (m) -> {
					m.resetToOrigin();
					return m;
				})
				.collect(Collectors.toList());
	
		
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
				
		
		meilleurScore = lesMobiles.stream()
						.map(m -> m.getScore())
						.reduce(0.0, Math::max);
		
		
		if(meilleurMobile != null) return meilleurMobile;
		else throw new Exception("Pas de meilleur ??");
	}

	public List<Mobile> getMobiles() {
		return lesMobiles;
	}
	
	/*public static double max(double s1,double s2) {
		if(s1 > s2)
			return s1;
		else 
			return s2;
	}*/
}
