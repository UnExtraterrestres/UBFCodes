import java.util.Scanner;


public class Entree {
	
	//~ Classe contenant les fonctions de saisies valides fondamentales
	
	//~ parametre
	static Scanner scan = new Scanner(System.in);
	
	//~ entree : chaine car_valides
	public static char saisieCarDans(String car_valides) {
		//~ est retournee : la saisie d'un caractere parmis car_valides
		
		//~ declaration de la donnee
		char car;
		
		//~ saisie de la donnee
		System.out.println("entrez une lettre dans",  car_valides, " : ");
		car = this.scan.nextChar();
		//~ verifier la saisie
		while (car_valides.indexOf(car) == -1) {
			//~ message d'erreur
			System.out.println("Erreur de saisie");
			//~ saisie de la donnee
			System.out.println("entrez une lettre dans",  car_valides, " : ");
			car = this.scan.nextChar();
		}
		
		//~ renvois du resultat
		return car;
	}
	
	//~ entree : reel  borne_inf
	//~ entree : reel borne_sup
	//~ entree : chaine nom
	public static double saisieDans() {
		//~ est retournee : la saisie d'un reel dans [borne_inf ; borne_sup]
		
		//~ declaration du resultat
		double nombre;
		
		//~ saisie du resultat
		System.out.println("Saisir un reel (", nom, ") dans |[", borneInf, ";", borneSup, "]| : ");
		nombre = this.scan.nextDouble();
		//~ verification de la saisie
		while (!Testeur.estDans(nombre, borne_inf, borne_sup)) {
			//~ message d'erreur
			System.out.println("Erreur de saisie");
			//~ saisie du resultat
			System.out.println("Saisir un reel (", nom, ") dans |[", borneInf, ";", borneSup, "]| : ");
			nombre = this.scan.nextDouble();
		}
		
		//~ revois du resultat
		return nombre;
	}
	
	//~ reel : entier borne_inf
	//~ reel : chaine nom
	public static double saisieSup(double borne_inf, String nom) {
		//~ est retournee : la saisie d'un reel superieur a un autre
		
		//~ declaration du resultat
		double nombre;
		
		//~ saisie du resultat
		System.out.println("Saisir un nombre ("+ nom+ ") superieur ou egal a : "+ borne_inf);
		nombre = this.scan.nextDouble();
		//~ verification de la saisie
		while (nombre < borne_inf) {
			//~ message d'erreur
			System.out.println("Erreur de saisie");
			//~ saisie du resultat
			System.out.println("Saisir un nombre ("+ nom+ ") superieur ou egal a : "+ borne_inf);
			nombre = this.scan.nextDouble();
		}
		
		//~ renvois du resultat
		return nombre;
	}	

}
