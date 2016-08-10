package cardgames;
import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> cards;
	
	public List<Card> getCards() {
		return cards;
	}

	public Hand()
	{
		cards = new ArrayList<>();
	}
	
	public Hand(List<Card> cards){
		this.cards = cards;
	}
	
	public void add(Card c)
	{
		this.cards.add(c);
	}
	
	public Hand getCardsOfSuit(Card.SUIT suit) {
		ArrayList<Card> cardsOfSuit = new ArrayList<>();
		for (Card c:this.cards)
			if(c.getSuit().equals(suit))
				cardsOfSuit.add(c);
		return new Hand(cardsOfSuit);
	}
	
}
