public class minToMaj{
	
	public static void main(String args[]){
		
		// declaration de la donnee
		char minuscule = (char)96;
		// declaration du resultat
		char majuscule;
		
		// saisie de la donnee
		// saisie de la minuscule ( ASCII dans |[97 ; 122]| )
		while ((int)minuscule < 97 || 122 < (int)minuscule) {
			Ecran.afficher("entrez une lettre minuscule : ");
			minuscule = Clavier.saisirChar();
		}
		
		// calcul du resultat
		// on convertit en caractere la difference entre, le code ASCII de minuscule et 32
		// exemple : (int)'a' - 32 = (int)'A'
		majuscule = (char)(((int)minuscule) - 32 );
		
		// affichage du resultat
		Ecran.afficher("la majuscule de " + minuscule + " est " + majuscule);
		
	}
}
