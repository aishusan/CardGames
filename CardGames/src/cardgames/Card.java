package cardgames;

import java.util.Comparator;

public class Card {
	
	public static enum VALUE {
	    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, JOKER
	}
	
	public static enum SUIT {
	    SPADES, HEARTS, DIAMOND, CLUBS, JOKER
	}
	
	private VALUE faceValue;
	private SUIT suit;
	
	public static Comparator<Card> valueComparator = new Comparator<Card>() {
	    public int compare(Card c1, Card c2) {
	        return c2.getFaceValue().compareTo(c1.getFaceValue()); // use your logic
	    }
	};
	
	public static Comparator<Card> suitComparator = new Comparator<Card>() {
	    public int compare(Card c1, Card c2) {
	        return c2.getSuit().compareTo(c1.getSuit()); // use your logic
	    }
	};
	
	public Card (SUIT suit, VALUE faceValue){
		this.faceValue = faceValue;
		this.suit = suit;
	}
	
	public String toString(){
		return this.suit.name() + " " + this.faceValue.name();
	}

	public VALUE getFaceValue() {
		return faceValue;
	}

	public SUIT getSuit() {
		return suit;
	}
}
