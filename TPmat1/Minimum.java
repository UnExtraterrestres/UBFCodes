class Minimum
{
	
	int valeur;
	Position position;
	
	public void afficher()
	{
		
		/**
		*@return l'affichage des parametres de this
		*/
		
		System.out.print(this + " : valeur (" + this.valeur + ")");
		this.position.afficherln();
	}
	
	public void affecter(int valeur, int x, int y)
	{
		
		/**
		*@param valeur type entier
		*@param x type entier
		*@param y type entier
		*@return l'affectation des parametres this.valeur .x et .y
		*respectivement par valeur x et y specifies
		*/
		
		this.valeur = valeur;
		this.position.affecter(x, y);
	}
	public void affecter(int valeur)
	{
		
		/**
		*@param valeur type entier
		*@return l'affectation de this.valeur par valeur specifie
		*/
		
		this.valeur = valeur;
	}
	
	/*CONSTRUCTEUR						*/
	public Minimum()
	{
		
		/*affectation par defaut des parametres 		*/
		this.position.affecter(0, 0);
	}
	public Minimum(int x, int y)
	{
		
		/*chargement des parametres			*/
		this.position.affecter(x, y);
	}
}
