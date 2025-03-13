// type : Date
public class Date {
	
	// parametres
	private int annee;
	private int mois;
	private int jour;
	
	/*
	GETTER and SETTER
	GET --> est retournee : le parametre conserne
	SET --> entree : type
		     change la valeur du parametre conserne
	*/
	// parametre : annee
	public int getAn() { return this.annee; }
	public void setAn(int a) { this.annee = a; }
	// parametre : mois
	public int getMois() { return this.mois; }
	public void setMois(int m) { this.mois = m; }
	// parametre : jour
	public int getJour() { return this.jour; }
	public void setJour(int j) { this.jour = j; }
	
	// CONSTRUCTEUR
	public Date(int j, int m, int a) {
		// sont charges : les arguments
		this.setAn(a);
		this.setMois(m);
		this.setJour(j);
	}
	
	public void lendemain() {
		// est changee : this en date du lendemain
		
		// declaration de la donnee
		int finmois;
		
		// calcul de la donnee
		if (this.mois < 8) {
			if (this.mois == 2) {
				if (this.estBisextile(this.annee)) {
					finmois = 29;
				} else {
					finmois = 28;
				}
			} else if (this.mois % 2 == 0) {
				finmois = 30;
			} else {
				finmois = 31;
			}
		} else {
			if (this.mois % 2 == 0) {
				finmois = 31;
			} else {
				finmois = 30;
			}
		}
		
		// calcul du resultat
		this.jour = (this.jour + 1) % finmois;
		if (this.jour == 1) {
			this.mois = (this.mois + 1) % 12;
		}
		if (this.mois == 1) {
			this.annee ++;
		}
	}
	
	public String toString()
	{
		
		/**
		*@return la chaine de caractere de la Date
		*/
		
		return ""+this.jour+" "+this.moisEnLettre+" "+this.annee
	}
	
	public void afficherDate() {
		// est affichee : la date
		
		// affichage du resultat (non stocke)
		Ecran.afficherln(this.toString);
	}
	
	public String moisEnLettre() {
		// est retourne : le mois en lettre
		
		// declaration du resultat
		String mois;
		
		// calcul du resultat
		switch (this.mois) {
			case 1: {
				mois = " janvier ";
			} break;
			case 2: {
				mois = " fevrier ";
			} break;
			case 3: {
				mois = " mars ";
			} break;
			case 4: {
				mois = " avril ";
			} break;
			case 5: {
				mois = " mai ";
			} break;
			case 6: {
				mois = " juin ";
			} break;
			case 7: {
				mois = " juillet ";
			} break;
			case 8: {
				mois = " aout ";
			} break;
			case 9: {
				mois = " septembre ";
			} break;
			case 10: {
				mois = " octobre ";
			} break;
			case 11: {
				mois = " novembre ";
			} break;
			case 12: {
				mois = " decembre ";
			} break;
			default: {
				mois = " erreur ";
			} break;
		}
		
		// renvois du resultat
		return mois;
		
	}
	
	public String saison() {
		// est retournee : la saison correspondant a la date
		
		/*
		HIVER :		21 dec - 19 mars
		PRINTEMPS :	20 mars - 20 juin
		ETE : 		21 juin - 20 sep
		AUTOMNE : 	21 sep - 20 dec
		*/
		
		// declaration des constantes
		final Saison HIVER = new Saison(new Date(21, 12, this.annee), new Date(19, 3, this.annee));
		final Saison PRINTEMPS = new Saison(new Date(20, 3, this.annee), new Date(20, 6, this.annee));
		final Saison ETE = new Saison(new Date(21, 6, this.annee), new Date(20, 9, this.annee));
		final Saison AUTOMNE = new Saison(new Date(21, 9, this.annee), new Date(20, 12, this.annee));
		
		if (AUTOMNE.comprend(this)) {
			return "automne";
		} else if (PRINTEMPS.comprend(this)) {
			return "printemps";
		} else if (ETE.comprend(this)) {
			return "ete";
		} else {
			return "hiver";
		}
		
	}
	
	// entree : Date date
	public boolean estAvant(Date date) {
		// est retourne : vrai si la date est avant date, faux sinon
		
		// calcul du resultat
		return (this.annee < date.getAn()) || 
		(this.annee == date.getAn()) && 
		((this.mois < date.getMois()) || (this.mois == date.getMois()) && (this.jour <= date.getJour()));
	}
	
	// entree : entier annee
	public static boolean estBisextile(int annee) {
		// est retourne : vrai si l'annee est bisextile, faux sinon
		
		// declaration du resultat
		boolean bisextile = false;
		
		// calcul du resultat
		/*
		une annee est bisextile si :
			est divisible par 4 et non divisible par 100
			ou est divisible par 400
		*/
		if ((annee % 4 == 0 && annee % 100 != 0) 
			|| annee % 400 == 0) { bisextile = true; }
		
		// revois du resultat
		return bisextile;
	}
	
}
