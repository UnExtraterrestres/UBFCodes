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
	
	//~ CONSTRUCTEUR
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
