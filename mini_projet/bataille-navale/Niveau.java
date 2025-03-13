public class Niveau extends Scene
{
	
	/** PARAMETRES										*/
	Joueur joueur_attaque;
	Joueur joueur_ennemi;
	
	/** CONSTRUCTEUR										*/
	public Niveau(Jeu jeu, Joueur joueur_attaque, Joueur joueur_ennemi)
	{
		/** chargement des args								 */
		super(jeu);
		this.joueur_attaque = joueur_attaque;
		this.joueur_ennemi = joueur_ennemi;
	}
	
	@Override
	public void saisir()
	{
		
		/** saisie de la cible par le joueur attaquant					 */
		
		System.out.println("niveau.verifSaisies");
	}
	
	@Override
	public void logique()
	{
		/** effectuer le tir par le joueur d'attaque						 */
		
		/** verifier l'etat du jeu (l'etat de la flotte ennemie)
		* NB que si la flotte ennemie est detruite on passe au menu des scores	*/
		
		System.out.println("niveau.logique");
		
		this.jeu.jeu_tourne = false;
	}
}
