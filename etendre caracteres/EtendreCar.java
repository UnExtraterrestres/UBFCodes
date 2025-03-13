class EtendreCar
{
	
	public static void etendreChaine(String chaine, int nEtape)
	{
		
		/**
		*@param chaine type chaine de caractere
		*@param nEtape type entier naturel
		*@return l'affichage de l'etendue de chaine apres nEtapes
		*/
		
		if (nEtape == 0)
		{
			System.out.println(chaine);
		} else
		{
			String auxiliaire = "";
			for (int i = 0; i<chaine.length(); i++)
			{
				char car = chaine.charAt(i);
				
				if (car == 'a')
				{
					auxiliaire += "bc";
				} else if (car == 'b')
				{
					auxiliaire += "ca";
				} else if (car == 'c')
				{
					auxiliaire += 'a';
				}
			}
			
			etendreChaine(auxiliaire, nEtape-1);
		}
	}
	
	public static void main(String[] args)
	{
		
		/*Appel de la fonction					*/
		etendreChaine("a", 5);
	}
}
