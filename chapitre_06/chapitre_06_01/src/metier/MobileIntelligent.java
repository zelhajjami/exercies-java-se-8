package metier;

import static java.lang.Math.random;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class MobileIntelligent extends Mobile{

	private Matrice pilote = new Matrice(4,2);
	
	public MobileIntelligent(String nom) {
		super(nom);
		pilote.random();
	}

	@Override
	public void bouge(int iteration) throws MatriceException {
		
		Matrice capteurs = new Matrice(1,4);
		capteurs.setData(0,0,100-y);
		capteurs.setData(0,1, 100-x);
		capteurs.setData(0,2, y);
		capteurs.setData(0,3, x);
		
		Matrice dir=null;
	
		dir = capteurs.multiplie(pilote);
	
		
		x = x +dir.getData(0, 0)*cos(dir.getData(0, 1));
		y = y +dir.getData(0, 0)*sin(dir.getData(0, 1));
		
		affiche(iteration);
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n"+pilote.toString();
	}
}
