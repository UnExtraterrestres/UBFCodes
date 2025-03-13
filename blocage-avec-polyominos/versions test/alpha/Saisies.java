/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Saisies
{
	
	/*ATTRIBUTS			*/
	/*CONSTRUCTEURS		*/
	/*METHODES			*/
	public static int entierEntre(int borneInf, int borneSup)
	{
		
		/**
		*@param borneInf type entier
		*@param borneSup type entier
		*@return une saisie d'un entier entre les bornes specifiees
		*/
		
		/*test de permutation		*/
		if (borneInf>borneSup)
		{
			borneInf += borneSup;
			borneSup = borneInf-borneSup;
			borneInf -= borneSup;
		}
		
		System.out.println("entier compris entre "+borneInf+" et "+borneSup);
		int saisie = Clavier.saisirInt();
		
		while(saisie<borneInf || borneSup<saisie)
		{
			
			/*message d'erreur		*/
			System.out.print("Erreur de saisie : vous n'avez pas saisie un ");
			saisie = entierEntre(borneInf, borneSup);
		}
		
		return saisie;
	}
	
	public static String nomHumain()
	{
		
		/**
		*@return la saisie d'un nom
		*/
		
		System.out.println("Entrez le nom du joueur : ");
		return Clavier.saisirString();
	}
}
