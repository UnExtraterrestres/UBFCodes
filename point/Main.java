public class Main {
	
	public static void main(String[] args) {
		/*
		PARTIE I
		Dans un ecran de resolution (SVGAX, SVGAY),
		est saisi : un point,
		est tire aleatoirement : un point different de celui saisi,
		est affichee : la distance entre ces deux points.
		
		PARTIE II
		est saisi : un cercle
		est tire : un point
		sont affichee : les coordonnees du point
		est affichee : la position relative du point par rapport au cercle
		
		PARTIE III
		sont affichees : les coordonnees du point de la partie I, et la resolution SVGA partie I
		est saisi : un sens de deplacement
		est deplace : le point
		sont affichees : les nouvelles coordonnes si le deplacement est possible, un message d'erreur sinon
		*/
		
		// PARTIE I
		
		// declaration des donnees
		// resolution ecran SVGA
		int SVGAX = 800;
		int SVGAY = 600;
		
		// declaration des resultats
		Point point0;
		Point point_tire;
		
		// affectation des resultats
		point0 = saisiePointDans(SVGAX, SVGAY);
		point_tire = pointDansSauf(SVGAX, SVGAY, point0);
		
		// affichage du resultat
		Ecran.afficherln("Partie I : distance entre deux points");
		
		Ecran.afficherln("Saisie :");
		Ecran.afficherln(point0.afficherCoord());
		Ecran.afficherln("Tirage :");
		Ecran.afficherln(point_tire.afficherCoord());
		Ecran.afficherln("La distance est de :", point0.distantDe(point_tire), " pixel(s)");
		
		// PARTIE II
		
		// declaration des donnees
		Cercle cercle;
		Point point_tire2;
		
		// saisie des donnees
		// est saisi : cercle
		cercle = saisieCercle();
		// est saisie : point_tire2
		point_tire2 = pointDans((int)cercle.getRayon(), (int)cercle.getRayon());
		
		// affichage des resultats
		Ecran.afficherln("Partie II : position relative d'un point par rapport a un cercle");
		
		// sont affiches : les parametres du cercle
		Ecran.afficherln("Cercle :");
		Ecran.afficherln(cercle.afficherParam());
		// sont affichees : les coordonnees de point_tire2
		Ecran.afficherln("Nouveau tirage :");
		Ecran.afficherln(point_tire2.afficherCoord());
		// est affichee : la position relative de point par rapport a cercle
		Ecran.afficherln("Position relative du point par rapport au cercle :");
		cercle.posRelativeA(point_tire2);
		
		// PARTIE III
		// declaration de la donnee
		char sens;
		
		// saisie de la donnee
		Ecran.afficherln("Entrez le sens de deplacement : n pour Nord, s pour Sud...");
		sens = saisieCarDans("nsoe");
		
		// calcul du resultat
		point0.deplacerVers(sens, SVGAX, SVGAY);
		
	}
	
	// SAISIES
	
	// entree : String car_valides
	public static char saisieCarDans(String car_valides) {
		// est retourne : la saisie d'un caractere parmis car_valides
		
		// declaration de la donnee
		char car;
		
		// saisie de la donnee
		Ecran.afficher("entrez une lettre dans",  car_valides, " : ");
		car = Clavier.saisirChar();
		// verifier la saisie
		while (car_valides.indexOf(car) == -1) {
			// message d'erreur
			Ecran.afficherln("Erreur de saisie : caractere invalide");
			// saisie de la donnee
			Ecran.afficher("entrez une lettre dans",  car_valides, " : ");
			car = Clavier.saisirChar();
		}
		
		return car;
		
	}
	
	public static Cercle saisieCercle() {
		// est retourne : la saisie d'un cercle
		
		// declaration des donnees
		Point origine;
		double rayon;
		
		// saisie des donnees
		// est saisi : origine
		Ecran.afficherln("Saisie de l'origine du cercle :");
		origine = saisiePoint();
		// est saisi : rayon
		Ecran.afficherln("Saisie du rayon du cercle :");
		rayon = saisieSup(0.0, "rayon");
		
		return new Cercle(origine, rayon);
		
	}
	
	public static Point saisiePoint() {
		// est retourne : la saisie d'un point
		
		// declaration des donnees
		int abscisse, ordonnee;
		
		// saisie des donnees
		// est saisie : abscisse
		abscisse = (int)saisieSup(0.0, "abscisse");
		// est saisie : ordonnee
		ordonnee = (int)saisieSup(0.0, "ordonnee");
		
		// renvois du resultat (non stocke)
		return new Point(abscisse, ordonnee);
	}
	
	// entree : entier larg_ecran
	// entree : entier haut_ecran
	public static Point saisiePointDans(int larg_ecran, int haut_ecran) {
		// est retourne : la saisie d'un point compris dans la resolution d'un ecran
		
		// declaration des donnees
		int abscisse, ordonnee;
		
		// saisie des donnees
		// est saisie : abscisse
		abscisse = saisieDans(0, larg_ecran-1);
		// est saisie : ordonnee
		ordonnee = saisieDans(0, haut_ecran);
		
		// renvois du resultat (non stocke)
		return new Point(abscisse, ordonnee);
	}
	
	// entree : reel borneInf
	// entree : String nom
	public static double saisieSup(double borneInf, String nom) {
		// est retournee : la saisie d'un reel superieur ou egal a borneInf
		
		// declaration du resultat
		double nb;
		
		// calcul du resultat
		// saisie du resultat
		Ecran.afficher("Saisir un reel (",  nom, ")superieur ou egal a ", borneInf, " :");
		nb = Clavier.saisirDouble();
		// verification du resultat
		while (nb < borneInf) {
			Ecran.afficherln("Erreur : saisie incorrecte");
			Ecran.afficher("Saisir un reel (",  nom, ")superieur ou egal a ", borneInf, " :");
			nb = Clavier.saisirDouble();
		}
		
		// renvois du resultat
		return nb;
	}
	
	// entree : entier borneInf
	// entree : entier borneSup
	public static int saisieDans(int borneInf, int borneSup) {
		// est retournee : la saisie d'un entier dans |[borneInf ; borneSup]|
		
		// declaration du resultat
		int nb;
		
		// calcul du resultat
		// saisie du resultat
		Ecran.afficher("Saisir un entier dans |[", borneInf, ";", borneSup, "]| : ");
		nb = Clavier.saisirInt();
		// verification du resultat
		while (!estDans(nb, borneInf, borneSup)) {
			Ecran.afficherln("Erreur : saisie incorrecte");
			Ecran.afficher("Saisir un entier dans |[", borneInf, ";", borneSup, "]| : ");
			nb = Clavier.saisirInt();
		}
		
		// renvois du resultat
		return nb;
	}
	
	// TESTS
	
	// entree : entier nombre
	// entree : entier b0
	// entree : entier b1
	public static boolean estDans(int nombre, int b0, int b1) {
		// est retourne : vrai si nombre appartient a [b0 ; b1], faux sinon
		
		// verification des arguments (b0 < b1)
		if (b0 > b1) {
			// permutation
			b0 += b1;
			b1 = b0 - b1;
			b0 = b0 - b1;
		}
		
		// renvois du resultat (non stocke)
		if (b0 <= nombre && nombre <= b1) {return true;} else {return false;}
	}
	
	// TIRAGES
	
	// entree : entier larg_ecran
	// entree : entier haut_ecran
	private static Point pointDans(int larg_ecran, int haut_ecran) {
		// est retourne :	un point choisit aleatoirement compris dans la resolution d'un ecran
		
		// renvois du resultat (non stocke)
		return new Point(entierDans(0, larg_ecran-1), entierDans(0, haut_ecran-1));
	}
	
	// entree : entier larg_ecran
	// entree : entier haut_ecran
	// entree : Point point_exclu
	private static Point pointDansSauf(int larg_ecran, int haut_ecran, Point point_exclu) {
		// est retourne :	un point choisit aleatoirement 
		// 			compris dans la resolution d'un ecran, different d'un autre point
		
		// declaration du resultat
		Point point;
		
		// calcul du resultat
		do {
			point = pointDans(larg_ecran, haut_ecran);
		} while (point.getX() == point_exclu.getX() && point.getY() == point_exclu.getY());
		
		// renvois du resultat
		return point;
	}
	
	// entree : entier b0
	// entree : entier b1
	private static int entierDans(int b0, int b1) {
		// est retourne : un entier choisit aleatoirement dans |[b0;b1]|
		
		// verification des arguments ( b0<b1)
		if (b0>b1) {
			// b1>b2 => on permute b1 et b2
			b0 += b1;
			b1 = b0 - b1;
			b0 = b0 - b1;
		}
		
		// retourne un entier dans |[b0 ; b1]|
		return b0 + (int)(Math.random()*(b1 - b0 + 1 ));
		
	}
	
}
