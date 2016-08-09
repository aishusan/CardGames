import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private List<Card> cards;
	
	public Deck(){
		cards = new ArrayList<>();
		for(Card.SUIT suit : Card.SUIT.values()){
			for(Card.VALUE value : Card.VALUE.values()){
				cards.add(new Card(suit, value));
			}
		}
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public void shuffle(){
		Collections.shuffle(cards);
	}
}
