class PGCD
{
	
	public static int PGCDRecursif(int a, int b)
	{
		
		/**
		*@param a typer entier naturel
		*@param b type entier naturel
		*@return le PGCD de a et b
		*/
		
		if (a < b)
		{
			return PGCD(b, a);
		} else if (a >= b && b==0)
		{
			return a;
		} else if (a >= b && b != 0)
		{
			return PGCD(b, a%b);
		}
		
		return -1;
	}
	
	public static int PGCD(int a, int b)
	{
		
		/**
		*@param a type entier naturel
		*@param b type entier naturel
		*@return le pgcd de a et b
		*/
		
		if (a < b)
		{
			return PGCD(b, a);
		} else if (b == 0) {
			return a;
		} else {
			return PGCD(a-b, b);
		}
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(PGCD(7, 77));
		System.out.println(PGCDRecursif(7, 77));
	}
}
