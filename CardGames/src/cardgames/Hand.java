package cardgames;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	public List<Card> cloneCards(List<Card> cards){
		List<Card> clonedCards=new ArrayList<Card>();
		for(int i=0;i<cards.size();i++){
			clonedCards.add(cards.get(i).clone());
		}
		return clonedCards;
	}
	
	public void add(Card c){
		this.cards.add(c);
	}
	
	public List<Card> getCardsOfSuit(Card.SUIT suit) {
		ArrayList<Card> cardsOfSuit = new ArrayList<>();
		for (Card c:this.cards)
			if(c.getSuit().equals(suit))
				cardsOfSuit.add(c);
		return cardsOfSuit;
	}
	public void sortOnValue(){
		Collections.sort(cards, new Comparator<Card>() {
		    public int compare(Card card1,Card card2)  {
		        return card1.getFaceValue().ordinal()-card2.getFaceValue().ordinal();
		    }
		});
	}
	public void sortOnSuit(){
		Collections.sort(cards, new Comparator<Card>() {
		    public int compare(Card card1,Card card2)  {
		        return card1.getValue()-card2.getValue();
		    }
		});
	}
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public Card showTopCard(){
		return cards.get(0);
	}
	
	public void removeCard(Card card){
		for(int i=0; i<cards.size(); i++){
			if(cards.get(i).equals(card)){
				cards.remove(i);
				return;
			}
		}
	}

	public boolean containsCard(Card card){
		return cards.contains(card);
	}
}
