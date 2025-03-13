public class Grille
{
	
	/** PARAMETRES			 */
	char [][] grille = this.presetGrille(10, 10);
	
	public void afficher(boolean bateau_visible)
	{
		
		/**
		*@return l'affichage de la grille
		*/
		
		Ecran.afficherln("	A	B	C	D	E	F	G	H	I	J");
		for (int y = 0; y < this.grille.length; y++)
		{
			Ecran.afficher(y+1);
			for (int x = 0; x < this.grille[y].length; x++)
			{
				
				Ecran.afficher("	", this.grille[y][x]);
			}
			Ecran.sautDeLigne();
			Ecran.sautDeLigne();
		}
	}
	
	public char[][] presetGrille(int taille_x, int taille_y)
	{
		/**
		*@param taille_x type entier naturel
		*@param taille_y type entier naturel
		*@return une grille de type tableau de caractere
		*/
		
		char [][] table = new char[taille_y][taille_x];
		
		for (int y =0; y < taille_y; y++)
		{
			for (int x = 0; x < taille_x; x++)
			{
				table[y][x] = '~';
			}
		}
		
		return table;
	}
}
