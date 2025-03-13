class Cercle {
	
	/*PARAMETRES						*/
	Point origine;
	double rayon;
	
	
	public 
	
	/*CONSTRUCTEURS						*/
	public Cercle()
	{
		
		/*affectation par defaut des parametres		*/
		this.affecter(new Point(), 1);
	}
	public Cercle(Point origine, double rayon) {
		
		/*chargement des parametres			*/
		this.affecter(origine, rayon);
	}
	
	public String afficherParam() {
		// sont retourne : les parametres de this
		
		// renvois des parametres
		return "("+this.origine.afficherCoord()+", "+this.rayon+")";
	}
	
	// entree : Point point
	public void posRelativeA(Point point) {
		// est affichee : la position relative de point par rapport a this
		
		if (this.origine.distantDe(point) < this.rayon) {
			Ecran.afficherln("Le point : ", point.afficherCoord(), " est strictement a l'interieur du cercle");
		} else if (this.origine.distantDe(point) > this.rayon) {
			Ecran.afficherln("Le point : ", point.afficherCoord(), " est strictement a l'exterieur du cercle");
		} else {
			Ecran.afficherln("Le point : ", point.afficherCoord(), " est sur le bord du cercle");
		}
	}
}
