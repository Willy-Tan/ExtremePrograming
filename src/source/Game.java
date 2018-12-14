package source;

import java.util.ArrayList;

public class Game {
	private ArrayList<Joueur> joueurs;
	private Paquet paquet;
	private int pot ;
	private int joueurCourant;
	private int miseMinimale;
	
	

	public Game() {
		
	}
	
	public int init(int nbJoueurs) {
		joueurs = new ArrayList<Joueur>();
		paquet = new Paquet();
		pot = 0;
		joueurCourant = 0;
		miseMinimale = 0;
		for(int i = 0; i < nbJoueurs; i++) {
			Joueur newJoueur = new Joueur("tata");
			joueurs.add(newJoueur);
		}
		return 0;
	}
	
	public Joueur getJoueur(int index) {  //Peut être changé pour le faire à partir du nom
		return joueurs.get(index);
	}
	public int getMiseMinimale () { 
		return miseMinimale;
	}
	public int getPot () { 
		return pot;
	}
	
	public int nbJoueursActifs() {
		int compteur = 0;
		Joueur joueur;
		for (int i = 0; i < joueurs.size(); i++) {
			joueur = joueurs.get(i);
			if (joueur.getState()) { //Si le joueur est actif
				compteur++;
			}
		}
		return compteur;
	}
	
	
	
	public void passerAuJoueurSuivant () {
		boolean flag = false;
		Joueur joueurSuivant;
		while (!flag) {
			joueurCourant = (joueurCourant+1)%joueurs.size();
			joueurSuivant = joueurs.get(joueurCourant);
			if (joueurSuivant.getState()) {
				flag = true;
			}
		}
	}
	
	public void tirage() {
		Joueur joueur;
		for (int i = 0; i < joueurs.size() ; i++ ) {
			joueur =  joueurs.get(i);
			if (joueur.getState()) {
				joueur.tirerCartes(paquet);
			}
		}	
	}
	
	public void mise (int montant) {
		//Il faudrait faire un try catch dans le cas où le joueur mise plus que ce qu'il n'a
		
		assert miseMinimale == 0;
		joueurs.get(joueurCourant).mise(montant);			//On fait miser le joueur courant
		pot+=montant;										//On ajoute au pot courant le montant	
		miseMinimale = montant;								//On actualise la mise minimale
		passerAuJoueurSuivant();
	}
	
	public void suivre() {
		//Il faudrait faire un try catch dans le cas où le joueur mise plus que ce qu'il n'a
		joueurs.get(joueurCourant).mise(miseMinimale);
		pot += miseMinimale;
		passerAuJoueurSuivant();
	}
	
	public void tapis() {
		Joueur joueur = joueurs.get(joueurCourant);
		int valeurTapis = joueur.getCash();
		joueur.mise(valeurTapis);
		pot += valeurTapis;
		miseMinimale = Math.max(miseMinimale, valeurTapis);
		passerAuJoueurSuivant();
	}
	
	public void relance(int montant) {
		assert montant > miseMinimale; 
		joueurs.get(joueurCourant).mise(montant);			//On fait miser le joueur courant
		pot+=montant;										//On ajoute au pot courant le montant	
		miseMinimale = montant;								//On actualise la mise minimale
		passerAuJoueurSuivant();
	}
	
	public void passer() {
		Joueur joueur = joueurs.get(joueurCourant);
		joueur.passer();
		passerAuJoueurSuivant();
	}
	
}
