package cardgames;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		

		
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		cards.add(new Card(Card.SUIT.DIAMOND, Card.VALUE.KING));
		Pack pack=new PackWithJoker();
		Deck deck=new Deck(2);
		deck.shuffle();
		Hand hand=new RummyHand(deck.getNCards(13));
		cards=hand.getCards();
		System.out.println(cards.toString());
		hand.sortOnValue();
		System.out.println(cards.toString());
		hand.sortOnSuit();
		System.out.println(cards.toString());
//		
		
		
	}
}
