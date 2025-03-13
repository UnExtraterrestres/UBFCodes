public class Saisie
{
	
	public static int dans(int borne_0, int borne_1)
	{
		/**
		*@param borne_0 type entier relatif
		*@param borne_1 type entier relatif
		*@return la saisie d'un entier dans l'intervalle |[borne_0, borne_1]|
		*/
		
		/** verification des args 			*/
		if (borne_0 > borne_1)
		{
			/** permutation necessaire		 */
			borne_0 += borne_1;
			borne_1 = borne_0 - borne_1;
			borne_0 -= borne_1;
		}
		
		int nombre; /** declaration du resultat 	*/
		
		Ecran.afficherln("(entier dans |[", borne_0, " ; ", borne_1, "]| )");
		nombre = Clavier.saisirInt();
		
		while (!Testeur.estDans(borne_0, borne_1, nombre)) /** verificaction de la saisie	 */
		{
			Ecran.afficherln("ErreurSaisie : ", nombre, " n'est pas compris dans ", "|[", borne_0, " ; ", borne_1, "]|");
			nombre = dans(borne_0, borne_1);
		}
		
		return nombre;
	}
	
	public static int dans(int borne)
	{
		/**
		*@param borne type entier relatif
		*@return la saisie d'un entier entre 0 et borne
		*/
		
		return Saisie.dans(0, borne);
	}
}
