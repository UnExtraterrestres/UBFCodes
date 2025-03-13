public class Tables {
	
	public static void main(String[] args) {
		
		// declaration de la donnee
		int choixChiffre;
		
		// saisie de la donnee
		Ecran.afficher("entrez un chiffre entre 2 et 9 (inclus) : ");
		choixChiffre = Clavier.saisirInt();
		// verification de la saisie
		while (choixChiffre < 2 || 9 < choixChiffre) {
			// message d'erreur
			Ecran.afficher("Erreur de saisie : votre chiffre n'est pas dans |[2 ; 9 ]|\n");
			
			// saisie de la donnee
			Ecran.afficher("entrez un chiffre entre 2 et 9 (inclus) :");
			choixChiffre = Clavier.saisirInt();
		}
		
		// lancement de la fonction tableProduit
		tableProduit(choixChiffre);
		
	}
	
	// fonction qui affiche la table de produit d'un chiffre donnee
	private static void tableProduit(int chiffre) {
		
		// declaration du compteur
		int i;
		
		// affichage de la table
		Ecran.afficher("\nTable du ", chiffre, " :\n");
		
		// boucle de calcul et d'affichage de la table
		for (i=1; i<=10; i+=1) {
			
			// affichage de la ligne
			Ecran.afficher("\n", chiffre, "x", i, "=", chiffre*i);
			
		}
		
	}
	
}
