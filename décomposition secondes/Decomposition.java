public class Decomposition{
	
	public static void main(String args[]){
		
		// d�claration de la donn�e
		int secondesInit = -1;
		// d�claration des r�sultats
		int heures, minutes, secondes;
		
		// saisie de la donn�e (suppos�e juste)
		// saisie du nombre de seconde (entier >= 0)
		while (secondesInit < 0) {
			Ecran.afficher("entrez le nombre de secondes : \n");
			secondesInit = Clavier.saisirInt();
		}
		
		// calcul du r�sultat
		heures = secondesInit / 3600;
		secondesInit %= 3600;
		minutes = secondesInit / 60;
		secondesInit %= 60;
		secondes = secondesInit % 60;
		
		// affichage du r�sultat
		Ecran.afficher(heures, "h ", minutes, "min ", secondes, "sec");
		
	}
}
