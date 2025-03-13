class EchantillonFraise
{
	
	int numero_machine;
	String date_fabrication;
	double [] poids;
	
	/*CONSTRUCTEURS				*/
	public EchantillonFraise()
	{
		
		/*affectation des parametres		*/
		this.affecter(0, "01/01/2023", 1000);
	}
	
	public EchantillonFraise(int numero, String date, int nb_fraises)
	{
		
		/*chargement des arguments		*/
		this.affecter(numero, date, nb_fraises);
	}
	
	public void afficher()
	{
		
		/**
		*@return l'affichage des parametres de this, sans saut de ligne
		*/
		
		System.out.print("Echantillon : machine n°" + this.numero_machine);
		System.out.print(" fabrication le " + this.date_fabrication);
		System.out.print(" nombre de fraises " + this.poids.length);
	}
	
	public void afficherln()
	{
		
		/**
		*@return l'affichage des parametres de this, avec un saut de ligne
		*/
		
		this.afficher();
		System.out.println(" ");
	}
	
	public void affecter(int numero, String date, int nb_fraises)
	{
		
		/**
		*@param numero type entier
		*@param date type chaine
		*@param nb_fraise type entier
		*@return l'affectation de this.numero_machine .date_fabrication .poids <br>
		*respectivements par numero, date et un tableau de double de taille nb_fraises
		*/
		
		this.numero_machine = numero;
		this.date_fabrication = date;
		this.poids = new double[nb_fraises];
	}
	
	public void genererPoids()
	{
		
		/**
		*@return l'affectation des valeurs des elements de this.poids, par des valeurs aleatoires
		*/
		
		for (int i = 1; i<this.poids.length; i++)
		{
			this.poids[i] = this.poids[i-1] + Math.random();
		}
	}
}
