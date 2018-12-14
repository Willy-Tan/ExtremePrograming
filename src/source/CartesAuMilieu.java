package source;

import java.util.ArrayList;

public class CartesAuMilieu {
	ArrayList<Carte> cartesAuMilieu;
	
	public CartesAuMilieu() {}
	
	public void flop(Paquet paquet) {
		assert cartesAuMilieu.size() == 0;
		paquet.tirerCarte();						//Brûler une carte du paquet
		cartesAuMilieu.add(paquet.tirerCarte());
		cartesAuMilieu.add(paquet.tirerCarte());
		cartesAuMilieu.add(paquet.tirerCarte());
		
	}
	
	public void river(Paquet paquet) {
		assert cartesAuMilieu.size() == 3;
		paquet.tirerCarte();						//Brûler une carte du paquet
		cartesAuMilieu.add(paquet.tirerCarte());
	}
	
	public void turn(Paquet paquet) {
		assert cartesAuMilieu.size() == 4;
		paquet.tirerCarte();						//Brûler une carte du paquet
		cartesAuMilieu.add(paquet.tirerCarte());
	}
}
