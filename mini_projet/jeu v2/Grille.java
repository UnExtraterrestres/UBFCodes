public class Grille {
	
	/**
	* parametres
	*/
	Joueur joueur;
	
	final int LONGUEUR;
	final int HAUTEUR;
	
	long touches_0;
	long touches_1;
	long touches_2;
	long touches_3;
	long touches_4;
	long touches_5;
	long touches_6;
	long touches_7;
	long touches_8;
	long touches_9;

	
	//~ CONSTRUCTEUR
	public Grille(Joueur joueur) {
		/**
		* chargement des arguments
		*/
		this.joueur = joueur;
		
		/**
		* affectation des parametres
		*/
		this.LONGUEUR = 9;
		this.HAUTEUR = 9;
		
		this.touches_0 = 44444444444L;
		this.touches_1 = 44444444444L;
		this.touches_2 = 44444444444L;
		this.touches_3 = 44444444444L;
		this.touches_4 = 44444444444L;
		this.touches_5 = 44444444444L;
		this.touches_6 = 44444444444L;
		this.touches_7 = 44444444444L;
		this.touches_8 = 44444444444L;
		this.touches_9 = 44444444444L;
	}
	
	/**
	* @param avec_bateau type booleen qui sert a decider si l'affichage conserne ou non les bateaux
	*/
	public void afficherGrille(boolean avec_bateaux) {
		/**
		* @return affiche la grille de this avec ou sans les bateaux suivant le parametre
		*/
		
		/**
		* affichage du resultat
		*/
		Ecran.afficherln("Grille de tirs : ", this.joueur.nom);
		Ecran.afficherln("   A   B  C  D  E  F  G  H  I  J");
		
		if (avec_bateaux) {
			/**
			* declaration de la donnee
			*/
			int coords;
			
			/**
			* affichage de la grille avec les bateaux
			*/
			for (int y=0; y<=this.HAUTEUR; y++) {
				
				Ecran.afficher(y+1, " ");
				for (int x=this.LONGUEUR; x>=0; x--) {
					coords = 9;
					coords = (int)Liste.ajouter(coords, y);
					coords = (int)Liste.ajouter(coords, x);
					
					if (this.joueur.flotte.bateauEstTouche(coords)) {
						Ecran.afficher(" # ");
					} else {
						Ecran.afficher(" ~ ");
					}
				}
				Ecran.sautDeLigne();
			}
			
		} else {
			/**
			* affichage de la grille sans les bateaux
			*/
			
			/**
			* declaration de la donnee
			*/
			long ligne_courrante = 0L;
			
			for (int y=0; y<=this.HAUTEUR; y++) {
				ligne_courrante = this.ligneEn(y);
				
				Ecran.afficher(y+1, " ");
				for (int x=this.LONGUEUR; x>=0; x--) {
					Ecran.afficher(Testeur.etatEn(ligne_courrante, x));
				}
				Ecran.sautDeLigne();
			}
		}
		Ecran.sautDeLigne();
	}
	
	/**
	* @param index_ligne type entier qui sert a identifier la ligne que l'on veut
	*/
	public long ligneEn(int index_ligne) {
		/**
		* @return retourne la ligne numero : index_ligne de this
		*/
		
		/**
		* declaration du resultat
		*/
		long ligne = this.touches_0;
		
		/**
		* calcul du resultat
		*/
		switch (index_ligne) {
			case 0: {
				ligne = this.touches_0;
			} break;
			case 1: {
				ligne = this.touches_1;
			} break;
			case 2: {
				ligne = this.touches_2;
			} break;
			case 3: {
				ligne = this.touches_3;
			} break;
			case 4: {
				ligne = this.touches_4;
			} break;
			case 5: {
				ligne = this.touches_5;
			} break;
			case 6: {
				ligne = this.touches_6;
			} break;
			case 7: {
				ligne = this.touches_7;
			} break;
			case 8: {
				ligne = this.touches_8;
			} break;
			case 9: {
				ligne = this.touches_9;
			} break;
		}
		
		/**
		* renvois du resultat
		*/
		return ligne;
	}
	
	/**
	* @param index_ligne type entier (meme utilitee que dans la fonction ligneEn precedante)
	* @param index type entier sert a identifier l'index de la valeur voulue dans la ligne, c'est a dire la colonne dans la grille
	* @param nombre type entier c'est le nombre par lequel on souhaite modifier celui en index
	*/
	public void changer(int index_ligne, int index, int nombre) {
		/**
		* @return change la valeur en index de la ligne numero index_ligne, par nombre
		*/
		
		/**
		* calcul du resultat (non stocke)
		*/
		switch (index_ligne) {
			case 0: {
				this.touches_0 = Liste.changer(this.touches_0, index, nombre);
			} break;
			case 1: {
				this.touches_1 = Liste.changer(this.touches_1, index, nombre);
			} break;
			case 2: {
				this.touches_2 = Liste.changer(this.touches_2, index, nombre);
			} break;
			case 3: {
				this.touches_3 = Liste.changer(this.touches_3, index, nombre);
			} break;
			case 4: {
				this.touches_4 = Liste.changer(this.touches_4, index, nombre);
			} break;
			case 5: {
				this.touches_5 = Liste.changer(this.touches_5, index, nombre);
			} break;
			case 6: {
				this.touches_6 = Liste.changer(this.touches_6, index, nombre);
			} break;
			case 7: {
				this.touches_7 = Liste.changer(this.touches_7, index, nombre);
			} break;
			case 8: {
				this.touches_8 = Liste.changer(this.touches_8, index, nombre);
			} break;
			case 9: {
				this.touches_9 = Liste.changer(this.touches_9, index, nombre);
			} break;
		}
	}
}
