public class Testeur
{
	
	public static boolean estDans(int borne_0, int borne_1, int nombre)
	{
		/**
		*@param borne_0 type entier relatif
		*@param borne_1 type entier relatif
		*@param nombre type entier relatif
		*@return vrai si nombre est compris entre borne_0 et borne_1, faux sinon
		*/
		
		/** verification des args 			*/
		if (borne_0 > borne_1)
		{
			/** permutation necessaire 		*/
			borne_0 += borne_1;
			borne_1 = borne_0 - borne_1;
			borne_0 -= borne_1;
		}
		
		return borne_0 <= nombre && nombre <= borne_1;
	}
}
