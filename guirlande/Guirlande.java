public class Guirlande {
	
	public static void main(String[] args) {
		
		// declaration des donnees
		int nbmotifs, largeur;
		char car;
		
		
		// saisie des donnees
		// saisie nbmotifs
		Ecran.afficher("entrez le nombre de motifs (entier >= 1) : ");
		nbmotifs = Clavier.saisirInt();
		// verification
		while (nbmotifs < 1) {
			// message d'erreur
			Ecran.afficher("Erreur de saisie : entrez un nombre >= 1\n");
			// saisie de la donnee
			Ecran.afficher("entrez le nombre de motifs : ");
			nbmotifs = Clavier.saisirInt();
		}
		
		// saisie largeur
		Ecran.afficher("entrez la largeur (entier >= 3) : ");
		largeur = Clavier.saisirInt();
		// verification
		while (largeur < 3) {
			// message d'erreur
			Ecran.afficher("Erreur de saisie : entrez un nombre >= 3\n");
			// saisie de la donnee
			Ecran.afficher("entrez la largeur : ");
			largeur = Clavier.saisirInt();
		}
		
		// saisie car
		Ecran.afficher("entrez un caractere : ");
		car = Clavier.saisirChar();
		
		// affichage de la guirlande
		afficherGuirlande(nbmotifs, largeur, car);
		
	}
	
	// fonction d'affichage de la guirlande
	private static void afficherGuirlande(int nb, int larg, char car) {
		
		// declaration des compteurs
		int i, j;
		
		// boucle du nombre de motifs
		for (j=1; j<=nb; j+=1) {
			// partie pyramidale
			for (i=1; i<=(larg/2)+1; i+=1) { Ecran.afficher(carToChar(' ', (larg/2)+1-i), carToChar(car, 2*i-1), "\n"); }
			
			// partie pyramidale inversee
			for (i=(larg/2)+1; i>=1; i-=1) { Ecran.afficher(carToChar(' ', (larg/2)+1-i), carToChar(car, 2*i-1), "\n"); }
		}
		
	}
	
	// fonction qui cree depuis un caractere (car) une chaine de n (longueur) fois ce meme caratere
	private static String carToChar(char car, int longueur) {
		// declaration du compteur de la boucle Pour
		int i;
		String chaine = "";
		
		// creation de la chaine
		for (i=1 ; i<=longueur ; i+=1) {
			chaine += car;
		}
		
		// renvois de la chaine
		return chaine;
		
	}
	
}
