/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

class Machine extends Joueur
{
	
	/*ATTRIBUTS			*/
	/*CONSTRUCTEURS		*/
	public Machine(Polyomino[] jeuPolyos)
	{
		
		/**
		*constructeur principal
		*@param jeuPolyos type tableau de Polyominos
		*@return l'affectation des attributs
		* par appel du constructeur principal de la super classe
		*/
		
		super(jeuPolyos, "M"+(int)(Math.random()*1000000));
	}
	
	/*METHODES			*/
	@Override
	public int placerPolyo(Plateau plateau)
	{
		
		/**
		*@param plateau type Plateau
		*@return le placement d'un polyomino
		* par methode naive
		*/
		
		int nbPolyos = jeuDePolyos.length;
		int nbLignes = plateau.getNbLignes();
		int nbColonnes = plateau.getNbColonnes();
		
		for (int idPoly=0; idPoly<nbPolyos; idPoly++)
		{
			Polyomino poly = jeuDePolyos[idPoly];
			int nbLignesPoly = poly.getNbLignes();
			int nbColonnesPoly = poly.getNbColonnes();
			
			for (int orient=0; orient<4; orient++)
			{
				
				for (int ligne=0; ligne<nbLignes-nbLignesPoly; ligne++)
				{
					
					for (int colonne=0; colonne<nbColonnes-nbColonnesPoly; colonne++)
					{
						
						if (poly.peutEtrePlaceEn(ligne, colonne, plateau))
						{
							plateau.placerPiece(poly, ligne, colonne);
							jeuDePolyos = retirerPolyo(idPoly);
							plateau.afficher();
							return 0;
						}
					}
				}
				
				poly.tourner();
			}
		}
		return -1;
	}
}
