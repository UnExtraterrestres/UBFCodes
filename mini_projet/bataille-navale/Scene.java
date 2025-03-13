public abstract class Scene
{
	
	/** PARAMETRES						 */
	Jeu jeu;
	
	/** CONSTRUCTEUR			 			*/
	public Scene(Jeu jeu)
	{
		/** chargement des args 				*/
		this.jeu = jeu;
	}
	
	public abstract void saisir();
	/**@return les saisies de l'utilisateur 			*/
	
	public abstract void logique();
	/**@return l'application de la logique de la scene 	*/
	
	public void changerScene(Scene scene)
	{
		/**
		*@param scene de type scene
		*@return l'affectation de jeu.scene_courrante par scene (param), puis appel de jeu.run
		*/
		
		this.jeu.scene_courrante = scene;
		this.jeu.run();
	}
}
