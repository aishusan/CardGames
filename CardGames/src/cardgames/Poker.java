package cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		
		//System.out.println(checkHighCard(hand).getCards());
		
		if(checkRoyalFlush(hand) != null){
			return PokerHand.ROYAL_FLUSH;
		} else if(checkStraightFlush(hand) != null){
			return PokerHand.STRAIGHT_FLUSH;
		} else if(checkFourOfAKind(hand) != null){
			return PokerHand.FOUR_OF_A_KIND;
		} else if(checkFullHouse(hand) != null){
			return PokerHand.FULL_HOUSE;
		} else if(checkFlush(hand) != null){
			return PokerHand.FLUSH;
		} else if(checkStraight(hand) != null){
			return PokerHand.STRAIGHT;
		} else if(checkThreeOfAKind(hand) != null){
			return PokerHand.THREE_OF_A_KIND;
		} else if(checkTwoPair(hand) != null){
			return PokerHand.TWO_PAIR;
		} else if(checkPair(hand) != null){
			return PokerHand.PAIR;
		} else if (checkHighCard(hand) != null){
			return PokerHand.HIGH_CARD;
		}
		return null;
	}
	
	
	private Hand checkHighCard(Hand hand){
		ArrayList<Card> myHandCards = new ArrayList<>();
		myHandCards.addAll(tableCards);
		myHandCards.addAll(hand.getCards());
		
		//Hand myHand = new Hand(myHandCards);
		Collections.sort(myHandCards, Card.valueComparator);
		
		ArrayList<Card> bestHandCards = new ArrayList<>();
		bestHandCards.addAll(myHandCards);
		
		bestHandCards.remove(6);
		bestHandCards.remove(5);
		
		Hand myHand = new Hand(bestHandCards);
		return myHand;
	}
	
	
	private Hand checkPair(Hand hand) {
		
		return null;
	}



	private Hand checkTwoPair(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}



	private Hand checkThreeOfAKind(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}



	private Hand checkStraight(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}



	private Hand checkFlush(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}



	private Hand checkFullHouse(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}



	private Hand checkFourOfAKind(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}



	private Hand checkStraightFlush(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}



	private Hand checkRoyalFlush(Hand hand) {
		// TODO Auto-generated method stub
		return null;
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
