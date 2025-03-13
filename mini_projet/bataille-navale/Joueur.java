public class Joueur
{
	
	/** PARAMETRES				 */
	String nom;
	Grille grille = new Grille();
	
	public void saisir()
	{
		/**
		*@return la saisie des parametres du joueur
		*/
		
		Ecran.afficherln("== Saisie d'un joueur ==");
		
		/** saisie du nom			*/
		Ecran.afficher("Entrer le nom : ");
		this.nom = Clavier.saisirString();
	}
	
	public void generer()
	{
		/**
		*@return la generation des parametres du joueur
		*/
		
		Ecran.afficherln("== Generation d'une IA ==");
		this.nom = "IA";
	}
	
	public void afficher()
	{
		/**
		*@return l'affichage des parametres du joueur
		*/
		
		Ecran.afficherln("== Joueur : ", this.nom, " ==");
		Ecran.afficherln("Grille de ", this.nom);
		this.grille.afficher();
	}
}
