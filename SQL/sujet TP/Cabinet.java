public class Cabinet
{
	
	public static String adresse = "sql7.freemysqlhosting.net";
	public static String bd = "sql7614286";
	public static String login = "sql7614286";
	public static String password = "K55YjyNVWK";

	public static void main(String[] args)
	{
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);
		
		// creation de la requete
		String sql = "SELECT NumSecu, Nom, COUNT(NumCons) AS NbCons "
				+"FROM PATIENT INNER JOIN CONSULTATION ON NumSecu=Patient GROUP BY Patient";
		
		// envoi de la requete
		int res = BD.executerSelect(connexion, sql);
		
		// parcours du resultat (ligne par ligne)
		while (BD.suivant(res))
		{
			long NumSecu = BD.attributLong(res,"NumSecu");
			String Nom = BD.attributString(res,"Nom");
			String NbCons = BD.attributString(res,"NbCons");
			
			System.out.println(""+NumSecu+ "\t"+ Nom +"\t"+NbCons);
		}
		
		BD.fermerResultat(res);
		BD.fermerConnexion(connexion);
	}
}
