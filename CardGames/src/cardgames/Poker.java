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
		List<Card> myHandCards = new ArrayList<>();
		myHandCards.addAll(tableCards);
		myHandCards.addAll(hand.getCards());
		
		Collections.sort(myHandCards, Card.valueComparator);
		
		ArrayList<Card> bestHandCards = new ArrayList<>();
		
		
		for(int i=0;i<myHandCards.size()-1;i++)
		{
			if(myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+1).getFaceValue())){
				bestHandCards.add(myHandCards.get(i));
				bestHandCards.add(myHandCards.get(i+1));
				myHandCards.remove(i);
				myHandCards.remove(i);
				break;
			}
		}
		
		if(bestHandCards.size()==0){
			return null;	
		}
		
		Collections.sort(myHandCards,Card.valueComparator);
		myHandCards.remove(4);
		myHandCards.remove(3);
		
		bestHandCards.addAll(myHandCards);
		
		Hand myHand = new Hand(bestHandCards);
		return myHand;
	}

	private Hand checkTwoPair(Hand hand) {
		List<Card> myHandCards = new ArrayList<>();
		myHandCards.addAll(tableCards);
		myHandCards.addAll(hand.getCards());
		
		Collections.sort(myHandCards, Card.valueComparator);
		
		ArrayList<Card> bestHandCards = new ArrayList<>();
		
		
		for(int i=0;i<myHandCards.size()-1;i++)
		{
			if(myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+1).getFaceValue())){
			bestHandCards.add(myHandCards.get(i));
			bestHandCards.add(myHandCards.get(i+1));
			myHandCards.remove(i);
			myHandCards.remove(i);
			break;
			}
		}
		
		if(bestHandCards.size()==0){
			return null;	
		}
		
		for(int i=0;i<myHandCards.size()-1;i++)
		{
			if(myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+1).getFaceValue())){
			bestHandCards.add(myHandCards.get(i));
			bestHandCards.add(myHandCards.get(i+1));
			myHandCards.remove(i);
			myHandCards.remove(i);
			break;
			}
		}
		
		if(bestHandCards.size()==2){
			return null;	
		}
		
		Collections.sort(myHandCards,Card.valueComparator);
		bestHandCards.add(myHandCards.get(0));
		
		Hand myHand = new Hand(bestHandCards);
		return myHand;
	}

	private Hand checkThreeOfAKind(Hand hand) {
		List<Card> myHandCards = new ArrayList<>();
		myHandCards.addAll(tableCards);
		myHandCards.addAll(hand.getCards());
		
		Collections.sort(myHandCards, Card.valueComparator);
		
		ArrayList<Card> bestHandCards = new ArrayList<>();
		
		
		for(int i=0;i<myHandCards.size()-2;i++)
		{
			if(myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+1).getFaceValue())&&myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+2).getFaceValue())){
				bestHandCards.add(myHandCards.get(i));
				bestHandCards.add(myHandCards.get(i+1));
				bestHandCards.add(myHandCards.get(i+2));
				myHandCards.remove(i);
				myHandCards.remove(i);
				myHandCards.remove(i);
				break;
			}
		}
		
		if(bestHandCards.size()==0){
			return null;	
		}
		
		Collections.sort(myHandCards,Card.valueComparator);
		myHandCards.remove(3);
		myHandCards.remove(2);
		
		bestHandCards.addAll(myHandCards);
		
		Hand myHand = new Hand(bestHandCards);
		return myHand;
	}

	private Hand checkStraight(Hand hand) {
		List<Card> handCards = hand.getCards();
		handCards.addAll(tableCards);
		List<Card> straight = new ArrayList<>();
		Collections.sort(handCards,Card.valueComparator);
		Card.VALUE sequence = Card.VALUE.ACE;
		straight.add(new Card(Card.SUIT.CLUBS,Card.VALUE.ACE));
		for (Card c:handCards)
			if(c.getFaceValue().compareTo(sequence)==-1){
				straight.add(c);
				sequence = c.getFaceValue();
			}
			else if(c.getFaceValue().compareTo(sequence)<-1) {
				straight = new ArrayList<>();
				straight.add(c);
				sequence = c.getFaceValue();
			}
		if (straight.size()>=5)
			return  new Hand(straight.subList(0,5));
		return null;
	}

	private Hand checkFlush(Hand hand) {
		// TODO Auto-generated method stub
		ArrayList<Card> availableCards = new ArrayList<>();
		availableCards.addAll(tableCards);
		availableCards.addAll(hand.getCards());
		
		Hand availableCardsHand = new Hand(availableCards);
		
		Hand diamonds = availableCardsHand.getCardsOfSuit(Card.SUIT.DIAMOND);
		Hand hearts = availableCardsHand.getCardsOfSuit(Card.SUIT.HEARTS);
		Hand spades = availableCardsHand.getCardsOfSuit(Card.SUIT.SPADES);
		Hand clubs = availableCardsHand.getCardsOfSuit(Card.SUIT.CLUBS);
		
		if(diamonds.getCards().size()>=5) {
			Collections.sort(diamonds.getCards(),Card.valueComparator);
			return new Hand(diamonds.getCards().subList(0,5));
		}
		if(hearts.getCards().size()>=5) {
			Collections.sort(diamonds.getCards(),Card.valueComparator);
			return new Hand(hearts.getCards().subList(0,5));
		}
		if(spades.getCards().size()>=5) {
			Collections.sort(diamonds.getCards(),Card.valueComparator);
			return new Hand(spades.getCards().subList(0,5));
		}
		if(clubs.getCards().size()>=5) {
			Collections.sort(diamonds.getCards(),Card.valueComparator);
			return new Hand(clubs.getCards().subList(0,5));
		}
		return null;
	}

	private Hand checkFullHouse(Hand hand) {
		List<Card> myHandCards = new ArrayList<>();
		myHandCards.addAll(tableCards);
		myHandCards.addAll(hand.getCards());
		
		Collections.sort(myHandCards, Card.valueComparator);
		
		ArrayList<Card> bestHandCards = new ArrayList<>();
		
		
		for(int i=0;i<myHandCards.size()-2;i++)
		{
			if(myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+1).getFaceValue())&&myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+2).getFaceValue())){
			bestHandCards.add(myHandCards.get(i));
			bestHandCards.add(myHandCards.get(i+1));
			bestHandCards.add(myHandCards.get(i+2));
			myHandCards.remove(i);
			myHandCards.remove(i);
			myHandCards.remove(i);
			break;
			}
		}
		
		if(bestHandCards.size()==0){
			return null;	
		}
		
		for(int i=0;i<myHandCards.size()-1;i++)
		{
			if(myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+1).getFaceValue())){
			bestHandCards.add(myHandCards.get(i));
			bestHandCards.add(myHandCards.get(i+1));
			myHandCards.remove(i);
			myHandCards.remove(i);
			break;
			}
		}
		
		if(bestHandCards.size()==3){
			return null;
		}
		
		Hand myHand = new Hand(bestHandCards);
		return myHand;
	}

	private Hand checkFourOfAKind(Hand hand) {
		List<Card> myHandCards = new ArrayList<>();
		myHandCards.addAll(tableCards);
		myHandCards.addAll(hand.getCards());
		
		Collections.sort(myHandCards, Card.valueComparator);
		
		ArrayList<Card> bestHandCards = new ArrayList<>();
		
		
		for(int i=0;i<myHandCards.size()-3;i++)
		{
			if(myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+1).getFaceValue())&&myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+2).getFaceValue())&&myHandCards.get(i).getFaceValue().equals(myHandCards.get(i+3).getFaceValue())){
				bestHandCards.add(myHandCards.get(i));
				bestHandCards.add(myHandCards.get(i+1));
				bestHandCards.add(myHandCards.get(i+2));
				bestHandCards.add(myHandCards.get(i+3));
				myHandCards.remove(i);
				myHandCards.remove(i);
				myHandCards.remove(i);
				myHandCards.remove(i);
				break;
			}
		}
		
		if(bestHandCards.size()==0){
			return null;	
		}
		
		Collections.sort(myHandCards,Card.valueComparator);
		myHandCards.remove(2);
		myHandCards.remove(1);
		
		bestHandCards.addAll(myHandCards);
		
		Hand myHand = new Hand(bestHandCards);
		return myHand;
	}

	private Hand checkStraightFlush(Hand hand) {
		// TODO Auto-generated method stub
		Hand spadesHand = new Hand();
		Hand heartsHand = new Hand();
		Hand diamondsHand = new Hand();
		Hand clubsHand = new Hand();
		
		ArrayList<Card> handList= new ArrayList<>();
		handList.addAll(tableCards);
		handList.addAll(hand.getCards());
		Hand playingHand = new Hand(handList);
		
		for(int i=0; i<4; i++){
			spadesHand = playingHand.getCardsOfSuit(Card.SUIT.SPADES);
			heartsHand = playingHand.getCardsOfSuit(Card.SUIT.HEARTS);
			clubsHand = playingHand.getCardsOfSuit(Card.SUIT.CLUBS);
			diamondsHand = playingHand.getCardsOfSuit(Card.SUIT.DIAMOND);
		}
		
		Hand straightFlushHand = null;
		ArrayList<Card> returnCards = new ArrayList<>();
		if(spadesHand.getCards().size() >= 5){
			Collections.sort(spadesHand.getCards(), Card.valueComparator);
			straightFlushHand = checkStraight(spadesHand);
		} else if(clubsHand.getCards().size() >= 5){
			Collections.sort(clubsHand.getCards(), Card.valueComparator);
			straightFlushHand = checkStraight(clubsHand);
		} else if(heartsHand.getCards().size() >= 5){
			Collections.sort(heartsHand.getCards(), Card.valueComparator);
			straightFlushHand = checkStraight(heartsHand);
		} else if(diamondsHand.getCards().size() >= 5){
			Collections.sort(diamondsHand.getCards(), Card.valueComparator);
			straightFlushHand = checkStraight(diamondsHand);
		}
		
		return straightFlushHand;
	}

	private Hand checkRoyalFlush(Hand hand) {
		Hand myHand = checkStraightFlush(hand);
		if(myHand == null || myHand.getCards().get(0).getFaceValue() != Card.VALUE.ACE){
			return null;
		}
		return myHand;
	}

	@Override
	public int compare(List<Hand> hands) {
		// TODO Auto-generated method stub
		ArrayList<PokerHand> bestHand = new ArrayList<>();
		for(Hand hand : hands){
			System.out.println(getBestHand(hand));
			bestHand.add(getBestHand(hand));
		}
		
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
