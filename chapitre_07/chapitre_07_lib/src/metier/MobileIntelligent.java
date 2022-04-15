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
		capteurs.setData(0,0,Math.min(100-y,5));
		capteurs.setData(0,1, Math.min(100-x,5));
		capteurs.setData(0,2,Math.min( y,5));
		capteurs.setData(0,3, Math.min(x,5));
		
		Matrice dir=null;
	
		dir = capteurs.multiplie(pilote);
	
	//	System.out.println("delta x = "+dir.getData(0, 0)*cos(dir.getData(0, 1)));
	//	System.out.println("delta y = "+dir.getData(0, 0)*sin(dir.getData(0, 1)));
		
		x = x +dir.getData(0, 0)*cos(dir.getData(0, 1));
		y = y +dir.getData(0, 0)*sin(dir.getData(0, 1));
		
		affiche(iteration);
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n"+pilote.toString();
	}
}
