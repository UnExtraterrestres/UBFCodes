public class TableDeScore {
	
	
	/**
	* parametres
	*/
	Jeu jeu;
	
	Joueur gagnant;
	Joueur perdant;
	
	int choix_jeu;
	
	//~ CONSTRUCTEUR
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
