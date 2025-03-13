public class Perimetre{
	
	public static void main(String args[]){
		
		// declaration des donnees
		String unite;
		double largeur = 0;
		double longueur = 0;
		// declaration du resultat
		double perimetre;
		
		// saisie des donnees
		// saisie de l'unite
		Ecran.afficher("entrez l'unite de mesure : ");
		unite = Clavier.saisirString();
		// saisie de la largeur (reel > 0)
		while (largeur <= 0) {
			Ecran.afficher("entrez la largeur : ");
			largeur = Clavier.saisirDouble();
		}
		// saisie de la largeur (reel > 0)
		while (longueur <= 0) {
			Ecran.afficher("entrez la longueur : ");
			longueur = Clavier.saisirDouble();
		}
		
		// calcul du resultat
		perimetre = 2*(largeur+longueur);
		
		// affichage du resultat
		Ecran.afficher("perimetre = ", perimetre, unite);
		
	}
}
