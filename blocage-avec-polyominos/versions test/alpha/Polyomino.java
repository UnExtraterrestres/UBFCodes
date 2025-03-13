/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

abstract class Polyomino
{
	
	/*ATTRIBUTS					*/
	private boolean[][] matrice;
	private char motif;
	private int aire;
	
	/*CONSTRUCTEURS				*/
	public Polyomino(char nom, char motif, int aire)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@param nom type caractere
		*@param motif type caractere
		*@param aire type entier naturel
		*@return l'affectation des attributs
		*par des valeurs specifiees
		*/
		
		choisirPolyomino(nom);
		this.motif = motif;
		this.aire = aire;
	}
	public Polyomino(char nom)
	{
		
		/**
		*CONSTRUCTEUR secondaire
		*@param nom type caractere
		*@return l'affectation des attributs
		*par appel du constructeur principal
		*/
		
		this(nom, 'X', 1);
	}
	public Polyomino()
	{
		
		/**
		*constructeur par defaut
		*@return l'affectation des attributs
		* par appel du constructeur secondaire
		*/
		
		this('I');
	}
	
	/*METHODES					*/
	
	public boolean peutEtrePlaceEn(int ligne, int colonne, Plateau pla)
	{
		
		/**
		*@param ligne type entier naturel
		*@param colonne type entier naturel
		*@param pla type Plateau
		*@return vrai si le polyomino peut etre place
		* en ligne, colonne sur pla
		*/
		
		int nbLignes = getNbLignes();
		int nbColonnes = getNbColonnes();
		
		for (int i=0; i<nbLignes; i++)
		{
			
			for (int j=0; j<nbColonnes; j++)
			{
				if (getCase(i, j) && !pla.getCase(ligne+i, colonne+j))
				{
					/*alors le polyomino ne peut pas etre place	*/
					return false;
				}
			}
		}
		/*alors le polyomino peut etre place	*/
		return true;
	}
	
	public void setMatrice(boolean[][] matrice)
	{
		
		/**
		*@param matrice type tableau de tableau de booleens
		*@return l'affectation de la matrice
		* par celle specifiee
		*/
		
		this.matrice = matrice;
	}
	
	abstract void choisirPolyomino(char nom);
	
	public void tourner()
	{
		
		/**
		*@return tourne la matrice
		* d'un quart de tour, sens horaire
		*/
		
		int nbLignes = getNbLignes();
		int nbColonnes = getNbColonnes();
		
		boolean[][] matriceAux = new boolean[nbColonnes][nbLignes];
		
		for (int i=0; i<nbLignes; i++)
		{
			
			for (int j=0; j<nbColonnes; j++)
			{
				
				matriceAux[j][nbLignes-1-i] = matrice[i][j];
			}
		}
		
		matrice = matriceAux;
	}
	
	
	public int getNbLignes()
	{
		
		/**
		* getteur sur le nombre de lignes de la matrice
		*@return la hauteur de la matrice
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
	
	public boolean getCase(int ligne, int colonne)
	{
		
		/**
		* getteur sur une valeur de matrice
		*@param ligne type entier naturel
		*@param colonne type entier naturel
		*@return la valeur de matrice en ligne, colonne
		*/
		
		return matrice[ligne][colonne];
	}
	
	public char getMotif()
	{
		
		/**
		*getteur sur motif
		*@return motif
		*/
		
		return motif;
	}
	
	public int getAire()
	{
		
		/**
		*getteur sur aire
		*@return l'aire du polyomino
		*/
		
		return aire;
	}
	
	public String versChaine()
	{
		
		/**
		*@return la chaine associee au Polyomino
		*/
		
		String chaine = "";
		
		int nbLignes = matrice.length;
		int nbColonnes = getNbColonnes();
		
		for (int i=0; i<nbLignes; i++)
		{
			
			for (int j=0; j<nbColonnes; j++)
			{
				if (matrice[i][j])
				{
					chaine += "\t"+motif;
				} else
				{
					chaine += "\t.";
				}
			}
			
			chaine += "\n\n";
		}
		
		return chaine;
	}
}
