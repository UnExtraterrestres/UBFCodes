class Moteur
{
	
	/* ATTRIBUTS								*/
	int kilometrage;
	Date prochaineVidange;
	
	/* CONSTRUCTEURS							*/
	public Moteur(int kilometrage, Date prochaineVidange)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@param kilometrage type entier naturel
		*@param prochaineVidange type Date
		*@return l'affectation des attributs
		* par les valeurs specifiees
		*/
		
		this.kilometrage = kilometrage;
		this.prochaineVidange = prochaineVidange;
	}
	public Moteur()
	{
		
		/**
		*CONSTRUCTEUR par defaut
		*@return l'affectation des attributs par defaut
		* par appel du constructeur principal
		*/
		
		this(0, new Date(1, 4, 2024));
	}
	
	/* METHODES								*/
	public int ajouterKilometres(int distance)
	{
		
		/**
		*@param distance type entier naturel
		*@return le kilometrage apres incementation de distance
		*/
		
		/*verification du parametre					*/
		if (distance < 0)
		{
			distance = -distance;
		}
		
		this.kilometrage += distance;
		
		return this.kilometrage;
	}
	
	public void setProchaineVidange(Date p)
	{
		
		/**
		*@param p type Date
		*@return l'affectation de prochaineVidange par p
		*/
		
		this.prochaineVidange = p;
	}
	
	public String toString()
	{
		
		/**
		*@return la chaine de caractere associee au Moteur
		*/
		
		return "Km = "+this.kilometrage
				+" / date prochaine vidange : "+this.prochaineVidange.toString();
	}
}
