class JeuAllumettes
{
	
	private String[] saisieJoueurs(String[] joueurs)
	{
		
		/**
		*@param joueurs type tableau de chaine
		*@return un tableau de meme longueur
		* contenant les noms saisis des joueurs
		*/
		
		int nbJoueurs = joueurs.length;
		for (int idJoueur=0; idJoueurs<nbJoueurs; idJoueur++)
		{
			System.out.print("Entrez le nom du joueur "+idJoueur+1+" : ");
			joueurs[idJoueur] = Clavier.saisirString();
		}
		
		return joueurs;
	}
	
	private String chaineDepuisChar(char car, int n)
	{
		
		/**
		*@param car type caractere
		*@param n type entier naturel
		*@return une chaine de n fois le caractere specifie
		*/
		
		String chaine = "";
		
		for (int i=0; i<n; i++)
		{
			chaine += car;
		}
		
		return chaine;
	}
	
	private boolean estEntre(int borneInf, int borneSup, int n)
	{
		
		/**
		*@param borneInf type entier
		*@param borneSup type entier
		*@param n type entier
		*@return vrai si n est compris entre borneInf et borneSup
		* faux sinon
		*/
		
		/*verification d'un besoin de permutation	*/
		if (borneInf>borneSup)
		{
			borneInf += borneSup;
			borneSup = borneInf - borneSup;
			borneInf -= borneSup;
		}
		
		return borneInf<=n && n<=borneSup;
	}
	
	private int saisieNbAllu(String nom, int nbAllu)
	{
		
		/**
		*@param nom type chaine
		*@param nbAllu type entier narurel
		*@return la saisie d'un entier
		* entier compris entre 1 et 3 si la difference avec nbAllu>0
		*/
		
		int saisie;
		
		System.out.print("Entrez le nombre d'allumette(s) a retirer (1, 2 ou 3): ");
		saisie = Clavier.saisirInt();
		while(!estEntre(1, 3, saisie) || nbAllu-saisie<1)
		{
			/*message d'erreur	*/
			System.out.println("Erreur : la saisie est incorrecte.");
			System.out.println("Verifiez que la saisie est 1, 2 ou 3.");
			System.out.println("Verifiez que le nombre d'allumettes est suffisant.");
			/*nouvelle saisie		*/
			System.out.print("Entrez le nombre d'allumette(s) a retirer (1, 2 ou 3): ");
			saisie = Clavier.saisirInt();
		}
		
		return saisie;
	}
	
	private boolean continuerJeu()
	{
		
		/**
		*@return vrai si l'utilisateur souhaite continuer
		* faux sinon
		*/
		
		System.out.println("+-----------------------+");
		System.out.println("1. Nouvelle Partie");
		System.out.println("2. Quitter");
		System.out.println("+-----------------------+");
		System.out.print("Faites votre choix (1 ou 2) : ");
		int choix = Clavier.saisirInt()
		while (!estEntre(1, 2, choix))
		{
			/*message d'erreur	*/
			System.out.println("Erreur : saisie inconnue");
			System.out.print("Faites votre choix (1 ou 2) : ");
			choix = Clavier.saisirInt()
		}
		System.out.println("+-----------------------+");
		
		return choix == 1;
	}
	
	public static main(String[] args)
	{
		
		/**
		* Déroulement du jeu :
		* Deux joueurs s'affrontent.
		* Au début il y a un certain nombre d'allumettes (17 par defaut)
		* Chacun leur tour les joueurs retirent d'une à trois allumettes si possible.
		* le premier joueur pour lequel il ne reste qu'une allumette a perdu.
		*/
		
		boolean continuerJeu = true;
		final int MAXALLU = 17;
		int nbAllu;
		String[] joueurs = new String[2];
		int numTour;
		
		/*boucle du jeu	*/
		do
		{
			/*initialisation de la partie	*/
			nbAllu = MAXALLU;
			joueurs = saisieJoueurs(joueurs);
			numTour = 0;
			
			/*boucle d'une partie	*/
			while (nbAllu > 1)
			{
				System.out.println("Jeu restant ["+nbAllu+"] allumettes : "+chaineDepuisChar('|', nbAllu));
				nbAllu -= saisieNbAllu(joueurs[numTour%joueurs.length], nbAllu);
				numTour ++;
			}
			
			System.out.println("Bravo "+joueurs[(numTour+1)%joueurs.length]+" vous avez gagne !");
			System.out.println("Dommage "+joueurs[numTour%joueurs.length]+" vous avez perdu...");
			
			continuerJeu = continuerJeu();
			
		}while (continuerJeu);
	}
}
