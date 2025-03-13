public class Cercle{
	
	public static void main(String args[]){
		
		// declaration des donnees
		String unite;
		double rayon;
		//declaration des resultats
		double perimetre, aire;
		
		// saisie des donnees (supposees justes)
		// saisie de l'unite
		Ecran.afficher("entrez votre unite de mesure : ");
		unite = Clavier.saisirString();
		// saisie du rayon
		rayon = saisieSup(0, "reel");
		
		// calcul des resultats
		perimetre = perimetreCercle(rayon);
		aire = aireCercle(rayon);
		
		// affiche des resultats
		Ecran.afficher("le perimetre est de : ", perimetre, unite, "\n");
		Ecran.afficher("l'aire est de : ", aire, unite, "^2");
		
	}
	
	//~ reel : entier borne_inf
	//~ reel : chaine nom
	public static double saisieSup(double borne_inf, String nom) {
		//~ est retournee : la saisie d'un reel superieur a un autre
		
		//~ declaration du resultat
		double nombre;
		
		//~ saisie du resultat
		Ecran.afficherln("Saisir un nombre ("+ nom+ ") superieur ou egal a : "+ borne_inf);
		nombre = Clavier.saisirDouble();
		//~ verification de la saisie
		while (nombre < borne_inf) {
			//~ message d'erreur
			Ecran.afficherln("Erreur de saisie");
			//~ saisie du resultat
			Ecran.afficherln("Saisir un nombre ("+ nom+ ") superieur ou egal a : "+ borne_inf);
			nombre = Clavier.saisirDouble();
		}
		
		//~ renvois du resultat
		return nombre;
	}
	
	//~ entree : rayon
	public static double perimetreCercle(double rayon) {
		//~ retourne : le perimetre d'un cercle de rayon rayon
		
		//~ declaration de la constante
		final double PI = 3.14;
		
		//~ renvois du resultat (non stocke)
		return 2*PI*rayon;
	}
	
	//~ entree : rayon
	public static double aireCercle(double rayon) {
		//~ retourne : l'aire d'un cercle de rayon rayon
		
		//~ declaration de la constante
		final double PI = 3.14;
		
		//~ renvois du resultat (non stocke)
		return PI*rayon*rayon;
	}
}
