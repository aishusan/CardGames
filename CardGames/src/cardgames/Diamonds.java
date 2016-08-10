package cardgames;

import java.util.ArrayList;
import java.util.List;

public class Diamonds implements Game {

	private Deck standardDeck;
	private Hand diamondsHand;
	
	public static int NUM_OF_CARDS_IN_SUIT = 13;
	
	List<DiamondPlayer> players;
	
	@Override
	public int compare(List<Hand> hands) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dealCards(List<Hand> hands) {
		// TODO Auto-generated method stub
		for(int i=0; i<hands.size(); i++){
			hands.get(i).getCards().addAll(standardDeck.getNCards(13));
		}
	}

	@Override
	public void initGame() {
		// TODO Auto-generated method stub
		standardDeck = new Deck();
		diamondsHand = new Hand(standardDeck.getNCards(13));
		diamondsHand.shuffle();
		
		Hand h1 = new Hand();
		Hand h2 = new Hand();
		
		List<Hand> playerHands = new ArrayList<>();
		playerHands.add(h1);
		playerHands.add(h2);
		
		dealCards(playerHands);
		
		RandomStrategy randomStrategy = new RandomStrategy();
		
		DiamondPlayer p1 = new HumanDiamondPlayer(h1);
		DiamondPlayer p2 = new ComputerDiamondPlayer(h2, 2, randomStrategy);
		
		players = new ArrayList<DiamondPlayer>();
		players.add(p1);
		players.add(p2);
	}

	public void playGame() {
		for(int i=0; i<NUM_OF_CARDS_IN_SUIT; i++){
			Card topCard = diamondsHand.showTopCard();
			List<Card> playedCards = new ArrayList<Card>();
			
			System.out.println("Top Card: " + topCard);
			
			for(int j=0; j<players.size(); j++){
				System.out.println("Player "+ j +" points = " + players.get(j).getPointsWon());
			}
			for(DiamondPlayer p : players){
				playedCards.add(p.getNextCard(topCard));
			}
			
			// process
			// whichValue, count
			Card.VALUE maxBid = Card.VALUE.TWO;
			double count = 0;
			
			for(int j=0; j<playedCards.size(); j++){
				System.out.println("Player " + j+1 + " played " + playedCards.get(j));
				if(playedCards.get(j).getFaceValue().equals(maxBid)){
					count++;
				} else if(playedCards.get(j).getFaceValue().compareTo(maxBid) > 0){
					maxBid = playedCards.get(j).getFaceValue();
					count = 1;
				}
			}
			
			System.out.println();
			
			for(int j=0; j<playedCards.size(); j++){
				if(playedCards.get(j).getFaceValue().equals(maxBid)){
					players.get(j).addPoints((topCard.getFaceValue().ordinal()+2)/count);
				}
			}
			
			diamondsHand.removeCard(topCard);
			
			for(DiamondPlayer p : players){
				p.playedCards(playedCards);
			}
		}
		
		for(int j=0; j<players.size(); j++){
			System.out.println("Player "+ j+1 +" points = " + players.get(j).getPointsWon());
		}
	}
	
}
