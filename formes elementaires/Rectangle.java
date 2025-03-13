public class Rectangle
{
	
	/*ATTRIBUTS						*/
	double longueur;
	double hauteur;
	Point2D cig; /*coin inferieur gauche 		*/
	
	/*METHODES						*/
	public void afficher()
	{
		/**
		*@return l'affichage des attributs du rectangle
		*/
		
		System.out.print("Rectangle:"+this);
		System.out.print(" Longueur:"+this.longueur);
		System.out.print(" Hauteur:"+this.hauteur);
		System.out.print(" Coin inferieur gauche:");
		this.cig.afficher();
		System.out.println("");
	}
	
	public double distanceValide(double distance)
	{
		
		/**
		*@param distance type réél
		*@return distance si distance>0
		*-distance si distance < 0
		*1.0 sinon
		*/
		
		if (distance > 0)
		{
			return distance;
		} else if (distance < 0)
		{
			return -distance;
		} else
		{
			return 1.0;
		}
	}
	
	public double perimetre()
	{
		
		/**
		*@return le perimetre du rectangle
		*comme double de la somme de longueur et hauteur
		*/
		
		return 2*(this.longueur+this.hauteur);
	}
	
	public double aire()
	{
		
		/**
		*@return l'aire du rectangle
		*comme produit de longueur et hauteur
		*/
		
		return this.longueur*this.hauteur;
	}
	
	public double diagonale()
	{
		
		/**
		*@return la longueur de la diagonale du rectangle
		*comme racine de la somme des carres de longueur et hauteur
		*/
		
		return Math.sqrt(this.longueur*this.longueur + this.hauteur*this.hauteur);
	}
	
	public Point2D centre()
	{
		
		/**
		*@return le centre Point2D du rectangle
		*/
		
		return new Point2D(this.cig.x+this.longueur/2, this.cig.y+this.hauteur/2);
	}
	
	public double distanceCentreOrigine()
	{
		
		/**
		*@return la distance entre le centre et l'origine
		*/
		
		return this.centre().distanceOrigine();
	}
	
	/*CONSTRUCTEUR					*/
	public Rectangle()
	{
		
		/**
		*@return l'affectation des attributs
		*par defaut
		*/
		
		this.longueur = 2.0;
		this.hauteur = 1.0;
		this.cig = new Point2D();
	}
	public Rectangle(double longueur, double hauteur)
	{
		
		/**
		*@param longueur type reel strictement positif
		*@param hauteur type reel strictement positif
		*@return l'affectation des attribut
		*par les valeurs specifiees
		*/
		
		this.longueur = this.distanceValide(longueur);
		this.hauteur = this.distanceValide(hauteur);
		this.cig = new Point2D();
	}
	public Rectangle(double longueur, double hauteur, Point2D cig)
	{
		
		/**
		*@param longueur type reel strictement positif
		*@param hauteur type reel strictement positif
		*@param cig type Point2D specifie
		*/
		
		this.longueur = longueur;
		this.hauteur = hauteur;
		this.cig = cig;
	}
}
