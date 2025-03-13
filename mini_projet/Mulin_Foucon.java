/**
* Binome :<br>
* Foucon Willfrid et Mulin Michael
*
* Groupe de TP :<br>
* I2
*/

/**
* Main --> BatailleNavale
* Un jeu de Bataille Navale pour 1 ou 2 joueur(s)
*/
class Mulin_Foucon {
	
	public static void main(String[] args) {
		/**
		* declaration du jeu
		*/
		Jeu jeu = new Jeu();
		
		/**
		* lancement du jeu
		*/
		jeu.run();
	}
	
}

/**
* Jeu
* Type agrege correspondant au corps du jeu en lui-meme
*/
public class Jeu {
	
	/**
	* parametres
	*/
	boolean jeu_tourne;
	String scene_courrante;
	Menu menu;
	Niveau niveau;
	TableDeScore table_score;
	
	public Jeu() {
		/**
		* affectation des parametres
		*/
		this.jeu_tourne = true;
		this.scene_courrante = "menu";
		this.menu = new Menu(this);
	}
	
	public void run() {
		/**
		* @return appelle les methodes propres a la boucle du jeu
		*/
		
		/**
		* boucle du jeu
		*/
		while (this.jeu_tourne) {
			switch (this.scene_courrante) {
				case "menu": {
					/**
					* saisies utilisateur
					*/
					this.menu.saisiesUtilisateur();
					/**
					* logique de la scene
					*/
					this.menu.logique();
				} break;
				
				case "niveau": {
					/**
					* saisies utilisateur
					*/
					this.niveau.saisiesUtilisateur();
					/**
					* logique de la scene
					*/
					this.niveau.logique();
				} break;
				
				case "table score": {
					/**
					* saisies utilisateurs
					*/
					this.table_score.saisiesUtilisateur();
					/**
					* logique de la scene
					*/
					this.table_score.logique();
				} break;
			}
		}
	}
}

/**
* Menu
* Type agrege qui decrit comment le menu doit etre
*/
public class Menu {
	
	/**
	* parametres
	*/
	Jeu jeu;
	
	Joueur joueur_1;
	Joueur joueur_2;
	
	public Menu(Jeu jeu) {
		/**
		* chargement de l'argument
		*/
		this.jeu = jeu;
		
		/**
		* affectation des parametres
		*/
		this.joueur_1 = new Joueur();
		this.joueur_2 = new Joueur();
	}
	
	public void saisiesUtilisateur() {
		/**
		* @return verifie les interractions de l'utilisateur avec le jeu
		*/
		
		/**
		* est saisi : le nombre de joueur
		*/
		Ecran.afficherln("Combien y a-t-il de joueurs ?");
		int nb_joueur = Saisie.dans(1, 2);
		Ecran.sautDeLigne();
		
		/**
		* sont affectes : les noms des joueurs
		*/
		switch (nb_joueur) {
			case 1: {
				/**
				* il y a un joueur
				* est saisi : le nom du joueur 1
				*/
				Ecran.afficherln("Quel est le nom du joueur ?");
				this.joueur_1.nom = Saisie.chaine();
				/**
				* est affecte : le nom du joueur 2 comme IA
				*/
				this.joueur_2.nom = "IA";
			} break;
			
			case 2: {
				/**
				* il y a deux joueurs
				* est saisi : le nom du joueur 1
				*/
				Ecran.afficherln("Quel est le nom du joueur 1 ?");
				this.joueur_1.nom = Saisie.chaine();
				Ecran.sautDeLigne();
				/**
				* est saisi : le nom du joueur 2
				*/
				Ecran.afficherln("Quel est le nom du joueur 2 ?");
				this.joueur_2.nom = Saisie.chaine();
			} break;
		}
		Ecran.sautDeLigne();
		
		/**
		* sont saisies : la flotte des joueurs
		* est saisie : la flotte du joueur 1
		*/
		this.joueur_1.flotte.saisirParams();
		/**
		* est saisie : la flotte du joueur 2
		*/
		this.joueur_2.flotte.saisirParams();
	}
	
	public void logique() {
		/**
		* @return applique la logique de la scene
		*/
		
		/**
		* est modifiiee : la scene courrante
		*/
		this.jeu.scene_courrante = "niveau";
		this.jeu.niveau = new Niveau(this.jeu, this.joueur_1, this.joueur_2);
		/**
		* est appellee : jeu.run
		*/
		this.jeu.run();
	}
}

/**
* Niveau
* Type agrege qui decrit comment le niveau doit etre
*/
public class Niveau {
	
	/**
	* parametres
	*/
	Jeu jeu;
	
	Joueur joueur_attaque;
	Joueur joueur_defence;
	
	public Niveau(Jeu jeu, Joueur joueur_attaque, Joueur joueur_defence) {
		/**
		* chargement des arguments
		*/
		this.jeu = jeu;
		this.joueur_attaque = joueur_attaque;
		this.joueur_defence = joueur_defence;
	}
	
	public void saisiesUtilisateur() {
		/**
		* verifie les interractions de l'utilisateur avec le jeu
		*/
		
		/**
		* est affichee : la grille du joueur de defence<br>
		*/
		this.joueur_defence.grille.afficherGrille(this.joueur_attaque.nom == "Starex Novelty Co" 
			|| this.joueur_defence.nom == "Starex Novelty Co");
		
		/**
		* est saisie : la cible pat le joueur d'attaque
		*/
		Saisie.cible(joueur_attaque);
	}
	
	public void logique() {
		/**
		* @return applique la logique de la scene
		*/
		
		/**
		* joueur d'attaque tir en cible
		*/
		this.joueur_attaque.tir(this.joueur_defence);
		
		/**
		* est verifie : l'etat du jeu (condition d'arret)
		*/
		if (Testeur.estDetruite(this.joueur_defence.flotte)) {
			/**
			* est modifiee : la scene courrante
			*/
			this.jeu.scene_courrante = "table score";
			this.jeu.table_score = new TableDeScore(this.jeu, this.joueur_attaque, this.joueur_defence);
			/**
			* est appellee : jeu.run
			*/
			this.jeu.run();
		} else {
			this.permuterJoueurs();
		}
	}
	
	public void permuterJoueurs() {
		/**
		* @return permute les joueurs attaque et defence
		*/
		
		/**
		* declaration de la donnee
		*/
		Joueur joueur_inter;
		
		/**
		* calcul du resultat
		*/
		joueur_inter = this.joueur_attaque;
		this.joueur_attaque = this.joueur_defence;
		this.joueur_defence = joueur_inter;
	}
}

/**
* TableDeScore
* Type agrege qui decrit comment la table de score doit etre
*/
public class TableDeScore {
	
	
	/**
	* parametres
	*/
	Jeu jeu;
	
	Joueur gagnant;
	Joueur perdant;
	
	int choix_jeu;
	
	public TableDeScore(Jeu jeu, Joueur gagnant, Joueur perdant) {
		/**
		* chargement des arguments
		*/
		this.jeu = jeu;
		this.gagnant = gagnant;
		this.perdant = perdant;
	}
	
	public void saisiesUtilisateur() {
		/**
		* @return verifie les interractions de l'utilisateur avec le jeu
		*/
		
		/**
		* afficher le score
		*/
		Ecran.afficherln(gagnant.nom, " a gagner ! Bravo !");
		Ecran.afficherln(perdant.nom, "a perdu ! Quel dommage !");
		
		/**
		* est saisi : rejouer ?
		*/
		Ecran.afficherln("Voulez-vous rejouer ?");
		Ecran.afficherln("1 : oui\n2 : non");
		choix_jeu = Saisie.dans(1, 2);
		/**
		* calcul du resultat
		*/
		switch(choix_jeu) {
			case 1: {
				jeu.jeu_tourne = false;
			} break;
		}
	}
	
	public void logique() {
		/**
		* applique la logique de la scene
		*/
		
		/**
		* rejouer ou arreter le jeu
		*/
		if (jeu.jeu_tourne) {
			/**
			* est modifiee : la scene courrante
			*/
			this.jeu.scene_courrante = "menu";
			this.jeu.menu = new Menu(this.jeu);
			/**
			* est appellee : jeu.run
			*/
			this.jeu.run();
		}
	}
}

/**
* Joueur
* Type agrege qui correspond aux joueurs : humain comme IA
* permet d'enregistrer chaque information correspondant au joueur :<br>
* nom, flotte qu'il possede, grille...
*/
public class Joueur {
	
	/**
	* parametres
	*/
	String nom;
	Flotte flotte;
	Grille grille;
	
	int cible;
	
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

/**
* Grille
* Type agrege qui permet d'enregistrer chaque information utiles<br>
* utiles a la creation et a l'affichage des grilles de jeu
*/
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

/**
* Flotte
* Type agrege qui permet d'enregistrer chaque bateau d'un joueur<br>
* le torpilleur les sous-marins le croiseur et le porte-avion
*/
public class Flotte {
	
	/**
	* parametres
	*/
	Joueur joueur;
	
	Bateau torpilleur;
	Bateau sous_marin_1;
	Bateau sous_marin_2;
	Bateau croiseur;
	Bateau porte_avion;
	
	public Flotte(Joueur joueur) {
		/**
		* chargement de l'argument
		*/
		this.joueur = joueur;
		
		/**
		* affectation des parametres
		*/
		this.torpilleur = new Bateau(this, 2, "torpilleur");
		this.sous_marin_1 = new Bateau(this, 3, "sous-marin 1");
		this.sous_marin_2 = new Bateau(this, 3, "sous-marin 2");
		this.croiseur = new Bateau(this, 4, "croiseur");
		this.porte_avion = new Bateau(this, 5, "porte-avion");
	}
	
	public void saisirParams() {
		/**
		* @return la saisie des bateaux de this
		*/
		
		Ecran.sautDeLigne();
		Ecran.afficherln("~", this.joueur.nom, " saisi sa flotte~");
		Ecran.sautDeLigne();
		this.torpilleur.saisirParams();
		this.sous_marin_1.saisirParams();
		this.sous_marin_2.saisirParams();
		this.croiseur.saisirParams();
		this.porte_avion.saisirParams();
	}
	
	/**
	* @param cible type entier stocke les coordonnees de la cible
	*/
	public boolean bateauEstTouche(int cible) {
		/**
		* @return retourne vrai si un bateau est touche en cible, faux sinon
		*/
		
		/**
		* renvois du resultat (non stocke)
		*/
		return Testeur.estTouche(this.torpilleur, cible) || Testeur.estTouche(this.sous_marin_1, cible) ||
			Testeur.estTouche(this.sous_marin_2, cible) || Testeur.estTouche(this.croiseur, cible) || 
			Testeur.estTouche(this.porte_avion, cible);
	}
	
	/**
	* @param cible type entier stocke les coordonnees de la cible
	*/
	public Bateau bateauTouche(int cible) {
		/**
		* @return retourne le bateau touche en cible
		*/
		
		/**
		* declaration du resultat
		*/
		Bateau bateau_touche = this.torpilleur;
		
		/**
		* calcul du resultat
		*/
		if (Testeur.estTouche(this.torpilleur, cible)) {
			bateau_touche = this.torpilleur;
		} else if (Testeur.estTouche(this.sous_marin_1, cible)) {
			bateau_touche = this.sous_marin_1;
		} else if (Testeur.estTouche(this.sous_marin_2, cible)) {
			bateau_touche = this.sous_marin_2;
		} else if (Testeur.estTouche(this.croiseur, cible)) {
			bateau_touche = this.croiseur;
		} else if (Testeur.estTouche(this.porte_avion, cible)) {
			bateau_touche = this.porte_avion;
		}
		
		/**
		* renvois du resultat
		*/
		return bateau_touche;
	}
}

/**
* Bateau
* Type agrege qui correspond aux bateaux
* permet d'enregistrer chaque information correspondant au bateau<br>
* nom, taille, la flotte a laquelle il appartient, son etat...
*/
public class Bateau {
	
	/**
	* parametres
	*/
	Flotte flotte;
	
	int taille;
	String nom;
	int etat;
	
	char orientation;
	long coordonnees;
	
	public Bateau(Flotte flotte, int taille, String nom) {
		/**
		* chargement des arguments
		*/
		this.flotte = flotte;
		this.taille = taille;
		this.nom = nom;
		this.coordonnees = 9;
		
		/**
		* affectation des parametres
		*/
		this.etat = this.taille;
	}
	
	public void saisirParams() {
		/**
		* @return saisies de l'orientation et des coordonnees de this
		*/
		
		/**
		* est saisie : l'orientation
		*/
		Ecran.afficherln("~", this.nom, "~");
		this.orientation = Saisie.orientation(this.flotte.joueur);
		/**
		* sont saisies : les coordonnees
		*/
		Saisie.coordonnees(this, this.flotte.joueur);
	}
}

/**
* Saisie
* Une classe qui regroupe toutes les fonctions de saisies utilisees dans le jeu
*/
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

/**
* Testeur
* Une classe qui regroupe toutes les fonctions de test utilisees dans le jeu
*/
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

/**
* Generateur
* Une classe qui regroupe toutes les fonctions de generation aleatoire utilisees dans le jeu
*/
public class Generateur {
	
	/**
	* @param borne_inf type entier borne inferieure de l'intervalle
	* @param borne_sup type entier borne superieure de l'intervalle
	*/
	public static int dans(int borne_inf, int borne_sup) {
		/**
		* @return retourne un entier tire aleatoirement dans |[borne_inf; borne_sup]|
		*/
		
		/**
		* verification des arguments
		*/
		if (borne_inf > borne_sup) {
			/**
			* on permute les deux bornes
			*/
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf = borne_inf - borne_sup;
		}
		
		/**
		* renvois du resultat (non stocke)
		*/
		return borne_inf + (int)(Math.random()*(borne_sup - borne_inf + 1));
	}
}

/**
* Liste
* AHAH on vous a bien eu...<br>
* on a trouve un moyen, grace a un peu de MFMA, d'enregistrer des informations dans des entiers
* Donc Liste est une classe regroupant toutes les fonctions utiles a la gestion de ses entiers
* lecture, ajouts, suppression et de remplacement
*/
public class Liste {
	
	/**
	* @param racine type entier nombre de reference
	* @param index type entier curseur de lecture de la racine
	* @param longueur type entier nombre de chiffre a lire sur racine depuis index
	*/
	public static int lireEn(long racine, int index, int longueur) {
		/**
		* @return retourne le nombre lu depuis index long de "longueur"
		*/
		
		/**
		* renvois du resultat (no stocke)
		*/
		return (int)(racine/(int)Math.pow(10, index)) % (int)Math.pow(10, longueur);
	}
	
	/**
	* @param nombre type entier nombre concerne par le calcul de la taille
	*/
	public static int taille(long nombre) {
		/**
		* @return retourne le nombre de chiffre de nombre
		*/
		
		/**
		* declaration et affectation du resultat
		*/
		int taille = 0;
	
		/**
		* calcul du resultat
		*/
		while (nombre != (nombre % (long)Math.pow(10, taille))) {
			taille ++;
		}
		
		if (nombre == 0) {
			taille = 1;
		}
		
		/**
		* renvois du resultat
		*/
		return taille;
	}
	
	/**
	* @param nombre type entier nombre a ajouter derriere racine
	* @param racine type entier nombre de reference
	*/
	public static long ajouter(long nombre, long racine) {
		/**
		* @return ajoute nombre a la fin de racine, puis retourne le resultat
		*/
		
		/**
		* calcul du resultat
		*/
		racine += nombre*(long)Math.pow(10, taille(racine));
		
		/**
		* renvois du resultat
		*/
		return racine;
	}
	
	/**
	* @param nombre type entier nombre a ajouter a racine en index
	* @param racine type entier nombre de reference
	* @param index type entier nombre curseur
	*/
	public static long ajouter(int nombre, long racine, int index) {
		/**
		* @return ajoute nombre en index a racine, puis retourne le resultat
		*/
	
		/**
		* renvois du resultat (non stocke)
		*/
		return ajouter(ajouter((long)lireEn(racine, index, taille(racine)), nombre), (long)lireEn(racine, 0, index));
	}
	
	/**
	* @param racine type entier nombre de reference
	* @param index type entier nombre curseur
	* @param nombre type entier nombre par lelquel modifier l'autre
	*/
	public static long changer(long racine, int index, int nombre) {
		/**
		*@return change la valeur de la racine en index par nombre, puis retourne le resultat
		*/
		
		Ecran.afficherln("racine : ", racine);
		Ecran.afficherln("retirer : ", Liste.retirer(racine, index));
		Ecran.afficherln("changer : ", Liste.changer(racine, index, nombre));
		
		/**
		* renvois du resultat (non stocke)
		*/
		if (index != 0) {
			return Liste.ajouter(nombre, Liste.retirer(racine, index), index);
		} else {
			return (long)(Liste.ajouter(nombre, Liste.retirer(racine, index), index) / 10);
		}
	}
	
	/**
	* @param racine type entier nombre de reference
	* @param index type entier nombre curseur
	*/
	public static long retirer(long racine, int index) {
		/**
		* @return retire la valeur de racine en index, puis retourne le resultat
		*/
		
		/**
		* renvois du resultat (non stocke)
		*/
		if (index != 0) {
			return Liste.ajouter(Liste.lireEn(racine, index+1, Liste.taille(racine)-index+1), Liste.lireEn(racine, 0, index));
		} else {
			return (long)(Liste.ajouter(Liste.lireEn(racine, index+1, Liste.taille(racine)-index+1), Liste.lireEn(racine, 0, index)) / 10);
		}
	}
}

}

/**
* Jeu
* Type agrege correspondant au corps du jeu en lui-meme
*/
public class Jeu {

/**
* parametres
*/
boolean jeu_tourne;
String scene_courrante;
Menu menu;
Niveau niveau;
TableDeScore table_score;

public Jeu() {
	/**
	* affectation des parametres
	*/
	this.jeu_tourne = true;
	this.scene_courrante = "menu";
	this.menu = new Menu(this);
}

public void run() {
	/**
	* @return appelle les methodes propres a la boucle du jeu
	*/
	
	/**
	* boucle du jeu
	*/
	while (this.jeu_tourne) {
		switch (this.scene_courrante) {
			case "menu": {
				/**
				* saisies utilisateur
				*/
				this.menu.saisiesUtilisateur();
				/**
				* logique de la scene
				*/
				this.menu.logique();
			} break;
			
			case "niveau": {
				/**
				* saisies utilisateur
				*/
				this.niveau.saisiesUtilisateur();
				/**
				* logique de la scene
				*/
				this.niveau.logique();
			} break;
			
			case "table score": {
				/**
				* saisies utilisateurs
				*/
				this.table_score.saisiesUtilisateur();
				/**
				* logique de la scene
				*/
				this.table_score.logique();
			} break;
		}
	}
}
}

/**
* Menu
* Type agrege qui decrit comment le menu doit etre
*/
public class Menu {

/**
* parametres
*/
Jeu jeu;

Joueur joueur_1;
Joueur joueur_2;

public Menu(Jeu jeu) {
	/**
	* chargement de l'argument
	*/
	this.jeu = jeu;
	
	/**
	* affectation des parametres
	*/
	this.joueur_1 = new Joueur();
	this.joueur_2 = new Joueur();
}

public void saisiesUtilisateur() {
	/**
	* @return verifie les interractions de l'utilisateur avec le jeu
	*/
	
	/**
	* est saisi : le nombre de joueur
	*/
	Ecran.afficherln("Combien y a-t-il de joueurs ?");
	int nb_joueur = Saisie.dans(1, 2);
	Ecran.sautDeLigne();
	
	/**
	* sont affectes : les noms des joueurs
	*/
	switch (nb_joueur) {
		case 1: {
			/**
			* il y a un joueur
			* est saisi : le nom du joueur 1
			*/
			Ecran.afficherln("Quel est le nom du joueur ?");
			this.joueur_1.nom = Saisie.chaine();
			/**
			* est affecte : le nom du joueur 2 comme IA
			*/
			this.joueur_2.nom = "IA";
		} break;
		
		case 2: {
			/**
			* il y a deux joueurs
			* est saisi : le nom du joueur 1
			*/
			Ecran.afficherln("Quel est le nom du joueur 1 ?");
			this.joueur_1.nom = Saisie.chaine();
			Ecran.sautDeLigne();
			/**
			* est saisi : le nom du joueur 2
			*/
			Ecran.afficherln("Quel est le nom du joueur 2 ?");
			this.joueur_2.nom = Saisie.chaine();
		} break;
	}
	Ecran.sautDeLigne();
	
	/**
	* sont saisies : la flotte des joueurs
	* est saisie : la flotte du joueur 1
	*/
	this.joueur_1.flotte.saisirParams();
	/**
	* est saisie : la flotte du joueur 2
	*/
	this.joueur_2.flotte.saisirParams();
}

public void logique() {
	/**
	* @return applique la logique de la scene
	*/
	
	/**
	* est modifiiee : la scene courrante
	*/
	this.jeu.scene_courrante = "niveau";
	this.jeu.niveau = new Niveau(this.jeu, this.joueur_1, this.joueur_2);
	/**
	* est appellee : jeu.run
	*/
	this.jeu.run();
}
}

/**
* Niveau
* Type agrege qui decrit comment le niveau doit etre
*/
public class Niveau {

/**
* parametres
*/
Jeu jeu;

Joueur joueur_attaque;
Joueur joueur_defence;

public Niveau(Jeu jeu, Joueur joueur_attaque, Joueur joueur_defence) {
	/**
	* chargement des arguments
	*/
	this.jeu = jeu;
	this.joueur_attaque = joueur_attaque;
	this.joueur_defence = joueur_defence;
}

public void saisiesUtilisateur() {
	/**
	* verifie les interractions de l'utilisateur avec le jeu
	*/
	
	/**
	* est affichee : la grille du joueur de defence<br>
	*/
	this.joueur_defence.grille.afficherGrille(this.joueur_attaque.nom == "Starex Novelty Co" 
		|| this.joueur_defence.nom == "Starex Novelty Co");
	
	/**
	* est saisie : la cible pat le joueur d'attaque
	*/
	Saisie.cible(joueur_attaque);
}

public void logique() {
	/**
	* @return applique la logique de la scene
	*/
	
	/**
	* joueur d'attaque tir en cible
	*/
	this.joueur_attaque.tir(this.joueur_defence);
	
	/**
	* est verifie : l'etat du jeu (condition d'arret)
	*/
	if (Testeur.estDetruite(this.joueur_defence.flotte)) {
		/**
		* est modifiee : la scene courrante
		*/
		this.jeu.scene_courrante = "table score";
		this.jeu.table_score = new TableDeScore(this.jeu, this.joueur_attaque, this.joueur_defence);
		/**
		* est appellee : jeu.run
		*/
		this.jeu.run();
	} else {
		this.permuterJoueurs();
	}
}

public void permuterJoueurs() {
	/**
	* @return permute les joueurs attaque et defence
	*/
	
	/**
	* declaration de la donnee
	*/
	Joueur joueur_inter;
	
	/**
	* calcul du resultat
	*/
	joueur_inter = this.joueur_attaque;
	this.joueur_attaque = this.joueur_defence;
	this.joueur_defence = joueur_inter;
}
}

/**
* TableDeScore
* Type agrege qui decrit comment la table de score doit etre
*/
public class TableDeScore {


/**
* parametres
*/
Jeu jeu;

Joueur gagnant;
Joueur perdant;

int choix_jeu;

public TableDeScore(Jeu jeu, Joueur gagnant, Joueur perdant) {
	/**
	* chargement des arguments
	*/
	this.jeu = jeu;
	this.gagnant = gagnant;
	this.perdant = perdant;
}

public void saisiesUtilisateur() {
	/**
	* @return verifie les interractions de l'utilisateur avec le jeu
	*/
	
	/**
	* afficher le score
	*/
	Ecran.afficherln(gagnant.nom, " a gagner ! Bravo !");
	Ecran.afficherln(perdant.nom, "a perdu ! Quel dommage !");
	
	/**
	* est saisi : rejouer ?
	*/
	Ecran.afficherln("Voulez-vous rejouer ?");
	Ecran.afficherln("1 : oui\n2 : non");
	choix_jeu = Saisie.dans(1, 2);
	/**
	* calcul du resultat
	*/
	switch(choix_jeu) {
		case 1: {
			jeu.jeu_tourne = false;
		} break;
	}
}

public void logique() {
	/**
	* applique la logique de la scene
	*/
	
	/**
	* rejouer ou arreter le jeu
	*/
	if (jeu.jeu_tourne) {
		/**
		* est modifiee : la scene courrante
		*/
		this.jeu.scene_courrante = "menu";
		this.jeu.menu = new Menu(this.jeu);
		/**
		* est appellee : jeu.run
		*/
		this.jeu.run();
	}
}
}

/**
* Joueur
* Type agrege qui correspond aux joueurs : humain comme IA
* permet d'enregistrer chaque information correspondant au joueur :<br>
* nom, flotte qu'il possede, grille...
*/
public class Joueur {

/**
* parametres
*/
String nom;
Flotte flotte;
Grille grille;

int cible;

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

/**
* Grille
* Type agrege qui permet d'enregistrer chaque information utiles<br>
* utiles a la creation et a l'affichage des grilles de jeu
*/
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

/**
* Flotte
* Type agrege qui permet d'enregistrer chaque bateau d'un joueur<br>
* le torpilleur les sous-marins le croiseur et le porte-avion
*/
public class Flotte {

/**
* parametres
*/
Joueur joueur;

Bateau torpilleur;
Bateau sous_marin_1;
Bateau sous_marin_2;
Bateau croiseur;
Bateau porte_avion;

public Flotte(Joueur joueur) {
	/**
	* chargement de l'argument
	*/
	this.joueur = joueur;
	
	/**
	* affectation des parametres
	*/
	this.torpilleur = new Bateau(this, 2, "torpilleur");
	this.sous_marin_1 = new Bateau(this, 3, "sous-marin 1");
	this.sous_marin_2 = new Bateau(this, 3, "sous-marin 2");
	this.croiseur = new Bateau(this, 4, "croiseur");
	this.porte_avion = new Bateau(this, 5, "porte-avion");
}

public void saisirParams() {
	/**
	* @return la saisie des bateaux de this
	*/
	
	Ecran.sautDeLigne();
	Ecran.afficherln("~", this.joueur.nom, " saisi sa flotte~");
	Ecran.sautDeLigne();
	this.torpilleur.saisirParams();
	this.sous_marin_1.saisirParams();
	this.sous_marin_2.saisirParams();
	this.croiseur.saisirParams();
	this.porte_avion.saisirParams();
}

/**
* @param cible type entier stocke les coordonnees de la cible
*/
public boolean bateauEstTouche(int cible) {
	/**
	* @return retourne vrai si un bateau est touche en cible, faux sinon
	*/
	
	/**
	* renvois du resultat (non stocke)
	*/
	return Testeur.estTouche(this.torpilleur, cible) || Testeur.estTouche(this.sous_marin_1, cible) ||
		Testeur.estTouche(this.sous_marin_2, cible) || Testeur.estTouche(this.croiseur, cible) || 
		Testeur.estTouche(this.porte_avion, cible);
}

/**
* @param cible type entier stocke les coordonnees de la cible
*/
public Bateau bateauTouche(int cible) {
	/**
	* @return retourne le bateau touche en cible
	*/
	
	/**
	* declaration du resultat
	*/
	Bateau bateau_touche = this.torpilleur;
	
	/**
	* calcul du resultat
	*/
	if (Testeur.estTouche(this.torpilleur, cible)) {
		bateau_touche = this.torpilleur;
	} else if (Testeur.estTouche(this.sous_marin_1, cible)) {
		bateau_touche = this.sous_marin_1;
	} else if (Testeur.estTouche(this.sous_marin_2, cible)) {
		bateau_touche = this.sous_marin_2;
	} else if (Testeur.estTouche(this.croiseur, cible)) {
		bateau_touche = this.croiseur;
	} else if (Testeur.estTouche(this.porte_avion, cible)) {
		bateau_touche = this.porte_avion;
	}
	
	/**
	* renvois du resultat
	*/
	return bateau_touche;
}
}

/**
* Bateau
* Type agrege qui correspond aux bateaux
* permet d'enregistrer chaque information correspondant au bateau<br>
* nom, taille, la flotte a laquelle il appartient, son etat...
*/
public class Bateau {

/**
* parametres
*/
Flotte flotte;

int taille;
String nom;
int etat;

char orientation;
long coordonnees;

public Bateau(Flotte flotte, int taille, String nom) {
	/**
	* chargement des arguments
	*/
	this.flotte = flotte;
	this.taille = taille;
	this.nom = nom;
	this.coordonnees = 9;
	
	/**
	* affectation des parametres
	*/
	this.etat = this.taille;
}

public void saisirParams() {
	/**
	* @return saisies de l'orientation et des coordonnees de this
	*/
	
	/**
	* est saisie : l'orientation
	*/
	Ecran.afficherln("~", this.nom, "~");
	this.orientation = Saisie.orientation(this.flotte.joueur);
	/**
	* sont saisies : les coordonnees
	*/
	Saisie.coordonnees(this, this.flotte.joueur);
}
}

/**
* Saisie
* Une classe qui regroupe toutes les fonctions de saisies utilisees dans le jeu
*/
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

/**
* Testeur
* Une classe qui regroupe toutes les fonctions de test utilisees dans le jeu
*/
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

/**
* Generateur
* Une classe qui regroupe toutes les fonctions de generation aleatoire utilisees dans le jeu
*/
public class Generateur {

/**
* @param borne_inf type entier borne inferieure de l'intervalle
* @param borne_sup type entier borne superieure de l'intervalle
*/
public static int dans(int borne_inf, int borne_sup) {
	/**
	* @return retourne un entier tire aleatoirement dans |[borne_inf; borne_sup]|
	*/
	
	/**
	* verification des arguments
	*/
	if (borne_inf > borne_sup) {
		/**
		* on permute les deux bornes
		*/
		borne_inf += borne_sup;
		borne_sup = borne_inf - borne_sup;
		borne_inf = borne_inf - borne_sup;
	}
	
	/**
	* renvois du resultat (non stocke)
	*/
	return borne_inf + (int)(Math.random()*(borne_sup - borne_inf + 1));
}
}

/**
* Liste
* AHAH on vous a bien eu...<br>
* on a trouve un moyen, grace a un peu de MFMA, d'enregistrer des informations dans des entiers
* Donc Liste est une classe regroupant toutes les fonctions utiles a la gestion de ses entiers
* lecture, ajouts, suppression et de remplacement
*/
public class Liste {

/**
* @param racine type entier nombre de reference
* @param index type entier curseur de lecture de la racine
* @param longueur type entier nombre de chiffre a lire sur racine depuis index
*/
public static int lireEn(long racine, int index, int longueur) {
	/**
	* @return retourne le nombre lu depuis index long de "longueur"
	*/
	
	/**
	* renvois du resultat (no stocke)
	*/
	return (int)(racine/(int)Math.pow(10, index)) % (int)Math.pow(10, longueur);
}

/**
* @param nombre type entier nombre concerne par le calcul de la taille
*/
public static int taille(long nombre) {
	/**
	* @return retourne le nombre de chiffre de nombre
	*/
	
	/**
	* declaration et affectation du resultat
	*/
	int taille = 0;

	/**
	* calcul du resultat
	*/
	while (nombre != (nombre % (long)Math.pow(10, taille))) {
		taille ++;
	}
	
	if (nombre == 0) {
		taille = 1;
	}
	
	/**
	* renvois du resultat
	*/
	return taille;
}

/**
* @param nombre type entier nombre a ajouter derriere racine
* @param racine type entier nombre de reference
*/
public static long ajouter(long nombre, long racine) {
	/**
	* @return ajoute nombre a la fin de racine, puis retourne le resultat
	*/
	
	/**
	* calcul du resultat
	*/
	racine += nombre*(long)Math.pow(10, taille(racine));
	
	/**
	* renvois du resultat
	*/
	return racine;
}

/**
* @param nombre type entier nombre a ajouter a racine en index
* @param racine type entier nombre de reference
* @param index type entier nombre curseur
*/
public static long ajouter(int nombre, long racine, int index) {
	/**
	* @return ajoute nombre en index a racine, puis retourne le resultat
	*/

	/**
	* renvois du resultat (non stocke)
	*/
	return ajouter(ajouter((long)lireEn(racine, index, taille(racine)), nombre), (long)lireEn(racine, 0, index));
}

/**
* @param racine type entier nombre de reference
* @param index type entier nombre curseur
* @param nombre type entier nombre par lelquel modifier l'autre
*/
public static long changer(long racine, int index, int nombre) {
	/**
	*@return change la valeur de la racine en index par nombre, puis retourne le resultat
	*/
	
	Ecran.afficherln("racine : ", racine);
	Ecran.afficherln("retirer : ", Liste.retirer(racine, index));
	Ecran.afficherln("changer : ", Liste.changer(racine, index, nombre));
	
	/**
	* renvois du resultat (non stocke)
	*/
	if (index != 0) {
		return Liste.ajouter(nombre, Liste.retirer(racine, index), index);
	} else {
		return (long)(Liste.ajouter(nombre, Liste.retirer(racine, index), index) / 10);
	}
}

/**
* @param racine type entier nombre de reference
* @param index type entier nombre curseur
*/
public static long retirer(long racine, int index) {
	/**
	* @return retire la valeur de racine en index, puis retourne le resultat
	*/
	
	/**
	* renvois du resultat (non stocke)
	*/
	if (index != 0) {
		return Liste.ajouter(Liste.lireEn(racine, index+1, Liste.taille(racine)-index+1), Liste.lireEn(racine, 0, index));
	} else {
		return (long)(Liste.ajouter(Liste.lireEn(racine, index+1, Liste.taille(racine)-index+1), Liste.lireEn(racine, 0, index)) / 10);
	}
}
