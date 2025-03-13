class Date
{
	
	/*ATTRIBUTS					*/
	int j, m, a;
	
	/*CONSTRUCTEURS				*/
	public Date(int j, int m, int a)
	{
		
		/**
		*CONSTRUCTEUR principal
		@param j type entier entre 1 et 31
		@param m type entier entre 1 et 12
		@param a type entier
		@return l'affectation des attributs
		* par les valeurs specifiees
		*/
		
		this.j = j;
		this.m = m;
		this.a = a;
	}
	public Date()
	{
		
		/**
		*CONSTRUCTEUR par defaut
		*@return l'affectation des attributs par defaut
		* par appel du constructeur principal
		*/
		
		this(14, 7, 1790);
	}
	
	
	/*METHODES					*/
	public String toString()
	{
		
		/**
		*@return la chaine de caractere de la Date
		*/
		
		return this.j+"/"+this.m+"/"+this.a;
	}
}
