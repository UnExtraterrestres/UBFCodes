public class Fleche {
	
	public static void main(String[] args) {
		
		// declaration de la donnee
		int hauteur;
		
		// saisie de la donnee
		Ecran.afficher("entrez la hauteur (entier >= 2) : ");
		hauteur = Clavier.saisirInt();
		// verification
		while (hauteur < 2) {
			// message d'erreur
			Ecran.afficher("Erreur de saisie : entrez un nombre >= 2\n");
			// saisie de la donnee
			Ecran.afficher("entrez la hauteur : ");
			hauteur = Clavier.saisirInt();
		}
		
		// affichage de la fleche
		afficherFleche(hauteur);
		
	}
	
	// fonction d'affichage de la fleche
	private static void afficherFleche(int h) {
		
		// declaration du compteur
		int i;
		
		// partie pyramidale
		for (i=1; i<=h; i+=1) {
			Ecran.afficher(carToChar(' ', h-i), carToChar('*', 2*i-1), "\n");
		}
		// partie rectangulaire
		for (i=1; i<=h; i+=1){
			Ecran.afficher(carToChar(' ', h-1), carToChar('*', 3), "\n");
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
