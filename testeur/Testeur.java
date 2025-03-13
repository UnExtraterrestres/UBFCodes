public class Testeur {
	
	public static void main(String[] args) {
		
		// declaration de la donnee
		int donnee;
		
		// saisie de la donnee
		donnee = saisieStrictPositif();
		
		// affichage de la donnee
		Ecran.afficher(donnee);
		
	}
	
	public static int saisieStrictPositif() {
		// est retourne un nombre entier saisie strictement positif
		int nb;
		
		Ecran.afficher("Saisir un nombre entier strictement positif pair : ");
		nb = Clavier.saisirInt();
		
		while (nb <= 0 || !estPaire(nb)) {
			Ecran.afficher("ERREUR de saisie ! \n");
			Ecran.afficher("Saisir un nombre entier strictement positif pair : ");
			nb=Clavier.saisirInt();
		}
		
		return nb;
	}
	
	// fonction qui teste la parite
	public static boolean estPaire(int nb) {
		// retourne true si pair, false sinon
		if (nb % 2 == 0) { return true; } else { return false; }
		
	}
	
}
