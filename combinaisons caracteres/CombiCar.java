class CombiCar
{
	
	public static void combinaisons(int n, String prefixe)
	{
		
		/**
		*@param n type entier naturel
		*@param prefixe type chaine de caracteres
		*@return l'affichage de toutes les combinaisons de n caracteres
		*/
		
		if (n == 0) {
			
			System.out.println(prefixe);
		} else
		{
			for (char c = 'a'; c <= 'z'; c++)
			{
				
				combinaisons(n - 1, prefixe + c);
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		/*Appel de la fonction					*/
		combinaisons(3, "");
	}
}
