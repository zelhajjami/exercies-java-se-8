package ihm;


import metier.Population;


public class Principale {
	
	public static void main(String[] args) {

		System.out.println("population numéro "+Population.getNumero());
		
		Population pop = new Population(50);
		
		for( int generation =0; generation <10; generation++) {
			System.out.println("population numéro "+Population.getNumero());
		
			for( int i=0; i<10; i++)
			{
				pop.deplaceLesMobiles(i);
			} 
			
			pop = pop.genere();
		}
		
	}

	
}
