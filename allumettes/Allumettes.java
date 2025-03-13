public class Allumettes{
	
	// fonction tour qui joue un tour du jeu
	private static int tour(String joueur, int nbAll) {
		// declaration de la donnee
		int choixAll = 0;
		
		// saisie du nombre d'allumettes
		while ((choixAll < 1 || 3 < choixAll) || (nbAll - choixAll < 1)) {
			Ecran.afficher(joueur, " combien d'allumettes ?\n");
			choixAll = Clavier.saisirInt();
		}
		
		// retire le nombre d'allumette saisies
		nbAll -= choixAll;
		
		// retourne le tour et le nombre d'allumettes
		return nbAll;
		
	}
	
	// fonction qui cree depuis un caractere une chaine de n fois ce meme caratere
	private static String creerChaineDepuisCar(char car, int longueur) {
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
	
	public static void main(String args[]){
		
		// declaration de la condition de jeu
		boolean isRunning = true;
		int choixJeu = 2;
		
		// boucle de jeu
		while (isRunning) {
			
			// Initialisation
			// declaration des donnees
			// relatives au jeu
			int nbAllumettes = 17;
			int auTourDe;
			// relatives aux joueurs
			String[] nomsJoueurs = {"", ""};
			
			// saisie des donnees
			// nom du joueur1
			Ecran.afficher("J1, entrez votre nom : ");
			nomsJoueurs[0] = Clavier.saisirString();
			// nom du joueur2
			Ecran.afficher("J2, entrez votre nom : ");
			nomsJoueurs[1] = Clavier.saisirString();
			
			// on calcul le premier tour (de maniere aleatoire entre 1 et 2)
			auTourDe = 0 + (int)(Math.random()*(2 - 0));
			
			// logique du jeu
			while (nbAllumettes > 1) {
				
				// affichage des allumettes
				Ecran.afficher(creerChaineDepuisCar('|', nbAllumettes), "\n");
				
				// calcul le nombre d'allumettes
				nbAllumettes = tour(nomsJoueurs[auTourDe], nbAllumettes);
				//change de tour
				auTourDe = 1 - auTourDe;
				
			}
			
			// affichage des allumettes
			Ecran.afficher(creerChaineDepuisCar('|', nbAllumettes), "\n");
			// affichage du resultat
			Ecran.afficher("Bravo ", nomsJoueurs[1 - auTourDe], " vous avez gagne !\n");
			Ecran.afficher("Dommage ", nomsJoueurs[auTourDe], " vous avez perdu !\n");
			
			// saisie de la relance de la partie
			//~ while ((choixJeu == 1 && choixJeu != 0) or (choixJeu != 1 and choixJeu == 0)) {
				Ecran.afficher("voulez vous rejouer ? oui: 1, non:0 \n");
				choixJeu = Clavier.saisirInt();
			}
			
			// on arrete seulement si choixJeu == 0 sinon on continue
			if (choixJeu == 0) {
				isRunning = false;
			}
			
		}
		
	}
}
