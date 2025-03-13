public class Convertion{
	
	public static void main(String args[]){
		
		// declaration de la donnee
		long nombre = 0;
		// declaration des resultats
		long  gio, mio, kio, o;
		
		// saisie de la donnee
		while(nombre <= 0){
			Ecran.afficher("entrez le nombre d'entier : ");
			nombre = Clavier.saisirLong();
		}
		
		// calcul des resultats
		gio = nombre / 1024*1024*1024;
		nombre %= 1024*1024*1024;
		mio = nombre / 1024*1024;
		nombre %= 1024*1024;
		kio = nombre / 1024;
		nombre %= 1024;
		o = nombre % 1024;
		nombre = gio*1024*1024*1024 + mio*1024*1024 + kio*1024 + o;
		
		// affichage des resultats
		Ecran.afficher(nombre, " corresponent à \n");
		Ecran.afficher(gio, " Gio ", mio, " Mio ", kio, " Kio ", o , " o");
		
	}
}
