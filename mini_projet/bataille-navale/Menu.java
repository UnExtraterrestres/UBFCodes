public class Menu extends Scene
{
	
	/** PARAMETRES						 */
	int nombre_joueur;
	Joueur joueur_0 = new Joueur();
	Joueur joueur_1 = new Joueur();
	
	/** CONSTRUCTEUR						 */
	public Menu(Jeu jeu)
	{
		/** chargement des args 				*/
		super(jeu);
	}
	
	@Override
	public void saisir()
	{
		
		/** saisie du nombre de Joueur 			*/
		Ecran.afficherln("Entrer le nombre de joueurs (0 minimum, 2 maximum): ");
		this.nombre_joueur = Saisie.dans(2);
		/** saisie des joueurs 					*/
		switch (this.nombre_joueur)
		{
			case 0: {
				this.joueur_0.generer();
				this.joueur_1.generer();
			} break;
			case 1: {
				this.joueur_0.saisir();
				this.joueur_1.generer();
			} break;
			case 2: {
				this.joueur_0.saisir();
				this.joueur_1.saisir();
			} break;
			default: {
				Ecran.afficherln("Erreur : ", this.nombre_joueur, " n'est pas un nombre de joueur compatible.");
				this.joueur_0.generer();
				this.joueur_1.generer();
			} break;
		}
		
		this.joueur_0.afficher(false);
		this.joueur_1.afficher(false);
	}
	
	@Override
	public void logique()
	{
		
		/** On passe au Niveau en passant les joueurs	 */
		this.changerScene(new Niveau(this.jeu, joueur_0, joueur_1));
	}
}
