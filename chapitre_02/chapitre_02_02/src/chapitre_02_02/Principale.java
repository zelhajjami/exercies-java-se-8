package chapitre_02_02;

public class Principale {

	public static void main(String[] args) {

		int x = 0;
		
		for( int i=0; i<10; i++)
		{
			x = x + 1;
		
			System.out.println("x vaut "+x);
			
			if(x>5) {
				x=0;
			}
		} 

	}

}
