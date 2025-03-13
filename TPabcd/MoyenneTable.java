public class MoyenneTable
{
	
	public static double sommeTable(double [] table)
	{
		/**
		*@param table type tableau de reel
		*@return la somme des elements de table
		*/
		
		/*declaration du resultat					*/
		double somme = 0;
		
		/*calcul du resultat						*/
		for (int i = 0; i < table.length ; i++) {somme += table[i];}
		
		/*renvois du resultat						*/
		return somme;
	}
	
	public static double moyenneTable(double [] table)
	{
		/**
		*@param table type tableau de reel
		*@return la moyenne des elements de table
		*/
		
		return sommeTable(table) / table.length;
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
				for (int i = 0; i < table.length; i++) {table[i] = 0;}
			} break;
		}
		
		/*renvois du resultat							*/
		return table;
	}
	
	/*action principale							*/
	public static void main(String [] args)
	{
		
		/*declaration de la constante et des donnes		*/
		double [] table = tableMode(20, 1);
		
		/*declaration du resultat					*/
		double moy;
		
		/*calcul du resultat						*/
		moy = moyenneTable(table);
		
		/*affichage du resultat						*/
		Ecran.afficherln("Moyenne de la table : ", moy);
	}
}
