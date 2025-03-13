class Position
{
	
	int x;
	int y;
	
	public void affecter(int x, int y)
	{
		
		/**
		*@param x type entier
		*@param y type entier
		*@return l'affectation des parametres de this, par x et y
		*/
		this.afficherln();
		
		this.x = x;
		this.y = y;
		
		this.afficherln();
	}
	
	/*CONSTRUCTEURS				*/
	public Position()
	{
		
		/*affectation des parametres		*/
		this.affecter(0, 0);
	}
	
	public Position(int x, int  y)
	{
		
		/*chargement des arguments		*/
		this.affecter(x, y);
	}
	
	public void afficherln()
	{
		
		/**
		*@return l'affichage des parametres de this
		*/
		
		System.out.println("Position : " + this.x + " ; " + this.y);
	}
}
