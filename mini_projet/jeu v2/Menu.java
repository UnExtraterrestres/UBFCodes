public class Menu {
	
	/**
	* parametres
	*/
	Jeu jeu;
	
	Joueur joueur_1;
	Joueur joueur_2;
	
	//~ CONSTRUCTEUR
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
