public class Joueur {
	
	/**
	* parametres
	*/
	String nom;
	Flotte flotte;
	Grille grille;
	
	int cible;
	
	//~ CONSTRUCTEUR
	public Joueur() {
		/**
		* affectation des parametres
		*/
		this.flotte = new Flotte(this);
		this.grille = new Grille(this);
		this.cible = 9;
	}
	
	/**
	* @param joueur_cible type Joueur est le joueur visee par this
	*/
	public void tir(Joueur joueur_cible) {
		/**
		* @return le joueur tir sur joueur_cible
		*/
		
		/**
		* si un bateau du joueur cible est touche
		*/
		if (joueur_cible.flotte.bateauEstTouche(this.cible)) {
			/**
			* declaration des donnees
			*/
			Bateau bateau = joueur_cible.flotte.bateauTouche(this.cible);
			int x, y;
			
			/**
			* on decremente son etat
			*/
			if (bateau.etat > 0) {
				bateau.etat --;
			}
			
			/**
			* calcul du resultat
			* si son etat est o : on change les touches de la grille par 2
			*/
			if (bateau.etat == 0) {
				//~ affichage du resultat
				/**
				* affichage du resultat
				*/
				Ecran.afficherln("Coule !");
				
				/**
				* on parcours chaque case du bateau
				*/
				for (int j=0; j<bateau.taille; j++) {
					x = Liste.lireEn(bateau.coordonnees, 2*j, 1);
					y = Liste.lireEn(bateau.coordonnees, 2*j+1, 1);
					joueur_cible.grille.changer(y, x, 1);
				}
			/**
			* sinon on change la touche de la grille par 1
			*/
			} else {
				/**
				* affichage du resultat
				*/
				Ecran.afficherln("Touche !");
				
				Ecran.afficherln("modification en ", cible, " de la grille : 1");
				joueur_cible.grille.changer(Liste.lireEn(this.cible, 1, 1), Liste.lireEn(this.cible, 0, 1), 1);
				Ecran.afficherln(joueur_cible.grille.ligneEn(Liste.lireEn(this.cible, 1, 1)));
			}
		/**
		* sinon on change la touche de la grille par 3
		*/
		} else {
			/**
			* affichage du resultat
			*/
			Ecran.afficherln("Rate !");
			
			Ecran.afficherln("modification en ", cible, " de la grille : 3");
			joueur_cible.grille.changer(Liste.lireEn(this.cible, 1, 1), Liste.lireEn(this.cible, 0, 1), 3);
			Ecran.afficherln(joueur_cible.grille.ligneEn(Liste.lireEn(this.cible, 1, 1)));
		}
	}
}
