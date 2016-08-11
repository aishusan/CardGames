package cardgames;

import java.util.Comparator;

public class Card {
	
	public static enum VALUE {
	    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, JOKER
	}
	
	public static enum SUIT {
		DIAMOND, SPADES, HEARTS, CLUBS, JOKER
	}
	
	private VALUE faceValue;
	private SUIT suit;
	
	
	
	public Card (SUIT suit, VALUE faceValue){
		this.faceValue = faceValue;
		this.suit = suit;
	}
	
	public String toString(){
		return this.suit.name() + " " + this.faceValue.name();
	}
	public int getValue(){
		return this.getSuit().ordinal()*13+this.getFaceValue().ordinal()+1;
	}
	public VALUE getFaceValue() {
		return faceValue;
	}

	public SUIT getSuit() {
		return suit;
	}
	
	@Override
	public boolean equals(Object thatObject){
		Card that = (Card)thatObject;
		return (this.getFaceValue().equals(that.getFaceValue()) && this.getSuit().equals(that.getSuit())); 
	}
}
