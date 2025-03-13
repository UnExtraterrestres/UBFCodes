class ElectronicPurse
{
	
	/*ATTRIBUTS					*/
	private double solde;
	private String PIN = "";
	private int ESSAIS_MAX;
	private int essaisRestants;
	private boolean bloque;
	
	/*SETeur						*/
	
	private void setPIN()
	{
		
		/**
		*@return l'affectation de l'attribut PIN, s'il n'existe pas
		*/
		
		final int TAILLE_PIN = 4;
		final int DIGIT_MIN = 0;
		final int DIGIT_MAX = 9;
		
		if (PIN.isEmpty() && !bloque)
		{
			for (int i = 0; i<TAILLE_PIN; i++)
			{
				
				PIN += (DIGIT_MIN + (int)(Math.random()*(DIGIT_MAX-DIGIT_MIN)));
			}
		} else
		{
			Ecran.afficherln("Le code PIN ne peut pas etre genere.");
			Ecran.afficherln("Verifiez :\n-qu'il n'existe deja\n-que le porte-monnaie n'est pas bloque");
		}
	}
	
	/*CONSTRUCTEURS				*/
	public ElectronicPurse()
	{
		
		/**
		*@return l'affectation des attributs par defaut
		*par un appel du constructeur principal
		*/
		
		new ElectronicPurse(0.0);
	}
	public ElectronicPurse(double solde)
	{
		
		/**
		*@param solde type reel
		*@return l'affectation de solde par celui specifie
		*appel du constructeur principal
		*/
		
		this.ESSAIS_MAX = 3;
		this.setPIN();
		this.bloque = false;	
		this.solde = solde;
		
		Ecran.afficherln("Code PIN : " + this.PIN);
	}
	
	/*METHODES					*/
	
	/*Operations					*/
	
	private boolean identification()
	{
		
		/**
		*@return vrai si une identification est reussie, faux sinon
		*verifie si le code entre correspond bien au code PIN,
		*en prennant en compte ESSAIS_MAX
		*/
		
		if (bloque)
		{
			
			Ecran.afficherln("Identification impossible : compte bloque.");
			return false;
		}
		
		for (int essais = 1; essais <= ESSAIS_MAX; essais++)
		{
			
			Ecran.afficher("Veuillez saisir votre code PIN : ");
			String pin = Clavier.saisirString();

			if (pin.equals(PIN))
			{
				
				Ecran.afficherln("Code bon");
				return true;
			} else
			{
				
				Ecran.afficherln("Code erroné");
				Ecran.afficherln(ESSAIS_MAX-essais + " essais restants");
			}
		}
		
		bloque = true;
		Ecran.afficherln("Indentification impossible : nombre d'essais depasse.");
		Ecran.afficherln("Compte bloque.");
		return false;
	}
	
	public void credit(double montant)
	{
		
		/**
		*@return incrementation de montant au solde du purse
		*suivant les conditions de validite du credit
		*
		*<br> -purse non bloque
		*<br> -montant a crediter positif
		*<br> -identification reussie
		*/
		
		Ecran.afficherln("Credit en cours...");
		
		if (bloque)
		{
			
			Ecran.afficherln("Credit impossible : compte bloque.");
		} else if (identification())
		{
			
			solde += Math.abs(montant);
			Ecran.afficherln("Montant de " + montant + " credite.");
		} else
		{
			
			Ecran.afficherln("Credit impossible : echec de l'identification.");
		}
	}
	
	public void debit(double montant)
	{
		
		/**
		*@return decrementation de montant du solde
		*suivant les conditions de validite du debit
		*
		*<br> -purse non bloque
		*<br> -montant a debiter positif
		*<br> -montant inferieur ou egal au solde
		*/
		
		Ecran.afficherln("Debit en cours...");
		
		if (bloque)
		{
			
			Ecran.afficherln("Debit impossible : compte bloque.");
		} else if (montant <= solde)
		{
			
			solde -= Math.abs(montant);
			Ecran.afficherln("Montant de " + montant + " debite.");
		} else
		{
			
			Ecran.afficherln("Debit impossible : montant trop eleve.");
		}
	}
	
	public String toString()
	{
		
		/**
		*@return le solde sous forme de chaine de caractere
		*/
		
		return ""+solde;
	}
}
