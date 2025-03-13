import java.util.ArrayList;

public class Permutation{
	
	public static void main(String args[]){
		
		// declaration de la constante et de la donnee
		final int NBREELS;
		ArrayList listeReel = new ArrayList();
		// declaration du compteur
		int i;
		
		// saisie des donnees
		for (i=1; i<=NBREELS; i+=1){
			Ecran.afficher("entrez un entier : ");
			listeReel.add(Clavier.saisirInt());
		}
		
		// afficher les premieres valeurs saisies
		affichage(listeReel);
		
		// calcul du resultat
		listeReel = permuter(liste);
		
		// afficher les nouvelles valeurs calculees
		affichage(listeReel);
		
	}
	
	// fonction affichage des donnees
	private static void affichage(ArrayList liste) {
		
		// declaration du compteur
		int i;
		
		// affichage des elements de liste
		for (i=0; i<=liste.size(); i+=1) {
			Ecran.afficher("nb", i, "= ", liste[i], "\n");
		}
	}
	
	// fonction de permutation pour n variables reelles
	private static ArrayList permuter(ArrayList liste) {
		// declaration du compteur
		int i;
		
		// algorithme de permutation
		liste[0] = sum(liste, 0, liste.size());
		for (i=1; i<=liste.size(); i+=1) {
			liste[i] = liste[0] - sum(liste, 1, liste.size());
		}
		liste[0] = liste[0] - sum(liste, 1, liste.size());
		
		// retourne le resultat
		return liste;
	
	}
	
	// fonction somme dans une liste
	private static double sum(ArrayList liste, int borne0, int borne1) {
		
		// declaration du compteur et du resultat
		int i;
		double somme = 0;
		
		// calcul du resultat
		for (i=borne0; i<=borne1; i+=1) {
			somme += liste[i];
		}
		
		// retourne le resultat
		return somme;
	}
	
}
