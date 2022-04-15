package chapitre_02_05;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Principale {
	
	static double x = 0.0;
	static double y = 0.0;
	
	public static void main(String[] args) {

		List<Integer> lesMobiles = new ArrayList<Integer>();
		
		for( int i=0; i<10; i++) {
			lesMobiles.add(i);
		}
		
	
		for( int i=0; i<10; i++)
		{
			for( int m=0;m<lesMobiles.size(); m++) {
				bouge(i,m);
			}
		} 
	}

	public static void bouge(int iteration, int mobile) {
		
		
		x = x + random()*2-1;
		y = y + random()*2-1;
		
		System.out.println("pour l'itération "+iteration+ "le mobile "+mobile +" est en ["+x+","+y+"]");
		
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
