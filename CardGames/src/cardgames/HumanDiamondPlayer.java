package cardgames;

import java.util.List;
import java.util.Scanner;

import cardgames.Card.VALUE;

public class HumanDiamondPlayer extends DiamondPlayer {

	private static Scanner s = new Scanner(System.in);
	
	public HumanDiamondPlayer(Hand hand) {
		super(hand);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Card getNextCard(Card diamondCard) {
		// TODO Auto-generated method stub
		//System.out.println(diamondCard.getFaceValue());
		System.out.println(hand.getCards());
		//System.out.println(getPointsWon());
		
		Card bidCard = null;
		boolean loopAgain = false;
		do {
			String cardToPlay = s.next();

			Card.VALUE cardValue = VALUE.JOKER;
			try{
				cardValue = Card.VALUE.valueOf(cardToPlay);
			} catch (IllegalArgumentException e){
				System.out.println(cardToPlay + " not a valid input. Enter again.");
				loopAgain = true;
				continue;
			}
			
			bidCard = new Card(mySuit, cardValue);
			loopAgain = !hand.containsCard(bidCard);
			if (loopAgain){
				System.out.println("Card not in hand. Enter another card");
			}
		} while(loopAgain);
		
		removeCard(bidCard);
		return bidCard;
	}

	@Override
	public void playedCards(List<Card> played) {
		// TODO Auto-generated method stub
		
	}

}
