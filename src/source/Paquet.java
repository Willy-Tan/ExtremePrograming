package source;

import java.util.Collections;
import java.util.Stack;


public class Paquet {
	private Stack<Carte> paquetDeCartes;
	
	public Paquet() {
		Couleur couleur;
		paquetDeCartes = new Stack<Carte>();
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 4; j++) {
				switch (j) {
					case 1: couleur = Couleur.Carreaux; break;
					case 2: couleur = Couleur.Trèfle; break;
					case 3: couleur = Couleur.Pique; break;
					case 4: couleur = Couleur.Coeur; break;
					default: throw new RuntimeException("Impossible");
				}
				Carte newCarte = new Carte(i, couleur);
				paquetDeCartes.push(newCarte);
			}
		}
		Collections.shuffle(paquetDeCartes);
	}
	
	public Carte tirerCarte() {
		return paquetDeCartes.pop();
	}
}
