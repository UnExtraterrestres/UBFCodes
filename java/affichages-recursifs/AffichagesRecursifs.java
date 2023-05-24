class AffichagesRecursifs
{
	
	public static void affichageDesCroissants(int nombre)
	{
		
		/**
		*@param nombre type entier positif
		*@return s'il est positif : l'affichage de nombre, s'il l'est strictement
		* l'appel de cette fonction pour nombre-1
		*/
		
		System.out.println(nombre);
		
		if (nombre > 0)
		{
			affichageDesCroissants(nombre - 1);
		}
	}
	
	public static void affichageCroissant(int racine, int limite)
	{
		
		/**
		*@param racine type entier naturel
		*@param limite type entier naturel
		*@return s'il est positif : l'affichage de nombre
		*s'il est inferieur a limite
		*/
		
		System.out.println(racine);
		
		if (racine < limite)
		{
			affichageCroissant(racine+1, limite);
		}
	}
	
	public static void affichageCroissant(int limite)
	{
		
		/**
		*@param limite type entier naturel
		*@return lance pour racine=0, l'action recursive affichageCroissant
		*/
		
		if (limite > 0)
		{
			affichageCroissant(0, limite);
		}
	}
	
	public static void affichageDesCroisCrois(int nombre)
	{
		
		/**
		*@param nombre type entier naturel
		*@return l'affichage DesCroissant puis Croissant avec nombre comme limite
		*/
		
		System.out.println(nombre);
		
		if (nombre > 0)
		{
			affichageDesCroisCrois(nombre - 1);
		}
		
		System.out.println(nombre);
	}
	
	public static void affichageCroisDesCrois(int racine, int limite)
	{
		
		/**
		*@param racine type entier naturel
		*@param limite type entier naturel
		*@return s'il est positif : l'affichage de nombre
		*s'il est inferieur a limite
		*/
		
		System.out.println(racine);
		
		if (racine < limite)
		{
			affichageCroisDesCrois(racine+1, limite);
		}
		
		System.out.println(racine);
	}
	
	public static void affichageCroisDesCrois(int limite)
	{
		
		/**
		*@param limite type entier naturel
		*@return lance pour racine=0, l'action recursive affichageCroissant
		*/
		
		if (limite > 0)
		{
			affichageCroisDesCrois(0, limite);
		}
	}
	
	public static void afficherChiffres(int racine)
	{
		
		/**
		*@param racine type entier
		*@return chaque chiffre de racine
		*en finissant par les unites
		*/
		
		if (racine > 10)
		{
			afficherChiffres((int)(racine/10));
		}
		
		System.out.println(racine%10);
	}
	
	
	public static void main(String[] args)
	{
		
		/*Affichage en ordre decroissant d'entiers consecutifs				*/
		System.out.println("Affichage des croissants");
		affichageDesCroissants(10);
		System.out.println("");
		
		/*Affichage en ordre croissant d'entiers consecutifs					*/
		System.out.println("Affichage Croissant");
		affichageCroissant(10);
		System.out.println("");
		
		/*Affichage en ordres decroissant puis croissant d'entiers consecutifs		*/
		System.out.println("Affichages des croissants puis croissant");
		affichageDesCroisCrois(5);
		System.out.println("");
		
		/*Affichage en ordres croissant puis decroissant d'entiers consecutifs		*/
		System.out.println("Affichages croissant puis des croissants");
		affichageCroisDesCrois(5);
		System.out.println("");
		
		/*Affichage individuel des chiffres d'un entier						*/
		System.out.println("Affichage des chiffres");
		afficherChiffres(86533);
		System.out.println("");
	}
}
