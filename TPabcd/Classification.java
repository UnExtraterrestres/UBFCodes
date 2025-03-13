public class Classification
{
	
	public static void afficherTable(double [] tableau)
	{
		/**
		*@param tableau type tableau de reel
		*@return l'affichage des valeurs des elements de tableau sur une ligne
		*/
		
		for (int i = 0; i<tableau.length; i++)
		{
			System.out.print(tableau[i] + " ");
		}
		System.out.println(" ");
	}
	
	public static void afficherlnTable(double [] tableau)
	{
		/**
		*@param tableau type tableau de reel
		*@return l'affichage des valeurs des elements de tableau sur une ligne
		*/
		
		for (int i = 0; i<tableau.length; i++)
		{
			System.out.println(tableau[i] + " ");
		}
	}
	
	public static double [] tableMode(int taille, int mode)
	{
		/**
		*@param taille type entier
		*@param mode type entier
		*@return un tableau de longueur taille, suivant le mode
		*/
		
		/*declaration du resultat				*/
		double [] table = new double[taille];
		
		switch (mode)
		{
			case 0: {
				/*affectation a 0						*/
				for (int i = 0; i < table.length; i++) {table[i] = Math.random()*20;}
			} break;
			case 1: {
				/*affectation a 0						*/
				for (int i = 0; i < table.length; i++) {table[i] = Math.random();}
			} break;
			default: {
				/*affectation a 0						*/
				for (int i = 0; i < table.length; i++) {table[i] = 0.0;}
			} break;
		}
		
		/*renvois du resultat							*/
		return table;
	}
	
	public static double max(double [] table)
	{
		/**
		*@param table type tableau de reels
		*@return la valeur maximale de table
		*/
		
		double maximum = table[0];
		
		for (int i = 0; i<table.length; i++)
		{
			if (table[i] > maximum)
			{
				maximum = table[i];
			}
		}
		
		return maximum;
	}
	
	public static double [] classeurTable(double [] table)
	{
		/**
		*@param table type tableau de reels
		*@return un tableau de la repartition des valeurs de table
		*/
		
		/*declaration du resultat						*/
		double [] compteur = tableMode((int)max(table)+1, -1);
		
		/*calcul du resultat							*/
		for (int i = 0; i < table.length; i++) 
		{
			compteur[(int)table[i]] ++;
		}
		
		return compteur;
	}
	
	/*action principale								*/
	public static void main(String [] args)
	{
		
		/*declaration de la constante et des donnees			*/
		double [] table = tableMode(20, 0);
		
		/*declaration du resultat						*/
		double [] classeur = classeurTable(table);
		
		/*affichage du resultat							*/
		Ecran.afficherln("Repartition : ");
		afficherTable(classeur);
	}
}
