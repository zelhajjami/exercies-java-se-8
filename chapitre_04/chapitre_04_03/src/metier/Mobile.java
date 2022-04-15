package metier;

import static java.lang.Math.random;

public abstract class Mobile {

	 double x = 0.0;
	 double y = 0.0;
	 
	 final private String nom;
	
	public Mobile(String nom) {
	
		 this.nom = nom;
		 
	}

	public void bouge(int iteration) throws Exception{
			    
			x = x + random()*2-1;
			y = y + random()*2-1;
			
			affiche(iteration);
		}

	protected void affiche(int iteration) {
		System.out.println("pour l'itération "+iteration+ " le mobile "+nom +" est en ["+x+","+y+"]");
		
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
}
