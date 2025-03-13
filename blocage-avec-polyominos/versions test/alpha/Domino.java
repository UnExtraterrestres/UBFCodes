/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Domino extends Polyomino
{
	
	/*ATTRIBUTS					*/
	/*CONSTRUCTEURS				*/
	public Domino(char nom, char motif)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@param nom type caractere
		*@param motif type caractere
		*@return l'affectation des attributs
		*par des valeurs specifiees
		* appel du constructeur principal de la super classe
		*/
		
		super(nom, motif, 2);
	}
	public Domino(char nom)
	{
		
		/**
		*CONSTRUCTEUR secondaire
		*@param nom type caractere
		*@return l'affectation des attributs
		*par appel du constructeur secondaire de la super classe
		*/
		
		this(nom, 'X');
	}
	public Domino()
	{
		
		/**
		*CONSTRUCTEUR par defaut
		*@return l'affectation des attributs
		*par appel du constructeur par defaut de la super classe
		*/
		
		this('I');
	}
	
	/*METHODES					*/
	@Override
	public void choisirPolyomino(char nom)
	{
		
		/**
		*@param nom type char
		*@return la matrice de booleens associee au nom specifie
		*<br>Domino existants :
		*I
		*/
		
		boolean[][] poly;
		
		switch(nom)
		{
			default:
			{
				poly = new boolean[][]{{true, true}};
			} break;
		}
		
		super.setMatrice(poly);
	}
}
