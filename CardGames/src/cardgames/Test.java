package cardgames;

public class Test {
	public static void main(String[] args) {
		Pack deck = new Pack();
		deck.shuffle();
		System.out.println(deck.getCards());
	}
}
