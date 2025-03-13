public class NbValeurInfLim
{
	
	public static int nbInfA(double max, double [] table)
	{
		/**
		*@param max type reel
		*@param table type tableau de reels
		*@return le nombre d'elements de table inferieurs a max
		*/
		
		/*declaration du resultat				*/
		int compteur = 0;
		
		/*calcul du resultat					*/
		for (int i = 0; i < table.length; i++)
		{
			if (table[i] <= max) {compteur ++;}
		}
		
		/*renvois du resultat					*/
		return compteur;
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
	
	/*action principale						*/
	public static void main(String [] args)
	{
		
		/*declaration de la constante et des donnes	*/
		double [] table = tableMode(20, 1);
		double max;
		
		/*declaration du resultat				*/
		int compteur;
		
		/*saisie des donnees					*/
		Ecran.afficher("Entrer la valeur maximale (reel positif inf a 1) : ");
		max = Clavier.saisirDouble();
		
		/*calcul du resultat					*/
		compteur  = nbInfA(max, table);
		
		/*affichage du resultat					*/
		Ecran.afficherln("Nombre d'elements inferieurs a ", max, " : ", compteur);
	}
}
