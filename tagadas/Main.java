class Main
{
	
	public static boolean estDans(double nombre, double borne_inf ,double borne_sup) {
		
		/**
		*@param nombre type reel
		*@param borne_inf type reel
		*@param borne_sup type reel
		*@return vrai si nombre est compris entre borne_inf et _sup, faux sinon
		*/
		
		/*verification des arguments					*/
		if (borne_inf > borne_sup) {
			/*permutation necessaire				*/
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		return borne_inf <= nombre && nombre <= borne_sup;
	}
	
	public static double fraiseHorsNorme(EchantillonFraise echantillon, double min, double max)
	{
		
		/**
		*@param echantillon type EchantillonFraise
		*@param min type reel
		*@param max type reel
		*@return le pourcentage de valeur d'elements de echantillon.fraise non compris entre min et max
		*/
		
		int compteur = 0;
		
		for(int i = 0; i<echantillon.poids.length; i++)
		{
			if (!estDans(echantillon.poids[i], min, max))
			{
				compteur ++;
			}
		}
		
		return 100*compteur/echantillon.poids.length;
	}
	
	public static void main(String [] args)
	{
		
		/*calcul du pourcentage de fraise aux normes		*/
	}
}
