public class Main
{
	
	public static void printTable(int[] table)
	{
		/*
		*@param table type tableau d'entier
		*@return un affichage du detail du tableau
		*/
		
		System.out.println(" ");
		System.out.println("Detail de : " + table);
		System.out.println("taille : " + table.length);
		for (int i = 0; i < table.length; i++)
		{
			if (i % 5 == 0) {System.out.println(" ");}
			System.out.print(table[i] + " ");
		}
	}
	
	public static int[] add(int[] table, int num)
	{
		/*
		*@param table type tableau d'entier
		*@param num type entier
		*@return une copie de table, avec num ajoute a la fin
		*/
		
		int [] new_table = new int[table.length+1];
		
		/* copie des elements de table dans new_table */
		for (int i = 0; i < table.length; i++) {new_table[i] = table[i];}
		/* ajout de num a la suite */
		new_table[new_table.length-1] = num;
		
		return new_table;
	}
	
	public static boolean isPrime(int num)
	{
		/*
		*@param num type entier
		*@return vrai si num est premier, faux s'il est compose
		*/
		
		if (num < 2 || num % 2 == 0) {return false;}
		for (int i = 3; i < num; i += 2)
		{
			if (num % i == 0) {return false;}
		}
		return true;
	}
	
	public static int[] calcPrimes(int[] table, int lim)
	{
		/*
		*@param table type tableau d'entier
		*@param lim type entier
		*@return table a laquelle on ajoute les nombres jusqu'a lim
		*/
		
		for (int i = 0; i < lim; i++)
		{
			if (isPrime(i)) {table = add(table, i);}
		}
		
		return table;
	}
	
	
	public static void main(String[] args)
	{
		/* Nombres Premiers */
		
		
		/* declaration des donnees */
		int [] premiers = {};
		
		System.out.print("Saisir la limite : ");
		int limite = Clavier.saisirInt();
		
		/* calcul du resultat */
		premiers = calcPrimes(premiers, limite);
		
		/* affichage du resultat */
		printTable(premiers);
	}
}
 