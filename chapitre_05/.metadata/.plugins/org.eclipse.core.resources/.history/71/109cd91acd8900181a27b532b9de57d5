package metier;

import static java.lang.Math.random;

public abstract class Mobile {

	 double x = 0.0;
	 double y = 0.0;
	 
	 final private String nom;
	 private double score;
	
	public Mobile(String nom) {
	
		 this.nom = nom;
		 
	}

	public void bouge(int iteration) throws MatriceException{
			    
			x = x + random()*2-1;
			y = y + random()*2-1;
			
			affiche(iteration);
		}

	protected void affiche(int iteration) {
		//System.out.println("pour l'itération "+iteration+ " le mobile "+nom +" est en ["+x+","+y+"]");
		
		if(x>100) {
			x=100;
		}
		if(x<0) {
			x=0;
		}
		if(y>100) {
			y=100;
		}
		if(y<0) {
			y=0;
		}
		
	}

	public void calculeScore(double x_cible, double y_cible) {
		this.score = 20000.0/((x_cible-x)*(x_cible-x)+(y_cible-y)*(y_cible-y)); 
	}

	public double getScore() {
		if(Double.isFinite(score))
			return score;
		else 
			return 0;
	}
	
	@Override
	public String toString() {
		return String.format("[ %f.2 , %f.2 ]", x, y);
	}
}
