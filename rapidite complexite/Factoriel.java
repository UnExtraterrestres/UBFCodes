class Factoriel
{
	
	public static int factorielRecursif(int racine)
	{
		
		/**
		*@param racine type entier naturel
		*@return racine*factorielRecursif(racine-1) si racine > 0
		* 1 sinon
		*/
		
		if (racine <= 1)
		{
			return 1;
		}
		return racine*factorielRecursif(racine-1);
	}
	
	public static int factorielSequentiel(int racine)
	{
		
		/**
		*@param racine type entier naturel
		*@return le factoriel de racine
		*/
		
		int factoriel = 1;
		
		if (racine > 1)
		{
			for (int i = 2; i<=racine; i++)
			{
				factoriel *= i;
			}
		}
		
		return factoriel;
	}
	
	public static void main(String[] args)
	{
		
		/*Mesure temps methode recusive				*/
		long debutRecursif = System.currentTimeMillis();
		System.out.println(factorielRecursif(5));
		System.out.println(System.currentTimeMillis() - debutRecursif);
		
		/*Mesure temps methode sequentielle			*/
		long debutSequentiel = System.currentTimeMillis();
		System.out.println(factorielSequentiel(5));
		System.out.println(System.currentTimeMillis() - debutSequentiel);
	}
}
