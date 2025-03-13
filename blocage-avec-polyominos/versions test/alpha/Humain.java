/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Humain extends Joueur
{
	
	/*ATTRIBUTS			*/
	/*CONSTRUCTEURS		*/
	public Humain(Polyomino[] jeuPolyos)
	{
		
		/**
		*constructeur principal
		*@param jeuPolyos type tableau de Polyominos
		*@return l'affectation des attributs
		* par appel du constructeur principal de la super classe
		*/
		
		super(jeuPolyos, Saisies.nomHumain());
	}
	
	/*METHODES			*/
	public int placerPolyo(Plateau plateau)
	{
		
		/**
		*@param plateau type Plateau
		*@return le placement d'un polyomino
		* par saisie des ligne et colonne
		*
		* affiche les pieces du joueur
		* veut il tourner les pieces ? ou en placer une ?
		* on affiche le plateau au joueur
		* on place la piece apres saisies
		*/
		
		/*affichage des pieces du joueur	*/
		afficherJeuDePolyos();
		System.out.println("Voici vos pieces disponibles.");
		
		/*tourner ou poser			*/
		System.out.println("Vous souhaitez :\n1. tourner les pieces d'un quart de tour\n2. placer une piece");
		System.out.print("Entrez l'entier associe a l'action souhaitee : ");
		switch(Saisies.entierEntre(1, 2))
		{
			case 1:
				tournerPolyos();
				placerPolyo(plateau);
				break;
			case 2:
				break;
			default:
				placerPolyo(plateau);
				break;
		}
		
		System.out.println("\nAppuyez sur la touche <Entrer> pour continuer...");
		Clavier.saisirString();
		
		/*saisie du polyo a poser		*/
		System.out.print("Entrez le numero de la piece a poser : ");
		int idPol = Saisies.entierEntre(0, jeuDePolyos.length-1);
		
		System.out.println("\nAppuyez sur la touche <Entrer> pour continuer...");
		Clavier.saisirString();
		
		/*affichage du plateau			*/
		plateau.afficher();
		
		/*saisie des coordonnees		*/
		System.out.print("Entrez la ligne ou poser le polyomino : ");
		int ligne = Saisies.entierEntre(1, plateau.getNbLignes());
		System.out.print("Entrez la colonne ou poser le polyomino : ");
		int colonne = Saisies.entierEntre(1, plateau.getNbColonnes());
		
		System.out.println("\nAppuyez sur la touche <Entrer> pour continuer...");
		Clavier.saisirString();
		
		/*on place le polyomino		*/
		if (!plateau.placerPiece(jeuDePolyos[idPol], ligne-1, colonne-1))
		{
			System.out.println("La piece ne peut pas etre placee.");
			placerPolyo(plateau);
		} else
		{
			jeuDePolyos = retirerPolyo(idPol);
		}
		
		return 0;
	}
}
