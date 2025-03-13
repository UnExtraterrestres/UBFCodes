class Voiture
{
	
	/*ATTRIBUTS						*/
	Moteur moteur;
	Personne conducteur;
	Personne[] passagers;
	int maxPassagers;
	int nbPassagers;
	
	/*CONSTRUCTEURS					*/
	public Voiture(Personne conducteur, Moteur moteur, int maxPassagers)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@param conducteur type Personne
		*@param moteur type Moteur
		*@param maxPassagers type entier naturel
		*@return l'affectation des attributs
		* par les valeurs specifiees
		*/
		
		this.conducteur = conducteur;
		this.moteur = moteur;
		this.maxPassagers = maxPassagers;
		
		this.passagers = new Personne[this.maxPassagers];
		
		/*par defaut il n'y a pas de passagers	*/
		this.nbPassagers = 0;
	}
	public Voiture()
	{
		
		/**
		*CONSTRUCTEUR par defaut
		*@return l'affectation par defaut des attributs
		* par appel du constructeur principal
		*/
		
		this(new Personne("Gosling", "Ryan", 1980), new Moteur(), 4);
	}
	
	/*METHODES						*/
	public int indiceLibre()
	{
		
		/**
		*@return l'indice de la premiere occurence null dans passagers
		* -1 s'il n'y a pas d'occurence de null
		*/
		
		for (int i=0; i<this.passagers.length; i++)
		{
			
			if (this.passagers[i] == null)
			{
				
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean ajoutPassager(Personne passager)
	{
		
		/**
		*@param passager type Personne
		*@return l'ajout de passager a passagers
		* vrai si effectue, faux sinon
		*/
		
		if (this.nbPassagers < this.maxPassagers)
		{
			this.passagers[this.indiceLibre()] = passager;
			this.nbPassagers ++;
			
			return true;
		}
		
		return false;
	}
	
	public void viderVoiture()
	{
		
		/**
		*@return l'affectation d'un tableau vide a passagers
		* l'affectation 
		*/
		
		this.passagers = new Personne[this.maxPassagers];
		this.nbPassagers = 0;
	}
	
	public String toString()
	{
		
		/**
		*@return la chaine de caractere associe aux Voitures
		*/
		
		String chaine = "Moteur : "+this.moteur.toString();
		chaine += "\nConducteur : "+this.conducteur.toString();
		chaine += "\nPassagers "+this.nbPassagers+"/"+this.maxPassagers;
		
		for (int i=0; i<this.nbPassagers; i++)
		{
			
			chaine += "\n\t"+this.passagers[i].toString();
		}
		
		return chaine;
	}
}
