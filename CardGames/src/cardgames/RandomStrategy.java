package cardgames;

import java.util.List;

public class RandomStrategy extends DiamondStrategy {

	@Override
	public Card getNext(Hand myHand, Card topCard, List<Hand> playedHands, List<Card> playedDiamonds) {
		// TODO Auto-generated method stub
		List<Card> handCards = myHand.getCards();
		return handCards.get((int)(Math.random() * handCards.size()));
	}

}
