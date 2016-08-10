package cardgames;

public class PackWithJoker extends Pack {
	
	public PackWithJoker() {
		super();
		addJokers(2);
	}
	
	public PackWithJoker(int count) {
		super();
		addJokers(count);
	}
	
	private void addJokers(int count){
		for(int i = 0; i<count; i++){
			cards.add(new Card(Card.SUIT.JOKER, Card.VALUE.JOKER));
		}
	}
}
