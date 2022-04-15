package metier;

import java.io.PrintStream;

public class Matrice {

	private double[][] data;
	int lignes;
	int colonnes;
	
	public Matrice(int lignes, int colonnes) {
		this.lignes=lignes;
		this.colonnes=colonnes;
		data = new double[lignes][colonnes];
	}
		
	public double getData(int ligne, int colonne) {
		return data[ligne][colonne];
	}
	
	public void setData(int ligne, int colonne, double valeur) {
		data[ligne][colonne] = valeur;
	}
	
	public Matrice multiplie(Matrice droite) throws Exception {
		
		if(colonnes != droite.lignes) {
			throw new Exception("Les matrices ne sont pas compatibles");
		}
		
		Matrice retval = new Matrice(this.lignes, droite.colonnes);
		for (int l = 0; l<this.lignes; l++) {
			for (int c = 0; c<droite.colonnes; c++) {
				double v=0.0;
				for (int i=0; i<this.colonnes; i++) {
					v += data[l][i]*droite.data[i][c];
				}				
				retval.data[l][c] = v;
			}
		}
		
		return retval;
	}

	public void affiche(PrintStream out) {

		for( int l = 0; l<lignes; l++) {
			for (int c=0; c<colonnes; c++) {
				out.print(data[l][c]+" ");
			}
			out.println();
		}
		
	}

	public void random() {
		for (int l=0; l<lignes; l++) {
			for (int c=0; c<colonnes; c++) {
				data[l][c] = Math.random();
			}
		}
		
	}
}
