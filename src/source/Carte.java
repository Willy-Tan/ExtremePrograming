package source;


public class Carte {
	private int valeur; 			//Valeur va de 1 à 13, , 11 = Valet, 12 = Dame, 13 = Roi
	private Couleur couleur; 		//Couleur = "Carreaux", "Trèfle", "Coeur", "Pique"
	
	public int getValeur () {
		return valeur;
	}
	
	public Couleur getCouleur () {
		return couleur;
	}
	
	public void setValeur (int newVal) {
		valeur = newVal;
	}
	
	public void setCouleur (Couleur newCoul) {
		couleur = newCoul;
	}
	
	public Carte(int val, Couleur coul) {
		valeur = val;
		couleur = coul;
	}
	
}
