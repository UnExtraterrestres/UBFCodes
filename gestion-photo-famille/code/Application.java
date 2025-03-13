class Application
{
	
	public static String adresse = "sql7.freemysqlhosting.net";
	public static String bd = "sql7618982";
	public static String login = "sql7618982";
	public static String password = "hIWBixQEvB";

	public static void main(String[] args) {
		
		int connexion = 0;
		
		int choix;
		
		do {
			afficherMenu();
			System.out.print("Entrez le chiffre de votre choix : ");
			choix = Clavier.saisirInt();

			switch (choix) {
				case 1:
					ajouterTable();
					break;
				case 2:
					supprimerTable();
					break;
				case 3:
					modifierTable();
					break;
				case 4:
					rechercherTable();
					break;
				case 5:
					System.out.println("Fin du programme.");
					break;
				default:
					System.out.println("Choix invalide. Veuillez réessayer.");
			}
		} while (choix != 5);
		
		BD.fermerConnexion(connexion);
	}
	
	/*MENUS								*/
	public static void afficherMenu() {
		
		String[] menu = new String[]{
			"----- MENU -----",
			"1. Ajouter une table",
			"2. Supprimer une table",
			"3. Modifier une table",
			"4. Rechercher dans une table",
			"5. Quitter",
			"----------------"
			};
			
		
		
		for (int i=0; i<menu.length; i++)
		{
			System.out.println(menu[i]);
		}
	}
	
	public static void afficherMenu(String nomMenu) {
		
		String[] menu = new String[]{
			"album",
			"individu",
			"evenement",
			"photo",
			"apparition"
			};
		
		
		for (int i=0; i<menu.length; i++)
		{
			System.out.println((i+1)+". "+nomMenu+menu[i]);
		}
	}

	public static void ajouterTable() {
		int achoix;
		
		afficherMenu("Ajout ");
		System.out.println("6. Quitter");
		do {
			System.out.println("Entrez le chiffre de votre choix :");
			achoix = Clavier.saisirInt();

			switch (achoix) {
				case 1:
					System.out.print("Entrez l'ID de l'ambum : ");
					int aID = Clavier.saisirInt();
					System.out.print("Entrez le nom de l'ambum : ");
					String anom = Clavier.saisirString();
					ajoutAlbum(aID, anom);
					break;
				case 2:
					System.out.print("Entrez l'ID de l'individu : ");
					int a1ID = Clavier.saisirInt();
					System.out.print("Entrez l'ID du pere de l'individu : ");
					int a1IDp = Clavier.saisirInt();
					System.out.print("Entrez l'ID de la mere de l'individu : ");
					int a1IDm = Clavier.saisirInt();
					System.out.print("Entrez le nom de l'individu : ");
					String a1nom = Clavier.saisirString();
					System.out.print("Entrez le prenom de l'individu : ");
					String a1prenom = Clavier.saisirString();
					ajoutIndividu(a1ID, a1IDp, a1IDm, a1nom, a1prenom);
					break;
				case 3:
					System.out.print("Entrez l'ID de l'evenement : ");
					int a2ID = Clavier.saisirInt();
					System.out.print("Entrez le nom de l'evenement : ");
					String a2nom = Clavier.saisirString();
					System.out.print("Entrez la date de l'evenement : ");
					String a2date = Clavier.saisirString();
					ajoutEvenement(a2ID, a2nom, a2date);
					break;
				case 4:
					System.out.print("Entrez l'ID de la photo : ");
					int a3ID = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'album : ");
					int a3IDa = Clavier.saisirInt();
					System.out.print("Entrez le numero de la page : ");
					int a3numP = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'evenement : ");
					int a3IDe = Clavier.saisirInt();
					ajoutPhoto(a3ID, a3IDa, a3numP, a3IDe);
					break;
				case 5:
					System.out.print("Entrez l'ID de la photo : ");
					int a4IDp = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'individu : ");
					int a4IDi = Clavier.saisirInt();
					ajoutApparait(a4IDp, a4IDi);
					break;
				case 6:
					System.out.println("Fermeture du menu.");
					break;
				default:
					System.out.println("Choix invalide. Veuillez réessayer.");
			}
		} while (achoix != 6);
	}

	public static void supprimerTable() {
		int schoix;
		
		afficherMenu("Suppresion ");
		System.out.println("6. Quitter");
		do {
			System.out.println("Entrez le chiffre de votre choix :");
			schoix = Clavier.saisirInt();

			switch (schoix) {
				case 1:
					System.out.print("Entrez l'ID de l'album : ");
					int ID = Clavier.saisirInt();
					suppressionAlbum(ID);
					break;
				case 2:
					System.out.print("Entrez l'ID de l'individu : ");
					int sID = Clavier.saisirInt();
					suppressionIndividu(sID);
					break;
				case 3:
					System.out.print("Entrez l'ID de l'evenement : ");
					int s1ID = Clavier.saisirInt();
					suppressionEvenement(s1ID);
					break;
				case 4:
					System.out.print("Entrez l'ID de la photo : ");
					int s2ID = Clavier.saisirInt();
					suppressionPhoto(s2ID);
					break;
				case 5:
					System.out.print("Entrez l'ID de la photo : ");
					int IDp = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'individu : ");
					int IDi = Clavier.saisirInt();
					suppressionApparait(IDp, IDi);
					break;
				case 6:
					System.out.println("Fermeture du menu.");
					break;
				default:
					System.out.println("Choix invalide. Veuillez réessayer.");
			}
		} while (schoix != 6);
	}

	public static void modifierTable() {
		int mchoix;
		
		afficherMenu("Modification ");
		System.out.println("6. Quitter");
		do {
			System.out.println("Entrez le chiffre de votre choix :");
			mchoix = Clavier.saisirInt();

			switch (mchoix) {
				case 1:
					System.out.print("Entrez l'ID de l'ambum : ");
					int ID = Clavier.saisirInt();
					System.out.print("Entrez le nom de l'ambum : ");
					String nom = Clavier.saisirString();
					modificationAlbum(ID, nom);
					break;
				case 2:
					System.out.print("Entrez l'ID de l'individu : ");
					int mID = Clavier.saisirInt();
					System.out.print("Entrez l'ID du pere de l'individu : ");
					int mIDp = Clavier.saisirInt();
					System.out.print("Entrez l'ID de la mere de l'individu : ");
					int mIDm = Clavier.saisirInt();
					System.out.print("Entrez le nom de l'individu : ");
					String mnom = Clavier.saisirString();
					System.out.print("Entrez le prenom de l'individu : ");
					String mprenom = Clavier.saisirString();
					modificationIndividu(mID, mIDp, mIDm, mnom, mprenom);
					break;
				case 3:
					System.out.print("Entrez l'ID de l'evenement : ");
					int m1ID = Clavier.saisirInt();
					System.out.print("Entrez le nom de l'evenement : ");
					String m1nom = Clavier.saisirString();
					System.out.print("Entrez la date de l'evenement : ");
					String m1date = Clavier.saisirString();
					modificationEvenement(m1ID, m1nom, m1date);
					break;
				case 4:
					System.out.print("Entrez l'ID de la photo : ");
					int m2ID = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'album : ");
					int m2IDa = Clavier.saisirInt();
					System.out.print("Entrez le numero de la page : ");
					int m2numP = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'evenement : ");
					int m2IDe = Clavier.saisirInt();
					modificationPhoto(m2ID, m2IDa, m2numP, m2IDe);
					break;
				case 5:
					System.out.print("Entrez l'ID de la photo : ");
					int IDp = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'individu : ");
					int IDi = Clavier.saisirInt();
					System.out.print("Entrez le nouveau ID de la photo : ");
					int nIDp = Clavier.saisirInt();
					System.out.print("Entrez le nouveau ID de l'individu : ");
					int nIDi = Clavier.saisirInt();
					modificationApparait(IDp, IDi, nIDp, nIDi);
					break;
				case 6:
					System.out.println("Fermeture du menu.");
					break;
				default:
					System.out.println("Choix invalide. Veuillez réessayer.");
			}
		} while (mchoix != 6);
	}

	public static void rechercherTable() {
		int rchoix;
		afficherMenu("Recherche ");
		System.out.println("6. Recherche photos de familles");
		System.out.println("7. Recherche d'albums et pages par individu");
		System.out.println("8. Recherche des personnes d'une m�me famille.");
		System.out.println("9. Quitter");
		do {
			System.out.println("Entrez le chiffre de votre choix :");
			rchoix = Clavier.saisirInt();

			switch (rchoix) {
				case 1:
					System.out.print("Entrez l'ID de l'album : ");
					int ID = Clavier.saisirInt();
					System.out.println(rechercheAlbum(ID));
					break;
				case 2:
					System.out.print("Entrez l'ID de l'individu : ");
					int rID = Clavier.saisirInt();
					System.out.println(rechercheIndividu(rID));
					break;
				case 3:
					System.out.print("Entrez l'ID de l'evenement : ");
					int r1ID = Clavier.saisirInt();
					System.out.println(rechercheEvenement(r1ID));
					break;
				case 4:
					System.out.print("Entrez l'ID de la photo : ");
					int r2ID = Clavier.saisirInt();
					System.out.println(recherchePhoto(r2ID));
					break;
				case 5:
					System.out.print("Entrez l'ID de la photo : ");
					int IDp = Clavier.saisirInt();
					System.out.print("Entrez l'ID de l'individu : ");
					int IDi = Clavier.saisirInt();
					System.out.println(rechercheApparait(IDp, IDi));
					break;
				case 6:
					System.out.print("Entrez le nom de l'individu : ");
					String nom = Clavier.saisirString();
					System.out.print("Entrez le prenom de l'individu : ");
					String prenom = Clavier.saisirString();
					System.out.println(recherchePhotosFamille(nom, prenom));
					break;
				case 7:
					System.out.print("Entrez le nom de l'individu : ");
					String r3nom = Clavier.saisirString();
					System.out.print("Entrez le prenom de l'individu : ");
					String r3prenom = Clavier.saisirString();
					System.out.println(rechercheAlbumsPagesParIndividu(r3nom, r3prenom));
					break;
				case 8:
					System.out.println("Entrez le nom de l'individu : ");
					String nomIndividu = Clavier.saisirString();
					System.out.println("Entrez le prenom de l'individu : ");
					String prenomIndividu = Clavier.saisirString();
					System.out.println(rechercheFamille(nomIndividu, prenomIndividu));
					break;
				case 9:
					System.out.println("Fermeture du menu.");
					break;
				default:
					System.out.println("Choix invalide. Veuillez réessayer.");
			}
		} while (rchoix != 9);
	}
	
	
	/* REQUETES PRINCIPALES				*/
	
	/*AJOUT								*/
	/*album								*/
	public static void ajoutAlbum(int ID, String nom)
	{
		
		/**
		*@param connexion type entier
		*@param ID type entier
		*@param nom type chaine de caractere
		*@return l'ajout d'un album à la BD
		*/
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);
		
		String requete = "INSERT INTO ALBUM (IDAlbum, nomAlbum)"
			+ "VALUES ("+ID+", "+'"'+nom+'"'+")";
		
		int result = BD.executerUpdate(connexion, requete);
		
		BD.fermerResultat(result);
	}
	
	/*individu								*/
	public static void ajoutIndividu(int ID, int IDPere, int IDMere, String nomInd, String prenomInd) {
		/**
		* @param connexion type entier
		* @param ID type entier
		* @param IDPere type entier
		* @param IDMere type entier
		* @param nomInd type chaine de caractere
		* @param prenomInd type chaine de caractere
		* @return l'ajout d'un individu à la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);
		
		String requete = "INSERT INTO INDIVIDU (IDInd, IDPere, IDMere, nomInd, PrenomInd) " +
			     "VALUES (" + ID + ", " + IDPere + ", " + IDMere + ", '" + nomInd + "', '" + prenomInd + "')";

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}

	/*evenement							*/
	public static void ajoutEvenement(int IDEvenement, String libelleEvenement, String dateEvenement) {
		/**
		* @param connexion type entier
		* @param IDEvenement type entier
		* @param libelleEvenement type chaine de caractere
		* @param dateEvenement type chaine de caractere
		* @return l'ajout d'un evenement à la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "INSERT INTO EVENEMENT (IDEvenement, LibelleEvenement, DateEvenement) " +
			     "VALUES (" + IDEvenement + ", '" + libelleEvenement + "', '" + dateEvenement + "')";

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}

	/*photo								*/
	public static void ajoutPhoto(int IDPhoto, int IDAlbum, int numPage, int IDEvenement) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @param IDAlbum type entier
		* @param numPage type entier
		* @param IDEvenement type entier
		* @return l'ajout d'une photo à la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "INSERT INTO PHOTO (IDPhoto, IDAlbum, NumPage, IDEvenement) " +
			     "VALUES (" + IDPhoto + ", " + IDAlbum + ", " + numPage + ", " + IDEvenement + ")";

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}

	/*apparait								*/
	public static void ajoutApparait(int IDPhoto, int IDInd) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @param IDInd type entier
		* @return l'ajout de l'apparition d'une photo d'un individu à la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "INSERT INTO APPARAIT (IDPhoto, IDInd) " +
			     "VALUES (" + IDPhoto + ", " + IDInd + ")";

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}
	
	/*SUPPRESSION						*/
	/*album								*/
	public static void suppressionAlbum(int ID)
	{
		
		/**
		*@param connexion type entier
		*@param ID type entier
		*@return la suppression d'un album de la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);
		
		String requete = "DELETE FROM ALBUM WHERE IDAlbum="+ID;
		
		int result = BD.executerUpdate(connexion, requete);
		
		BD.fermerResultat(result);
	}
	
	/*individu 								*/
	public static void suppressionIndividu(int ID) {
		/**
		* @param connexion type entier
		* @param ID type entier
		* @return la suppression d'un individu de la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "DELETE FROM INDIVIDU WHERE IDInd=" + ID;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}

	/*evenement							*/
	public static void suppressionEvenement(int IDEvenement) {
		/**
		* @param connexion type entier
		* @param IDEvenement type entier
		* @return la suppression d'un événement de la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "DELETE FROM EVENEMENT WHERE IDEvenement=" + IDEvenement;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}
	
	/*photo								*/
	public static void suppressionPhoto(int IDPhoto) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @return la suppression d'une photo de la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "DELETE FROM PHOTO WHERE IDPhoto=" + IDPhoto;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}
	
	/*apparait								*/
	public static void suppressionApparait(int IDPhoto, int IDInd) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @param IDInd type entier
		* @return la suppression de l'apparition d'une photo d'un individu de la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "DELETE FROM APPARAIT WHERE IDPhoto=" + IDPhoto + " AND IDInd=" + IDInd;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}
	
	/*MODIFICATION						*/
	/*album								*/
	public static void modificationAlbum(int ID, String nouveauNom) {
		/**
		* @param connexion type entier
		* @param ID type entier
		* @param nouveauNom type chaine de caractere
		* @return la modification du nom d'un album dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "UPDATE ALBUM SET nomAlbum = '" + nouveauNom + "' WHERE IDAlbum = " + ID;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}

	/*individu								*/
	public static void modificationIndividu(int ID, int IDPere, int IDMere, String nouveauNomInd, String nouveauPrenomInd) {
		/**
		* @param connexion type entier
		* @param ID type entier
		* @param IDPere type entier
		* @param IDMere type entier
		* @param nouveauNomInd type chaine de caractere
		* @param nouveauPrenomInd type chaine de caractere
		* @return la modification des informations d'un individu dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "UPDATE INDIVIDU SET IDPere = " + IDPere + ", IDMere = " + IDMere + ", nomInd = '" + nouveauNomInd +
			     "', PrenomInd = '" + nouveauPrenomInd + "' WHERE IDInd = " + ID;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}

	/*evenement							*/
	public static void modificationEvenement(int IDEvenement, String nouveauLibelleEvenement, String nouvelleDateEvenement) {
		/**
		* @param connexion type entier
		* @param IDEvenement type entier
		* @param nouveauLibelleEvenement type chaine de caractere
		* @param nouvelleDateEvenement type chaine de caractere
		* @return la modification des informations d'un evenement dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "UPDATE EVENEMENT SET LibelleEvenement = '" + nouveauLibelleEvenement + "', DateEvenement = '" +
			     nouvelleDateEvenement + "' WHERE IDEvenement = " + IDEvenement;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}
	
	/*photo								*/
	public static void modificationPhoto(int IDPhoto, int nouvelIDAlbum, int nouvelleNumPage, int nouvelIDEvenement) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @param nouvelIDAlbum type entier
		* @param nouvelleNumPage type entier
		* @param nouvelIDEvenement type entier
		* @return la modification des informations d'une photo dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "UPDATE PHOTO SET IDAlbum = " + nouvelIDAlbum + ", NumPage = " + nouvelleNumPage +
			     ", IDEvenement = " + nouvelIDEvenement + " WHERE IDPhoto = " + IDPhoto;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}
	
	/*apparait								*/
	public static void modificationApparait(int IDPhoto, int IDInd, int nouvelIDPhoto, int nouvelIDInd) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @param IDInd type entier
		* @param nouvelIDPhoto type entier
		* @param nouvelIDInd type entier
		* @return la modification des informations de l'apparition d'une photo d'un individu dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "UPDATE APPARAIT SET IDPhoto = " + nouvelIDPhoto + ", IDInd = " + nouvelIDInd +
		     " WHERE IDPhoto = " + IDPhoto + " AND IDInd = " + IDInd;

		int result = BD.executerUpdate(connexion, requete);

		BD.fermerResultat(result);
	}
	
	/*RECHERCHE							*/
	/*album								*/
	public static String rechercheAlbum(int ID) {
		/**
		* @param connexion type entier
		* @param ID type entier
		* @return une chaîne de caractères représentant le résultat de la recherche d'un album dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT * FROM ALBUM WHERE IDAlbum = " + ID;

		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";

		while (BD.suivant(resultat)) {
			int idAlbum = BD.attributInt(resultat, "IDAlbum");
			String nomAlbum = BD.attributString(resultat, "nomAlbum");

			resultatString += "IDAlbum: " + idAlbum + ", NomAlbum: " + nomAlbum + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}
	/*individu								*/
	public static String rechercheIndividu(int ID) {
		/**
		* @param connexion type entier
		* @param ID type entier
		* @return une chaîne de caractères représentant le résultat de la recherche d'un individu dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT * FROM INDIVIDU WHERE IDInd = " + ID;

		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";
		
		while (BD.suivant(resultat)) {
			int idInd = BD.attributInt(resultat, "IDInd");
			int idPere = BD.attributInt(resultat, "IDPere");
			int idMere = BD.attributInt(resultat, "IDMere");
			String nomInd = BD.attributString(resultat, "nomInd");
			String prenomInd = BD.attributString(resultat, "PrenomInd");

			resultatString += "IDInd: " + idInd + ", IDPere: " + idPere + ", IDMere: " + idMere +
			    ", NomInd: " + nomInd + ", PrenomInd: " + prenomInd + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}
	
	/*evenement							*/
	public static String rechercheEvenement(int IDEvenement) {
		/**
		* @param connexion type entier
		* @param IDEvenement type entier
		* @return une chaîne de caractères représentant le résultat de la recherche d'un événement dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT * FROM EVENEMENT WHERE IDEvenement = " + IDEvenement;

		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";
		
		while (BD.suivant(resultat)) {
			int idEvenement = BD.attributInt(resultat, "IDEvenement");
			String libelleEvenement = BD.attributString(resultat, "LibelleEvenement");
			String dateEvenement = BD.attributString(resultat, "DateEvenement");

			resultatString += "IDEvenement: " + idEvenement + ", LibelleEvenement: " + libelleEvenement +
			    ", DateEvenement: " + dateEvenement + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}

	/*photo								*/
	public static String recherchePhoto(int IDPhoto) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @return une chaîne de caractères représentant le résultat de la recherche d'une photo dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT * FROM PHOTO WHERE IDPhoto = " + IDPhoto;

		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";

		while (BD.suivant(resultat)) {
			int idPhoto = BD.attributInt(resultat, "IDPhoto");
			int idAlbum = BD.attributInt(resultat, "IDAlbum");
			int numPage = BD.attributInt(resultat, "NumPage");
			int idEvenement = BD.attributInt(resultat, "IDEvenement");

			resultatString += "IDPhoto: " + idPhoto + ", IDAlbum: " + idAlbum +
			    ", NumPage: " + numPage + ", IDEvenement: " + idEvenement + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}
	
	/*apparait								*/
	public static String rechercheApparait(int IDPhoto, int IDInd) {
		/**
		* @param connexion type entier
		* @param IDPhoto type entier
		* @param IDInd type entier
		* @return une chaîne de caractères représentant le résultat de la recherche de l'apparition d'une photo dans la BD
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT * FROM APPARAIT WHERE IDPhoto = " + IDPhoto + " AND IDInd = " + IDInd;

		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";

		while (BD.suivant(resultat)) {
			int idPhoto = BD.attributInt(resultat, "IDPhoto");
			int idInd = BD.attributInt(resultat, "IDInd");

			resultatString += "IDPhoto: " + idPhoto + ", IDInd: " + idInd + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}
	
	
	/*REQUETES SPECIALES					*/
	/*recherche des photos de famille				*/
	public static String recherchePhotosFamille(String nomIndividu, String prenomIndividu) {
		/**
		* @param connexion type entier
		* @param nomIndividu type chaîne de caractères
		* @param prenomIndividu type chaîne de caractères
		* @return une chaîne de caractères représentant le résultat de la recherche des photos de famille
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT DISTINCT P.IDPhoto, P.IDAlbum, P.NumPage " +
			     "FROM PHOTO AS P " +
			     "INNER JOIN APPARAIT AS AP1 ON P.IDPhoto = AP1.IDPhoto " +
			     "INNER JOIN INDIVIDU AS I1 ON AP1.IDInd = I1.IDInd " +
			     "INNER JOIN INDIVIDU AS I2 ON (I1.IDPere = I2.IDPere OR I1.IDMere = I2.IDMere) " +
			     "INNER JOIN APPARAIT AS AP2 ON I2.IDInd = AP2.IDInd " +
			     "WHERE I1.nomInd = '" + nomIndividu + "' AND I1.PrenomInd = '" + prenomIndividu + "'";

		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";

		while (BD.suivant(resultat)) {
			int idPhoto = BD.attributInt(resultat, "IDPhoto");
			int idAlbum = BD.attributInt(resultat, "IDAlbum");
			int numPage = BD.attributInt(resultat, "NumPage");

			resultatString += "IDPhoto: " + idPhoto + ", IDAlbum: " + idAlbum + ", NumPage: " + numPage + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}
	
	public static String rechercheFamille(String nomIndividu, String prenomIndividu)
	{
		
		/**
		* @param connexion type entier
		* @param nomIndividu type chaîne de caractères
		* @param prenomIndividu type chaîne de caractères
		* @return tous les individus de la famille de l'individu specifie
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT DISTINCT I2.IDInd, I2.nomInd, I2.PrenomInd"+
					"FROM INDIVIDU AS I1"+
					"INNER JOIN INDIVIDU AS I2 ON (I1.IDPere = I2.IDPere OR I1.IDMere = I2.IDMere)"+
					"WHERE I1.nomInd = "+nomIndividu +"AND I1.PrenomInd = "+prenomIndividu +"";
		
		


		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";

		while (BD.suivant(resultat)) {
			int idIndiv = BD.attributInt(resultat, "IDInd");
			String nomIndiv = BD.attributString(resultat, "nomInd");
			String prenomIndiv = BD.attributString(resultat, "PrenomInd");

			resultatString += "IDInd: " + idIndiv + ", nomInd: " + nomIndiv + ", PrenomInd: " + prenomIndiv + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}

	
	/*recherche d'album et page par individu		*/
	public static String rechercheAlbumsPagesParIndividu(String nomIndividu, String prenomIndividu) {
		/**
		* @param connexion type entier
		* @param nomIndividu type chaîne de caractères
		* @param prenomIndividu type chaîne de caractères
		* @return une chaîne de caractères représentant le résultat de la recherche des albums et pages par individu
		*/
		
		int connexion = BD.ouvrirConnexion(adresse, bd, login,password);

		String requete = "SELECT NomAlbum, NumPage " +
			     "FROM ALBUM NATURAL JOIN PHOTO " +
			     "WHERE IDPhoto IN " +
			     "( " +
			     "SELECT IDPhoto " +
			     "FROM APPARAIT NATURAL JOIN INDIVIDU " +
			     "WHERE nomInd = '" + nomIndividu + "' AND PrenomInd = '" + prenomIndividu + "' " +
			     ")";

		int resultat = BD.executerSelect(connexion, requete);
		String resultatString = "";

		while (BD.suivant(resultat)) {
			String nomAlbum = BD.attributString(resultat, "NomAlbum");
			int numPage = BD.attributInt(resultat, "NumPage");

			resultatString += "NomAlbum: " + nomAlbum + ", NumPage: " + numPage + "\n";
		}

		BD.fermerResultat(resultat);

		return resultatString;
	}
}
