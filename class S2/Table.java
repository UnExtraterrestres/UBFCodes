public class Table
{
	
	public static <T> [] tableMode(int taille, int mode)
	{
		/**
		*@param taille type entier
		*@param mode type entier
		*@return un tableau de longueur taille, suivant le mode
		*/
		
		/*declaration du resultat						*/
		<T> [] table = new <T>[taille];
		
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
	
	public static void main(String [] args)
	{
		
		Ecran.afficherln("Test de la fonction de generation");
		double [] table = tableMode(10, -1);
	}
}
