package ihm;

import metier.Critere;
import metier.Mobile;

public class CritereSimple implements Critere {

	@Override
	public boolean applique(Mobile m) {
		
		return true;
	}

}
