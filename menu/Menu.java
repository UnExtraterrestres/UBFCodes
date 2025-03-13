public class Menu{
	
	public static void main(String args[]){
		// declaration des constantes et de la donnee
		final int borneInf = 10;
		final int borneSup = 50;
		char operation;
		// declaration des resultats
		int operande1, operande2;
		String egalite;
		
		// saisie de la donnee
		// saiside du choix operation
		Ecran.afficher("Choisissez une operation\n+: addition\n-: difference\n*: produit\n/: division entiere\n");
		operation = Clavier.saisirChar();
		
		// calcul des resultats
		// calcul des entiers aleatoires entre borne1 et borne2
		operande1 = borneInf + (int)(Math.random()*(borneSup - borneInf + 1 ));
		operande2 = borneInf + (int)(Math.random()*(borneSup - borneInf + 1 ));
		// calcul l'egalite en fonction du choix d'operation
		switch(operation){
			// addition
			case '+':
				egalite = operande1 + " " + operation + " " + operande2 + " = ";
				egalite += (operande1 + operande2);
			break;
			// difference
			case '-':
				egalite = operande1 + " " + operation + " " + operande2 + " = ";
				egalite += (operande1 - operande2);
			break;
			// produit
			case '*':
				egalite = operande1 + " " + operation + " " + operande2 + " = ";
				egalite += (operande1 * operande2);
			break;
			// division entiere
			case '/':
				egalite = operande1 + " " + operation + " " + operande2 + " = ";
				egalite += (operande1 / operande2);
			break;
			// operations non definis
			default:
				egalite = "Erreur de saisie : opperation impossible";
			break;
			
		}
		
		// affichage du resultat (de l'egalite ou du message d'erreur)
		Ecran.afficher(egalite);
		
	}
}
