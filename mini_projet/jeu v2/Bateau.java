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
	
	//~ CONSTRUCTEUR
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
