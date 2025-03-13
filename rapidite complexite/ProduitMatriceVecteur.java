class ProduitMatriceVecteur
{
	
	public static void produitMatriceVecteur(double[][] mat, double[][] vec, double[][] produit)
	{
		
		/**
		*@param mat type matrice de reels
		*@param vec type vecteur de reels
		*@param produit type vecteur de reels
		*@return l'affectation a produit du produit de mat et vec
		*/
		
		int n = vec.length;
		
		for (int i = 0; i<n; i++)
		{
			produit[i] = 0.0;
			
			for (int j = 0; j<n; j++)
			{
				produit[i] += mat[i][j]*vec[j];
			}
		}
	}
	
	public static double[][] produitMatricesCarrees(double[][] mat1, double[][] mat2)
	{
		
		/**
		*@param mat1 type matrice carree de reels
		*@param mat2 type matrice carree de reels
		*@return le produit de mat1 et mat2
		*/
		
		int n = mat1.length;
		
		double [][] produit = new double[n][n];
		
		for (int i = 0; i<n; i++)
		{
			
			for (int j = 0; j<n; j++)
			{
				produit[i][j] = 0.0;
				
				for (int k = 0; k<n; k++)
				{
					produit[i][j] += mat1[i][k]*mat2[i][k];
				}
			}
		}
		
		return produit;
	}
	
	public static double[][] produitMatriceMatrice(double[][] mat1, double[][] mat2)
	{
		
		/**
		*@param mat1 type matrice de reels de taille n.m
		*@param mat2 type matrice de reels de taille m.p
		*@return le produit de mat1 et mat2
		*/
		
		int n = mat1.length;
		int m = mat2.length;
		int p = mat2[0].length;
		
		double[][] produit = new double[n][p];
		
		for (int i = 0; i<n; i++)
		{
			
			for (int j = 0; j<p; j++)
			{
				produit[i][j] = 0.0;
				
				for (int k = 0; k<m; k++)
				{
					
					produit[i][j] += mat1[i][k]*mat2[k][j];
				}
			}
		}
		
		return produit;
	}
	
	public static void main(String[] args)
	{
		
		/*
		*Defini un vecteur de reels
		*Defini deux matrices carrees
		*Defini une matrice non carree
		*/
		
		/*Mesure temps produit matrice-vecteur				*/
		
		/*Mesure temps produit matrice-carre				*/
		
		/*Mesure temps produit matrice-matrice				*/
	}
}
