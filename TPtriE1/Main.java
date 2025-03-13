class Main
{
	
	public static boolean[] convertChaineABool(String chaine)
	{
		
		/**
		*@param chaine type chaine de caractere
		*@return un tableau de booleen cree a partir de chaine
		*/
		
		boolean [] table = new boolean[chaine.length()];
		
		for (int i = 0; i<table.length; i++)
		{
			if (chaine.charAt(i) == '1')
			{
				table[i] = true;
			} else {
				table[i] = false;
			}
		}
		
		return table;
	}
	
	public static boolean genererBool(int part_vrai)
	{
		
		/**
		*@param part_vrai type entier naturel
		*@return vrai ou faux aleatoirement, en prenant en compte la part de vrais
		*/
		
		if (Math.random()*(100) < part_vrai)
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	public static boolean[] genererTableBool(int longueur, int part_vrai)
	{
		
		/**
		*@param longueur type entier naturel
		*@param part_vrai type entier naturel
		*@return un tableau de booleen de longueur specifie
		*<br> les booleens sont choisit aleatoirement entre vrai et faux
		*/
		
		boolean[] table = new boolean[longueur];
		
		for (int i =0; i<table.length; i++)
		{
			
			table[i] = genererBool(part_vrai);
		}
		
		return table;
	}
	
	public static int afficherBool(boolean bool)
	{
		
		/**
		*@param bool type booleen
		*@return 1 si bool est vrai, 0 sinon
		*/
		
		if (bool)
		{
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void afficherTable(boolean[] table)
	{
		
		/**
		*@param table type tableau de booleens
		*@return l'affichage des valeurs du tableau sur une ligne
		*/
		
		for (int i = 0; i<table.length; i++)
		{
			System.out.print(afficherBool(table[i]) + " ");
		}
		
		System.out.println(" ");
	}
	
	public static int compteurVrai(boolean[] table)
	{
		
		/**
		*@param table type tableau de booleens
		*@return le nombre d'element ayants pour valeur : vrai
		*/
		
		if (table.length==0)
		{
			return 0;
		}
		
		int compteur = 0;
		
		for (int i = 0; i<table.length; i++)
		{
			
			if (table[i])
			{
				compteur++;
			}
		}
		
		return compteur;
	}
	
	public static int compteurSerie(boolean[] table)
	{
		
		/**
		*@param table type tableau de booleens
		*@return le nombre de serie de vrai et de faux consecutives
		*contenues dans table
		*/
		
		if (table.length==0)
		{
			return 0;
		}
		
		int compteur = 1;
		
		for (int i = 0; i<table.length-1; i++)
		{
			if (table[i] != table[i+1])
			{
				compteur++;
			}
		}
		
		return compteur;
	}
	
	public static int longueurMaxSerie(boolean[] table)
	{
		
		/**
		*@param table type tableau de booleens
		*@return la longueur maximale des series de vrai
		*contenue dans table
		*/
		
		if (table.length==0)
		{
			return 0;
		}
		
		int long_max = 0;
		int long_cour = 1;
		
		for (int i = 0; i<table.length-1; i++)
		{
			
			if (table[i] && table[i+1])
			{
				long_cour ++;
			} else
			{
				if (long_cour > long_max)
				{
					long_max = long_cour;
				}
				long_cour = 1;
			}
		}
		
		return long_max;
	}
	
	public static int egalAMotif(boolean[] motif, boolean[] table, int indice)
	{
		
		/**
		*@param motif type tableau de booleens
		*@param table type tableau de booleens
		*@param indice type entier naturel inferieur a table.length - motif.length
		*@return indice si motif est dans table a l'indice specifie, -1 sinon
		*/
		
		if (indice > table.length-motif.length)
		{
			return -1;
		}
		
		for (int i = 0; i<motif.length; i++)
		{
			if (motif[i] != table[indice+i])
			{
				return -1;
			}
		}
		
		return indice;
	}
	
	public static int motifA(boolean[] motif, boolean[] table)
	{
		
		/**
		*@param motif type tableau de booleens
		*@param table type tableau de booleens
		*@return la premiere occurence de motif dans table, -1 s'il napparait pas
		*/
		
		int occurence;
		
		for (int i = 0; i<table.length; i++)
		{
			
			occurence = egalAMotif(motif, table, i);
			
			if (occurence != -1)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		
		boolean[] tab_bool = genererTableBool(10, 70);
		
		System.out.println("Table : ");
		afficherTable(tab_bool);
		
		boolean [] motif_bool = genererTableBool(2, 50);
		
		System.out.println("Motif : ");
		afficherTable(motif_bool);
		
		System.out.println("Nombre de vrais dans le tableau : " + compteurVrai(tab_bool));
		System.out.println("Nombre de serie de v/f consecutives : " + compteurSerie(tab_bool));
		System.out.println("Longueur maximale d'une serie de vrai : " + longueurMaxSerie(tab_bool));
		System.out.println("Indice de premiere occurence de motif : " + motifA(motif_bool, tab_bool));
		
		System.out.println("Convetion d'une chaine de 0/1 en table de booleens : ");
		afficherTable(convertChaineABool("110001"));
	}
}
