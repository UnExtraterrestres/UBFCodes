class Personne
{
	
	/* ATTRIBUTS							*/
	String nom, prenom;
	int anneeNaissance;
	
	final int ANNECOURANTE = 2023;
	
	/* CONSTRUCTEURS						*/
	public Personne(String nom, String prenom, int anneeNaissance)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@param nom type chaine de caractere
		*@param prenom type chaine de caractere
		*@param anneeNaissance type entier
		*@return l'affectation des attributs
		* par les valeurs specifiees
		*/
		
		this.nom = nom;
		this.prenom = prenom;
		this.anneeNaissance = anneeNaissance;
	}
	
	/*METHODES							*/
	public int getAge(int anneeCourrante)
	{
		
		/**
		*@param anneeCourrante type entier
		*@return l'age de la personne
		* comme diference de l'annee courrante par celle de naissance
		*/
		
		return ANNEECOURANTE - anneeNaissance;
	}
	
	public String toString()
	{
		
		/**
		*@return la chaine de caractere associee a Personne
		*/
		
		return this.prenom+"\t"+this.nom+"\t("+this.getAge(ANNECOURANTE)+" ans)";
	}
}
