public class Main {
	
	public static void main(String[] args) {
		/*
		 est saisie : date
		 est affiche : date
		 est calculee : lendemain (date + 1jour)
		 est affichee : lendemain (date)
		 est affichee : la saison de la date
		 est tiree au hasard : une date entre 1950 et 2020 (inclus, prendre en compte les annees bisextiles)
		
		*/
		
		// declaration de la donnee
		Date date;
		
		// saisie de la donnee
		date = saisirDate();
		
		// affichage de la date
		Ecran.afficherln("Saisie :");
		date.afficherDate();
		
		// calcul du resultat (changement de la donnee)
		date.lendemain();
		
		// affichage de la date (changee en lendemain)
		Ecran.afficherln("Lendemain :");
		date.afficherDate();
		
		// affichage de la saison
		Ecran.afficherln("Saison :");
		Ecran.afficherln(date.saison());
		
		// tirage d'une date aleatoire
		Date dateAlea = dateDans(1950, 2020);
		
		// affichage du tirage
		Ecran.afficherln("Tirage :");
		dateAlea.afficherDate();
		
	}
	
	public static Date saisirDate() {
		// est retournee : la saisie d'une date valide
		
		// declaration des donnees
		int annee, mois, jour;
		
		// saisie des donnees
		// est saisie : annee
		annee = saisieSup(0, "annee");
		// est saisie : mois
		mois = saisieDans(1, 12, "mois");
		// est saisie : jour
		if (mois < 8) {
			if (mois == 2) {
				if (Date.estBisextile(annee)) {
					jour = saisieDans(1, 29, "jour");
				} else {
					jour = saisieDans(1, 28, "jour");
				}
			} else if (mois % 2 == 0) {
				jour = saisieDans(1, 30, "jour");
			} else {
				jour = saisieDans(1, 31, "jour");
			}
		} else {
			if (mois % 2 == 0) {
				jour = saisieDans(1, 31, "jour");
			} else {
				jour = saisieDans(1, 30, "jour");
			}
		}
		
		// renvois du resultat (non stocke)
		return new Date(jour, mois, annee);
	}
	
	// entree : entier borneInf
	// entree : chaine nom
	public static int saisieSup(int borneInf, String nom) {
		// est retournee : la saisie d'un entier superieur ou egal a borneInf
		
		// declaration du resultat
		int nb;
		
		// calcul du resultat
		// saisie du resultat
		Ecran.afficher("Saisir un entier (", nom, ") superieur ou egal a ", borneInf, " :");
		nb = Clavier.saisirInt();
		// verification du resultat
		while (nb < borneInf) {
			Ecran.afficherln("Erreur : saisie incorrecte");
			Ecran.afficher("Saisir un entier (", nom, ") superieur ou egal a ", borneInf, " :");
			nb = Clavier.saisirInt();
		}
		
		// renvois du resultat
		return nb;
	}
	
	// entree : entier borneInf
	// entree : entier borneSup
	// entree : chaine nom
	public static int saisieDans(int borneInf, int borneSup, String nom) {
		// est retournee : la saisie d'un entier dans |[borneInf ; borneSup]|
		
		// declaration du resultat
		int nb;
		
		// calcul du resultat
		// saisie du resultat
		Ecran.afficher("Saisir un entier (", nom, ") dans |[", borneInf, ";", borneSup, "]| : ");
		nb = Clavier.saisirInt();
		// verification du resultat
		while (!estDans(nb, borneInf, borneSup)) {
			Ecran.afficherln("Erreur : saisie incorrecte");
			Ecran.afficher("Saisir un entier (", nom, ") dans |[", borneInf, ";", borneSup, "]| : ");
			nb = Clavier.saisirInt();
		}
		
		// renvois du resultat
		return nb;
	}
	
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
	
	// entree : entier b0
	// entree : entier b1
	private static Date dateDans(int b0, int b1) {
		// est retourne : une date choisit aleatoirement dans |[b0;b1]|
		
		// verification des arguments ( b0<b1)
		if (b0>b1) {
			// b1>b2 => on permute b1 et b2
			b0 += b1;
			b1 = b0 - b1;
			b0 = b0 - b1;
		}
		
		// declaration des donnees
		int annee, mois, jour;
		
		// affection des donnees
		// est affectee : annee
		annee = entierDans(b0, b1);
		// est affectee : mois
		mois = entierDans(1, 12);
		// est affectee : jour
		if (mois < 8) {
			if (mois == 2) {
				if (Date.estBisextile(annee)) {
					jour = entierDans(1, 29);
				} else {
					jour = entierDans(1, 28);
				}
			} else if (mois % 2 == 0) {
				jour = entierDans(1, 30);
			} else {
				jour = entierDans(1, 31);
			}
		} else {
			if (mois % 2 == 0) {
				jour = entierDans(1, 31);
			} else {
				jour = entierDans(1, 30);
			}
		}
		
		// revois du resultat (non stocke)
		return new Date(jour, mois, annee);
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
