public class Generateur {
	
	/**
	* @param borne_inf type entier borne inferieure de l'intervalle
	* @param borne_sup type entier borne superieure de l'intervalle
	*/
	public static int dans(int borne_inf, int borne_sup) {
		/**
		* @return retourne un entier tire aleatoirement dans |[borne_inf; borne_sup]|
		*/
		
		/**
		* verification des arguments
		*/
		if (borne_inf > borne_sup) {
			/**
			* on permute les deux bornes
			*/
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf = borne_inf - borne_sup;
		}
		
		/**
		* renvois du resultat (non stocke)
		*/
		return borne_inf + (int)(Math.random()*(borne_sup - borne_inf + 1));
	}
}
