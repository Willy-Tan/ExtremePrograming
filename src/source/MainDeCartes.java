package source;

import java.util.ArrayList;

public class MainDeCartes {
	private ArrayList<Carte> listeCartes; 
	
	public MainDeCartes() {
		listeCartes = new ArrayList<Carte>();
	}

	public int nbCartes() {
		return listeCartes.size();
	}
	
	public void ajoutCartes (Carte newCarte) {
		listeCartes.add(newCarte);
	}
	
	public void jeterCartes () {
		listeCartes = new ArrayList<Carte>();
	}
	
}
