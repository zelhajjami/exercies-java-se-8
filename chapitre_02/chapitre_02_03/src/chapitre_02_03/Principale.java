package chapitre_02_03;

public class Principale {

	public static void main(String[] args) {
		//byte
		//short
		//int
		//long
		
		//float -> 0.0F
		//double
		
		//boolean
		//char c='c';
		
		String str = "Je suis...";
		
		str = str.trim();
		
		double x = 0.0;
		
		for( int i=0; i<10; i++)
		{
			x = x + 1.0;
		
			System.out.println("x vaut "+x);
			
			if(x>5) {
				x=0;
			}
		} 

	}

}
