public class Entree {
	
	//~ entree : chaine car_valides
	public char saisieCarDans(String car_valides) {
		//~ est retournee : la saisie d'un caractere parmis car_valides
		
		//~ declaration de la donnee
		char car;
		
		//~ saisie de la donnee
		Ecran.afficherln("entrez une lettre dans",  car_valides, " : ");
		car = Clavier.saisirChar();
		//~ verifier la saisie
		while (car_valides.indexOf(car) == -1) {
			//~ message d'erreur
			Ecran.afficherln("Erreur de saisie");
			//~ saisie de la donnee
			Ecran.afficherln("entrez une lettre dans",  car_valides, " : ");
			car = Clavier.saisirChar();
		}
		
		//~ renvois du resultat
		return car;
	}
	
	//~ entree : reel  borne_inf
	//~ entree : reel borne_sup
	//~ entree : chaine nom
	public double saisieDans() {
		//~ est retournee : la saisie d'un reel dans [borne_inf ; borne_sup]
		
		//~ declaration du resultat
		double nombre;
		
		//~ saisie du resultat
		Ecran.afficherln("Saisir un reel (", nom, ") dans |[", borneInf, ";", borneSup, "]| : ");
		nombre = Clavier.saisirDouble();
		//~ verification de la saisie
		while (!Testeur.estDans(nombre, borne_inf, borne_sup)) {
			//~ message d'erreur
			Ecran.afficherln("Erreur de saisie");
			//~ saisie du resultat
			Ecran.afficherln("Saisir un reel (", nom, ") dans |[", borneInf, ";", borneSup, "]| : ");
			nombre = Clavier.saisirDouble();
		}
		
		//~ revois du resultat
		return nombre;
	}
	
	//~ reel : entier borne_inf
	//~ reel : chaine nom
	public double saisieSup(double borne_inf, String nom) {
		//~ est retournee : la saisie d'un reel superieur a un autre
		
		//~ declaration du resultat
		double nombre;
		
		//~ saisie du resultat
		Ecran.afficherln("Saisir un nombre ("+ nom+ ") superieur ou egal a : "+ borne_inf);
		nombre = Clavier.saisirDouble();
		//~ verification de la saisie
		while (nombre < borne_inf) {
			//~ message d'erreur
			Ecran.afficherln("Erreur de saisie");
			//~ saisie du resultat
			Ecran.afficherln("Saisir un nombre ("+ nom+ ") superieur ou egal a : "+ borne_inf);
			nombre = Clavier.saisirDouble();
		}
		
		//~ renvois du resultat
		return nombre;
	}	

}
