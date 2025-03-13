public class Generateur {
	
	//~ Classe contenant les fonctions de generation fondamentales
	
	//~ entree : entier jour
	public static String jourDepuisEntier(int jour) {
		//~ est retourne : le jour en lettre
		
		//~ declaration du resultat
		String jour_chaine = "";
		
		// calcul du resultat
		switch (jour) {
			
			case 1: {
				jour_chaine = "lundi";
			} break;
			
			case 2: {
				jour_chaine = "mardi";
			} break;
			
			case 3: {
				jour_chaine = "mercredi";
			} break;
			
			case 4: {
				jour_chaine = "jeudi";
			} break;
			
			case 5: {
				jour_chaine = "vendredi";
			} break;
			
			case 6: {
				jour_chaine = "samedi";
			} break;
			
			case 7: {
				jour_chaine = "dimanche";
			} break;
			
			default: {
				jour_chaine = "erreur";
			} break;
		}
		
		//~ renvois du resultat
		return jour_chaine;
	}	
	
	//~ entree : entier mois
	public static String moisDepuisEntier(int mois) {
		//~ est retourne : le mois en lettre
		
		// declaration du resultat
		String mois_chaine = "";
		
		//~ calcul du resultat
		switch (mois) {
			case 1: {
				mois_chaine = " janvier ";
			} break;
			case 2: {
				mois_chaine = " fevrier ";
			} break;
			case 3: {
				mois_chaine = " mars ";
			} break;
			case 4: {
				mois_chaine = " avril ";
			} break;
			case 5: {
				mois_chaine = " mai ";
			} break;
			case 6: {
				mois_chaine = " juin ";
			} break;
			case 7: {
				mois_chaine = " juillet ";
			} break;
			case 8: {
				mois_chaine = " aout ";
			} break;
			case 9: {
				mois_chaine = " septembre ";
			} break;
			case 10: {
				mois_chaine = " octobre ";
			} break;
			case 11: {
				mois_chaine = " novembre ";
			} break;
			case 12: {
				mois_chaine = " decembre ";
			} break;
			default: {
				mois_chaine = " erreur ";
			} break;
		}
		
		//~ renvois du resultat
		return mois_chaine;
		
	}
	
	//~ entree : caractere car
	//~ entree : entier longueur
	public static String chaineDepuisCar(char car, int longueur) {
		//~ est retournee : une chaine de taille longueur de car
		
		//~ declaration du resultat
		String chaine = "";
		//~ declaration du compteur
		int i;
		
		//~ calcul du resultat
		for (i=0; i<=longueur; i++) {
			chaine += car;
		}
		
		//~ renvois du resultat
		return chaine;
	}
	
	//~ entree : reel borne_inf
	//~ entree : reel borne_sup
	public static double reelDans(double borne_inf, double borne_sup) {
		//~ est retourne : un reel tire aleatoirement dans [borne_inf ; borne_sup[
		
		//~ verification des arguments
		if (borne_inf > borne_sup) {
			//~ permutation
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		//~ renvois du resultat (non stocke)
		return borne_inf + Math.random()*(borne_sup - borne_inf);
	}
	
}
