public class Testeur {
	
	//~ entree : reel nombre
	//~ entree : reel borne_inf
	//~ entree : reel borne_sup
	public boolean estDans(double nombre, double borne_inf ,double borne_sup) {
		//~ est retourne : vrai si nombre est dans [borne_inf ; borne_sup]
		
		//~ verification des arguments
		if (borne_inf > borne_sup) {
			//~ permutation
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		//~ renvois du resultat (non stocke)
		return borne_inf <= nombre && nombre <= borne_sup;
	}
	
	public boolean estDans(char [] tableau, char caractere)
	{
		
		/**
		*@param tableau type tableau de caractere
		*@param caractere type caractere
		*@return vrai si la valeur d'au moins un element de tableau 
		* est egal a caractere, faux sinon
		*/
		
		for (int i = 0; i<tableau.length; i++)
		{
			if ((int)tableau[i] == (int)caractere)
			{
				return true;
			}
		}
		
		return false;
	}
	
	//~ entree : entier dividende
	//~ entree : entier diviseur
	public boolean estMultiple(int dividende, int diviseur) {
		//~ est retourne : vrai si le reste est nul, faux sinon
		
		//~ renvois du resultat (non stocke)
		return dividende % diviseur == 0;
	}
	
	//~ entree : entier annee
	public  boolean estBisextile(int annee) {
		//~ est retourne : vrai si annee est bisextile, faux sinon
		
		//~ declaration du resultat
		boolean bisextile = false;
		
		//~ calcul du resultat
		if (estMultiple(annee, 4) && !estMultiple(annee, 100) || estMultiple(annee, 400)) {
			bisextile = true;
		}
		
		//~ renvois du resultat
		return bisextile;
		
	}
	
}
