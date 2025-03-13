class Main
{
	
	public static void afficherMenu()
	{
		
		/**
		*@return l'affichage du menu
		*
		*Consultation
		*Credit
		*Debit
		*Quitter
		*/
		
		String[] menu = 
		{
			"Consultation",
			"Credit",
			"Debit",
			"Quitter"
		};
		
		for (int i = 0; i<menu.length; i++)
		{
			Ecran.afficherln(i+1 + ". " +menu[i]);
		}
	}
	
	public static int choixMenu()
	{
		
		/**
		*@param menu type tableau de chaine de caracteres
		*@return la saisie d'un entier
		*/
		
		Ecran.afficherln("Saisir l'entier correspondant a l'action souhaitee...");
		int choix = Math.abs(Clavier.saisirInt());
		
		return choix;
	}
	
	public static void menu(ElectronicPurse purse)
	{
		
		/**
		*@param purse type ElectronicPurse
		*@return un menu proposant une interface plus humaine,
		*pour des actions sur le purse specifie
		*/
		
		afficherMenu();
		
		switch(choixMenu())
		{
			
			case 1:
			{
				
				Ecran.afficherln("Solde du porte-monnaie : " + purse.toString() + "\n");
			} break;
			
			case 2:
			{
				Ecran.afficher("Montant a crediter : ");
				purse.credit(Clavier.saisirDouble());
			} break;
			
			case 3:
			{
				Ecran.afficher("Montant a debiter : ");
				purse.debit(Clavier.saisirDouble());
			} break;
			
			default:
			{
				
				Ecran.afficherln("Sortie du menu...");
			} break;
		}
		
		Ecran.afficher("Tappez 1 pour continuer. 2 pour sortir du menu : ");
		if (Math.abs(Clavier.saisirInt()) == 1)
		{
			
			menu(purse);
		}
	}
	
	public static void main(String[] args)
	{
		
		ElectronicPurse purse = new ElectronicPurse(20.0);
		
		purse.debit(8.50);
		Ecran.afficherln("Solde du porte-monnaie : " + purse.toString());
		
		purse.credit(10.0);
		Ecran.afficherln("Solde du porte-monnaie : " + purse.toString());
		
		menu(purse);
	}
}
