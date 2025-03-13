public class Fusion
{
	
	public static int [] tableMode(int taille, int mode)
	{
		/**
		*@param taille type entier
		*@param mode type entier
		*@return un tableau de longueur taille, suivant le mode
		*/
		
		/*declaration du resultat				*/
		int [] table = new int[taille];
		
		switch (mode)
		{
			default: {
				/*affectation a 0						*/
				for (int i = 0; i < table.length; i++) {table[i] = 0;}
			} break;
		}
		
		/*renvois du resultat							*/
		return table;
	}
	
	public static int max(int [] table)
	{
		/**
		*@param table type tableau de reels
		*@return la valeur maximale de table
		*/
		
		int maximum = table[0];
		
		for (int i = 0; i<table.length; i++)
		{
			if (table[i] > maximum)
			{
				maximum = table[i];
			}
		}
		
		return maximum;
	}
	
	public static int [] classeurTable(int [] table)
	{
		/**
		*@param table type tableau de reels
		*@return un tableau de la repartition des valeurs de table
		*/
		
		/*declaration du resultat						*/
		int [] compteur = tableMode((int)max(table)+1, -1);
		
		/*calcul du resultat							*/
		for (int i = 0; i < table.length; i++) 
		{
			compteur[(int)table[i]] ++;
		}
		
		return compteur;
	}
	
	public static void afficherTable(int [] tableau)
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
	
	public static void afficherlnTable(int [] tableau)
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
	
	public static int [] ajouter(int nombre, int [] tableau)
	{
		
		/**
		*@param nombre type entier
		*@param tableau type tableau d'entier
		*@return un tableau fait des elements de tableau auquel est ajoute nombre
		*/
		
		int [] nouv_table = new int [tableau.length+1];
		
		for (int i = 0; i< tableau.length; i++)
		{
			nouv_table[i] = tableau[i];
		}
		nouv_table[nouv_table.length-1] = nombre;
		
		return nouv_table;
	}
	
	public static int [] etendre(int [] table0, int [] table1)
	{
		/**
		*@param table0 type tableau d'entier trie
		*@param table1 type tableau d'enter trie
		*@return l'extension de table0 par table1
		*/
		
		for (int i = 0; i<table1.length; i++)
		{
			table0 = ajouter(table1[i], table0);
		}
		
		return table0;
	}
	
	public static int [] fusionner(int [] table0, int [] table1)
	{
		/**
		*@param table0 type tableau d'entier trie
		*@param table1 type tableau d'entier trie
		*@return la fusion des deux tableaux triee
		*/
		
		int [] fusion = etendre(table0, table1);
		
		trierTable(fusion);
		
		return fusion;
	}
	
	public static void trierTable(int [] tableau)
	{
		/**
		*@param tableau type tableau d'entier
		*@return le tri de tableau dans l'ordre croissant
		*/
		
		int [] classeur = classeurTable(tableau);
		int pointeur = 0;
		
		for (int i = 0; i<classeur.length; i++)
		{
			for (int j = 0; j<classeur[i]; j++)
			{
				tableau[pointeur] = i;
				pointeur ++;
			}
		}
	}
	
	public static int [] tableEntier(int taille)
	{
		/**
		*@param taille type entier naturel
		*@return un tableau des premiers entiers de 0 a taille-1
		*/
		
		int [] tableau = new int [taille];
		
		for (int i = 0; i<tableau.length; i++)
		{
			tableau[i] = i;
		}
		
		return tableau;
	}
	
	public static void main(String [] args)
	{
		/*fonction de fusion de deux tableaux d'entiers tries		*/
		
		int [] tableau0 = tableEntier(10);
		afficherTable(tableau0);
		int [] tableau1 = tableEntier(15);
		afficherTable(tableau1);
		
		int [] fusion_tables = fusionner(tableau0, tableau1);
		afficherTable(fusion_tables);
	}
}
