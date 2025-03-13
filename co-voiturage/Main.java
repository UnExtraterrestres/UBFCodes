class Main
{
	
	public static void main(String[] args)
	{
		
		
		Date date = new Date();
		System.out.println(date.toString());
		
		System.out.println("\n\n\n");
		
		Moteur moteur = new Moteur();
		System.out.println(moteur.toString());
		
		System.out.println("\n\n\n");
		
		Personne personne = new Personne("Gosling", "Ryan", 1980);
		System.out.println(personne.toString());
		
		System.out.println("\n\n\n");
		
		Voiture voiture = new Voiture();
		System.out.println(voiture.toString());
		voiture.ajoutPassager(personne);
		System.out.println(voiture.toString());
		voiture.viderVoiture();
		System.out.println(voiture.toString());
		
		System.out.println("\n\n\n");
		
		Voiture voituuu = new Voiture();
		
		voituuu.ajoutPassager(new Personne("Mulligan", "Carey", 1986));
		voituuu.ajoutPassager(new Personne("Hendriks", "Christina", 1976));
		voituuu.ajoutPassager(new Personne("Isaac", "Oscar", 1979));
		
		System.out.println(voituuu.toString());
	}
}
