public class AppPi {
	
	public static void main(String[] args) {
		
		// declaration de la constante et des données
		final double C = 2;
		int nbPointsIn = 0;
		int nbPointsOut = 0;
		int nbPoints;
		// coordonnees du point
		double x, y;
		// declaration du resultat
		double pi;
		
		// saisie du nombre de points a tirer
		nbPoints = saisieStrictPositif();
		
		// calcul du resultat
		// declaration du compteur
		int i;
		for (i=1; i<=nbPoints; i++) {
			// le point tire, est-il dans le cercle ?
			x = hasard(0, C);
			y = hasard(0, C);
			if (C<(Math.sqrt(x*x + y*y))) {
				nbPointsIn ++;
			} else {
				nbPointsOut ++;
			}
		}
		pi = (4.0*nbPointsIn/nbPoints)/C*C;
		
		// affichage du resultat
		Ecran.afficher("pi ~", pi);
		
	}
	
	public static int saisieStrictPositif() {
		// est retourne un nombre entier saisie strictement positif
		int nb;
		
		Ecran.afficher("Saisir un nombre entier strictement positif : ");
		nb = Clavier.saisirInt();
		
		while (nb <= 0) {
			Ecran.afficher("ERREUR de saisie ! \n");
			Ecran.afficher("Saisir un nombre entier strictement positif : ");
			nb=Clavier.saisirInt();
		}
		
		return nb;
	}
	
	private static double hasard(double b1, double b2) {
		
		// verification des arguments ( b1<b2)
		if (b1>b2) {
			// b1>b2 => on permute b1 et b2
			b1 += b2;
			b2 = b1 - b2;
			b1 = b1 - b2;
		}
		
		// retourne un entier dans |[b1 ; b2]|
		return b1 + (Math.random()*(b2 - b1 + 1 ));
		
	}
	
}
