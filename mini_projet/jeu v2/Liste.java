public class Liste {
	
	/**
	* @param racine type entier nombre de reference
	* @param index type entier curseur de lecture de la racine
	* @param longueur type entier nombre de chiffre a lire sur racine depuis index
	*/
	public static int lireEn(long racine, int index, int longueur) {
		/**
		* @return retourne le nombre lu depuis index long de "longueur"
		*/
		
		/**
		* renvois du resultat (no stocke)
		*/
		return (int)(racine/(int)Math.pow(10, index)) % (int)Math.pow(10, longueur);
	}
	
	/**
	* @param nombre type entier nombre concerne par le calcul de la taille
	*/
	public static int taille(long nombre) {
		/**
		* @return retourne le nombre de chiffre de nombre
		*/
		
		/**
		* declaration et affectation du resultat
		*/
		int taille = 0;
	
		/**
		* calcul du resultat
		*/
		while (nombre != (nombre % (long)Math.pow(10, taille))) {
			taille ++;
		}
		
		if (nombre == 0) {
			taille = 1;
		}
		
		/**
		* renvois du resultat
		*/
		return taille;
	}
	
	/**
	* @param nombre type entier nombre a ajouter derriere racine
	* @param racine type entier nombre de reference
	*/
	public static long ajouter(long nombre, long racine) {
		/**
		* @return ajoute nombre a la fin de racine, puis retourne le resultat
		*/
		
		/**
		* calcul du resultat
		*/
		racine += nombre*(long)Math.pow(10, taille(racine));
		
		/**
		* renvois du resultat
		*/
		return racine;
	}
	
	/**
	* @param nombre type entier nombre a ajouter a racine en index
	* @param racine type entier nombre de reference
	* @param index type entier nombre curseur
	*/
	public static long ajouter(int nombre, long racine, int index) {
		/**
		* @return ajoute nombre en index a racine, puis retourne le resultat
		*/
	
		/**
		* renvois du resultat (non stocke)
		*/
		return ajouter(ajouter((long)lireEn(racine, index, taille(racine)), nombre), (long)lireEn(racine, 0, index));
	}
	
	/**
	* @param racine type entier nombre de reference
	* @param index type entier nombre curseur
	* @param nombre type entier nombre par lelquel modifier l'autre
	*/
	public static long changer(long racine, int index, int nombre) {
		/**
		*@return change la valeur de la racine en index par nombre, puis retourne le resultat
		*/
		
		Ecran.afficherln("racine : ", racine);
		Ecran.afficherln("retirer : ", Liste.retirer(racine, index));
		Ecran.afficherln("changer : ", Liste.changer(racine, index, nombre));
		
		/**
		* renvois du resultat (non stocke)
		*/
		if (index != 0) {
			return Liste.ajouter(nombre, Liste.retirer(racine, index), index);
		} else {
			return (long)(Liste.ajouter(nombre, Liste.retirer(racine, index), index) / 10);
		}
	}
	
	/**
	* @param racine type entier nombre de reference
	* @param index type entier nombre curseur
	*/
	public static long retirer(long racine, int index) {
		/**
		* @return retire la valeur de racine en index, puis retourne le resultat
		*/
		
		/**
		* renvois du resultat (non stocke)
		*/
		if (index != 0) {
			return Liste.ajouter(Liste.lireEn(racine, index+1, Liste.taille(racine)-index+1), Liste.lireEn(racine, 0, index));
		} else {
			return (long)(Liste.ajouter(Liste.lireEn(racine, index+1, Liste.taille(racine)-index+1), Liste.lireEn(racine, 0, index)) / 10);
		}
	}
}
