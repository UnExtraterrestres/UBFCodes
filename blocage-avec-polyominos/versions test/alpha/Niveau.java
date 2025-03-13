/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Niveau extends Scene
{
	
	/*ATTRIBUTS		*/
	private Plateau plateau;
	private Joueur[] joueurs;
	private int numTour;
	
	/*CONSTRUCTEURS	*/
	public Niveau(Plateau plateau, Joueur[] joueurs, Jeu jeu)
	{
		
		/**
		*constructeur principal
		*@param plateau type Plateau
		*@param joueurs type tableau de Joueur
		*@param jeu type Jeu
		*@return l'affectation des attributs
		* par appel du constructeur principal de la super classe
		*/
		
		super(jeu);
		
		this.plateau = plateau;
		this.joueurs = joueurs;
		numTour = 0;
	}
	
	/*METHODES		*/
	@Override
	public void main()
	{
		
		/**
		*@return la boucle logique d'un niveau
		*/
		
		/*affiche le numero du tour			*/
		for (int i=0; i<100; i++)
		{
			System.out.println("");
		}
		System.out.println("Tour : "+numTour+"\n C'est au tour de : "+joueurs[numTour%joueurs.length].nom);
		
		/*le joueur courrant pose une piece		*/
		joueurs[numTour%joueurs.length].placerPolyo(plateau);
		
		/*si le plateau est bloque on arrete le jeu	*/
		if (plateau.joueurEstBloque(joueurs[numTour%joueurs.length].jeuDePolyos))
		{
			System.out.println(joueurs[numTour%joueurs.length].nom+" a perdu la partie est finie...");
			jeu.arreterJeu();
		}
		/*sinon tour suivant				*/
		numTour++;
	}
}
