/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Jeu
{
	
	/*ATTRIBUTS		*/
	private Scene sceneCourante;
	private boolean jeuTourne;
	
	/*CONSTRUCTEURS	*/
	public Jeu()
	{
		
		/**
		*constructeur par defaut
		*@return l'affectation des attributs
		* par defaut
		*/
		
		sceneCourante = new Menu(this);
		jeuTourne = true;
	}
	
	/*METHODES		*/
	public void commencer()
	{
		
		/**
		*@return la boucle du jeu
		*/
		
		while (jeuTourne)
		{
			sceneCourante.main();
		}
	}
	
	public void arreterJeu()
	{
		
		/**
		*@return voir le nom de la methode...
		*/
		
		jeuTourne = false;
	}
	
	public void setScene(Scene scene)
	{
		
		/**
		*setteur sur sceneCourante
		*@return l'affectation de sceneCourante
		* par la scene specifiee
		*/
		
		sceneCourante = scene;
	}
}
