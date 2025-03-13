public class Jeu {
	
	/**
	* parametres
	*/
	boolean jeu_tourne;
	String scene_courrante;
	Menu menu;
	Niveau niveau;
	TableDeScore table_score;
	
	//~ CONSTRUCTEUR
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
