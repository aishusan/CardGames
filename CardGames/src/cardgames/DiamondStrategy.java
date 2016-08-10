package cardgames;

import java.util.List;

public abstract class DiamondStrategy {
	public abstract Card getNext(Hand myHand, Card topCard, List<Hand> playedHands, List<Card> playedDiamonds);
}
