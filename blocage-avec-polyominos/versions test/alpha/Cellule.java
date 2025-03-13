/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Cellule
{
	
	/*ATTRIBUTS				*/
	private boolean estLibre;
	private char motif;
	
	/*CONSTRUCTEURS			*/
	public Cellule(char motif)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@param motif type caractere
		*@return l'affectation des attributs
		* par des valeurs specifiees
		*/
		
		this.estLibre = true;
		this.motif = motif;
	}
	public Cellule()
	{
		
		/**
		*CONSTRUCTEUR par defaut
		*@return l'affectation des attributs
		*par appel du constructeur principal
		*/
		
		this('.');
	}
	
	/*METHODES				*/
	
	// verifiee
	public boolean getEstLibre()
	{
		
		/**
		*@return estLibre
		*/
		
		return estLibre;
	}
	
	// verifiee
	public void setEstLibre(char motif)
	{
		
		/**
		*@return l'affectation de estLibre en oppose
		*/
		
		if (estLibre)
		{
			this.motif = motif;
			estLibre = !estLibre;
		}
	}
	
	// verifiee
	public String versChaine()
	{
		
		/**
		*@return la chaine associe a la Cellule
		*/
		
		return ""+motif;
	}
}
