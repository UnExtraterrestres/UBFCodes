// type : Saison
public class Saison {
	
	// parametres
	private Date debut;
	private Date fin;
	
	/*
	 GETTER and SETTER
	GET --> est retournee : le parametre conserne
	SET --> entree : type
		     change la valeur du parametre conserne
	*/
	// parametre : debut
	public Date getDebut() { return this.debut; }
	public void setDebut(Date d) { this.debut = d; }
	// parametre : fin
	public Date getFin() { return this.fin; }
	public void setFin(Date f) { this.fin = f; }
	
	// CONSTRUCTEUR
	public Saison(Date debut, Date fin) {
		// sont charges : les arguments
		this.setDebut(debut);
		this.setFin(fin);
	}
	
	// entree : Date date
	public boolean comprend(Date date) {
		// est retourne : vrai si debut <= date <= fin, faux sinon
		
		// renvois du resultat (non stocke)
		return this.debut.estAvant(date) && date.estAvant(this.fin);
	}
	
}
