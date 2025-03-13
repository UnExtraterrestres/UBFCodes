class Point2D
{
	
	/*ATTRIBUTS				*/
	double x;
	double y;
	
	/*METHODES				*/
	public void afficher()
	{
		
		/**
		*@return l'affichage des attributs du Point2D
		*/
		
		System.out.print("Point2D:"+this);
		System.out.print(" x:"+this.x);
		System.out.print(" y:"+this.y);
		System.out.println("");
	}
	
	public double distanceOrigine()
	{
		
		/**
		*@return la distance a l'origine du point2D
		*comme racine de la somme des carres de x et y
		*/
		
		return distanceAvec(new Point2D(0.0, 0.0));
	}
	
	public double distanceAvec(Point2D point)
	{
		
		/**
		*@param point type Point2D
		*@return la distance euclidienne entre le point2D et celui specifie
		*par le theoreme de Pythagore
		*/
		
		return Math.sqrt(Math.pow(this.x-point.x, 2)+Math.pow(this.y-point.y, 2));
	}
	
	/*CONSTRUCTEUR			*/
	public Point2D()
	{
		
		/**
		*@return l'affectation des attributs
		*par defaut
		*/
		
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Point2D(double x, double y)
	{
		
		/**
		*@param x type reel
		*@param y type reel
		*@return l'affectation des attributs
		*par valeurs specifiees
		*/
		
		this.x = x;
		this.y = y;
	}
}
