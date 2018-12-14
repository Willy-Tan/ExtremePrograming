package source;

import org.junit.Test;

import junit.framework.TestCase;

public class GeneralTest extends TestCase {
	protected Game game;
	
	protected void setUp() {
		game = new Game();
	}
	
	// ---- Premier sprint -----
	
	
	@Test //UC 1
	public void testInit() {
		int initValue = game.init(2);				//Initialisation de la partie
		assertTrue (initValue == 0);				//On renvoie 0 si la partie a bien été initialisée
	}
	@Test //UC 4
	public void testMainDebut () {
		game.init(2);								//Initialisation de la partie
		game.tirage();								//On effectue le tirage initial des cartes
		Joueur premierJoueur = game.getJoueur(0);	//On regarde le premier joueur
		MainDeCartes main = premierJoueur.getMain();//On récupère sa main
		assertEquals(main.nbCartes(), 2);			//On vérifie qu'il a bien deux cartes
	}
	@Test //UC 8
	public void testMise () {
		game.init(2);								//Initialisation de la partie
		Joueur premierJoueur = game.getJoueur(0);	//On récupère le premier joueur
		assertEquals(premierJoueur.getCash(),5000); //On vérifie que son cash initial est de 5000
		game.mise(5);								//On lui fait miser 5
		assertEquals(premierJoueur.getCash(),4995);	//On vérifie qu'il a bien moins 5 à son cash
		assertEquals(game.getPot(),5);				//On vérifie que le pot total est de 5
	
		
	}
	
	
	@Test //UC 9
    public void testSuivi () {
		game.init(2) ;								//Initialisation de la partie
		game.mise(5);								//On fait miser le premier joueur de 5
		game.suivre();								//On fait suivre le deuxième joueur
		Joueur deuxiemeJoueur = game.getJoueur(1);	//On regarde le deuxième joueur
		assertEquals(game.getPot(),10);				//On vérifie que le pot total est de 10
		assertEquals(deuxiemeJoueur.getCash(),4995);//On vérifie que le deuxième joueur a moins 5 de cash
		
	}
	
	@Test //UC 10
	public void testTapis() {
		game.init(2) ;								//Initialisation de la partie
		game.tapis();								//Le premier joueur fait tapis (il a 5000)
		Joueur premierJoueur = game.getJoueur(0);	//On regarde le premier joueur
		assertEquals(game.getPot(),5000);			//On vérifie que le pot total est de 5000
		assertEquals(premierJoueur.getCash(), 0);	//On vérifie que le premier joueur n'a plus rien

	}
	@Test //UC 11
	public void testRelance() {
		game.init(2) ;								//Initialisation de la partie
		game.mise(5);								//On fait miser le premier joueur
		game.relance(8);							//On fait relancer le deuxième
		assertEquals(game.getPot(),13);				//On vérifie que le pot total est de 13
		assertEquals(game.getMiseMinimale(),8);		//On vérifie que la mise minimale est passée à 8
	}
	
	@Test //UC 12
	public void testPasse() {
		game.init(2) ;								//Initialisation de la partie
		assertEquals(game.nbJoueursActifs(),2);		//On vérifie qu'il y a deux joueurs
		game.mise(5);								//Le premier joueur mise
		game.passer();								//Le deuxième joueur passe
		assertEquals(game.nbJoueursActifs(),1);		//On vérifie qu'il n'y a plus qu'un joueur actif
	}
	
	@Test //UC 13 
	public void testVoirMiseActuelle() {
		game.init(2) ;								//Initialisation de la partie
		Joueur premierJoueur = game.getJoueur(0);	//On regarde le premier joueur
		game.mise(10);								//Le premier joueur mise 10
		assertEquals(premierJoueur.getMiseActuelle(), 10);//On vérifie la mise du premier joueur
	}
	
	
	@Test //UC 15
	public void testVoirMainActuelle() {
		game.init(3) ;								//Initialisation de la partie
		game.mise(10);								//Le premier joueur mise 10
		game.passer();								//Le deuxième joueur passe
		game.suivre();								//Le troisième joueur suit
		game.tirage();								//Le tirage des cartes se fait
		Joueur premierJoueur = game.getJoueur(0);	//On regarde le premier joueur
		MainDeCartes mainPremier = premierJoueur.getMain();
		assertEquals(mainPremier.nbCartes(), 2);	//On vérifie que le joueur a bien deux cartes
		Joueur deuxiemeJoueur = game.getJoueur(1);	//On regarde le deuxième joueur
		MainDeCartes mainDeuxieme = deuxiemeJoueur.getMain();
		assertEquals(mainDeuxieme.nbCartes(),0);	//On vérifie que le deuxième joueur a 0 carte
	}
	
	// ---- Deuxième sprint -----
	@Test //UC 2
	public void testNbJoueurs() {
		int nbJoueurs = 5;							//Remplacé par un scanner dans le main
		game.init(nbJoueurs);
		assertEquals(game.nbJoueurs(), 5);			//On vérifie qu'il y a bien 5 joueurs dans la partie
	}
	
	@Test //UC 7
	public void testEnleverJoueur() {
		game.init(3);                               //On initialise la partie
		game.tapis();								//Le premier joueur fait tapis
		game.tapis();								//Le deuxième joueur fait tapis (l'un des deux perd forcément)
		game.suivre(); 								//Le troisième suit
		game.actualise();							//On actualise à la fin de partie
		assertEquals(game.nbJoueurs(), 2); 			//On vérifie qu'il ne reste plus que deux joueurs
	}
	
}


