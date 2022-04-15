package metier;

public interface Critere {
	boolean applique(Mobile m);
	
	static double getLargeurMax() {
		return 100.0;
	}
	
	static double getHauteurMax() {
		return 100.0;
	}
	
	default String getName() {
		return "Critere";
	}
}
