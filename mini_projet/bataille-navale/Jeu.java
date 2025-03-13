public class Jeu
{
	
	/** PARAMETRES 				*/
	boolean jeu_tourne = true;
	Scene scene_courrante = new Menu(this);
	
	public void run()
	{
		
		/**
		*@return appelle les methodes propres a la boucle du jeu
		*/
		
		while (this.jeu_tourne)
		{
			/** saisies utilisateurs 		*/
			this.scene_courrante.saisir();
			/** logique de la scene 		*/
			this.scene_courrante.logique();
		}
	}
}
