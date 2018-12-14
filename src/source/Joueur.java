package source;

public class Joueur {
	private MainDeCartes mainCourante;
	private String nom;
	private int cash;
	private boolean actif;
	private int miseActuelle;
	
	public Joueur(String newNom) {
		nom = newNom;
		mainCourante = new MainDeCartes();
		cash = 5000;
		actif = true;
	}
	
	
	public MainDeCartes getMain() {
		return mainCourante;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getCash() {
		return cash;
	}
	
	public boolean getState() {
		return actif;
	}
	
	public int getMiseActuelle() {
		return miseActuelle;
	}
	
	public void tirerCartes(Paquet paquet) {
		mainCourante.ajoutCartes(paquet.tirerCarte());
		mainCourante.ajoutCartes(paquet.tirerCarte());
	}
	
	public void mise(int montant) {
		//Remplacer par un throw
		assert cash >= montant;
		cash = cash-montant ;
		miseActuelle = montant;
	}
	
	public void passer() {
		mainCourante.jeterCartes();
		actif = false;
	}
	
	
}
