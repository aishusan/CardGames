package cardgames;

import java.util.List;

public abstract class DiamondPlayer {
	
	protected Hand hand;
	protected double pointsWon;
	protected Card.SUIT mySuit;
	
	public DiamondPlayer(Hand hand){
		this.hand = hand;
		pointsWon = 0;
		mySuit = hand.getCards().get(0).getSuit();
	}
	
	public void addPoints(double p){
		pointsWon += p;
	}
	
	public double getPointsWon() {
		return pointsWon;
	}

	public abstract Card getNextCard(Card diamondCard);
	
	public abstract void playedCards(List<Card> played);
	
	public void removeCard(Card card){
		hand.removeCard(card);
	}

}
