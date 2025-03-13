public class Moi
{
	
	public static String adresse = "sql7.freemysqlhosting.net";
	public static String bd = "sql7614286";
	public static String login = "sql7614286";
	public static String password = "K55YjyNVWK";
	
	public static void main(String[] args)
	{
		
		String moiNom = "Willfrid Foucon";
		long moiNumSecu = 10403771851818L;
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);
		
		// creation de la requete
		//~ String sql = "INSERT INTO PATIENT (NumSecu, Nom) VALUES("+moiNumSecu+",'"+moiNom+"')";
		
		String sql = "INSERT INTO CONSULTATION (Medecin, Patient, Date) "
				+"VALUES (526736, 10403771851818, CURRENT_DATE)";
		
		// envoi de la requete
		int res = BD.executerUpdate(connexion, sql);
		
		System.out.println(res);
		
		BD.fermerResultat(res);
		BD.fermerConnexion(connexion);
	}
}
