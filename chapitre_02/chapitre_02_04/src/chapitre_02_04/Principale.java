package chapitre_02_04;

public class Principale {

	public static void main(String[] args) {

		double x = 0.0;
		for( int i=0; i<10; i++)
		{
			x= bouge(i, x);
		} 
	}

	public static double bouge(int iteration, double x) {
		
		
		x = x + 1.0;
		
		System.out.println("pour l'itération "+iteration+ "x vaut "+x);
		
		if(x>5) {
			x=0;
		}
		
		return x;
	}
}
