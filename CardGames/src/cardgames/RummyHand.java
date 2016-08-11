package cardgames;

import java.util.ArrayList;
import java.util.List;

public class RummyHand extends Hand {
	public RummyHand()
	{
		super();
	}
	
	public RummyHand(List<Card> cards){
		super(cards);
	}
	public List<Integer> findDifferencesInCards(List<Card> cards){
		List<Integer> differences=new ArrayList<Integer>();
		differences.add(-1);
		for(int i=1;i<cards.size();i++){
			differences.add(cards.get(i).getValue()-cards.get(i-1).getValue());
		}
		return differences;
	}
	public List<Card> extractSequence(int jokerNumber){
		int[] sizeOfSequences={5,4,3};//need to loop through this for sequences of different length
		extractSequence(4,jokerNumber,cloneCards(cards));
		return null;
	}
	public List<Card> extractSequence(int n,int jokerNumber,List<Card> cards){
		List<Integer> differences;
		differences=findDifferencesInCards(cards);
		int startingPos;
		int count;
		/**
		 * loop through the differences
		 * difference[0]=-1;
		 * difference[n]=value(nth card)-value(n-1th card)
		 */
		return null;
	}
}
