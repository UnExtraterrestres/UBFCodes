public class Age{
	
	public static void main(String args[]){
		
		// declaration des constantes et des donnees
		final int AUJOURDHUI = 2022;
		String prenom;
		int naissance = -1;
		// declaration des resultats
		int age;
		
		// saisie des donnees
		// saisie du prenom
		Ecran.afficher("entrez votre prenom : ");
		prenom = Clavier.saisirString();
		// saisie de l'annee de naissance (entier >= 0)
		while (naissance < 0) {
			Ecran.afficher("entrez votre annee de naissance : ");
			naissance = Clavier.saisirInt();
		}
		
		// calcul des resultats
		age = AUJOURDHUI - naissance;
		
		// affichage des resultats
		Ecran.afficher("Bonjour " + prenom + " .\n");
		Ecran.afficher("Cette annee vous avez : " + age + " an(s)\n");
		
	}
}
