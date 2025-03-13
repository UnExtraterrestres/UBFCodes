public class Fibonacci {
	
	public static void main(String[] args) {
		
		// declaration de la constante et des donnees
		final int N = 9;
		int F0 = 0;
		int F1 = 1;
		// declaration du resultat
		int Fn;
		// declaration du compteur
		int i;
		
		// affichage de N, F0 et F1
		Ecran.afficher("N=", N, ", saisie : ", F0, ", ", F1);
		
		// boucle de calcul et d'affichage
		for (i=1; i<=N-2; i+=1) {
			
			// calcul du resultat
			Fn = F0 + F1;
			F0 = F1;
			F1 = Fn;
			
			// affichage du resultat
			Ecran.afficher(", ", Fn);
		}
		
	}
	
}
