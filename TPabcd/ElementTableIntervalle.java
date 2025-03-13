public class ElementTableIntervalle
{
	
	public static double[] genererTable(int longueur)
	{
		/**
		*@param longueur type entier naturel
		*@return un tableau de reels generes aleatoirement, d'une longueure specifie
		*/
		
		double [] tableau = new double[longueur];
		
		for (int i = 0; i<tableau.length; i++)
		{
			tableau[i] = Math.random();
		}
		
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
	
	public static double[] getDans(double [] tableau, double borne_inf, double borne_sup)
	{
		
		/**
		*@param tableau type tableau de reel
		*@param borne_inf type reel
		*@param borne_sup type reel
		*@return une tableau des valeurs de tableau comprises entre borne_inf et _sup
		*/
		
		/*verification des parametres			*/
		if (borne_inf > borne_sup)
		{
			/*permutation necessaire			*/
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		double [] valeurs = new double[tableau.length];
		
		for (int i = 0; i<tableau.length; i++)
		{
			if (borne_inf <= tableau[i] && tableau[i] <= borne_sup)
			{
				valeurs[i] = tableau[i];
			}
		}
		
		return valeurs;
	}
	
	/*programme principale					*/
	public static void main(String [] args)
	{
		/*
		*On considere un tableau de reel quelconques.
		*On souhaite afficher les valeurs de ce tableau comprises dans un intervalle
		*/
		
		double [] table = genererTable(20);
		
		afficherTable(table);
		
		double min;
		double max;
		
		Ecran.afficher("Entrer la borne inferieur (reel dans [0; 1]) : ");
		min = Clavier.saisirDouble();
		Ecran.afficher("Entrer la borne superieur (reel dans [0; 1]) : ");
		max = Clavier.saisirDouble();
		
		double [] filtre = getDans(table, min, max);
		
		afficherTable(filtre);
	}
}
