public class Test
{
	
	public static String adresse = "sql7.freemysqlhosting.net";
	public static String bd = "sql7614286";
	public static String login = "sql7614286";
	public static String password = "K55YjyNVWK";

	public static void main(String[] args)
	{
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);
		
		// creation de la requete
		String sql = "SELECT NumSecu, Nom"
				+" FROM PATIENT";
		
		// envoi de la requete
		int res = BD.executerSelect(connexion, sql);
		
		// parcours du resultat (ligne par ligne)
		while (BD.suivant(res))
		{
			long NumSecu = BD.attributLong(res,"NumSecu");
			String Nom = BD.attributString(res,"Nom");
			
			System.out.println(""+NumSecu+ "\t"+ Nom);
		}
		
		BD.fermerResultat(res);
		BD.fermerConnexion(connexion);
	}
}
