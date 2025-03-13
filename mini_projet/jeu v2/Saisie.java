public class Saisie {
	
	/**
	* @param borne_inf type entier borne inferieure de l'intervalle
	* @param borne_sup type entier borne superieure de l'itervalle
	*/
	public static int dans(int borne_inf, int borne_sup) {
		/**
		* @return retournee : la saisie valide d'un entier dans |[borne_inf; borne_sup]|
		*/
		
		/**
		* declaration du resultat
		*/
		int nombre;
		
		/**
		* saisie du resultat
		*/
		Ecran.afficherln("(un entier dans |[", borne_inf, " ; ", borne_sup, "]|)");
		nombre = Clavier.saisirInt();
		
		/**
		* verification de la saisie
		*/
		while (!Testeur.estDans(nombre, borne_inf, borne_sup)) {
			/**
			* message d'erreur
			*/
			Ecran.afficherln("Erreur de saisie");
			/**
			* saisie du resultat
			*/
			Ecran.afficherln("(un entier dans |[", borne_inf, " ; ", borne_sup, "]|)");
			nombre = Clavier.saisirInt();
		}
		
		/**
		* renvois du resultat
		*/
		return nombre;
	}
	
	public static String chaine() {
		/**
		* @return retourne la saisie d'une chaine de caractere
		*/
		
		/**
		* declaration du resultat
		*/
		String chaine;
		
		/**
		* saisie du resultat
		*/
		chaine = Clavier.saisirString();
		
		/**
		* renvois du resultat
		*/
		return chaine;
	}
	
	/**
	* @param joueur type Joueur joueur conserne par la saisie de l'orientation
	*/
	public static char orientation(Joueur joueur) {
		/**
		* @return retourne la saisie valide de l'orientation : en x ou en y
		*/
		
		/**
		* declaration de la donnee
		*/
		int choix_orientation = 1;
		/**
		* declaration du resultat
		*/
		char orientation = 'x';
		
		/**
		* saisie du resultat
		*/
		if (Testeur.estJoueur(joueur)) {
			/**
			* un joueur doit saisir l'orientation
			*/
			Ecran.afficherln("Saisie de l'orientation");
			Ecran.afficherln("1 : horizontal\n2 : vertical");
			choix_orientation = (int)Saisie.dans(1, 2);				
		} else {
			/**
			* une IA doit generer l'orientation
			*/
			Ecran.afficherln("Generation de l'orientation par l'IA");
			choix_orientation = (int)Generateur.dans(1, 2);
		}
		Ecran.sautDeLigne();
		
		/**
		* calcul du resultat
		*/
		switch (choix_orientation) {
			case 1: {
				/**
				* le choix est horizontal
				*/
				orientation = 'x';
			} break;
			case 2: {
				/**
				* le choix est vertical
				*/
				orientation = 'y';
			} break;
		}
		
		/**
		* renvois du resultat
		*/
		return orientation;
	}
	
	/**
	* @param char_inf type caractere borne inferieure de l'intervalle
	* @param char_sup type caractere borne superieure de l'intervalle
	*/
	public static int abscisse(char char_inf, char char_sup) {
		/**
		* @return retourne la saisie valide d'une abscisse
		*/
		
		/**
		* declaration du resultat
		*/
		int abscisse;
		
		/**
		* saisie du resultat
		*/
		Ecran.afficherln("(un caractere entre ", char_inf, " et ", char_sup, ")");
		abscisse = (int)Clavier.saisirChar();
		Ecran.afficherln(abscisse);
		
		/**
		* verification de la donnee
		*/
		while (!Testeur.estDans(abscisse, (int)char_inf, (int)char_sup)) {
			if (Testeur.estDans(abscisse, (int)char_inf+32, (int)char_sup+32)) {
				abscisse -= 32;
			} else {
				/**
				* message d'erreur
				*/
				Ecran.afficherln("Erreur de saisie");
				abscisse = Saisie.abscisse(char_inf, char_sup);
			}
		}
		
		/**
		* calcul du resultat
		*/
		abscisse -= 65;
		
		/**
		* renvois du resultat (non stocke)
		*/
		return abscisse;
	}
	
	/**
	* @param borne_inf type entier borne inferieure de l'intervalle
	* @param borne_sup type entier borne superieure de l'intervalle
	*/
	public static int ordonnee(int borne_inf, int borne_sup) {
		/**
		* @return retourne la saisie valide d'une ordonnee
		*/
		
		/**
		* renvois du resultat (non stocke)
		*/
		return Saisie.dans(borne_inf+1, borne_sup+1)-1;
	}
	
	/**
	* @param bateau type Bateau est le bateau pour lequel on saisi les coordonnees
	* @param joueur type Joueur est le joueur conserne par la saisie des coordonnees
	*/
	public static void coordonnees(Bateau bateau, Joueur joueur) {
		/**
		* @return change les coordonnees des points du bateau a partir d'une saisie valide
		*/
		
		/**
		* declaration des donnees
		*/
		int x = 0;
		int y = 0;
		long coord_inter;
		int limite_x, limite_y;
		
		/**
		* affectation des donnees
		*/
		limite_x = joueur.grille.LONGUEUR - bateau.taille*Testeur.orienteEn(bateau, 'x');
		limite_y = joueur.grille.HAUTEUR - bateau.taille*Testeur.orienteEn(bateau, 'y');
		/**
		* affectation du resultat
		*/
		bateau.coordonnees = 9;
		
		/**
		* saisie du resultat
		*/
		if (Testeur.estJoueur(joueur)) {
			/**
			* un joueur doit saisir les coordonnees du premier point
			*/
			Ecran.afficherln("Saisir l'abscisse du ",  bateau.nom, " :");
			x = Saisie.abscisse((char)(0+65), (char)(limite_x+65));
			Ecran.afficherln("Saisir l'ordonnee du ",  bateau.nom, " :");
			y = Saisie.ordonnee(0, limite_y);
		} else {
			/**
			* une IA doit generer l'orientation
			*/
			Ecran.afficherln("Generation des coordonnees par l'IA");
			x = Generateur.dans(0, limite_x);
			y = Generateur.dans(0, limite_y);
		}
		Ecran.sautDeLigne();
		/**
		* ajout de la saisie aux coordonnees
		*/
		bateau.coordonnees = Liste.ajouter(bateau.coordonnees, y);
		bateau.coordonnees = Liste.ajouter(bateau.coordonnees, x);
		
		/**
		* calcul du resultat
		*/
		for (int i=1; i<bateau.taille; i++) {
			/**
			* calcul des donnees
			*/
			x = Liste.lireEn(bateau.coordonnees, 2*i-2, 1)+Testeur.orienteEn(bateau, 'x');
			y = Liste.lireEn(bateau.coordonnees, 2*i-1, 1)+Testeur.orienteEn(bateau, 'y');
			/**
			* affectation du resultat
			*/
			coord_inter = 9;
			/**
			* ajouter x et y a des coordonnees intermediaires
			*/
			coord_inter = Liste.ajouter(coord_inter, y);
			coord_inter = Liste.ajouter(coord_inter, x);
			/**
			* ajoute tous les autres points aux coordonnees intermediaires
			*/
			for (int k=Liste.taille(bateau.coordonnees)-2; k>-1; k--) {
				coord_inter = Liste.ajouter(coord_inter, Liste.lireEn(bateau.coordonnees, k, 1));
			}
			
			/**
			* affecte les coordonnees par la valeur des coordonnees intermediaires
			*/
			bateau.coordonnees = coord_inter;
		}
		
		/**
		* verification du resultat
		*/
		while (Testeur.chevauche(bateau, bateau.flotte)) {
			if (Testeur.estJoueur(joueur)) {
				/**
				* message d'erreur
				*/
				Ecran.afficherln("Erreur de saisie");
			}
			Saisie.coordonnees(bateau, joueur);
		}
	}
	
	/**
	* @param joueur type Joueur est le joueur conserne par la saisie de la cible
	*/
	public static void cible(Joueur joueur) {
		/**
		* @return retourne la saisie valide d'une cible par joueur
		*/
		
		Ecran.afficherln(joueur.nom, " saisi sa cible");
		
		/**
		* declaration des donnees
		*/
		int x = 0;
		int y = 0;
		
		/**
		* affectation des donnees
		*/
		if (Testeur.estJoueur(joueur)) {
			/**
			* saisie des donnees par joueur
			*/
			Ecran.afficherln("Saisir l'abscisse de la cible :");
			x = Saisie.abscisse((char)(0+65), (char)(joueur.grille.LONGUEUR+65));
			Ecran.afficherln("Saisir l'ordonnee de la cible :");
			y = Saisie.ordonnee(0, joueur.grille.HAUTEUR);
		} else {
			/**
			* generation des donnees par IA
			*/
			Ecran.afficherln("Generation des coordonnees par l'IA");
			x = Generateur.dans(0, joueur.grille.LONGUEUR);
			y = Generateur.dans(0, joueur.grille.HAUTEUR);
		}
		Ecran.sautDeLigne();
		
		/**
		* affectation du resultat
		*/
		joueur.cible = (int)Liste.ajouter(joueur.cible, y);
		joueur.cible = (int)Liste.ajouter(joueur.cible, x);
		
		/**
		* verification des donnees
		*/
		while (!Testeur.cibleEstValide(joueur)) {
			if (Testeur.estJoueur(joueur)) {
				/**
				* message d'erreur
				*/
				Ecran.afficherln("Erreur de saisie");
			}
			Saisie.cible(joueur);
		}
	}
}
