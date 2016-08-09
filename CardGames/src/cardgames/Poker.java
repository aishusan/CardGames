package cardgames;

import java.util.ArrayList;
import java.util.List;

public class Poker implements Game{
	private Deck standardDeck;
	private List<Card> tableCards;
	private int noOfCards=2;
	/**
	 * Royal Flush
	 * Straight Flush
	 * Four of a kind
	 * Full House
	 * Flush
	 * Straight
	 * Three of a kind
	 * Two Pair
	 * Pair
	 * High Card
	 */
	
	private static enum PokerHand{
		HIGH_CARD,
		PAIR,
		TWO_PAIR,
		THREE_OF_A_KIND,
		STRAIGHT,
		FLUSH,
		FULL_HOUSE,
		FOUR_OF_A_KIND,
		STRAIGHT_FLUSH,
		ROYAL_FLUSH
	}
	
	private PokerHand getBestHand(Hand hand){
		if(checkRoyalFlush(hand)){
			return PokerHand.ROYAL_FLUSH;
		} else if(checkStraightFlush(hand)){
			return PokerHand.STRAIGHT_FLUSH;
		} else if(checkFourOfAKind(hand)){
			return PokerHand.FOUR_OF_A_KIND;
		} else if(checkFullHouse(hand)){
			return PokerHand.FULL_HOUSE;
		} else if(checkFlush(hand)){
			return PokerHand.FLUSH;
		} else if(checkStraight(hand)){
			return PokerHand.STRAIGHT;
		} else if(checkThreeOfAKind(hand)){
			return PokerHand.THREE_OF_A_KIND;
		} else if(checkTwoPair(hand)){
			return PokerHand.TWO_PAIR;
		} else if(checkPair(hand)){
			return PokerHand.PAIR;
		} else {
			return PokerHand.HIGH_CARD;
		}
	}
	
	private boolean checkPair(Hand hand) {
		// TODO Auto-generated method stub
		
		return false;
	}



	private boolean checkTwoPair(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean checkThreeOfAKind(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean checkStraight(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean checkFlush(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean checkFullHouse(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean checkFourOfAKind(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean checkStraightFlush(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean checkRoyalFlush(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public int compare(List<Hand> hands) {
		// TODO Auto-generated method stub
		ArrayList<PokerHand> bestHand = new ArrayList<>();
		for(Hand hand : hands)
			bestHand.add(getBestHand(hand));
		
		return 0;
	}
	
	@Override
	public void dealCards(List<Hand> hands) {
		for(int i=0;i<noOfCards;i++){
		for(Hand hand : hands)
		{
			hand.add(standardDeck.getCard());
		}}
	}

	public String displayTable()
	{
		return tableCards.toString();
	}
	@Override
	public void initGame() {
		standardDeck = new Deck();
		tableCards = new ArrayList<>();
		
		standardDeck.shuffle();
		standardDeck.removeCard();
		tableCards.add(standardDeck.getCard());
		tableCards.add(standardDeck.getCard());
		tableCards.add(standardDeck.getCard());
		standardDeck.removeCard();
		tableCards.add(standardDeck.getCard());
		standardDeck.removeCard();
		tableCards.add(standardDeck.getCard());
	}

}
