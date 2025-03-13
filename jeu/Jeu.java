public class Jeu {
	
	public static void main(String[] args) {
		
		// declaration de constante
		final int NB_ESSAIS_MAX = 3;
		// declaration du resultat
		boolean gagne;
		
		// Jeu
		char lettre = initJeu(NB_ESSAIS_MAX);	// lettre a deviner
		
		gagne = essais(lettre, NB_ESSAIS_MAX);	// essais
		
		conclureJeu(lettre, gagne);		// affichage final
		
	}
	
	public static void conclureJeu(char caractere, boolean aGagne) {
		
		if (aGagne) {
			// message gagne
			Ecran.afficher("Bravo vous avez trouve la lettre : ", caractere);
		} else {
			// message perdu
			Ecran.afficher("Dommage... la lettre etait : ", caractere);
		}
		
	}
	
	public static boolean essais(char caractere, int maxi) {
		
		// declaration de la donnee
		char essai;
		// declaration du resultat
		boolean score = false;
		
		// boucle d'essais
		// declaration du compteur
		int i;
		for (i=1; i<=maxi; i++) {
			// affichage de l'essai
			Ecran.afficherln("Essai : ", i);
			// saisie de l'essai
			essai = saisirCaractere();
			
			// verification du score
			if (essai == caractere) {
				Ecran.afficherln("lettre trouvee");
				score = true;
			} else if ( (int)essai < (int)caractere ) {
				Ecran.afficherln("plus grand");
			} else {
				Ecran.afficherln("plus petit");
			}
		}
		
		// renvois du resultat
		return score;
		
	}
	
	public static char initJeu(int maxi) {
		
		// affichage des regles
		
		// renvois d'un voyelle choisie aleatoirement
		return (char)hasardIntervalle(97, 122);	// ASCII 97 à 122 a à z
		
	}
	
	public static char saisirCaractere() {
		
		// declaration de la donnee
		char car;
		
		// saisie de la donnee
		Ecran.afficher("entrez une lettre minuscule : ");
		car = Clavier.saisirChar();
		// verifier la saisie
		while ((int)car < 97 && 122 > (int)car) {
			// message d'erreur
			Ecran.afficherln("Erreur de saisie : entrez une lettre minuscule.");
			// saisie de la donnee
			car = Clavier.saisirChar();
		}
		
		return car;
		
	}
	
	public static int hasardIntervalle(int b1, int b2) {
		
		// verification des arguments ( b1<b2)
		if (b1>b2) {
			// b1>b2 => on permute b1 et b2
			b1 += b2;
			b2 = b1 - b2;
			b1 = b1 - b2;
		}
		
		// retourne un entier dans |[b1 ; b2]|
		return b1 + (int)(Math.random()*(b2 - b1 + 1 ));
		
	}
	
}
