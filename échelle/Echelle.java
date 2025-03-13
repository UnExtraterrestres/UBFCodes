public class Echelle{
	
	public static void main(String args[]){
		
		// declaration de la constantes et des donnees
		// N la largeur des echelons
		final int N = 10;
		final char C = '-';
		// H le nombre d'echelons, i : compteur pour boucle for
		int H, i;
		// declaration du resultat
		String echelon = "";

		// saisie des donnees
		// saisie de H (entier <0)
		Ecran.afficher("entrez le nombre d'echelons : ");
		H = Clavier.saisirInt();
		
		// calcul du resultat
		echelon = creerChaineDepuisCar(C, N);
		
		// affichage de l'echelle
		// boucle du nombre d'echelons
		for (i = 1 ; i <= H ; i += 1) {
			Ecran.afficher("|" + echelon + "|\n");
		}
		
	}
	
	// fonction qui cree depuis un caractere (car) une chaine de n (longueur) fois ce meme caratere
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
}
