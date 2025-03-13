class Point {
	
	/*PARAMETRES						*/
	int x;
	int y;
	
	public void affecter(int x, int y)
	{
		
		/**
		*@param x type entier
		*@param y type entier
		*@return m'affectation de this.x et .y
		*respectivement par x et y specifie
		*/
		
		this.x = x;
		this.y = y;
	}
	
	public void afficher()
	{
		
		/**
		*@return l'affichage des parametres de this
		*/
		
		System.out.print("(" + this.x + " ; " + this.y + ")");
	}
	
	public void afficherln()
	{
		
		/**
		*@return l'affichage des parametres
		*suivi d'un saut de ligne
		*/
		
		this.afficher();
		System.out.println(" ");
	}
	
	/*CONSTRUCTEURS						*/
	public Point()
	{
		
		/*affectation par defaut des parametres		*/
		this.affecter(0, 0);
	}
	public Point(int x, int y) {
		
		/*chargement des parametres			*/
		this.affecter(x, y);
	}
}
