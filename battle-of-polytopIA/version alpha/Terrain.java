class Terrain
{
	
	/*attributs		*/
	String nom;
	boolean brouillard;
	boolean ressource;
	boolean batiment;
	
	/*constructeurs	*/
	public Terrain(String nom, boolean brou, boolean rsc, boolean bat)
	{
		
		this.nom = nom;
		brouillard = brou;
		ressource = rsc;
		batiment = bat;
	}
	public Terrain()
	{
		this("terrain", true, false, false);
	}
	
	/*methodes	*/
	
	private char carDuNom()
	{
		
		if (brouillard) {return '~';}
		
		char car = '?';
		switch (nom)
		{
			default:
				car = '?';
			break;
		}
		
		return car;
	}
	
	public String versChaine()
	{
		
		String chaine = ""+this.carDuNom();
		if (ressource) {chaine+="1";}
		else {chaine+="0";}
		if(batiment) {chaine+="1";}
		else {chaine+="0";}
		
		return chaine;
	}
}
