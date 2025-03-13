public class Hasard {
	
	private static int hasardIntervalle(int b1, int b2) {
		
		// verification des arguments ( b1<b2)
		if (b1>b2) {
			// b1>b2 => on permute b1 et b2
			b1 += b2;
			b2 = b1 - b2;
			b1 = b1 - b2;
		}
		
		// retourne un entier dans |[b1 ; b2]|
		return b1 + (int)(Math.random()*(b2 - b1 + 1 ));
		
	}
	
	public static void main(String[] args) {
		
		/*
		// declaration des donnees
		int borne1, borne2;
		
		// saisie des donnees
		Ecran.afficher("entrez un entier relatif : ");
		borne1 = Clavier.saisirInt();
		Ecran.afficher("entrez un entier relatif : ");
		borne2 = Clavier.saisirInt();
		
		// affichage d'un entier compris entre borne1 et borne2
		Ecran.afficher(hasardIntervalle(borne1, borne2));
		*/
		
		int nbGroupe = 6;
		
		for (int i=0; i<nbGroupe; i++)
		{
			
			System.out.println("Sujet " + hasardIntervalle(1, 3));
		}
	}
}
