package cardgames;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		Pack deck = new Pack();
		deck.shuffle();

		
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		
		
//		Poker pokerGame = new Poker();
//		pokerGame.initGame();
//		Hand h1 = new Hand();
//		Hand h2 = new Hand();
//		Hand h3 = new Hand();
//		ArrayList<Hand> hands = new ArrayList<>();
//		hands.add(h1);
//		hands.add(h2);
//		hands.add(h3);
//		pokerGame.dealCards(hands);
//		pokerGame.compare(hands);
//		
//		System.out.println("Nisarg   : " + h1.getCards());
//		System.out.println("Abhishek : " + h2.getCards());
//		System.out.println("Ashish   : " + h3.getCards());
//		System.out.println("Table    : " + pokerGame.displayTable());
		
		Diamonds diamondsGame = new Diamonds();
		diamondsGame.initGame();
		diamondsGame.playGame();
//		Hand h1 = new Hand();
//		Hand h2 = new Hand();
//		Hand h3 = new Hand();
//		ArrayList<Hand> hands = new ArrayList<>();
//		hands.add(h1);
//		hands.add(h2);
//		hands.add(h3);
//		diamondsGame.dealCards(hands);

		
		
	}
}
