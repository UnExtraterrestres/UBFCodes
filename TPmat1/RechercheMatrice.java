class RechercheMatrice
{
	
	public static Minimum min(int[][] matrice)
	{
		
		/**
		*@param matrice type tableau de tableau d'entier
		*@return un Minimum correspondant au minimum contenu dans matrice
		*/
		
		Minimum min = new Minimum();
		
		for (int i = 0; i<matrice.length; i++)
		{
			
			for (int j = 0; j<matrice[i].length; j++)
			{
				if (min.valeur < matrice[i][j])
				{
					
				}
			}
		}
		
		return min;
	}
	
	public static void main(String[] args)
	{
		
		int[][] mat_test = {
			{8, 1, 4},
			{7, 9, 0},
			{-6, 6, 0}
			};
		min(mat_test).afficher();
	}
}
