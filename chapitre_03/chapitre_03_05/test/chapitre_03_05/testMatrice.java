package chapitre_03_05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import metier.Matrice;

class testMatrice {

	@Test
	void testUnite() {
		
		Matrice m1 = new Matrice(1,4);
		m1.setData(0,0,1);
		
		Matrice m2 = new Matrice(4,2);
		m2.setData(0,0,1);
		
		Matrice m3 = m1.multiplie(m2);
		m3.affiche(System.out);
	}
	@Test
	void testPlein() {
		
		Matrice m1 = new Matrice(1,4);
		m1.setData(0,0,1);
		m1.setData(0,1,1);
		m1.setData(0,2,1);
		m1.setData(0,3,1);
		
		Matrice m2 = new Matrice(4,2);
		m2.setData(0,0,1);
		m2.setData(0,1,1);
		
		Matrice m3 = m1.multiplie(m2);
		m3.affiche(System.out);
	}
}
