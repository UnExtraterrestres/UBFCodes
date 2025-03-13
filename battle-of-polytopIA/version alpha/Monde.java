class Monde
{
	
	/*attributs		*/
	int largeur;
	Terrain[][] terrains;
	
	/*constructeur	*/
	public Monde(int larg)
	{
		
		largeur = larg;
		terrains = new Terrain[largeur][largeur];
		this.genererTerrain();
	}
	public Monde()
	{
		
		this(8);
	}
	
	/*methodes	*/
	
	public void genererTerrain()
	{
		
		for (int i = 0; i<largeur; i++)
		{
			for (int j = 0; j<largeur; j++)
			{
				terrains[i][j] = new Terrain();
			}
		}
	}
	
	public String versChaine()
	{
		
		String chaine = "Monde "+largeur+"x"+largeur;
		for (int i = 0; i<largeur; i++)
		{
			chaine += "\n\n\n";
			for (int j = 0; j<largeur; j++)
			{
				chaine += terrains[i][j].versChaine()+"\t\t";
			}
		}
		
		return chaine;
	}
	
	public void afficher()
	{
		
		System.out.println(this.versChaine());
	}
}
