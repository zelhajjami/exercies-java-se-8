package ihm;

import metier.Critere;
import metier.Mobile;

public class CritereDistance implements Critere{

	private double moyenne;
	
	public CritereDistance(double scoreMoyen) {
		this.moyenne = scoreMoyen;
	}
	
	@Override
	public boolean applique(Mobile m) {
		return m.getScore()>=(moyenne/2);
	}

}
