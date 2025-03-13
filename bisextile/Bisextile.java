public class Bisextile{
		
	public static void main(String args[]){
	
		// declaration de la donnee
		int annee;
		// declaration du resultat
		boolean bisextile;
		
		// saisie de la donnee
		while (annee <= 0) {
			Ecran.afficher("entrez une annee (entier>0) : ");
			annee = Clavier.saisirInt();
		}
		
		// calcul du resultat
		if (annee % 4 == 0) {
			// calcul en plus a cause du pape...
			if (annee % 400 == 0) {
				bisextile = true;
			// pourquoi faire simple quand on peut faire complique ?
			} else if (annee % 100 == 0) {
				bisextile = false;
			} else {
				bisextile = true;
			}
		} else {
			bisextile = false;
		}
		
		// affichage du resultat
		if (bisextile) {
			System.out.println(annee + " est bisextile");
		} else {
			System.out.println(annee + " n'est pas bisextile");
		}
	}
}
