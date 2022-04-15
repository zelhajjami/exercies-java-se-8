package metier;

import static java.lang.Math.random;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class MobileIntelligent extends Mobile{

	private Matrice pilote = new Matrice(4,2);
	
	public MobileIntelligent(String nom) {
		super(nom);
	}

	@Override
	public void bouge(int iteration) {
		
		Matrice capteurs = new Matrice(1,4);
		capteurs.setData(0,0, Math.random());
		capteurs.setData(0,1, Math.random());
		capteurs.setData(0,2, Math.random());
		capteurs.setData(0,3, Math.random());
		
		Matrice dir = capteurs.multiplie(pilote);
		
		x = x +dir.getData(0, 0)*cos(dir.getData(0, 1));
		y = y +dir.getData(0, 0)*sin(dir.getData(0, 1));
	}
}
