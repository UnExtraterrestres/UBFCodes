/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Tetromino extends Polyomino
{
	
	/*ATTRIBUTS					*/
	/*CONSTRUCTEURS				*/
	public Tetromino(char nom, char motif)
	{
		
		/**
		*CONSTRUCTEUR principal
		*@param nom type caractere
		*@param motif type caractere
		*@return l'affectation des attributs
		*par des valeurs specifiees
		* appel du constructeur principal de la super classe
		*/
		
		super(nom, motif, 4);
	}
	public Tetromino(char nom)
	{
		
		/**
		*CONSTRUCTEUR secondaire
		*@param nom type caractere
		*@return l'affectation des attributs
		*par appel du constructeur secondaire de la super classe
		*/
		
		this(nom, 'X');
	}
	public Tetromino()
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
		*<br>Tetrominos existants :
		*O, T, L, J, I, Z, S
		*/
		
		boolean[][] poly;
		
		switch(nom)
		{
			case 'O':
			{
				poly = new boolean[][]{{true, true}, {true, true}};
			} break;
			
			case 'T':
			{
				poly = new boolean[][]{{true, true, true}, {false, true, false}};
			} break;
			
			case 'L':
			{
				poly = new boolean[][]{{false, false, true}, {true, true, true}};
			} break;
			
			case 'J':
			{
				poly = new boolean[][]{{true, true, true}, {false, false, true}};
			} break;
			
			case 'Z':
			{
				poly = new boolean[][]{{true, true, false}, {false, true, true}};
			} break;
			
			case 'S':
			{
				poly = new boolean[][]{{false, true, true}, {true, true, false}};
			} break;
			
			default:
			{
				poly = new boolean[][]{{true, true, true, true}};
			} break;
		}
		
		super.setMatrice(poly);
	}
}
