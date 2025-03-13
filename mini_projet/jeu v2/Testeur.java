public class Testeur {
	
	/**
	* @param nombre type entier nombre conserne
	* @param borne_inf type entier borne inferieure de l'intervalle
	* @param borne_sup type entier borne superieure de l'intervalle
	*/
	public static boolean estDans(int nombre, int borne_inf, int borne_sup) {
		/**
		* @return retourne : vrai si nombre est dans |[borne_inf ; borne_sup]|, faux sinon
		*/
		
		/**
		* verification des bornes de l'intervalle
		*/
		if (borne_inf > borne_sup) {
			/**
			* permutation
			*/
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		/**
		* renvois du resultat (non stocke)
		*/
		return borne_inf <= nombre && nombre <= borne_sup;
	}
	
	/**
	* @param joueur type Joueur est le joueur concerne par la verification de son nom
	*/
	public static boolean estJoueur(Joueur joueur) {
		/**
		* @return retourne vrai si joueur.nom n'est pas IA
		*/
		
		/**
		* renvois du resultat (non stocke)
		*/
		return joueur.nom != "IA";
	}
	
	/**
	* @param bateau type Bateau bateau dont on veut verifier l'axe
	* @param axe type caractere axe d'orientation suppose
	*/
	public static int orienteEn(Bateau bateau, char axe) {
		/**
		* @return retourne : 1 si bateau est oriente en axe, 0 sinon
		*/
		
		/**
		* renvois du resultat (non stocke)
		*/
		if (bateau.orientation == axe) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	* @param bateau type Bateau bateau dont on verifie le chevauchement sur un autre
	* @param flotte type Flotte flotte de bateau
	*/
	public static boolean chevauche(Bateau bateau, Flotte flotte) {
		/**
		* @return retourne vrai si bateau chevauche un autre bateau de flotte, faux sinon
		*/
		
		/**
		* declaration du resultat
		*/
		boolean chevauche = false;
		
		/**
		* calcul du resultat
		*/
		switch (bateau.nom) {
			case "torpilleur": {
				/**
				* pour le torpilleur rien a verifier
				*/
			} break;
			case "sous-marin 1": {
				/**
				* verifier pour tout les bateaux poses avant
				* torpilleur
				*/
				chevauche = Testeur.estSur(bateau, flotte.torpilleur);
			} break;
			case "sous-marin 2": {
				/**
				* verifier pour tout les bateaux poses avant
				* torpilleur, sous-marin 1
				*/
				chevauche = Testeur.estSur(bateau, flotte.torpilleur) || Testeur.estSur(bateau, flotte.sous_marin_1);
			} break;
			case "croiseur": {
				/**
				* verifier pour tout les bateaux poses avant
				* torpilleur, sous-marin 1, sous-marin 2
				*/
				chevauche = Testeur.estSur(bateau, flotte.torpilleur) || Testeur.estSur(bateau, flotte.sous_marin_1)
						|| Testeur.estSur(bateau, flotte.sous_marin_2);
			} break;
			case "porte-avion": {
				/**
				* verifier pour tout les bateaux poses avant
				* torpilleur, sous-marin 1, sous-marin 2, croiseur
				*/
				chevauche = Testeur.estSur(bateau, flotte.torpilleur) || Testeur.estSur(bateau, flotte.sous_marin_1)
						|| Testeur.estSur(bateau, flotte.sous_marin_2) || Testeur.estSur(bateau, flotte.croiseur);
			} break;
			default: {
				/**
				* message d'erreur
				*/
				Ecran.afficherln("Erreur : ", bateau.nom, " n'existe pas");
			} break;
		}
		
		/**
		* renvois du resultat
		*/
		return chevauche;
	}
	
	/**
	* @param petit_bateau type Bateau ne nous demandez pas pourquoi on l'a nomme petit bateau (on en sait rien)
	* @param grand_bateau type Bateau la il peut pas etre petit sinon ce serai les memes... XD
	*/
	public static boolean estSur(Bateau petit_bateau, Bateau grand_bateau) {
		/**
		* @return retourne : vrai si petit bateau chevauche grand bateau
		*/
		
		/**
		* declaration des donnees
		*/
		int petit_yx;
		int grand_yx;
		/**
		* declaration du resultat
		*/
		boolean est_sur = false;
		
		/**
		* calcul du resultat
		* premiere boucle : on parcours chaque case du petit bateau
		*/
		for (int i=0; i<petit_bateau.taille; i++) {
			/**
			* affectation du petit_yx
			*/
			petit_yx = (int)Liste.ajouter(Liste.lireEn(petit_bateau.coordonnees, 1, 1)+i*Testeur.orienteEn(petit_bateau, 'y'),
						Liste.lireEn(petit_bateau.coordonnees, 0, 1)+i*Testeur.orienteEn(petit_bateau, 'x'));
			
			/**
			* seconde boucle : on parcours chaque case du grand bateau
			*/
			for (int j=0; j<grand_bateau.taille; j++) {
				/**
				* si yx est egal a une coordonnee du grand bateau : est_sur <-- vrai
				* affectation du grand yx
				*/
				grand_yx = Liste.lireEn(grand_bateau.coordonnees, 2*j, 2);
				/**
				* verification de la condition : a changer seulement si vrai
				*/
				if (petit_yx == grand_yx) {
					est_sur = true;
				}
			}
		}
		
		/**
		* renvois du resultat
		*/
		return est_sur;
	}
	
	/**
	* @param racine type entier racine dont on veut extraire l'etat
	*/
	public static String etatEn(long racine, int index) {
		/**
		* @return retourne : ! si la case est touchee, # coulee, o a l'eau, ~ il ne s'est rien passe, e erreur
		*/
		
		/**
		* declaration du resultat
		*/
		String etat = " ~ ";
		
		/**
		* calcul du resultat
		*/
		switch (Liste.lireEn(racine, index, 1)) {
			case 1: {
				etat =  " ! ";
			} break;
			case 2: {
				etat = " # ";
			} break;
			case 3: {
				etat = " o ";
			} break;
			case 4: {
				etat = " ~ ";
			} break;
			default: {
				etat = " e ";
			}
		}
		
		/**
		* renvois du resultat
		*/
		return etat;
	}
	
	/**
	* @param joueur type Joueur joueur conserne par la verification de sa cible
	*/
	public static boolean cibleEstValide(Joueur joueur) {
		/**
		* @return retourne vrai si la cible n'a pas encore ete visee, faux sinon
		*/
		
		/**
		* declaration de la donnee
		*/
		long ligne_courrante = joueur.grille.touches_0;
		/**
		* declaration du resultat
		*/
		boolean est_valide = true;
		
		/**
		* calcul du resultat
		*/
		for (int y=0; y<=joueur.grille.HAUTEUR; y++) {
			ligne_courrante = joueur.grille.ligneEn(y);
			for (int x=joueur.grille.LONGUEUR; x>=0; x--) {
				if (Testeur.etatEn(ligne_courrante, x) != " ~ ") {
					est_valide = false;
				}
			}
		}
		
		/**
		* renvois du resultat
		*/
		return est_valide;
	}
	
	/**
	* flotte type Flotte flotte dont on veut verifier l'etat des bateaux
	*/
	public static boolean estDetruite(Flotte flotte) {
		/**
		* @return retourne : vrai si la flotte est detruite, faux sinon
		*/
		
		/**
		* renvois du resultat (non stocke)
		*/
		return flotte.torpilleur.etat + flotte.sous_marin_1.etat + flotte.sous_marin_2.etat +
				flotte.croiseur.etat + flotte.porte_avion.etat == 0;
	}
	
	/**
	* @param bateau type Bateau bateau potentiellement visee par cible
	* @param cible entier stocke les coordonnees de la cible
	*/
	public static boolean estTouche(Bateau bateau, int cible) {
		/**
		* @return retourne : vrai si la cible touche le bateau, faux sinon
		*/
		
		/**
		* declaration du resultat
		*/
		boolean est_touche = false;
		
		/**
		* calcul du resultat
		* on parcours chaque case du bateau
		*/
		for (int j=0; j<bateau.taille; j++) {
			/**
			* si cible est egal a une coordonnee du bateau : est_touche <-- vrai
			*/
			if (Liste.lireEn(cible, 0, 2) ==  Liste.lireEn(bateau.coordonnees, 2*j, 2)) {
				est_touche = true;
			}
		}
		
		/**
		* renvois du resultat
		*/
		return est_touche;
	}
}
