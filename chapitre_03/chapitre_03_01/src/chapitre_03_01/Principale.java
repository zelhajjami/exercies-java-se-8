package chapitre_03_01;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Principale {
	

	
	public static void main(String[] args) {

		List<Mobile> lesMobiles = new ArrayList<Mobile>();
		
		for( int i=0; i<10; i++) {
			Mobile m = new Mobile();
			m.nom = "mobile "+i;
			lesMobiles.add(m);
		}
		
	
		for( int i=0; i<10; i++)
		{
			for(Mobile m : lesMobiles) {
				m.bouge(i);
			}
		} 
	}

	
}
