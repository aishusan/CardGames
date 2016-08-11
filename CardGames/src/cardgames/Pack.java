package cardgames;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pack {

	protected List<Card> cards;
	
	public Pack(){
		cards = new ArrayList<>();
		for(Card.SUIT suit : Card.SUIT.values()){
			for(Card.VALUE value : Card.VALUE.values()){
				if(!suit.equals(Card.SUIT.JOKER) && !value.equals(Card.VALUE.JOKER))
					cards.add(new Card(suit, value));
			}
		}
	}
//	public Pack Pack(Pack pack) throws CloneNotSupportedException{
//		Pack p=new Pack();
//		p.cards=(List<Card>) pack.clone();
//		return p;
//		
//	}
//	public Pack clone() throws CloneNotSupportedException{
//		return Pack(this);
//	}
	public List<Card> getCards() {
		return cards;
	}

	public void shuffle(){
		Collections.shuffle(cards);
	}
}
