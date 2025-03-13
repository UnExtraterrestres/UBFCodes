public class GenerationTable
{
	
	//~ entree : reel borne_inf
	//~ entree : reel borne_sup
	public static double reelDans(double borne_inf, double borne_sup) {
		//~ est retourne : un reel tire aleatoirement dans [borne_inf ; borne_sup[
		
		//~ verification des arguments
		if (borne_inf > borne_sup) {
			//~ permutation
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		//~ renvois du resultat (non stocke)
		return borne_inf + Math.random()*(borne_sup - borne_inf);
	}
	
	public static void initialiserTable(double [] tableau, double max)
	{
		/**
		*@param tableau type tableau de reel
		*@return l'initialisation des elements de table,
		*<br> par des valeurs aleatoires entre 0 et max
		*/
		
		for (int i = 0; i<tableau.length; i++)
		{
			tableau[i] = reelDans(0, max);
		}
	}
	
	public static double[] genererTable(int longueur, double max)
	{
		/**
		*@param longueur type entier naturel
		*@param max type reel
		*@return un tableau de reels generes aleatoirement entre 0 et max, d'une longueure specifiee
		*/
		
		double [] tableau = new double[longueur];
		
		initialiserTable(tableau, max);
		
		return tableau;
	}
	
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
	
	public static void main(String [] args)
	{
		/*initialiser un tableau	entre 0 max		*/
		/*generer un tableau	entre 0 max 		*/
		/*affichages d'un tableau				*/
		
		double [] table = new double [20];
		
		initialiserTable(table, 60.0);
		
		afficherlnTable(table);
	}
}
