/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

abstract class Scene
{
	
	/*ATTRIBUTS		*/
	protected Jeu jeu;
	
	/*CONSTRUCTEURS	*/
	public Scene(Jeu jeu)
	{
		
		/**
		*constructeur principal
		*@param jeu type Jeu
		*@return l'affectation des attributs
		* par des valeurs specifiees
		*/
		
		this.jeu = jeu;
	}
	
	/*METHODES		*/
	abstract void main();
}
