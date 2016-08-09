package cardgames;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Pack deck = new Pack();
		deck.shuffle();
		
		Poker pokerGame = new Poker();
		pokerGame.initGame();
		Hand h1 = new Hand();
		Hand h2 = new Hand();
		ArrayList<Hand> hands = new ArrayList<>();
		hands.add(h1);
		hands.add(h2);
		pokerGame.dealCards(hands);
		System.out.println("Nisarg: " + h1.getCards());
		System.out.println("Abhishek: " + h2.getCards());
		System.out.println("Table: " + pokerGame.displayTable());
	}
}
