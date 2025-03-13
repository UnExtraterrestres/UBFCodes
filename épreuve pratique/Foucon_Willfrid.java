//~ Foucon Willfrid I2

public class Foucon_Willfrid {
	
	public static void main(String[] args) {
	
		//~ exo1
		Carte carte = tirerCarte();
		
		//~ exo2
		afficherCarte(carte);
		
		//~ exo3
		Pli pli = tirerPli(new Groupe());
		
		//~ exo4
		afficherPli(pli);
		
		//~ exo5
		//~ aucune action depuis exo4 : simple modification dans afficherPli
		
		//~ exo6
		Groupe groupe = new Groupe();
		for (int i = 1; i<=6; i++) {
			System.out.println("Pli "+i+" : ");
			pli = tirerPli(groupe);
			afficherPli(pli);
		}
		afficherGroupe(pli.groupe);
	}
	
	public static void afficherGroupe(Groupe groupe) {
		//~ affiche les points des joueurs du groupe
		
		System.out.println("Resultats :");
		System.out.println("Joueur 1 : "+groupe.joueur1+" points");
		System.out.println("Joueur 2 : "+groupe.joueur2+" points");
		System.out.println("Joueur 3 : "+groupe.joueur3+" points\n");
	}
	
	public static class Groupe {
		int joueur1 = 0;
		int joueur2 = 0;
		int joueur3 = 0;
	}
	
	public static boolean carteSup(Carte carte1, Carte carte2) {
		//~ renvoi vrai si carte1 est srtictement superieur a carte2, faux sinon
		return carte1.points > carte2.points;
	}
	
	public static void gagnantPli(Pli pli) {
		//~ renvois le gagnant du pli, incremente le score du joueur
		
		if (carteSup(pli.carte1, pli.carte2) && carteSup(pli.carte1, pli.carte3)) {
			System.out.println("Gagnant joueur 1 remportant "+pli.points+" points\n");
			pli.groupe.joueur1 += pli.points;
			
		} else if (carteSup(pli.carte2, pli.carte1) && carteSup(pli.carte2, pli.carte3)) {
			System.out.println("Gagnant joueur 2 remportant "+pli.points+" points\n");
			pli.groupe.joueur2 += pli.points;
			
		} else if (carteSup(pli.carte3, pli.carte1) && carteSup(pli.carte3, pli.carte2)) {
			System.out.println("Gagnant joueur 3 remportant "+pli.points+" points\n");
			pli.groupe.joueur3 += pli.points;
			
		} else {
			System.out.println("egalite\n");
		}
	}
	
	public static void afficherPli(Pli pli) {
		//~ affiche les parametres du pli
		System.out.println("joueur 1 : " + affCarte(pli.carte1));
		System.out.println("joueur 2 : " + affCarte(pli.carte2));
		System.out.println("joueur 3 : " + affCarte(pli.carte3));
		System.out.println("Ce pli vaut : "+pli.points + " point(s)");
		gagnantPli(pli);
	}
	
	public static Pli tirerPli(Groupe groupe) {
		//~ renvois le tirage d'un pli
		Pli pli = new Pli(groupe);
		
		pli.carte1 = tirerCarte();
		pli.carte2 = tirerCarte(pli.carte1);
		pli.carte3 = tirerCarte();
		while (carteEgal(pli.carte3, pli.carte1) || carteEgal(pli.carte3, pli.carte2)) {
			pli.carte3 = tirerCarte();
		}
		
		pli.points = pli.carte1.points + pli.carte2.points + pli.carte3.points;
		
		return pli;
	}
	
	public static class Pli {
		Carte carte1;
		Carte carte2;
		Carte carte3;
		int points;
		Groupe groupe;
		
		//~ constructeur
		public Pli(Groupe groupe) {
			this.groupe = groupe;
		}
	}
	
	public static class Carte {
		
		String couleur;
		String valeur;
		int points;
	}
	
	public static boolean carteEgal(Carte carte1, Carte carte2) {
		//~ rentourne vrai si les cartes sont egales
		
		if (carte1.couleur.equals(carte2.couleur) && carte1.valeur.equals(carte2.valeur)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String affCarte(Carte carte) {
		return carte.valeur+" de "+carte.couleur+" ("+carte.points+")";
	}
	
	public static void afficherCarte(Carte carte) {
		//~ affiche la carte en argument
		
		System.out.println(affCarte(carte));
	}
	
	public static Carte tirerCarte(Carte contrainte) {
		//~ retourne le tirage aleatoire d'une Carte
		
		Carte carte = tirerCarte();
		
		while (carteEgal(carte, contrainte)) {
			carte.couleur = tirerCouleur();
			carte.valeur = tirerValeur();
			carte.points = pointDe(carte.valeur);
		}
		
		return carte;
	}
	
	public static Carte tirerCarte() {
		//~ retourne le tirage aleatoire d'une Carte
		
		Carte carte = new Carte();
		carte.couleur = tirerCouleur();
		carte.valeur = tirerValeur();
		carte.points = pointDe(carte.valeur);
		
		return carte;
	}
	
	//~ entree : entier borne_inf
	//~ entree : entier borne_sup
	public static int reelDans(int borne_inf, int borne_sup) {
		//~ est retourne : un entier tire aleatoirement dans [borne_inf ; borne_sup[
		
		//~ verification des arguments
		if (borne_inf > borne_sup) {
			//~ permutation
			borne_inf += borne_sup;
			borne_sup = borne_inf - borne_sup;
			borne_inf -= borne_sup;
		}
		
		//~ renvois du resultat (non stocke)
		return borne_inf + (int)(Math.random()*(borne_sup - borne_inf+1));
	}
	
	public static int pointDe(String valeur) {
		//~ retourne le calcul des points par la valeur
		
		int points = 0;
		
		switch (valeur) {
			case "9": {
				points = 14;
			} break;
			case "10": {
				points = 10;
			} break;
			case "valet": {
				points = 20;
			} break;
			case "dame": {
				points = 3;
			} break;
			case "roi": {
				points = 4;
			} break;
			case "as": {
				points = 11;
			} break;
		}
		
		return points;
	}
	
	public static String tirerValeur() {
		//~ retourne le tirage d'une valeur
		
		String valeur = "";
		int tirage = (int)reelDans(1, 8);
		
		switch (tirage) {
			case 5: {
				valeur = "valet";
			} break;
			case 6: {
				valeur = "dame";
			} break;
			case 7: {
				valeur = "roi";
			} break;
			case 8: {
				valeur = "as";
			} break;
			default: {
				int inc = tirage + 6;
				valeur = "" + inc;
			} break;
		}
		
		return valeur;
	}
	
	public static String tirerCouleur() {
		//~ retourne le tirage d'une couleur
		
		String couleur = "";
		
		switch ((int)reelDans(0, 3)) {
			case 0: {
				couleur = "coeur";
			} break;
			case 1: {
				couleur = "carreau";
			} break;
			case 2: {
				couleur = "pique";
			} break;
			case 3: {
				couleur = "trefle";
			} break;
		}
		
		return couleur;
	}
}
