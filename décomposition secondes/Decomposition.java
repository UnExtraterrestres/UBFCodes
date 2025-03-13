public class Decomposition{
	
	public static void main(String args[]){
		
		// déclaration de la donnée
		int secondesInit = -1;
		// déclaration des résultats
		int heures, minutes, secondes;
		
		// saisie de la donnée (supposée juste)
		// saisie du nombre de seconde (entier >= 0)
		while (secondesInit < 0) {
			Ecran.afficher("entrez le nombre de secondes : \n");
			secondesInit = Clavier.saisirInt();
		}
		
		// calcul du résultat
		heures = secondesInit / 3600;
		secondesInit %= 3600;
		minutes = secondesInit / 60;
		secondesInit %= 60;
		secondes = secondesInit % 60;
		
		// affichage du résultat
		Ecran.afficher(heures, "h ", minutes, "min ", secondes, "sec");
		
	}
}
