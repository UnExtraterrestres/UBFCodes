class Main
{
	
	public static void afficherMesures(Rectangle rect)
	{
		
		/**
		*@param rect type Rectangle
		*@return l'affichage de rect.perimetre .aire et .diagonale
		*/
		
		rect.afficher();
		System.out.println("Perimetre:"+rect.perimetre());
		System.out.println("Aire:"+rect.aire());
		System.out.println("Diagonale:"+rect.diagonale());
		System.out.println("Centre du Rectangle:");
		rect.centre().afficher();
		System.out.println("Distance centre-origine:"+rect.distanceCentreOrigine());
		System.out.println("");
	}
	
	public static void afficherMesures(Point2D point)
	{
	
		/**
		*@param point type Point2D
		*@return l'affichage de point.distanceALOrigine et .distanceAuPoint2D
		*/
		
		point.afficher();
		System.out.println("Distance a l'origine:"+point.distanceOrigine());
		
		Point2D pAux = new Point2D(Math.random(), Math.random());
		pAux.afficher();
		System.out.println("Distance au point:"+point.distanceAvec(pAux));
		System.out.println("");
	}
	
	public static void main(String[] args)
	{
		
		/*Declarations de Rectangles pour tests				*/
		Rectangle rectDefaut = new Rectangle();
		rectDefaut.afficher();
		
		Rectangle rectNul = new Rectangle(0.0, 0.0);
		rectNul.afficher();
		
		Rectangle rectNeg = new Rectangle(-100.0, 60.0);
		rectNeg.afficher();
		
		System.out.println("\n\n\n");
		
		/*Affichage des mesures des rectangles declares		*/
		afficherMesures(rectDefaut);
		afficherMesures(rectNul);
		afficherMesures(rectNeg);
		
		System.out.println("\n\n\n");
		
		/*Declaration de Point2Ds pour tests				*/
		Point2D pDefaut = new Point2D();
		pDefaut.afficher();
		
		Point2D pQuelconque = new Point2D(Math.random(), Math.random());
		pQuelconque.afficher();
		
		System.out.println("\n\n\n");
		
		/*Affichage des mesures des point2Ds declares		*/
		afficherMesures(pDefaut);
		afficherMesures(pQuelconque);
	}
}
