/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Plateau
{
	
	/*ATTRIBUTS											*/
	private Cellule[][] matrice;
	
	/*CONSTRUCTEURS										*/
	public Plateau(int nbLignes, int nbColonnes)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@return l'affectation des attributs
		*par des valeurs specifiees
		*
		*/
		
		matrice = new Cellule[nbLignes][nbColonnes];
		remplirMatrice();
	}
	public Plateau()
	{
		
		/**
		*CONSTRUCTEUR par defaut
		*@return l'affectation des attributs
		*par appel du constructeur principal
		*/
		
		this(10, 10);
	}
	
	/*METHODES											*/
	public boolean joueurEstBloque(Polyomino[] pol)
	{
		
		/**
		*@param pol type tableau de Polyomino
		*@return vrai si aucun polyomino de pol ne peut etre place
		* faux sinon
		*/
		
		if (pol.length==0)
		{
			return true;
		}
		
		int nbPolyos = pol.length;
		int nbLignes = getNbLignes();
		int nbColonnes = getNbColonnes();
		
		for (int idPoly=0; idPoly<nbPolyos; idPoly++)
		{
			Polyomino poly = pol[idPoly];
			int nbLignesPoly = poly.getNbLignes();
			int nbColonnesPoly = poly.getNbColonnes();
			
			for (int orient=0; orient<4; orient++)
			{
				
				for (int ligne=0; ligne<nbLignes-nbLignesPoly; ligne++)
				{
					
					for (int colonne=0; colonne<nbColonnes-nbColonnesPoly; colonne++)
					{
						
						if (poly.peutEtrePlaceEn(ligne, colonne, this))
						{
							return false;
						}
					}
				}
				
				poly.tourner();
			}
		}
		
		return true;
	}
	
	// verifiee
	public boolean placerPiece(Polyomino pol, int ligne, int colonne)
	{
		
		/**
		*@param pol type Polyomino
		*@param ligne type entier naturel
		*@param colonne type entier naturel
		*@return vrai si la piece a pu etre placee
		* faux sinon
		*/
		
		int nbLignesPol = pol.getNbLignes();
		int nbColonnesPol = pol.getNbColonnes();
		
		if (!pol.peutEtrePlaceEn(ligne, colonne, this))
		{
			return false;
		}
		
		/*parcours la matrice du pol								*/
		for (int i=0; i<nbLignesPol; i++)
		{
			
			for (int j=0; j<nbColonnesPol; j++)
			{
				
				if (pol.getCase(i, j))
				{
					matrice[ligne+i][colonne+j].setEstLibre(pol.getMotif());
				}
			}
		}
		
		return true;
	}
	
	public boolean getCase(int ligne, int colonne)
	{
		
		/**
		*@param ligne type entier naturel
		*@param colonne type entier naturel
		*@return l'etat de la case de matrice
		* en ligne, colonne
		*/
		
		return matrice[ligne][colonne].getEstLibre();
	}
	
	public int getNbLignes()
	{
	
		/**
		* getteur sur le nombre de lignes de matrice
		*@return l'hauteur de la matrice
		*/
		
		return matrice.length;
	}
	
	public int getNbColonnes()
	{
		
		/**
		* getteur sur le nombre de colonnes de matrice
		*@return la largeur de la matrice
		*/
		
		return matrice[0].length;
	}
	
	private void remplirMatrice()
	{
		
		/**
		*@param etat type booleen
		*@return remplissage de la matrice
		* par des Cellules
		*/
		
		int nbLignes = getNbLignes();
		int nbColonnes = getNbColonnes();
		
		for (int ligne=0; ligne<nbLignes; ligne++)
		{
			
			for (int colonne=0; colonne<nbColonnes; colonne++)
			{
				
				matrice[ligne][colonne] = new Cellule();
			}
		}
	}
	
	public void afficher()
	{
		
		/**
		*@return l'affichage du plateau
		*/
		
		int nbLignes = getNbLignes();
		int nbColonnes = getNbColonnes();
		
		/*ajout d'une lettre pour la colonne						*/
		for (int colonne=0; colonne<nbColonnes; colonne++)
		{
			System.out.print("\t"+(char)(colonne+'A'));
		}
		System.out.println("\n");
		
		/*parcours de la matrice								*/
		for (int ligne=0; ligne<nbLignes; ligne++)
		{
			/*ajout du numero de ligne							*/
			System.out.print(ligne+1);
			for (int colonne=0; colonne<nbColonnes; colonne++)
			{
				/*affichage de la cellule						*/
				System.out.print("\t"+matrice[ligne][colonne].versChaine());
			}
			System.out.println("\n");
		}
	}
}
