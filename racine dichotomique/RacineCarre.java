class RacineCarre
{
	
	public static final double EPSILON = 0.0000000000001;
	
	public static double racineDichotomie(double nombre, double borne_inf, double borne_sup)
	{
		
		/**
		*@param nombre type reel positif
		*@param borne_inf type reel positif
		*@param borne_sup type reel positif
		*@return la racine carre de nombre par une methide recursive
		*/
		
		/*verification des bornes							*/
		if (borne_inf > borne_sup)
		{
			/*permutation des valeurs des bornes				*/
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		double racine;
		double borne_moy = (borne_inf+borne_sup) / 2.0;
		
		if (borne_sup-borne_inf > EPSILON)
		{
			if (borne_moy*borne_moy > nombre)
			{
				racine = racineDichotomie(nombre, borne_inf, borne_moy);
			} else
			{
				racine = racineDichotomie(nombre, borne_moy, borne_sup);
			}
		} else
		{
			racine = borne_moy;
		}
		
		return racine;
	}
	
	public static void main(String[] args)
	{
		
		double nombre = Math.random()*100;
		
		System.out.println("Racine carre par dichotomie de " + nombre + " : \n" + racineDichotomie(nombre, 0.0, 100.0));
	}
}
