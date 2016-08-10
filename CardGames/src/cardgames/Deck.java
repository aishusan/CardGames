package cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> cards;
	
	public Deck(){
		Pack p1 = new Pack();
		cards= new ArrayList<>();
		cards.addAll(p1.getCards());
	}
	
	public Deck(int n){
		cards = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			Pack p1 = new Pack();
			cards.addAll(p1.getCards());
		}
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public void removeCard()
	{
		cards.remove(0);
	}
	
	public Card getCard()
	{
		Card temp = cards.get(0);
		removeCard();
		return temp;
	}
	
	public List<Card> getNCards(int n){
		ArrayList<Card> nCards = new ArrayList<>();
		for(int i=0; i<n; i++){
			nCards.add(getCard());
		}
		return nCards;
	}
	
}
