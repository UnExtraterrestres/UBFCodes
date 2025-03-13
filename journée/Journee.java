public class Journee{
	
	public static void main(String args[]){
		
		// declaration des donnees
		// J : journee, E : ecoulement
		int choixJ = 0;
		int choixE = -1;
		// declaration des resultats
		String jourSaisie = "";
		String jourSuivant = "";
		
		// saisie des donnees
		// saisie du choixJ (entier dans [1;7])
		while (choixJ < 1 || 7 < choixJ) {
			Ecran.afficher("entrez un jour (entier entre 1 et 7) : ");
			choixJ = Clavier.saisirInt();
		}
		// saisie du choixE (entier >= 0)
		while (choixE < 0) {
			Ecran.afficher("entrez le nombre de jours ecoules : ");
			choixE = Clavier.saisirInt();
		}
		
		// calcul des resultats
		// calcul du jourSaisie
		jourSaisie = journeeChaine(choixJ);
		// calcul du jourSuivant
		jourSuivant = journeeChaine((choixJ + choixE) % 7);
		
		// affichage du resultat
		Ecran.afficher("jour saisie :	", jourSaisie, "\n");
		Ecran.afficher(choixE, " jours plus tard sera un ", jourSuivant);
		
	}
	
	// fonction qui convertit un entier en un jour de la semaine et le renvoit
	private static String journeeChaine(int jour) {
		// declaration du resultat
		String jourChaine = "";
		
		// calcul du resultat
		switch (jour) {
			
			// lundi
			case 1:
				jourChaine = "lundi";
			break;
			
			// mardi
			case 2:
				jourChaine = "mardi";
			break;
			
			// mercredi
			case 3:
				jourChaine = "mercredi";
			break;
			
			// jeudi
			case 4:
				jourChaine = "jeudi";
			break;
			
			// vendredi
			case 5:
				jourChaine = "vendredi";
			break;
			
			// samedi
			case 6:
				jourChaine = "samedi";
			break;
			
			// dimanche
			case 0:
				jourChaine = "dimanche";
			break;
			
			// erreurs de saisie
			default:
				jourChaine = "Erreur de saisie : calcul impossible ou jour inexistant";
			break;
		}
		
		// retourne le resultat
		return jourChaine;
	}
}
