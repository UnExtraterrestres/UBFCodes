class Main {
	
	public static void main(String[] args) {
		
		/*
		est tire : un entier dans |[10;50]|
		
		est boucle :
			sont tirees : deux operandes dans |[1;9]|
		
			est affiche : le numero de l'operation
			sont affichees : les operandes
		
			est saisie : une operation parmis +*-/
		
			est calculee : l'operation des deux operandes
		
			est verifiee : la condition d'arret
		
		est affiche : le score final (gagne ou perdu)
		*/
		
		//~ declarations des contantes et des donnees
		final int CIBLE = (int)Generateur.reelDans(10, 50);
		final int NB_ESSAIS_MAX = 4;
		int operande1;
		char operation;
		boolean continuer;
		//~ declaration des resultats
		int operande0 = (int)Generateur.reelDans(1, 9);
		boolean jeu_tourne = true;
		//~ declaration du compteur
		int num_tour = 1;
		
		//~ boucle du jeu
		while (jeu_tourne) {
			//~ est tiree : operande1
			operande1 = (int)Generateur.reelDans(1, 9);
			
			//~ affichage des resultats
			//~ est affiche : num_tour
			//~ sont affichees : les operandes
			Ecran.afficherln("Voici les deux operandes : n0 = ", operande0, " et n1 = ", operande1);
			
			//~ saisie des donnees
			Ecran.afficherln("Choisissez une operation");
			operation = Entree.saisieCarDans("+-*/");
			
			//~ calcul du resultat
			//~ calcul de l'operande0
			switch (operation) {
				case '+': {
					operande0 += operande1;
				} break;
				case '-': {
					operande0 -= operande1;
				} break;
				case '*': {
					operande0 *= operande1;
				} break;
				case '/': {
					operande0 /= operande1;
				} break;
			}
			
			//~ est verifiee : la condition d'arret
			if (num_tour == NB_ESSAIS_MAX) {
				jeu_tourne = false;
			} else if (num_tour > 1) {
				//~ est saisie : continuer
				Ecran.afficherln("voulez-vous poursuivre ? (1: oui, 0: non)");
				continuer = Entree.saisieDans(0, 1, "continuer");
				
				//~ condition d'arret
				jeu_toune = continuer != 0;
			}
		}
		
		//~ affichage du score
		if (operande0 == CIBLE) {
			Ecran.afficherln("C'est gagne : vous avez atteint la cible !");
		} else {
			Ecran.afficherln("C'est perdu : vous n'avez pas atteint la cilbe !");
		}
		
	}
	
}
