/**
*
*Foucon Willfrid
*UBFC - L1ST - APOO - Projet TP 2023
*/

abstract class Joueur
{
	
	/*ATTRIBUTS			*/
	protected Polyomino[] jeuDePolyos;
	protected String nom;
	
	/*CONSTRUCTEURS		*/
	public Joueur(Polyomino[] jeuPolyos, String nom)
	{
		
		/**
		*constructeur principal
		*@param jeuPolyos type tableau de polyominos
		*@param nom type chaine de caracteres
		*@return l'affectation des attributs
		* par des valeurs specifiees
		*/
		
		jeuDePolyos = jeuPolyos;
		this.nom = nom;
	}
	
	/*METHODES			*/
	protected void afficherJeuDePolyos()
	{
		
		/**
		*@return l'affichage dans la console des pieces du jeu de polyominos
		*/
		
		int nbPolyos = jeuDePolyos.length;
		
		for (int idPol=0; idPol<nbPolyos; idPol++)
		{
			System.out.println("["+idPol+"] :\n"+jeuDePolyos[idPol].versChaine());
		}
	}
	
	public void afficher()
	{
		
		/**
		*@return l'affichage dans la console du joueur
		*/
		
		System.out.println("Nom du joueur : "+nom+"\nJeu du pieces : ");
		afficherJeuDePolyos();
	}
	
	abstract int placerPolyo(Plateau plateau);
	
	protected Polyomino[] retirerPolyo(int indicePol)
	{
		
		/**
		*@param indicePol
		*@return un nouveau jeu de piece
		* auquel on a retire le polyomino en indice specifie
		*/
		
		afficherJeuDePolyos();
		Polyomino[] aux = new Polyomino[jeuDePolyos.length-1];
		
		int idPol = 0;
		for (int i=0; i<jeuDePolyos.length; i++)
		{
			if (i!=indicePol)
			{
				aux[idPol] = jeuDePolyos[i];
				idPol ++;
			}
		}
		
		return aux;
	}
	
	protected void tournerPolyos()
	{
		
		/**
		*@return tourne tous les polyominos du joueur
		*/
		
		for (int i=0; i<jeuDePolyos.length; i++)
		{
			jeuDePolyos[i].tourner();
		}
	}
}
