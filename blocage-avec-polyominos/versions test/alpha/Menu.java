/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Menu extends Scene
{
	
	/*ATTRIBUTS				*/
	private final int MAXJOUEURS;
	private int choixMain;
	private String[] menuMain;
	private String regles;
	private String aPropos;
	private String[] menuPlateau;
	
	/*CONSTRUCTEURS			*/
	public Menu(Jeu jeu)
	{
		
		/**
		*constructeur principal
		*@return l'affectation des attributs
		* par appel du constructeur principal de la super classe
		* par des valeurs par defaut
		*/
		
		super(jeu);
		
		MAXJOUEURS = 2;
		choixMain = 1;
		menuMain = new String[]
		{
			"+---Menu Principal-----+",
			" 1. Nouvelle partie",
			" 2. Consulter les règles",
			" 3. À propos du jeu",
			" 4. Quitter",
			"+------------------------+"
		};
		regles = "Le jeu oppose deux joueurs, humain ou machine, sur un plateau de forme rectangulaire.\n"+
				"Les joueurs ont des pieces, les polyominos, qu'ils placent chacun leur tour.\n"+
				"La fin du jeu est decide par un blocage, c'est a dire que lorsqu'un des joueurs\n"+
				"ne plus poser aucune de ces pieces il a perdu, et la partie ce termine.";
		
		aPropos = "Voir ReadMe.md join dans le dossier du jeu.\n"+
					"Ou consultez la page GitHub suivante : \n"+
					"\t https://github.com/UnExtraterretres/blocage-avec-polyominos";
		menuPlateau = new String[]
		{
			"+--Menu des Plateaux--+",
			" 1. Plateau par defaut",
			" 2. Grand Plateau",
			" 3. Plateau personnalise",
			"+-------------------------+"
		};
	}
	
	/*METHODES				*/
	private void afficherMenu(String[] menu)
	{
		
		/**
		*@param menu type tableau de chaine de caractere
		*@return l'affichage dans la console du menu specifie
		*/
		
		System.out.println("\nAppuyez sur la touche <Entrer> pour continuer...");
		Clavier.saisirString();
		
		for (int i=0; i<100; i++)
		{
			System.out.println(" ");
		}
		
		int tailleMenu = menu.length;
		
		for (int i=0; i<tailleMenu; i++)
		{
			
			System.out.println(menu[i]);
		}
		System.out.print("Tappez l'entier associe a votre choix : ");
	}
	
	private Plateau choixPlateau()
	{
		
		/**
		*@return un plateau en fonction du choix saisie
		*/
		
		int choixPlat = 1;
		Plateau plateau = new Plateau();
		
		do
		{
			afficherMenu(menuPlateau);
			choixPlat = Clavier.saisirInt();
			System.out.println(" ");
			
			switch(choixPlat)
			{
				case 1:
					break;
				case 2:
					plateau = new Plateau(26, 26);
					break;
				case 3:
					System.out.print("Entrez le nombre de lignes : ");
					int nbLignes = Saisies.entierEntre(7, 26);
					System.out.print("Entrez le nombre de colonnes : ");
					int nbColonnes = Saisies.entierEntre(7, 26);
					plateau = new Plateau(nbLignes, nbColonnes);
					break;
				default:
					System.out.println("Action inconnue : votre saisie est peut etre incorrecte.");
					System.out.println("En cas de probleme n'hesitez pas a consulter le developpeur du jeu.");
					System.out.println("(Pour cela voir page 'A propos')");
					break;
			}
		} while(choixPlat<1 || 3<choixPlat);
		
		System.out.println(" ");
		
		return plateau;
	}
	
	private Polyomino[] ajouter(Polyomino[] jeuPol, Polyomino pol)
	{
		
		/**
		*@param jeuPol type tableau de Polyominos
		*@param pol type Polyomino
		*@return l'ajout de pol a jeuPol
		*/
		
		int tailleJeu = jeuPol.length;
		
		Polyomino[] aux = new Polyomino[tailleJeu+1];
		
		for (int i=0; i<tailleJeu; i++)
		{
			aux[i] = jeuPol[i];
		}
		aux[tailleJeu] = pol;
		
		return aux;
	}
	
	private int aireTotale(Polyomino[] poly)
	{
		
		/**
		*@param poly type tableau de polyominos
		*@return l'aire totale des polyominos de poly
		*/
		
		int taillePoly = poly.length;
		int sum = 0;
		
		for (int idPoly=0; idPoly<taillePoly; idPoly++)
		{
			sum += poly[idPoly].getAire();
		}
		
		return sum;
	}
	
	private Polyomino[] getJeuInitial(int nbLignes, int nbColonnes)
	{
		
		/**
		*@param nbLignes type entier naturel
		*@param nbColonnes type entier naturel
		*@return le jeu minimum de polyominos initial
		* tel qu'il remplisse plus de la moitiee de l'aire du plateau
		*/
		
		int limiteMin = 1+nbLignes*nbColonnes/2;
		int i = 0;
		
		Polyomino[] jeuParDefaut = new Polyomino[]
		{
			new Domino(),
			new Triomino(), new Triomino('L'),
			new Tetromino(), new Tetromino('L'), new Tetromino('J'),
			new Tetromino('S'), new Tetromino('Z'), new Tetromino('T'),
			new Tetromino('O')
		};
		
		Polyomino[] jeuFinal = new Polyomino[jeuParDefaut.length];
		for (int id=0; id<jeuFinal.length; id++)
		{
			jeuFinal[id] = jeuParDefaut[id];
		}
		
		while (aireTotale(jeuFinal)<limiteMin)
		{
			
			jeuFinal = ajouter(jeuFinal, jeuParDefaut[i%10]);
			i++;
		}
		
		return jeuFinal;
	}
	
	private void nouvellePartie()
	{
		
		/**
		*@return le lancement d'une nouvelle partie
		* saisie du plateau
		* saisie des joueurs
		* creation du niveau
		* lancement du niveau
		*/
		
		/*saisie du plateau					*/
		Plateau plateau = choixPlateau();
		
		/*saisie des jouers					*/
		/*creation des jeux de polyominos necessaires	*/
		Polyomino[] jeuPolyos = getJeuInitial(plateau.getNbLignes(), plateau.getNbColonnes());
		/*saisie du nombre de joueurs			*/
		System.out.print("\n\nEntrez le nombre de joueurs (humains) : ");
		int nbHumains = Saisies.entierEntre(0, MAXJOUEURS);
		/*creation de la table de joueurs			*/
		Joueur[] joueurs = new Joueur[MAXJOUEURS];
		for (int i=0; i<MAXJOUEURS; i++)
		{
			if (i<nbHumains)
			{
				joueurs[i] = new Humain(jeuPolyos);
			} else
			{
				joueurs[i] = new Machine(jeuPolyos);
			}
		}
		
		jeu.setScene(new Niveau(plateau, joueurs, jeu));
	}
	
	private void afficherRegles()
	{
		
		/**
		*@return l'affichage dans la console des regles du jeu specifiees
		*/
		
		System.out.println(regles);
	}
	
	private void afficherAPropos()
	{
		
		/**
		*@return l'affichage dans la console de la page 'A propos'
		*/
		
		System.out.println(aPropos);
	}
	
	@Override
	public void main()
	{
		
		/**
		*@return le menu principal
		*/
		
		do
		{
			
			afficherMenu(menuMain);
			choixMain = Clavier.saisirInt();
			System.out.println(" ");
			
			switch(choixMain)
			{
				case 1:
					nouvellePartie();
					break;
				case 2:
					afficherRegles();
					break;
				case 3:
					afficherAPropos();
					break;
				case 4:
					System.out.println("Fermeture du menu principal.");
					break;
				default:
					System.out.println("Action inconnue : votre saisie est peut etre incorrecte.");
					System.out.println("En cas de probleme n'hesitez pas a consulter le developpeur du jeu.");
					System.out.println("(Pour cela voir page 'A propos')");
					break;
			}
			if (choixMain==1)
			{
				break;
			}
		}while(choixMain!=4);
	}
}
