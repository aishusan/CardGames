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
	
	public Hand(ArrayList<Card> cards){
		this.cards = cards;
	}
	
	public void add(Card c)
	{
		this.cards.add(c);
	}
	
}
