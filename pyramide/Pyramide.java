public class Pyramide {
	
	public static void main(String[] args) {
		
		// declaration des donnees
		int nbbriques;
		// declaration des resultats
		int hauteur = 0;
		int briquesutils = 0;
		int briquesrest = 0;
		
		// saisie de la donnee
		Ecran.afficher("entrez un entier : ");
		nbbriques = Clavier.saisirInt();
		// verification
		while (nbbriques<0) {
			// message d'erreur
			Ecran.afficherln("Erreur de saisie : l'entier doit être positif");
			// saisie de la donnee
			Ecran.afficher("entrez un entier : ");
			nbbriques = Clavier.saisirInt();
		}
		
		// calcul des resultats
		// calcul de la hauteur et du nombre de briques utilisees
		while (briquesutils + hauteur*hauteur <= nbbriques) {
			// on peut passer a l'etage suivant
			hauteur += 1;
			// le nombre de briques utilisees augmentent du nombre de brique qu'il faut pour un etage
			briquesutils += hauteur*hauteur;
		}
		// calcul du nombre de brique restantes
		briquesrest = nbbriques - briquesutils;
		
		// affichage des resultats
		Ecran.afficherln("Hauteur de la pyramide = ", hauteur);
		Ecran.afficherln("Nombre de briques utilisees = ", briquesutils);
		Ecran.afficherln("Nombre de briques restantes = ", briquesrest);
		
	}
	
	// fonction qui teste si un etage peut etre construit
	private static boolean peutConstruire(int nbbriques, int h) { return nbbriques - h*h >= 0; }
	
}
