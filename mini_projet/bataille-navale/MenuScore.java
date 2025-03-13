public class MenuScore extends Scene
{
	
	/** CONSTRUCTEUR 				*/
	public MenuScore(Jeu jeu)
	{
		
		/** chargement des args 		*/
		super(jeu);
	}
	
	@Override
	public void saisir()
	{
		/** affiche le score		 	 */
		/** saisir une nouvelle partie		 */
		
		System.out.println("score.verifSaisies");
	}
	
	@Override
	public void logique()
	{
		
		/** rejouer ou arreter le jeu		 */
		
		System.out.println("score.logique");
	}
}
