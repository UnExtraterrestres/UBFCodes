public class Multiple{
	
	public static void main(String args[]){
		
		// declaration des donnees
		int a = 0;
		int b = 0;
		// declaration du resultat
		boolean estMultiple;
		
		// saisie des donnees
		// saisie de a (entier > 0)
		while (a <= 0) {
			Ecran.afficher("entrez a un entier strictement positif : ");
			a = Clavier.saisirInt();
		}
		// saisie de b (entier > 0)
		while (b <= 0) {
			Ecran.afficher("entrez b le modulo, un entier strictement positif : ");
			b = Clavier.saisirInt();
		}
		// si a > b l'opperation b % a n'est pas possible
		if (a > b) {
			// permutation de a avec b
			a += b;
			b = b - a;
			a = b - a;
		}
		
		// calcul des resultats
		if (b % a == 0) {
			estMultiple = true;
		} else {
			estMultiple = false;
		}
		
		// affichage du resultat
		if (estMultiple) {
			Ecran.afficher(b, " est multiple de ", a);
		} else {
			Ecran.afficher(b, " n'est pas multiple de ", a);
		}
		
	}
}
