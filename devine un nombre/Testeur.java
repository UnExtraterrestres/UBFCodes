public class Testeur {
	
	//~ Classe contenant les fonctions fondamentales de tests
	
	//~ entree : reel nombre
	//~ entree : reel borne_inf
	//~ entree : reel borne_sup
	public static boolean estDans(double nombre, double borne_inf ,double borne_sup) {
		//~ est retourne : vrai si nombre est dans [borne_inf ; borne_sup]
		
		//~ verification des arguments
		if (borne_inf > borne_sup) {
			//~ permutation
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		//~ renvois du resultat (non stocke)
		return borne_inf <= nombre && nombre <= borne_sup;
	}
	
	//~ entree : entier dividende
	//~ entree : entier diviseur
	public static boolean estMultiple(int dividende, int diviseur) {
		//~ est retourne : vrai si le reste est nul, faux sinon
		
		//~ renvois du resultat (non stocke)
		return dividende % diviseur == 0;
	}
	
	//~ entree : entier annee
	public static boolean estBisextile(int annee) {
		//~ est retourne : vrai si annee est bisextile, faux sinon
		
		//~ declaration du resultat
		boolean bisextile = false;
		
		//~ calcul du resultat
		if (estMultiple(annee, 4) && !estMultiple(annee, 100) || estMultiple(annee, 400)) {
			bisextile = true;
		}
		
		//~ renvois du resultat
		return bisextile;
		
	}
	
}
