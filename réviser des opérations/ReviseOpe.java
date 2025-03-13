public class ReviseOpe
{
	
	public static void main(String args[]){
		
		// declaration des constantes et de la donnee
		final int borneInf = 10;
		final int borneSup = 50;
		char operation;
		int reponseUtil;
		// declaration des resultats
		int operande1, operande2;
		int reponseOrdi = 0;
		
		// saisie de la donnee
		// saiside du choix operation
		System.out.println("Choisissez une operation\n+: addition\n-: difference\n*: produit\n/: division entiere");
		operation = Clavier.saisirChar();
		
		// calcul des resultats
		// calcul des entiers aleatoires entre borne1 et borne2
		operande1 = borneInf + (int)(Math.random()*(borneSup - borneInf + 1 ));
		operande2 = borneInf + (int)(Math.random()*(borneSup - borneInf + 1 ));
		
		// calcul l'egalite en fonction du choix d'operation
		switch(operation){
			
			// addition
			case '+':
				reponseOrdi = operande1 + operande2;
			break;
			
			// difference
			case '-':
				reponseOrdi = operande1 - operande2;
			break;
			
			// produit
			case '*':
				reponseOrdi = operande1 * operande2;
			break;
			
			// division entiere
			case '/':
				reponseOrdi = operande1 / operande2;
			break;
			
			// operations non definis
			default:
				System.out.println("Erreur de saisie : opperation impossible");
			break;
			
		}
		
		if (operation == '+' || operation == '-' || operation == '*' || operation == '/'){
			// affiche le calcul a faire
			// saisie de la donnee (entier relatif)
			Ecran.afficher(operande1 + " " + operation + " " +  operande2 + " =");
			reponseUtil = Clavier.saisirInt();
		
			// comparaison des reponses Ordinateur et Utilisateur
			if (reponseOrdi == reponseUtil){
				// l'utilisateur est une calculatrice ambulante !
				System.out.println("Bravo !\nUne vraie calculatrice (sans vouloir t'offancer en cas d'acnee) ;)");
			} else {
				// l'utilisateur devrait relancer le programme...
				System.out.println("Mais quel dommage :,( ...\n La reponse etait : " + reponseOrdi);
			}
		}
		
	}
}
