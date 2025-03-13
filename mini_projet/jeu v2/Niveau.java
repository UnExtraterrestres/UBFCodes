public class Niveau {
	
	/**
	* parametres
	*/
	Jeu jeu;
	
	Joueur joueur_attaque;
	Joueur joueur_defence;
	
	//~ CONSTRUCTEUR
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
