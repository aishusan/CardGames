package cardgames;

import java.util.ArrayList;
import java.util.List;

public class ComputerDiamondPlayer extends DiamondPlayer {

	private List<Hand> playedHands;
	private List<Card> playedDiamonds;
	private DiamondStrategy strategy;
	
	public ComputerDiamondPlayer(Hand hand, int numberOfPlayers, DiamondStrategy s) {
		super(hand);
		playedHands = new ArrayList<>();
		playedDiamonds = new ArrayList<>();
		strategy = s;
		
		for(int i=0; i<numberOfPlayers; i++){
			playedHands.add(new Hand());
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public Card getNextCard(Card diamondCard) {
		// TODO Auto-generated method stub
		Card bidCard = strategy.getNext(hand, diamondCard, playedHands, playedDiamonds);
		
		removeCard(bidCard);
		return bidCard;
	}

	@Override
	public void playedCards(List<Card> played) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<played.size(); i++){
			playedHands.get(i).add(played.get(i));
		}
	}

}
