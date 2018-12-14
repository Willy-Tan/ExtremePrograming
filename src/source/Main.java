package source;

import java.util.Scanner;

public class Main {
	
	private static int demanderNbJoueurs() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Nombre de joueurs ?");
		int nbJoueurs = reader.nextInt();
		reader.close();
		return nbJoueurs;
	}
	
	public static void main(String[] args) {
		int nbJoueurs = demanderNbJoueurs();
		Game game = new Game();
		game.init(nbJoueurs);
	}
}
