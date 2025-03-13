class TriBulle
{
	
	public static int ordreChaine(String chn0, String chn1)
	{
		
		/**
		*@param chn0 type chaine de caractere
		*@param chn1 type chaine de caractere
		*@return -1, 0, 1 si les codes ASCII des differents caracteres des deux chaines
		*sont respectivements inferieurs, egaux ou superieur
		*/
		
		int longueur_min;
		if (chn0.length() < chn1.length())
		{
			longueur_min = chn0.length();
		} else
		{
			longueur_min = chn1.length();
		}
		
		for (int i = 0; i<longueur_min; i++)
		{
			
			if ((int)chn0.charAt(i) < (int)chn1.charAt(i))
			{
				return -1;
			} else if ((int)chn0.charAt(i) > (int)chn1.charAt(i)) {
				return 1;
			}
		}
		
		return 0;
	}
	
	public static void triBubulle(String[] table)
	{
		
		/**
		*@param table type tableau de chaines de caracteres
		*@return le tri de table, par bulle
		*/
		
		String auxiliaire;
		boolean permutation;
		int lim = table.length;
		
		do
		{
			
			permutation = false;
			for (int i = 0; i<lim-1; i++)
			{
				
				if (ordreChaine(table[i], table[i+1]) == -1)
				{
					
					auxiliaire = table[i];
					table[i] = table[i+1];
					table[i+1] = auxiliaire;
					permutation = true;
				}
			}
			
			lim--;
		} while (permutation);
	}
}
