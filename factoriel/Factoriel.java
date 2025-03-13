class Factoriel
{
	
	public static int factoriel(int nombre)
	{
		
		/**
		*@param nombre type entier naturel
		*@return la factoriel de nombre
		*/
		
		if (nombre==0)
		{
			return 1;
		} else {
			return factoriel(nombre-1);
		}
	}
	
	public static main(String[] args)
	{
		
		System.out.println(factoriel(0));
		System.out.println(factoriel(10));
	}
}
